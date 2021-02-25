package com.github.spring.boot.jpa.specification.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 * <p>
 * create in 2021/2/25 3:50 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Getter
@Setter
@ToString
public class UserInfoDTO {

    private String username;

    private String mobile;

    private Integer age;

    private String email;


}
