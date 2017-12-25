package com.lanou.bookstore.user.service.impl;

import com.lanou.bookstore.user.dao.UserDao;
import com.lanou.bookstore.user.dao.impl.UserDaoImpl;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.service.UserException;
import com.lanou.bookstore.user.service.UserService;
import com.lanou.commons.CommonUtils;

/**
 * Created by dllo on 17/9/21.
 */
public class UserServiceImpl implements UserService {
    /**
     * 判断数据库中是否存在
     * 不存在则添加
     * @param formUser
     * @throws UserException
     */

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User formUser) throws UserException {
        System.out.println("这是注册");
        User dbUser = userDao.findWithUName(formUser.getUsername());
        if (dbUser != null){
            throw new UserException("用户: " + formUser.getUsername() + "已经存在");
        }
//         用户bu存在, 可以添加到数据库
        formUser.setUid(CommonUtils.uuid());
        userDao.insert_tb_user(formUser);
    }

    /**
     * 判断登录
     * @param username
     * @param password
     */
    @Override
    public boolean loginUser(String username, String password) {

            boolean b = userDao.loginUser(username, password);
            if (b){
                return b;
            }else {
                return false;
            }

    }

    @Override
    public User select(String username) {
       return userDao.select(username);
    }

    // 查询是否有重复名的用户
    @Override
    public boolean cuser(String username) {
        return userDao.cuser(username);
    }
}
