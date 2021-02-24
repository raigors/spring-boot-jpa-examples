package com.github.spring.boot.jpa.one.to.many.controller;

import com.github.spring.boot.jpa.one.to.many.pojo.orm.EmployeeDO;
import com.github.spring.boot.jpa.one.to.many.repository.IEmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/employee")
    public Page<EmployeeDO> findAllEmployees(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
