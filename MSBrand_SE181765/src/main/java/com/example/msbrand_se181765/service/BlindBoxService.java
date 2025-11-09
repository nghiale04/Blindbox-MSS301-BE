package com.example.msbrand_se181765.service;



import com.example.msbrand_se181765.dto.BlindBoxDto;
import com.example.msbrand_se181765.dto.request.BlindBoxRequest;

import java.util.List;

public interface BlindBoxService {
    void deleteBlindBox(Integer blindBoxId);
    BlindBoxDto createBlindBox(BlindBoxRequest request);
    List<BlindBoxDto> getAllBlindBoxes();
    BlindBoxDto updateBlindBox(Integer blindBoxId, BlindBoxRequest request);
}
