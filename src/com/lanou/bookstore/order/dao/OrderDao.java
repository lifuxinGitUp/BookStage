package com.lanou.bookstore.order.dao;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;

import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
public interface OrderDao {
    void addOrder(Order order);


    Book findByBid(String bid);

    void addOrderItemList(List<OrderItem> orderItemList);
    // 我的订单
    List<Order> findByUid(String uid);
    // 付款功能
    Order load(String oid);
    // 确认收货
    Order getStateByOid(String oid);

    void updateState(String oid,int state);

    // 付款 修改state的状态
    void pay(Order order);

    // 发货
    void send(String oid);

    // 查询所有
    List<Order> findAll();

    // 管理员查询未付款订单
    List<Order> noPay(String state);

}
