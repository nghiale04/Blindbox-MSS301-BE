package com.example.msblindbox_se181765.controller;

import com.example.msblindbox_se181765.dto.BlindBoxDto;
import com.example.msblindbox_se181765.dto.request.BlindBoxRequest;
import com.example.msblindbox_se181765.service.BlindBoxService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blindbox")
@RequiredArgsConstructor
public class BlindBoxController {
        private final BlindBoxService blindBoxService;
    @GetMapping
    public ResponseEntity<List<BlindBoxDto>> getAllBlindBoxes() {
        return ResponseEntity.ok().body(blindBoxService.getAllBlindBoxes());
    }
    @DeleteMapping("/{blindBoxId}")
    public ResponseEntity<Void> deleteBlindBox(@PathVariable Integer blindBoxId) {
        blindBoxService.deleteBlindBox(blindBoxId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<BlindBoxDto> createBlindBox(@RequestBody BlindBoxRequest request) {
        BlindBoxDto createdBlindBox = blindBoxService.createBlindBox(request);
        return ResponseEntity.ok(createdBlindBox);
    }

    @PutMapping("/{blindBoxId}")
    public ResponseEntity<BlindBoxDto> updateBlindBox(@PathVariable Integer blindBoxId, @RequestBody BlindBoxRequest request) {
        BlindBoxDto updatedBlindBox = blindBoxService.updateBlindBox(blindBoxId, request);
        return ResponseEntity.ok(updatedBlindBox);
    }

}
