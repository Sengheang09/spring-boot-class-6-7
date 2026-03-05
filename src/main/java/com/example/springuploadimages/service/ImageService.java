package com.example.springuploadimages.service;

import com.example.springuploadimages.entity.ImageEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageService {
    ResponseEntity<ImageEntity> uploadImage(ImageEntity image , MultipartFile file) throws IOException;

}
