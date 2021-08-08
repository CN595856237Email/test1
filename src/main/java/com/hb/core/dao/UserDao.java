package com.hb.core.dao;

import com.hb.core.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Dao层
 */
public interface UserDao {
    /**
     * 通过账号和密码查询用户
     */

    public User findUser(@Param("usercode") String usercode,@Param("password") String password);
}
