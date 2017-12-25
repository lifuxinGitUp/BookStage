package com.lanou.bookstore.user.dao;

import com.lanou.bookstore.user.domain.User;

/**
 * Created by dllo on 17/9/21.
 */
public interface UserDao {
    // 注册用户
    void insert_tb_user(User formUser);
    // 查询用户是否存在
    User findWithUName(String username);
    // 邮箱验证登录
    void update_UUid(String code);
    // 用户登录
    boolean loginUser(String username,String password);

    User select(String username);

    // 查询是否有重复名的用户
    boolean cuser(String username);
}
