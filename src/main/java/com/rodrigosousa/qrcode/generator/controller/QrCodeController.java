package com.rodrigosousa.qrcode.generator.controller;

import com.rodrigosousa.qrcode.generator.dto.QrCodeGenerateRequestDTO;
import com.rodrigosousa.qrcode.generator.dto.QrCodeGenerateResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponseDTO> generate(@RequestBody QrCodeGenerateRequestDTO request) {


        return null;
    }
}
