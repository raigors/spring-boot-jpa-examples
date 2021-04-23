package com.github.spring.boot.jpa.lock.pojo.converter;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;

/**
 * TODO
 * <p>
 * create in 2021/4/7 10:19 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class IpConverter implements AttributeConverter<String, Long> {

    @Override
    public Long convertToDatabaseColumn(String attribute) {
        String[] ip = attribute.split("\\.");
        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]);
    }

    @Override
    public String convertToEntityAttribute(Long intIp) {
        return (intIp >> 24) + "." +
                ((intIp & 0x00FFFFFF) >> 16) + "." +
                ((intIp & 0x0000FFFF) >> 8) + "." +
                (intIp & 0x000000FF);
    }
}
