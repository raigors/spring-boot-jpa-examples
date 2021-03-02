package com.github.spring.boot.jpa.many.to.many.pojo.orm;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.spring.boot.jpa.common.pojo.orm.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

import static com.github.spring.boot.jpa.many.to.many.pojo.common.RoleInfoConstant.MID_ROLE_ID;
import static com.github.spring.boot.jpa.many.to.many.pojo.common.UserInfoConstant.EMAIL;
import static com.github.spring.boot.jpa.many.to.many.pojo.common.UserInfoConstant.MID_USER_ID;
import static com.github.spring.boot.jpa.many.to.many.pojo.common.UserInfoConstant.USERNAME;
import static com.github.spring.boot.jpa.many.to.many.pojo.common.UserInfoConstant.USER_INFO;

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

    @Column(nullable = false, columnDefinition = "TINYINT COMMENT '用户年龄'")
    private Integer age;

    @JsonManagedReference
    @ManyToMany(targetEntity = RoleInfoDO.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "many_to_many_role_user",
            joinColumns = @JoinColumn(name = MID_USER_ID, referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = MID_ROLE_ID, referencedColumnName = "id")
    )
    private List<RoleInfoDO> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfoDO that = (UserInfoDO) o;
        return new EqualsBuilder().append(id, that.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).toHashCode();
    }
}
