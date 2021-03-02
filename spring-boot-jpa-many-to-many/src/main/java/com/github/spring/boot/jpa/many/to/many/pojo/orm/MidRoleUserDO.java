package com.github.spring.boot.jpa.many.to.many.pojo.orm;

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
import javax.persistence.Table;

import static com.github.spring.boot.jpa.many.to.many.pojo.common.RoleInfoConstant.MID_ROLE_ID;
import static com.github.spring.boot.jpa.many.to.many.pojo.common.UserInfoConstant.MID_USER_ID;

/**
 * 中间表
 * <p>
 * create in 2021/3/2 5:31 下午
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
@Table(name = "many_to_many_role_user")
public class MidRoleUserDO extends BaseEntity {

    private static final long serialVersionUID = -2261063336260537394L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = MID_USER_ID, nullable = false, columnDefinition = "BIGINT COMMENT '用户ID'")
    private Long userId;

    @Column(name = MID_ROLE_ID, nullable = false, columnDefinition = "BIGINT COMMENT '角色ID'")
    private Long roleId;

}
