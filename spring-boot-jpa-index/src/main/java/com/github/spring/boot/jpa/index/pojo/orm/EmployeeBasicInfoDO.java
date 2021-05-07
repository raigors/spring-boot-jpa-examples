package com.github.spring.boot.jpa.index.pojo.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import static com.github.spring.boot.jpa.index.pojo.common.EmployeeConstant.EMPLOYEE_BASIC_INFO;
import static com.github.spring.boot.jpa.index.pojo.common.EmployeeConstant.EMPLOYEE_EXTEND_INFO;
import static javax.persistence.ConstraintMode.NO_CONSTRAINT;

/**
 * TODO
 * <p>
 * create in 2021/5/6 5:44 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = EMPLOYEE_BASIC_INFO)
@SecondaryTables(value = {@SecondaryTable(name = EMPLOYEE_EXTEND_INFO, pkJoinColumns = @PrimaryKeyJoinColumn(name = "employee_id"), foreignKey = @ForeignKey(NO_CONSTRAINT))})
public class EmployeeBasicInfoDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @Column(table = EMPLOYEE_EXTEND_INFO)
    private String address;

    @Column(table = EMPLOYEE_EXTEND_INFO)
    private String mobile;

}
