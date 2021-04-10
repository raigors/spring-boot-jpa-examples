package com.github.spring.boot.jpa.index.pojo.orm;

import com.github.spring.boot.jpa.common.pojo.orm.BaseEntity;
import com.github.spring.boot.jpa.index.pojo.converter.IpConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

import static com.github.spring.boot.jpa.index.pojo.common.UserInfoConstant.EMAIL;
import static com.github.spring.boot.jpa.index.pojo.common.UserInfoConstant.USERNAME;
import static com.github.spring.boot.jpa.index.pojo.common.UserInfoConstant.USER_INFO;

/**
 * 用户关系实体映射类
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
        indexes = {@Index(name = "idx_email", columnList = EMAIL), @Index(name = "idx_age_email", columnList = "age,email")},
        uniqueConstraints = {@UniqueConstraint(name = "uk_username", columnNames = {USERNAME})}
)
public class UserInfoDO extends BaseEntity {

    private static final long serialVersionUID = 4882503753448314743L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    private String username;

    @Column(nullable = false, columnDefinition = "CHAR(50) COMMENT '电子邮箱'")
    private String email;

    @Column(name = "cell_phone", nullable = false, columnDefinition = "CHAR(11) COMMENT '手机号码'")
    private String cellPhone;

    @Column(nullable = false, columnDefinition = "TINYINT COMMENT '用户年龄'")
    private Integer age;

    @Convert(converter = IpConverter.class)
    @Column(nullable = false, columnDefinition = "INT UNSIGNED COMMENT 'ip地址'")
    private String ip;

    @Column(nullable = false, columnDefinition = "DATETIME COMMENT '生日'")
    private Date birthday;

}
