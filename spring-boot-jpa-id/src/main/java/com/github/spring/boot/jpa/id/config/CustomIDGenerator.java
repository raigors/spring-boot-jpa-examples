package com.github.spring.boot.jpa.id.config;

import com.github.spring.boot.jpa.id.service.IdService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * TODO
 * <p>
 * create in 2021/5/28 5:49 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class CustomIDGenerator extends IdentityGenerator  {

    private static IdService service;

    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        return service.getId();
    }

    public static void setService(IdService service) {
        CustomIDGenerator.service = service;
    }
}
