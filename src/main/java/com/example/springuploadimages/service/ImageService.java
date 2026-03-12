package com.example.springuploadimages.service;

import com.example.springuploadimages.entity.ImageEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ImageService {
    ResponseEntity<ImageEntity> uploadImage(ImageEntity image , MultipartFile file) throws IOException;

    ResponseEntity<List<ImageEntity>> getAllData();

    ResponseEntity<ImageEntity> getImageById(Long id);

    ResponseEntity<ImageEntity> updateImageById(
            Long id,
            ImageEntity image,
            MultipartFile file
            ) throws IOException;
}
