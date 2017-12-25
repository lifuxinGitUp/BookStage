package com.lanou.bookstore.cart;

import com.lanou.bookstore.book.domain.Book;

import java.io.Serializable;

/**
 * Created by dllo on 17/9/22.
 */
public class CartItem implements Serializable{
    private Book book;
    private Integer count;
    private double subtotal;

    public CartItem() {
    }

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
