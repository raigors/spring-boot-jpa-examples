package com.github.spring.boot.jpa.multiple.datasources.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * TODO
 * <p>
 * create in 2021/4/21 3:51 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Entity
@Setter
@Getter
@ToString
public class UserInfoDO {

    @Id
    @GeneratedValue
    private Long id;

}
