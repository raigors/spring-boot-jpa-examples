package com.github.spring.boot.jpa.many.to.many.pojo.orm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.spring.boot.jpa.common.pojo.orm.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

import static com.github.spring.boot.jpa.many.to.many.pojo.common.RoleInfoConstant.ROLE_CODE;
import static com.github.spring.boot.jpa.many.to.many.pojo.common.RoleInfoConstant.ROLE_INFO;
import static com.github.spring.boot.jpa.many.to.many.pojo.common.RoleInfoConstant.ROLE_NAME;

/**
 * TODO
 * <p>
 * create in 2021/3/1 6:11 下午
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
        name = ROLE_INFO,
        indexes = {@Index(columnList = ROLE_NAME, name = "idx_role_name")},
        uniqueConstraints = {@UniqueConstraint(columnNames = {ROLE_CODE}, name = "uk_role_code")}
)
public class RoleInfoDO extends BaseEntity {

    private static final long serialVersionUID = -6663887169470106120L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", nullable = false, columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    private String roleName;

    @Column(name = "role_code", nullable = false, columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    private String roleCode;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "roles")
    private List<UserInfoDO> users;
}
