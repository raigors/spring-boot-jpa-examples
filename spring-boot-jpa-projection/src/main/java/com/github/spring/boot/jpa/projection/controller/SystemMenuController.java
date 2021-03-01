package com.github.spring.boot.jpa.projection.controller;

import com.github.spring.boot.jpa.projection.pojo.vo.IComplexSystemMenuVO;
import com.github.spring.boot.jpa.projection.pojo.vo.ISystemMenuVO;
import com.github.spring.boot.jpa.projection.repository.ISystemMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/2/26 10:00 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
@RequiredArgsConstructor
public class SystemMenuController {

    @Resource
    private ISystemMenuRepository repository;

    @GetMapping("/root/simple")
    public List<ISystemMenuVO> getSimpleSystemMenu() {
        return repository.findAllByParentMenuIdIsNull(ISystemMenuVO.class);
    }

    @GetMapping("/root/complex")
    public List<IComplexSystemMenuVO> getComplexSystemMenu() {
        return repository.findAllByParentMenuIdIsNull(IComplexSystemMenuVO.class);
    }
}
