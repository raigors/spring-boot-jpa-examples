package com.github.spring.boot.jpa.one.to.many.pojo.orm;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static com.github.spring.boot.jpa.one.to.many.pojo.common.EmployeeConstant.DEPARTMENT_ID;
import static com.github.spring.boot.jpa.one.to.many.pojo.common.EmployeeConstant.ID;
import static com.github.spring.boot.jpa.one.to.many.pojo.common.EmployeeConstant.TABLE_EMPLOYEE;

/**
 * 员工实体类
 * <p>
 * create in 2021/2/24 2:29 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString(exclude = "department")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_EMPLOYEE)
@Entity
public class EmployeeDO extends BaseEntity {

    private static final long serialVersionUID = 1428614737372098349L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;

    @Column(name = DEPARTMENT_ID, insertable = false, updatable = false)
    private Long departmentId;

    @ManyToOne(targetEntity = DepartmentDO.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = DEPARTMENT_ID, referencedColumnName = ID)
    @JsonBackReference
    private DepartmentDO department;

}
