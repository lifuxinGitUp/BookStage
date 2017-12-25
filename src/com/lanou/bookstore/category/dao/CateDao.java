package com.lanou.bookstore.category.dao;

import com.lanou.bookstore.category.domain.Category;

import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
public interface CateDao {
    // 管理员登录
    boolean adminLogin(String adminname, String password);
    // 查询所有分类
    List findAll();
    // 添加分类
    void add(Category category);

    // 删除分类
    void delete(String cid);
    int getCount(String cid);


    Category editPre(String cid);

    // 修改分类
    void update(Category category);

}
