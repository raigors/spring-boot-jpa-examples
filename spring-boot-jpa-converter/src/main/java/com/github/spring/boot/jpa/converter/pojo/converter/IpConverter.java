package com.github.spring.boot.jpa.converter.pojo.converter;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;

/**
 * 将字符串的 IP 转换成 数字类型
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
        return NetUtil.ipv4ToLong(attribute);
    }

    @Override
    public String convertToEntityAttribute(Long intIp) {
        return NetUtil.longToIpv4(intIp);
    }
}
