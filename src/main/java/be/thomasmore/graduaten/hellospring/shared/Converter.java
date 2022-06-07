package be.thomasmore.graduaten.hellospring.shared;

import org.springframework.stereotype.Component;

import java.util.Base64;


@Component
public  class Converter {

    // Omzetten van image naar base 64 voor laten tonen van image op scherm

    public String ConvertByteArrayToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);

    }
}
