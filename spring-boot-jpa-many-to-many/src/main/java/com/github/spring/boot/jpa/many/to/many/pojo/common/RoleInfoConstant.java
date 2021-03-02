package com.github.spring.boot.jpa.many.to.many.pojo.common;

/**
 * 用户信息工具类
 * <p>
 * create in 2021/2/23 5:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public final class RoleInfoConstant {

    private RoleInfoConstant() {
    }

    /**
     * 表的名称
     */
    public static final String ROLE_INFO = "many_to_many_tb_role_info";

    /**
     * 角色名
     */
    public static final String ROLE_NAME = "role_name";

    public static final String ROLE_CODE = "role_code";


    public static final String MID_ROLE_ID = "mid_role_id";

}
