package com.rodrigosousa.qrcode.generator.controller;

import com.rodrigosousa.qrcode.generator.dto.QrCodeGenerateRequestDTO;
import com.rodrigosousa.qrcode.generator.dto.QrCodeGenerateResponseDTO;
import com.rodrigosousa.qrcode.generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponseDTO> generate(@RequestBody QrCodeGenerateRequestDTO request) {
        try {
            QrCodeGenerateResponseDTO qrCodeGenerateResponseDTO = this.qrCodeGeneratorService.generateAndUploadQrCode(request.text());

            return ResponseEntity.ok(qrCodeGenerateResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
