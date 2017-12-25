package com.lanou.bookstore.order.web.servlet;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.Cart;
import com.lanou.bookstore.cart.CartItem;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;
import com.lanou.bookstore.order.service.OrderException;
import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.order.service.impl.OrderServiceImpl;
import com.lanou.bookstore.user.domain.User;
import com.lanou.commons.CommonUtils;
import com.lanou.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/9/23.
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    // 添加订单到数据库
    public String add(HttpServletRequest request, HttpServletResponse response) {
        Order order = new Order();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        User user = (User) request.getSession().getAttribute("user");
        Double num = Double.valueOf(request.getParameter("sum"));
        order.setOid(CommonUtils.uuid());
        order.setState(1);
        order.setOrdertime(time);
        order.setUid(user.getUid());
        order.setTotal(num);
        order.setAddress(null);
        orderService.addOrder(order);

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Map<String, CartItem> map = cart.getCartMap();
        List<OrderItem> orderItemList = new ArrayList<>();
        for (String key : map.keySet()) {
            OrderItem orderItem = new OrderItem();
            int count = map.get(key).getCount();
            Double price = Double.valueOf(map.get(key).getBook().getPrice());
            orderItem.setIid(CommonUtils.uuid());
            orderItem.setCount(count);
            orderItem.setSubtotal(count * price);
            orderItem.setOid(order.getOid());
            orderItem.setBid(key);
            Book book = orderService.findByBid(key);
            orderItem.setBook(book);
            orderItemList.add(orderItem);
        }
        order.setOrderItemList(orderItemList);
        orderService.addOrderItemList(orderItemList);
        request.setAttribute("order", order);
        cart.clear();
        return "f:/jsps/order/desc.jsp";
    }


    // 我的订单
    public String findByUid(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orders = orderService.findByUid(user.getUid());
//        System.out.println("orders" + orders);
        request.setAttribute("orders", orders);
        return "f:/jsps/order/list.jsp";
    }

    // 付款
    public String load(HttpServletRequest request, HttpServletResponse response) {
        String oid = request.getParameter("oid");
        Order order = orderService.load(oid);
        request.setAttribute("order",order);
        return "f:/jsps/order/desc.jsp";

    }
    // 确认收货

    public String confirm(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        try {
            orderService.confirm(oid);
            request.setAttribute("msg","确认成功,交易完成!!");
        } catch (OrderException e) {
            request.setAttribute("msg",e.getMessage());
        }
        return "f:/jsps/order/msg.jsp";
    }
    // 付款 修改 state的状态
    public String pay(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        Order order = new Order();
        order.setAddress(request.getParameter("address"));
        String address = request.getParameter("address");
        order.setState(2);
        order.setOid(oid);
        orderService.pay(order);
        request.setAttribute("address",address);
        request.setAttribute("msg","恭喜支付成功");
        return "f:/jsps/order/msg.jsp";
    }









}
