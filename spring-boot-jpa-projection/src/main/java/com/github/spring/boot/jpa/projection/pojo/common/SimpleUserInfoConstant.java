package com.github.spring.boot.jpa.projection.pojo.common;

/**
 * 用户信息工具类
 * <p>
 * create in 2021/2/23 5:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public final class SimpleUserInfoConstant {

    private SimpleUserInfoConstant() {
    }

    /**
     * 表的名称
     */
    public static final String USER_INFO = "tb_user_info_projection_simple";

    /**
     * 用户名
     */
    public static final String USERNAME = "username";

    /**
     * 电子邮箱
     */
    public static final String EMAIL = "email";

}
