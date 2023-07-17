package com.info.edp.config;

import com.info.edp.utils.EncryptionUtil;
import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Encrypt implements AttributeConverter<String, String> {

    private EncryptionUtil encryptionUtil;

    @Override
    public String convertToDatabaseColumn(String input) {

        return encryptionUtil.encrypt(input);
    }

    @Override
    public String convertToEntityAttribute(String input) {
        return encryptionUtil.decrypt(input);
    }
}
