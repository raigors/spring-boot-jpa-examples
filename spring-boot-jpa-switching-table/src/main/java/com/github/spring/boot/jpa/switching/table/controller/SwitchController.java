package com.github.spring.boot.jpa.switching.table.controller;

import com.github.spring.boot.jpa.switching.table.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.switching.table.repository.IUserInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.github.spring.boot.jpa.switching.table.pojo.common.UserInfoConstant.TB_USER_INFO_INDEX;

/**
 * TODO
 * <p>
 * create in 2021/3/4 10:59 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class SwitchController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("/switch/{table}")
    Page<UserInfoDO> findAllUsers1(@PathVariable String table, HttpServletRequest request, Pageable pageable) {
        request.setAttribute(TB_USER_INFO_INDEX, table);
        return repository.findAll(pageable);
    }

}
