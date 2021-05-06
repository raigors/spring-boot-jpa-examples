package com.github.spring.boot.jpa.index.repository;

import com.github.spring.boot.jpa.index.pojo.orm.EmployeeBasicInfoDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/5/6 6:43 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IEmployeeBasicInfoRepositoryTest {

    @Resource
    private IEmployeeBasicInfoRepository repository;

    @Test
    void save() {
        EmployeeBasicInfoDO build = EmployeeBasicInfoDO.builder()
                .name("test_name")
                .address("test_address")
                .age(18)
                .mobile("test_mobile")
                .build();
        repository.save(build);
    }
}