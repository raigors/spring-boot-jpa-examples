package com.github.spring.boot.jpa.converter.controller;

import com.github.spring.boot.jpa.converter.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.converter.repository.IUserInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/24 5:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
public class UserInfoController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("/users")
    public Page<UserInfoDO> findAllUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
