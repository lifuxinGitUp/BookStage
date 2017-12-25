package com.lanou.bookstore.book.dao;

import com.lanou.bookstore.book.domain.Book;

import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public interface BookDao {
    //查询所有
    List findAll();
    // 分类查询
    List findOne(String cid);

    // 查询书的详细信息
    Book findOnlyOne(String cid);

    // 加载图书
    Book load(String bid);

    // 添加图书
    void add(Book book);

    // 删除图书
    void del(String bid);
    // 编辑图书
    void edit(Book book);


}
