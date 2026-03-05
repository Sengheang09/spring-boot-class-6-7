package com.example.springuploadimages.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class ImageUploadConfig {

    @Value("${spring.upload-dir}")
    private String uploadDir;

    @Bean
    public Path uploadPath(){
        Path path = Paths.get(System.getProperty("user.dir"),uploadDir);

        if(Files.notExists(path)){
            try{
                Files.createDirectories(path);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        return path;
    }

}
