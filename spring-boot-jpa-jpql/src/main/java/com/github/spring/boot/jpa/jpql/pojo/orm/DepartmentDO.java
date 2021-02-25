package com.github.spring.boot.jpa.jpql.pojo.orm;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.spring.boot.jpa.common.pojo.orm.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Map;

import static com.github.spring.boot.jpa.jpql.pojo.common.DepartmentConstant.DEPARTMENT;
import static com.github.spring.boot.jpa.jpql.pojo.common.DepartmentConstant.TABLE_DEPARTMENT;

/**
 * 部门实体类
 * <p>
 * create in 2021/2/24 2:29 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_DEPARTMENT)
@Entity
public class DepartmentDO extends BaseEntity {

    private static final long serialVersionUID = -229128533892916234L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

    @MapKey
    @OrderBy("id ASC")
    @OneToMany(mappedBy = DEPARTMENT)
    @JsonManagedReference
    private Map<Long, EmployeeDO> employees;

}
