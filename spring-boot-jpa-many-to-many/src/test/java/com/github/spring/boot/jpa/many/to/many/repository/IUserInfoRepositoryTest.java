package com.github.spring.boot.jpa.many.to.many.repository;

import com.github.spring.boot.jpa.many.to.many.pojo.orm.RoleInfoDO;
import com.github.spring.boot.jpa.many.to.many.pojo.orm.UserInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import java.util.Collections;

/**
 * TODO
 * <p>
 * create in 2021/3/1 11:34 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@SpringBootTest
class IUserInfoRepositoryTest {

    @Resource
    private IUserInfoRepository userInfoRepository;

    @Resource
    private IRoleInfoRepository roleInfoRepository;

    @Resource
    private EntityManager entityManager;

    /**
     * {@link UserInfoDO#getRoles()} 上 cascade 至少有 {@link CascadeType#PERSIST}
     */
    @Test
    void cascadeTypePersist() {
        UserInfoDO user = getUserInfo();
        user.setRoles(Collections.singletonList(getRoleInfo()));
        userInfoRepository.save(user);
//        Assertions.assertEquals(1, userInfoRepository.count());
//        Assertions.assertEquals(1, roleInfoRepository.count());
    }

    /**
     * {@link UserInfoDO#getRoles()} 上 cascade 至少有 {@link CascadeType#PERSIST}
     */
    @Test
    void saveRole() {
        RoleInfoDO role = getRoleInfo();
        role.setUsers(Collections.singletonList(getUserInfo()));
        roleInfoRepository.save(role);
        Assertions.assertEquals(0, userInfoRepository.count());
        Assertions.assertEquals(1, roleInfoRepository.count());
    }

    /**
     * {@link UserInfoDO#getRoles()} 上 cascade 至少有 {@link CascadeType#REMOVE}
     * 生产环境慎用
     */
    @Test
    void cascadeTypeRemove() {
        UserInfoDO user = getUserInfo();
        user.setRoles(Collections.singletonList(getRoleInfo()));
        UserInfoDO saved = userInfoRepository.save(user);
        Assertions.assertEquals(1, userInfoRepository.count());
        Assertions.assertEquals(1, roleInfoRepository.count());
        userInfoRepository.delete(saved);
        Assertions.assertEquals(0, userInfoRepository.count());
        Assertions.assertEquals(0, roleInfoRepository.count());
    }

    /**
     * {@link UserInfoDO#getRoles()} 上 cascade 至少有 {@link CascadeType#REMOVE}
     * 生产环境慎用
     */
    @Test
    void cascadeTypeDetach() {
        UserInfoDO user = getUserInfo();
        user.setRoles(Collections.singletonList(getRoleInfo()));
        userInfoRepository.save(user);
        Assertions.assertEquals(1, userInfoRepository.count());
        Assertions.assertEquals(1, roleInfoRepository.count());
        roleInfoRepository.deleteAll(roleInfoRepository.findAll());
        Assertions.assertEquals(1, userInfoRepository.count());
        Assertions.assertEquals(0, roleInfoRepository.count());
    }


    private UserInfoDO getUserInfo() {
        return UserInfoDO.builder()
                .username("mm:" + System.currentTimeMillis())
                .email("mm@ss.com")
                .age(12)
                .build();
    }

    private RoleInfoDO getRoleInfo() {
        return RoleInfoDO.builder()
                .roleName("test_role_name:" + System.currentTimeMillis())
                .roleCode("test_code_name:" + System.currentTimeMillis())
                .build();
    }
}