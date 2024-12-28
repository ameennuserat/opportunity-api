package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.AddJobSubCategoryDto;
import com.example.opportunityapi.service.JobSubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job_sub_categories")
public class JobSubCategoryController {

    final private JobSubCategoryService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/job_categories/{id}")
    public ResponseEntity<?> findAllByCategoryId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllByCategoryId(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddJobSubCategoryDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AddJobSubCategoryDto dto, @PathVariable int id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
