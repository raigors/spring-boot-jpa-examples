package com.github.spring.boot.jpa.jpql.repository;

import com.github.spring.boot.jpa.jpql.pojo.orm.DepartmentDO;
import com.github.spring.boot.jpa.jpql.pojo.orm.EmployeeDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 员工增删改查接口
 * <p>
 * create in 2021/2/24 2:42 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IEmployeeRepository extends JpaRepository<EmployeeDO, Long> {

    /**
     * DepartmentDO
     *
     * @param id id
     * @return DepartmentDO
     */
    @Query("SELECT employee.department FROM EmployeeDO AS employee WHERE employee.id = :id")
    DepartmentDO findEmployeeDepartmentById(long id);

    /**
     * 不生效
     *
     * @param id
     * @param clz
     * @param <T>
     * @return
     */
    @Query("SELECT employee.department FROM EmployeeDO AS employee WHERE employee.id = :id")
    <T> T findEmployeeDepartmentById(long id, Class<T> clz);

    @Query("SELECT employee FROM EmployeeDO AS employee WHERE employee.age < (SELECT AVG(p.age) FROM employee p)")
    Page<EmployeeDO> findAllByAvg(Pageable pageable);

    /**
     * 根据ID修改年龄
     *
     * @param id  id
     * @param age age
     * @return int
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE EmployeeDO AS employee SET employee.age = :age, employee.lastModifiedDate=CURRENT_TIMESTAMP WHERE employee.id = :id")
    int updateEmployeeAgeById(long id, int age);

    /**
     * 更新 salary
     *
     * @param id     id
     * @param salary salary
     * @return int
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE EmployeeDO AS employee SET employee.salary =(employee.salary + :salary) WHERE employee.id = :id")
    int updateSalaryById(long id, int salary);
}
