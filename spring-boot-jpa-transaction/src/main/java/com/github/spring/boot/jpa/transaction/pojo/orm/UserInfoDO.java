package com.github.spring.boot.jpa.transaction.pojo.orm;


import com.github.spring.boot.jpa.common.pojo.orm.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static com.github.spring.boot.jpa.transaction.pojo.common.UserInfoConstant.EMAIL;
import static com.github.spring.boot.jpa.transaction.pojo.common.UserInfoConstant.USERNAME;
import static com.github.spring.boot.jpa.transaction.pojo.common.UserInfoConstant.USER_INFO;


/**
 * 用户关系实体映射类
 * extends AbstractPersistable<Long>
 * <p>
 * create in 2021/2/23 5:26 下午
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
@Entity
@Table(
        name = USER_INFO,
        indexes = {@Index(columnList = EMAIL, name = "idx_email")},
        uniqueConstraints = {@UniqueConstraint(columnNames = {USERNAME}, name = "uk_username")}
)
public class UserInfoDO extends BaseEntity {

    private static final long serialVersionUID = 4882503753448314743L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) COMMENT '电子邮箱'")
    private String email;

    @Column(nullable = false, columnDefinition = "BIGINT COMMENT '用户年龄'")
    private Integer age;

}
