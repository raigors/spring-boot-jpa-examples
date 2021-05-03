package com.github.spring.boot.jpa.index.pojo.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Embeddable;

/**
 * TODO
 * <p>
 * create in 2021/4/28 10:15 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@ToString
@Embeddable
public class EmailBO {

    private String email;

    public EmailBO(String email) {
        this.email = email;
    }

    public EmailBO() {

    }
}
