package com.github.spring.boot.jpa.converter.pojo.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * TODO
 * <p>
 * create in 2021/2/24 5:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Converter
public class PasswordConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return "加密过后:" + attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
