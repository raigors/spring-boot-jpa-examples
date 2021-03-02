package com.github.spring.boot.jpa.many.to.many.pojo.common;

/**
 * 用户信息工具类
 * <p>
 * create in 2021/2/23 5:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public final class UserInfoConstant {

    private UserInfoConstant() {
    }

    /**
     * 表的名称
     */
    public static final String USER_INFO = "many_to_many_tb_user_info";

    /**
     * 用户名
     */
    public static final String USERNAME = "username";

    /**
     * 电子邮箱
     */
    public static final String EMAIL = "email";

    public static final String MID_USER_ID = "mid_user_id";

}
