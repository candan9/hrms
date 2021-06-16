package com.example.HRMS;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.HRMS.core.helpers.CloudinaryImageManager;
import com.example.HRMS.core.helpers.ImageService;
import com.example.HRMS.core.helpers.MailManager;
import com.example.HRMS.core.helpers.MailService;
import com.example.HRMS.core.helpers.MernisCheckService;
import com.example.HRMS.core.helpers.MernisServiceAdapter;

@Configuration
public class Configurations {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    
    public MernisCheckService mernisCheckService(){
        return new MernisServiceAdapter();
    }
    @Bean
    public MailService mailService(){
        return new MailManager();
    }

    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "hrmsemre",
                "api_key", "832421528255312",
                "api_secret", "SqQ9L2ejrqy4cfCJ1sHBeFWa2qU"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}