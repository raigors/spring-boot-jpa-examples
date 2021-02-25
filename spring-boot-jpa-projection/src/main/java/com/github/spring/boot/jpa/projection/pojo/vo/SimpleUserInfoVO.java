package com.github.spring.boot.jpa.projection.pojo.vo;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;

/**
 * TODO
 * <p>
 * create in 2021/2/24 5:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Value
@ToString
@RequiredArgsConstructor
public class SimpleUserInfoVO implements Serializable {

    private static final long serialVersionUID = -8782043859160469253L;

    String username;

    String email;

}
