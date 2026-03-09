package com.example.springuploadimages.service.Impl;

import com.example.springuploadimages.entity.ImageEntity;
import com.example.springuploadimages.repo.ImageRepository;
import com.example.springuploadimages.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    ImageRepository repo;
    Path uploadPath;

    public ImageServiceImpl(ImageRepository repo, Path uploadPath){
        this.repo = repo;
        this.uploadPath = uploadPath;
    }

    @Override
    public ResponseEntity<ImageEntity> uploadImage(ImageEntity image, MultipartFile file) throws IOException {
        if(file==null || file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String fileName = UUID.randomUUID() +"_"+ file.getOriginalFilename();

        Path filePath = uploadPath.resolve(fileName);
        file.transferTo(filePath.toFile());

//        "http://localhost:8080"+"/uploads/"+filePath

        image.setImageUrl(fileName);

        ImageEntity saved = repo.save(image);

        saved.setImageUrl("http://localhost:8080"+"/uploads/"+fileName);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}