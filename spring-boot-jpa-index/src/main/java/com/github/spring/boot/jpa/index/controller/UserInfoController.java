package com.github.spring.boot.jpa.index.controller;

import com.github.spring.boot.jpa.index.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.index.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/7 10:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RestController
public class UserInfoController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("users")
    public Page<UserInfoDO> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PatchMapping("user/ip/{id}/{ip}")
    public int getAll(@PathVariable long id, @PathVariable String ip) {
        return repository.updateIpById(id, ip);
    }


}
