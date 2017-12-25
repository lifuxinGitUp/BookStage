package com.lanou.bookstore.book.service;



import com.lanou.bookstore.book.domain.Book;

import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public interface BookService {
    // 查询所有
    List findAll();
    // 分类查询
    List findOne(String cid);
    Book findOnlyOne(String bid);

    // 加载图书
    Book load(String bid);
    // 添加图书
    void add(Book book);
    // mod 删除图书
    void del(String bid);
    // 编辑图书
    void edit(Book book);


}
