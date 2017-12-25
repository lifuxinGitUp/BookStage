package com.lanou.bookstore.order.service;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;

import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
public interface OrderService {
    // 添加订单
    void addOrder(Order order);
    // 查询书的信息
    Book findByBid(String bid);
    // 本次订单的信息
    void addOrderItemList(List<OrderItem> orderItemList);
    // 我的订单
    List<Order> findByUid(String uid);
    // 付款
    Order load(String oid);
    // 确认收货
    void confirm(String oid) throws OrderException;

    // 确认购买  修改state的状态
    void pay(Order order);

    // 管理员发货
    void send(String oid);

    // 查询所有信息
    List<Order> findAll();
    // 管理员查询未付款订单
    List<Order> noPay(String state);

}
