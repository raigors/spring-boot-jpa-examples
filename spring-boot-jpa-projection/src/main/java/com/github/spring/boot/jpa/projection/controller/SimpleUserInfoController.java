package com.github.spring.boot.jpa.projection.controller;

import com.github.spring.boot.jpa.projection.pojo.vo.ISimpleUserInfoVO;
import com.github.spring.boot.jpa.projection.pojo.vo.SimpleUserInfoVO;
import com.github.spring.boot.jpa.projection.repository.ISimpleUserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/2/24 5:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
@RequiredArgsConstructor
public class SimpleUserInfoController {

    private final ISimpleUserInfoRepository repository;

    @GetMapping("/simple/users1")
    public Page<ISimpleUserInfoVO> findAllUsers1(Pageable pageable) {
        return repository.findAllBy(pageable, ISimpleUserInfoVO.class);
    }

    @GetMapping("/simple/users2")
    public Page<SimpleUserInfoVO> findAllUsers2(Pageable pageable) {
        return repository.findAllBy(pageable, SimpleUserInfoVO.class);
    }

}
