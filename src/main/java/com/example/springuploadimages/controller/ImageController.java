package com.example.springuploadimages.controller;

import com.example.springuploadimages.entity.ImageEntity;
import com.example.springuploadimages.service.Impl.ImageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/uploads")
public class ImageController {

    private ImageServiceImpl imageService;
    public ImageController(ImageServiceImpl imageService){
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<ImageEntity> upload(
            @ModelAttribute ImageEntity image,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        return imageService.uploadImage(image, file);
    }

}
