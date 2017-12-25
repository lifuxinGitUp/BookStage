package com.lanou.bookstore.order.service.impl;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.dao.impl.OrderDaoImpl;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;
import com.lanou.bookstore.order.service.OrderException;
import com.lanou.bookstore.order.service.OrderService;

import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public Book findByBid(String bid) {
        return orderDao.findByBid(bid);
    }

    @Override
    public void addOrderItemList(List<OrderItem> orderItemList) {
       orderDao.addOrderItemList(orderItemList);
    }

    @Override
    public List<Order> findByUid(String uid) {
        return orderDao.findByUid(uid);
    }
    // 付款
    @Override
    public Order load(String  oid) {
        return orderDao.load(oid);

    }

    // 确认收货
    @Override
    public void confirm(String oid) throws OrderException {
        Order order = orderDao.getStateByOid(oid);
        if (order.getState() != 2){
            throw new OrderException("还没发货,你就确认是不是虎!");
        }
        orderDao.updateState(oid,4);
    }

    // 付款 修改 state 的状态
    @Override
    public void pay(Order order) {
        orderDao.pay(order);
    }

    // 发货
    @Override
    public void send(String oid) {
        orderDao.send(oid);
    }

    // 查询所有
    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    // 管理员查询未付款订单
    @Override
    public List<Order> noPay(String state) {
        return orderDao.noPay(state);
    }


}
