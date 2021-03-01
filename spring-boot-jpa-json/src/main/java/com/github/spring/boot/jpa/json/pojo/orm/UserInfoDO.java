package com.github.spring.boot.jpa.json.pojo.orm;

import com.github.spring.boot.jpa.common.pojo.orm.BaseEntity;
import com.github.spring.boot.jpa.json.pojo.bo.AddressBO;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static com.github.spring.boot.jpa.json.pojo.common.UserInfoConstant.EMAIL;
import static com.github.spring.boot.jpa.json.pojo.common.UserInfoConstant.USERNAME;
import static com.github.spring.boot.jpa.json.pojo.common.UserInfoConstant.USER_INFO;


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
@EntityListeners({AuditingEntityListener.class})
@Entity
@Table(
        name = USER_INFO,
        indexes = {@Index(columnList = EMAIL, name = "idx_email")},
        uniqueConstraints = {@UniqueConstraint(columnNames = {USERNAME}, name = "uk_username")}
)
@DynamicInsert
@DynamicUpdate
@TypeDef(name = "JSON", typeClass = JsonStringType.class)
public class UserInfoDO extends BaseEntity {

    private static final long serialVersionUID = 4882503753448314743L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) COMMENT '电子邮箱'")
    private String email;

    @Column(nullable = false, columnDefinition = "TINYINT COMMENT '用户年龄'")
    private Integer age;

    @Type(type = "JSON")
    @Column(columnDefinition = "JSON")
    private AddressBO address;
}
