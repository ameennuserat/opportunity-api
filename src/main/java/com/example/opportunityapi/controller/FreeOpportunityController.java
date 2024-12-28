package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.AddFreeOpportunityDto;
import com.example.opportunityapi.service.FreeOpportunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/free_opportunities")
public class FreeOpportunityController {

    final private FreeOpportunityService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/userProfiles/{id}")
    public ResponseEntity<?> findAllByUserProfileId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddFreeOpportunityDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AddFreeOpportunityDto dto, @PathVariable int id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
