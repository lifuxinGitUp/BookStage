package com.lanou.bookstore.category.dao.impl;

import com.lanou.bookstore.category.dao.CateDao;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
public class CategoryDaoImpl implements CateDao {
    QueryRunner qr = new GxQueryRunner();
    // 管理员验证登录
    @Override
    public boolean adminLogin(String adminname, String password) {
        String sql = "select * from admin where adminname=? AND password =?";
        Object[] params = {adminname,password};
        try {
            Category query = qr.query(sql, new BeanHandler<>(Category.class), params);
            if (!(query == null)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // 查询分类
    @Override
    public List findAll() {
        String sql = "select * from category";
        try {
            return qr.query(sql, new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // 添加分类
    @Override
    public void add(Category category) {
        String sql = "insert into category values(?,?)";
        Object[] params = {category.getCid(),category.getCname()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 删除分类
    @Override
    public void delete(String cid) {

        String sql = "delete from category where cid =?";
        try {
            qr.update(sql,cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查询指定分类下图书的本数
    @Override
    public int getCount(String cid) {
        String sql = "select count(*) from book where cid=?";

        try {
          Number num = qr.query(sql, new ScalarHandler<>(), cid);
            return num.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    // 根据cid 查找图书的所有
    @Override
    public Category editPre(String cid) {
        String sql = "select * from category where cid=?";
        try {
            return qr.query(sql,new BeanHandler<>(Category.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 修改分类
    @Override
    public void update(Category category) {
        String sql = "update category set cname=? where cid=?";
        try {
            qr.update(sql,category.getCname(),category.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
