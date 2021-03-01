package com.github.spring.boot.jpa.jpql.controller;

import com.github.spring.boot.jpa.jpql.pojo.orm.DepartmentDO;
import com.github.spring.boot.jpa.jpql.pojo.orm.EmployeeDO;
import com.github.spring.boot.jpa.jpql.pojo.vo.IDepartmentSimpleVO;
import com.github.spring.boot.jpa.jpql.repository.IEmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 员工增删改查接口
 * <p>
 * create in 2021/2/24 3:31 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class EmployeeController {

    @Resource
    private IEmployeeRepository repository;

    @GetMapping("/employees/avg")
    public Page<EmployeeDO> findAllEmployeesAvg(Pageable pageable) {
        return repository.findAllByAvg(pageable);
    }

    @GetMapping("/employee/department/{id}")
    public DepartmentDO findEmployeeDepartmentById(@PathVariable long id) {
        return repository.findEmployeeDepartmentById(id);
    }

    @GetMapping("/employee/department/simple/{id}")
    public IDepartmentSimpleVO findEmployeeDepartmentSimpleById(@PathVariable long id) {
        return repository.findEmployeeDepartmentById(id, IDepartmentSimpleVO.class);
    }

    @GetMapping("/employees")
    public Page<EmployeeDO> findAllEmployees(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PutMapping("/employee/age/{id}/{age}")
    public int updateEmployeeAgeById(@PathVariable Long id, @PathVariable Integer age) {
        return repository.updateEmployeeAgeById(id, age);
    }


}
