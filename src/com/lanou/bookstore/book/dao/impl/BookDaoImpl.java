package com.lanou.bookstore.book.dao.impl;


import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sun.jvm.hotspot.debugger.bsd.amd64.BsdAMD64CFrame;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public class BookDaoImpl implements BookDao {
    private QueryRunner qr = new GxQueryRunner();

    /**
     * 查询所有
     * @return
     */
    @Override
    public List findAll() {
        String sql = "select * from book where del=false";
        try {
            List<Book> books = qr.query(sql, new BeanListHandler<>(Book.class));
//            System.out.println(books);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 分类查询
     * @return
     */
    @Override
    public List findOne(String cid) {
        String sql = "select * from book where cid=?";
        try {
            List<Book> books = qr.query(sql, new BeanListHandler<>(Book.class), cid);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 详细查询
     * @param bid
     * @return
     */
    @Override
    public Book findOnlyOne(String bid) {
        String sql = "select * from book where bid=?";
        try {
            Book query = qr.query(sql, new BeanHandler<>(Book.class), bid);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 加载图书
    @Override
    public Book load(String bid) {
        String sql = "select * from book where bid = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Book.class),bid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //  添加图书
    @Override
    public void add(Book book) {
        String sql = "insert into book values (?,?,?,?,?,?,?)";
        Object[] params = {book.getBid(),book.getBname(),book.getPrice(),book.getAuthor(),
                book.getImage(),book.getCid(),false};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // mod 删除图书
    @Override
    public void del(String bid) {
        String sql = "update book set del=true where bid=?";
        try {
            qr.update(sql,bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // edit 编辑图书
    @Override
    public void edit(Book book) {
        String sql = "update book set bname=?,price=?,author=?,cid=? where bid=?";
        Object[] params = {book.getBname(),book.getPrice(),book.getAuthor(),book.getCid(),book.getBid()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
