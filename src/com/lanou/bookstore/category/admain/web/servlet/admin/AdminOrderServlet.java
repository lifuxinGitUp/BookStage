package com.lanou.bookstore.category.admain.web.servlet.admin;

import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.order.service.impl.OrderServiceImpl;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/27.
 */
@WebServlet("/AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    // 管理员查询所有订单
    public String findAll(HttpServletRequest request,HttpServletResponse response){
        List<Order> orders = orderService.findAll();
        request.setAttribute("orders",orders);
        return "f:/adminjsps/admin/order/list.jsp";
    }

    // 发货
    public String send(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        orderService.send(oid);
        request.setAttribute("msg","发货成功!");
        findAll(request,response);
        return "f:/adminjsps/msg.jsp";
    }
    // 管理员查询未付款订单
    public String noPay(HttpServletRequest request,HttpServletResponse response){
        String state = request.getParameter("state");
        List<Order> orders = orderService.noPay(state);
        request.setAttribute("orders",orders);
        return "f:adminjsps/admin/order/list.jsp";
    }



}
