package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.AddReportDto;
import com.example.opportunityapi.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
public class ReportController {

    final private ReportService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<?> findAllByCompanyProfileId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllByCompanyProfileId(id));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findAllByUserProfileId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllByUserProfileId(id));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> add(@ModelAttribute AddReportDto dto) throws IOException {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
