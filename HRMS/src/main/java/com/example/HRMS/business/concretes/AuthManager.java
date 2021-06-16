package com.example.HRMS.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.AuthService;
import com.example.HRMS.business.abstracts.CandidateService;
import com.example.HRMS.business.abstracts.EmployerService;
import com.example.HRMS.business.abstracts.UserService;
import com.example.HRMS.core.helpers.MailService;
import com.example.HRMS.core.helpers.MernisCheckService;
import com.example.HRMS.core.helpers.MernisPerson;
import com.example.HRMS.core.results.*;
import com.example.HRMS.entities.concretes.Candidate;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.dtos.LoginUserDto;
import com.example.HRMS.entities.dtos.RegisterCandidateDto;
import com.example.HRMS.entities.dtos.RegisterEmployerDto;

@Service
public class AuthManager implements AuthService {

    private UserService userService;
    private EmployerService employerService;
    private CandidateService candidateService;
    private ModelMapper modelMapper;
    private MernisCheckService mernisCheckService;
    private MailService mailService;

    @Autowired
    public AuthManager(UserService userService,
                       EmployerService employerService,
                       CandidateService candidateService,
                       ModelMapper modelMapper,
                       MernisCheckService mernisCheckService,
                       MailService mailService) {
        this.userService = userService;
        this.employerService = employerService;
        this.candidateService = candidateService;
        this.modelMapper = modelMapper;
        this.mernisCheckService = mernisCheckService;
        this.mailService = mailService;
    }

    @Override
    public Result registerEmployer(RegisterEmployerDto registerEmployerDto) {
        if(!checkEmployerDomain(registerEmployerDto)){
            return new ErrorResult("Mail domaininiz şirket sitenizin domainiyle aynı olmak zorundadır.");
        }
        if(this.userService.getByEmail(registerEmployerDto.getEmail()).getData() != null){
            return new ErrorResult("Bu maile ait bi şirket zaten kayıtlı.");
        }

        mailService.send(registerEmployerDto.getEmail());
        Employer employerForRegister = modelMapper.map(registerEmployerDto,Employer.class)  ;
        employerService.add(employerForRegister);
        return new SuccessResult("Kullanıcı kaydoldu.");
    }

    @Override
    public Result registerCandidate(RegisterCandidateDto registerCandidateDto) {

        if(this.userService.getByEmail(registerCandidateDto.getEmail()).getData() != null ||
            this.candidateService.getByIdentificationNumber(registerCandidateDto.getIdentificationNumber()).getData() !=null){
            return new ErrorResult("Bu maile veya TC kimlik numarasına ait birisi zaten kayıtlı");
        }

        if(!mernisCheckService.validate(modelMapper.map(registerCandidateDto, MernisPerson.class))){
            return new ErrorResult("Kimlik doğrulanmadı");
        }

        mailService.send(registerCandidateDto.getEmail());
        Candidate candidatesForRegister = modelMapper.map(registerCandidateDto, Candidate.class);
        candidateService.add(candidatesForRegister);
        return new SuccessResult("Kayıt başırılı.");
    }

    @Override
    public Result login(LoginUserDto loginForUserDto) {
        return new SuccessResult("Giriş başarılı.");
    }

    public boolean checkEmployerDomain(RegisterEmployerDto registerForEmployerDto) {
        String mailDomain = registerForEmployerDto.getEmail().split("@")[1];
        return mailDomain.equals(registerForEmployerDto.getWebsite());
    }

}
