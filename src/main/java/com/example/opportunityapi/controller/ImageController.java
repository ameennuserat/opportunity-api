package com.example.opportunityapi.controller;

import com.example.opportunityapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/images")
public class ImageController {

    private final ImageService imageService;

    @Value("${image.directory}")
    private String uploadImageDirectory;


    @GetMapping("image/{imageName}")
    public ResponseEntity<?> viewImage(@PathVariable String imageName) throws IOException {
        return ResponseEntity.ok(imageService.viewImage(imageName));
    }

    @GetMapping("file/{fileName}")
    public ResponseEntity<?> viewFile(@PathVariable String fileName) throws IOException {
        File file = new File(uploadImageDirectory + "/" + fileName);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=myDoc.pdf");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path filePath = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(filePath));

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
