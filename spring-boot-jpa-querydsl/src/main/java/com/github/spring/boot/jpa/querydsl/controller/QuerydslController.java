package com.github.spring.boot.jpa.querydsl.controller;

import com.github.spring.boot.jpa.querydsl.pojo.dto.UserInfoDTO;
import com.github.spring.boot.jpa.querydsl.pojo.orm.QUserInfoDO;
import com.github.spring.boot.jpa.querydsl.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.querydsl.repository.IUserInfoRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/24 5:36 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class QuerydslController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("/users")
    public Page<UserInfoDO> queryWeb(@QuerydslPredicate(root = UserInfoDO.class) Predicate predicate, Pageable pageable) {
        return repository.findAll(predicate, pageable);
    }

    @GetMapping("/dsl")
    public Page<UserInfoDO> query(UserInfoDTO userInfo, Pageable pageable) {
        return repository.findAll(predicate(userInfo), pageable);
    }

    private Predicate predicate(UserInfoDTO userInfo) {
        QUserInfoDO qUserInfoDO = QUserInfoDO.userInfoDO;
        BooleanExpression expression = null;
        if (StringUtils.isNotBlank(userInfo.getUsername())) {
            expression = qUserInfoDO.username.startsWith(userInfo.getUsername());
        }
        if (ObjectUtils.isNotEmpty(userInfo.getAge())) {
            assert expression != null;
            expression = expression.and(qUserInfoDO.age.gt(userInfo.getAge()));
        }
        return expression;
    }

}
