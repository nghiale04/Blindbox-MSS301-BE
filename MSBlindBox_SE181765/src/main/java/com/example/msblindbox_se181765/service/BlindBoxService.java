package com.example.msblindbox_se181765.service;


import com.example.msblindbox_se181765.dto.BlindBoxDto;
import com.example.msblindbox_se181765.dto.request.BlindBoxRequest;

import java.util.List;

public interface BlindBoxService {
    List<BlindBoxDto> getAllBlindBoxes();
    void deleteBlindBox(Integer blindBoxId);
    BlindBoxDto createBlindBox(BlindBoxRequest request);
    BlindBoxDto updateBlindBox(Integer blindBoxId, BlindBoxRequest request);
}
