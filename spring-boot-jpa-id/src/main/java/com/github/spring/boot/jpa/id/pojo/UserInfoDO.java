package com.github.spring.boot.jpa.id.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * TODO
 * <p>
 * create in 2021/5/28 5:34 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
public class UserInfoDO {

    @Id
    @GeneratedValue(generator = "CustomGenerator")
    @GenericGenerator(name = "CustomGenerator", strategy = "com.github.spring.boot.jpa.id.config.CustomIDGenerator")
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    private String username;


}
