package com.github.spring.boot.jpa.projection.pojo.vo;


import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/2/26 9:32 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IComplexSystemMenuVO {

    Long getId();

    String getName();

    String getCode();

    List<IComplexSystemMenuVO> getChildMenus();

}
