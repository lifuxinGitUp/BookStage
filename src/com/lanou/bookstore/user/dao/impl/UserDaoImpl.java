package com.lanou.bookstore.user.dao.impl;

import com.lanou.bookstore.user.dao.UserDao;
import com.lanou.bookstore.user.domain.User;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by dllo on 17/9/21.
 */
public class UserDaoImpl implements UserDao {
    private QueryRunner qr = new GxQueryRunner();
    /**
     * 注册
     * @param formUser
     */
    @Override
    public void insert_tb_user(User formUser) {
        String sql = "INSERT INTO tb_user(uid,username,password,email,code,state) values(?,?,?,?,?,?)";
        Object[] params = {formUser.getUid(),formUser.getUsername(),formUser.getPassword(),formUser.getEmail(),formUser.getCode(),false};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询数据库是否重名
     * @param username
     * @return
     */
    @Override
    public User findWithUName(String username) {
        String sql = "SELECT * FROM tb_user WHERE username=?";
        try {
           return qr.query(sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 邮箱验证登录
     * 修改数据库的状态码
     * @param code
     */
    @Override
    public void update_UUid(String code) {
        String sql = "update tb_user set state=true where code=?";
        try {
            qr.update(sql,code);
            System.out.println("sql:::::"+qr.update(sql,code));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean loginUser(String username, String password) {
        String sql = "select * from tb_user where username=? and password = ? AND state =1";
        Object[] params = {username,password};
        try {
            User query = qr.query(sql, new BeanHandler<>(User.class), params);
            if (!(query == null)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // 根据姓名查询用户
    @Override
    public User select(String username) {

        String sql = "select * from tb_user where username = ?";
        try {
           return qr.query(sql,new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cuser(String username) {
        String sql = "select * from tb_user where username = ?";
        try {
            User query = qr.query(sql, new BeanHandler<>(User.class), username);
            if (!(query == null)){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}
