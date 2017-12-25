package com.lanou.bookstore.book.service.impl;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.dao.impl.BookDaoImpl;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;

import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    /**
     * 查询所有
     * @return
     */
    @Override
    public List findAll() {
        List list = bookDao.findAll();
        System.out.println("LLLLL" + list);
        return list;
    }

    /**
     * 分类查询
     * @param cid
     * @return
     */
    @Override
    public List findOne(String cid) {
        List findOne = bookDao.findOne(cid);
        return findOne;
    }

    /**
     * 书的详细信息
     * @param bid
     * @return
     */
    @Override
    public Book findOnlyOne(String bid) {
        Book book = bookDao.findOnlyOne(bid);
        return book;
    }

    @Override
    public Book load(String bid) {
       return bookDao.load(bid);

    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    // mod 删除图书
    @Override
    public void del(String bid) {
        bookDao.del(bid);
    }
    // 编辑图书
    @Override
    public void edit(Book book) {
        bookDao.edit(book);
    }






}
