package com.example.demo.device.control;
import com.example.demo.device.dto.DataDto;
import com.example.demo.device.dto.ImageDto;
import com.example.demo.device.mapper.Image_mapper;
import com.example.demo.device.entity.ImageEntity;
import com.example.demo.device.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.device.response.DataControllerResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
//import com.example.demo.device.response.ImageInsertRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService=imageService;
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertData(@RequestParam("image") MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                ImageEntity imageEntity = new ImageEntity();
                imageEntity.setImage(imageFile.getBytes());
                imageEntity.setCreate_time(LocalDateTime.now());
                imageService.insertData(imageEntity);

                if (imageEntity.getId() != null) {
                    return ResponseEntity.status(HttpStatus.CREATED).body("Data inserted successfully");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert data");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process image file");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No image file provided");
        }
    }


    @GetMapping("/latest")
    public ResponseEntity<ImageDto> getLatestImage() {
        ImageDto latestImage = imageService.getLatest();
        if (latestImage != null) {
            return ResponseEntity.ok(latestImage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
