package com.lanou.bookstore.user.service;

import com.lanou.bookstore.user.domain.User;

/**
 * Created by dllo on 17/9/21.
 */
public interface UserService {
    // 注册
    void register(User formUser) throws UserException;
    // 登录
    boolean loginUser(String username, String password);
    // 根据姓名查询用户
    User select(String username);
    // 查询数据库是否有名为.. 的用户
    boolean cuser(String username);
}
