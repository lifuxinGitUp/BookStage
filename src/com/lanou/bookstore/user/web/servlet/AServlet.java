package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.user.service.UserService;
import com.lanou.bookstore.user.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dllo on 17/9/29.
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        boolean b = userService.cuser(username);
        if (b){
            response.getWriter().print(1);
        }else {
            response.getWriter().print(0);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
    }
}
