package com.github.spring.boot.jpa.one.to.many.controller;

import com.github.spring.boot.jpa.one.to.many.pojo.orm.DepartmentDO;
import com.github.spring.boot.jpa.one.to.many.repository.IDepartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 部门增删改查接口
 * <p>
 * create in 2021/2/24 3:37 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class DepartmentController {

    @Resource
    private IDepartmentRepository repository;

    @GetMapping("/departments")
    public Page<DepartmentDO> findAllDepartments(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/department/{id}")
    public DepartmentDO findAllDepartments(@PathVariable long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") DepartmentDO department) {
        repository.delete(department);
        return "deleteDepartmentById";
    }

}
