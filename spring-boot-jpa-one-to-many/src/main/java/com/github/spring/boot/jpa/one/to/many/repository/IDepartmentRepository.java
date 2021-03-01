package com.github.spring.boot.jpa.one.to.many.repository;

import com.github.spring.boot.jpa.one.to.many.pojo.orm.DepartmentDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 部门增删改查接口
 * <p>
 * create in 2021/2/24 2:42 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IDepartmentRepository extends JpaRepository<DepartmentDO, Long> {

    DepartmentDO findById(long id);

}
