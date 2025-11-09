package com.example.msblindbox_se181765.feign;

import com.example.msblindbox_se181765.dto.BlindBoxDto;
import com.example.msblindbox_se181765.dto.request.BlindBoxRequest;
import jakarta.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "brand-service", url = "${app.brand-service-path}")
public interface BrandControllerFeign {

    @DeleteMapping("/brand/{blindBoxId}")
    ResponseEntity<Void> delete(@PathVariable Integer blindBoxId);
    @PostMapping("/brand")
    ResponseEntity<BlindBoxDto> createBlindBox(@RequestBody @Valid BlindBoxRequest request);
    @GetMapping("/brand")
    ResponseEntity<List<BlindBoxDto>> getAllBlindBoxes();
    @PutMapping("/brand/{blindBoxId}")
    ResponseEntity<BlindBoxDto> updateBlindBox(@PathVariable Integer blindBoxId, @RequestBody @Valid BlindBoxRequest request);
}
