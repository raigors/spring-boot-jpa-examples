package com.github.spring.boot.jpa.many.to.many.repository;

import com.github.spring.boot.jpa.many.to.many.pojo.orm.RoleInfoDO;
import com.github.spring.boot.jpa.many.to.many.pojo.orm.UserInfoDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/3/1 11:34 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class IUserInfoRepositoryTest {

    @Resource
    private IUserInfoRepository userInfoRepository;

    @Resource
    private IRoleInfoRepository roleInfoRepository;

    @Test
    void saveUser() {
        UserInfoDO user = getUserInfo();
        user.setRoles(Collections.singletonList(getRoleInfo()));
        userInfoRepository.save(user);
    }

    @Test
    void saveRole() {
        RoleInfoDO role = getRoleInfo();
        role.setUsers(Collections.singletonList(getUserInfo()));
        roleInfoRepository.save(role);
    }


    @Test
    void removeUser() {
        UserInfoDO user = getUserInfo();
        user.setRoles(Collections.singletonList(getRoleInfo()));
        Optional<RoleInfoDO> optional = roleInfoRepository.findById(1L);
        user = userInfoRepository.save(user);
        UserInfoDO finalUser = user;
        optional.ifPresent(roleInfoDO -> finalUser.getRoles().remove(roleInfoDO));
    }


    private UserInfoDO getUserInfo() {
        return UserInfoDO.builder()
                .username("mm")
                .email("mm@ss.com")
                .age(12)
                .build();
    }

    private RoleInfoDO getRoleInfo() {
        return RoleInfoDO.builder()
                .roleName("role_name")
                .roleCode("code_name")
                .build();
    }
}