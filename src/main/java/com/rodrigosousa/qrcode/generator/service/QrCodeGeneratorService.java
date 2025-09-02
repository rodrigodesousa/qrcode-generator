package com.rodrigosousa.qrcode.generator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.rodrigosousa.qrcode.generator.dto.QrCodeGenerateResponseDTO;
import com.rodrigosousa.qrcode.generator.ports.StoragePort;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGeneratorService {

    private final StoragePort storage;

    public QrCodeGeneratorService(StoragePort storage){
        this.storage = storage;
    }

    public QrCodeGenerateResponseDTO generateAndUploadQrCode(String text) throws WriterException, IOException {
        // 1. Generate QR Code image bytes from the text
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngQrCodeData = pngOutputStream.toByteArray();

        // 2. Upload the image bytes to storage and get the URL
        String fileName = UUID.randomUUID().toString();
        String contentType = "image/png";
        String url = storage.uploadFile(pngQrCodeData, fileName, contentType);

        // 3. Return the URL in the response DTO
        return new QrCodeGenerateResponseDTO(url);
    }
}
