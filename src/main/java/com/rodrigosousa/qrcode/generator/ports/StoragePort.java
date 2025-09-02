package com.rodrigosousa.qrcode.generator.ports;

public interface StoragePort {

    String uploadFile(byte[] filData, String filename, String contentType);
}
