package com.example.springuploadimages.service.Impl;

import com.example.springuploadimages.entity.ImageEntity;
import com.example.springuploadimages.repo.ImageRepository;
import com.example.springuploadimages.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
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

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path filePath = uploadPath.resolve(fileName);
        file.transferTo(filePath.toFile());


        image.setImageUrl(fileName);

        ImageEntity saved = repo.save(image);

        saved.setImageUrl("http://localhost:8080"+"/uploads/"+fileName);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    public ResponseEntity<List<ImageEntity>> getAllData() {

        List<ImageEntity> images = repo.findAll();

        if(images.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(images);
    }

    @Override
    public ResponseEntity<ImageEntity> getImageById(Long id) {
        Optional<ImageEntity> findImage = repo.findById(id);

        if(findImage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ImageEntity image = findImage.get();

        return ResponseEntity.ok().body(image);
    }

    @Override
    public ResponseEntity<ImageEntity> updateImageById(Long id, ImageEntity image, MultipartFile file) throws IOException {

        Optional<ImageEntity> updateImage = repo.findById(id);
        if(updateImage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ImageEntity update = updateImage.get();

        String fileName = UUID.randomUUID()+"_"+file.getOriginalFilename();

        Path filePath = uploadPath.resolve(fileName);
        file.transferTo(filePath.toFile());

        update.setTitle(image.getTitle());
        update.setImageUrl(fileName);

        ImageEntity Updated = repo.save(update);

        Updated.setImageUrl("http://localhost:8080"+"/uploads/"+fileName);

        return ResponseEntity.ok().body(Updated);
    }


}