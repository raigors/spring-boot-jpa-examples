package com.github.spring.boot.jpa.one.to.many.init;

import com.github.javafaker.Faker;
import com.github.spring.boot.jpa.one.to.many.pojo.orm.DepartmentDO;
import com.github.spring.boot.jpa.one.to.many.pojo.orm.EmployeeDO;
import com.github.spring.boot.jpa.one.to.many.repository.IDepartmentRepository;
import com.github.spring.boot.jpa.one.to.many.repository.IEmployeeRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

/**
 * TODO
 * <p>
 * create in 2021/2/24 3:10 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDataRunner implements CommandLineRunner {

    private static final Faker FAKER = new Faker(Locale.CHINESE);

    private static final int DEPARTMENT_NUM = 5;

    private static final int EMPLOYEE_NUM = 100;

    private final List<DepartmentDO> departmentList = Lists.newArrayList();

    private final IEmployeeRepository employeeRepository;

    private final IDepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (departmentRepository.count() == 0) {
            generateDepartments();
        }
        if (employeeRepository.count() == 0) {
            generateEmployees();
        }
    }

    private void generateDepartments() {
        for (int i = 0; i < DEPARTMENT_NUM; i++) {
            DepartmentDO department = DepartmentDO.builder().departmentName(FAKER.company().name()).build();
            departmentList.add(departmentRepository.save(department));
        }
    }

    private void generateEmployees() {
        for (int i = 0; i < EMPLOYEE_NUM; i++) {
            DepartmentDO department = departmentList.get(FAKER.number().numberBetween(0, 100) % departmentList.size());
            EmployeeDO employee = EmployeeDO.builder().employeeName(FAKER.name().username()).department(department).build();
            employeeRepository.save(employee);
        }
    }
}
