package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.AddApplyDto;
import com.example.opportunityapi.model.dto.AddFreeCategoryDto;
import com.example.opportunityapi.model.dto.UpdateApplyDto;
import com.example.opportunityapi.model.enums.ApplyStatus;
import com.example.opportunityapi.service.ApplyService;
import com.example.opportunityapi.service.FreeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/applies")
public class ApplyController {

    final private ApplyService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{status}")
    public ResponseEntity<?> findAllByStatus(@PathVariable ApplyStatus status) {
        return ResponseEntity.ok(service.findAllByStatus(status));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findAllByUserProfileId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllByUserProfileId(id));
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<?> findAllByCompanyProfileId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllByCompanyProfileId(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddApplyDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateApplyDto dto, @PathVariable int id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
