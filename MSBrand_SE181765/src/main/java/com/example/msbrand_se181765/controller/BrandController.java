package com.example.msbrand_se181765.controller;

import com.example.msbrand_se181765.dto.BlindBoxDto;
import com.example.msbrand_se181765.dto.request.BlindBoxRequest;
import com.example.msbrand_se181765.service.BlindBoxService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BlindBoxService blindBoxService;
    @DeleteMapping("/{blindBoxId}")
    public ResponseEntity<Void> deleteBlindBox(@PathVariable  Integer blindBoxId) {
        blindBoxService.deleteBlindBox(blindBoxId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<BlindBoxDto> createBlindBox(@RequestBody @Valid BlindBoxRequest request){
        BlindBoxDto createdBlindBox = blindBoxService.createBlindBox(request);
        return ResponseEntity.ok(createdBlindBox);
    }
    @GetMapping
    public ResponseEntity<List<BlindBoxDto>> getAllBlindBoxes() {
        return ResponseEntity.ok().body(blindBoxService.getAllBlindBoxes());
    }
    @PutMapping("/{blindBoxId}")
    public ResponseEntity<BlindBoxDto> updateBlindBox(@PathVariable Integer blindBoxId, @RequestBody @Valid BlindBoxRequest request) {
        BlindBoxDto updatedBlindBox = blindBoxService.updateBlindBox(blindBoxId, request);
        return ResponseEntity.ok(updatedBlindBox);
    }

}
