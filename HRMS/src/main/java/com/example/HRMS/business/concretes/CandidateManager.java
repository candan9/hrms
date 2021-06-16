package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.*;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.CandidateDao;
import com.example.HRMS.entities.concretes.*;
import com.example.HRMS.entities.dtos.CandidateCvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private EducationService educationService;
    private ExperienceService experienceService;
    private PhotoService photoService;
    private ForLanguageService forLanguageService;
    private ForContactService forContactService;
    private TalentService talentService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, EducationService educationService, ExperienceService experienceService, PhotoService photoService, ForLanguageService forLanguageService, ForContactService forContactService, TalentService talentService) {
        this.candidateDao = candidateDao;
        this.educationService = educationService;
        this.experienceService = experienceService;
        this.photoService = photoService;
        this.forLanguageService = forLanguageService;
        this.forContactService = forContactService;
        this.talentService = talentService;
    }

    @Override
    public Result add(Candidate candidates) {
        this.candidateDao.save(candidates);
        return new SuccessResult("İş Adayı eklendi.");
    }

    @Override
    public DataResult<Candidate> getByIdentificationNumber(String identificationNumber) {
        return new SuccessDataResult<>(this.candidateDao.getByIdentificationNumber(identificationNumber));
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<>(this.candidateDao.findById(id).get());
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(this.candidateDao.findAll());
    }

    @Override
    public DataResult<CandidateCvDto> getResumeByCandidateId(int candidateId) {
    	CandidateCvDto candidateCvDto = new CandidateCvDto();
    	candidateCvDto.setCandidate(this.getById(candidateId).getData());
    	candidateCvDto.setEducations(this.educationService.getAllByCandidateIdOrderByGraduationYear(candidateId).getData());
    	candidateCvDto.setExperiences(this.experienceService.getAllByCandidateIdOrderByLeaveDate(candidateId).getData());
    	candidateCvDto.setPhotos(this.photoService.getAllByCandidateId(candidateId).getData());
    	candidateCvDto.setForLanguages(this.forLanguageService.getAllByCandidateId(candidateId).getData());
    	candidateCvDto.setForContacts(this.forContactService.getAllByCandidateId(candidateId).getData());
    	candidateCvDto.setTalents(this.talentService.getAllByCandidateId(candidateId).getData());
        return new SuccessDataResult<>(candidateCvDto);
    }

}
