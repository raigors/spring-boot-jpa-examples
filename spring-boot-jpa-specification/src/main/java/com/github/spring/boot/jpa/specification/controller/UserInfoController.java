package com.github.spring.boot.jpa.specification.controller;

import com.github.spring.boot.jpa.specification.pojo.dto.UserInfoDTO;
import com.github.spring.boot.jpa.specification.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.specification.repository.IUserInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/2/25 3:50 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class UserInfoController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("/users")
    public Page<UserInfoDO> listUsers(UserInfoDTO user, Pageable pageable) {
        return repository.findAll((Specification<UserInfoDO>) (root, query, builder) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNotBlank(user.getUsername())) {
                Predicate predicateParent = builder.equal(root.get("username").as(Long.class), user.getUsername());
                list.add(predicateParent);
            }
            if (!ObjectUtils.isEmpty(user.getAge())) {
                Predicate predicateParent = builder.ge(root.get("age").as(Integer.class), user.getAge());
                list.add(predicateParent);
            }
            Predicate[] predicates = list.toArray(new Predicate[0]);
            return query.where(predicates).getRestriction();
        }, pageable);
    }



}
