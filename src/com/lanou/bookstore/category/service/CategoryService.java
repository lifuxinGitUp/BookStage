package com.lanou.bookstore.category.service;

import com.lanou.bookstore.category.domain.Category;

import java.util.List;


/**
 * Created by dllo on 17/9/25.
 */
public interface CategoryService {
    // 管理员登录
    boolean adminLogin(String adminname,String password);
    // 查看所有分类
    List<Category> findAll();
    // 添加分类
    void add(Category category);
    // 删除分类
    void delete(String cid) throws CategoryException;
    // 查询某个分类下图书的数量
    Category editPre(String cid);
    // 修改分类
    void updatePre(Category category);

}
