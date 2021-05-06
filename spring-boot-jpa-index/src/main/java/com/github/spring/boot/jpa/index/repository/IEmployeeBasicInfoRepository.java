package com.github.spring.boot.jpa.index.repository;

import com.github.spring.boot.jpa.index.pojo.orm.EmployeeBasicInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 * <p>
 * create in 2021/5/6 6:40 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IEmployeeBasicInfoRepository extends JpaRepository<EmployeeBasicInfoDO, Long> {

}
