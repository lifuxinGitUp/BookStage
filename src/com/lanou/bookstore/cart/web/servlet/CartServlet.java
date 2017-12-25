package com.lanou.bookstore.cart.web.servlet;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.impl.BookServiceImpl;
import com.lanou.bookstore.cart.Cart;
import com.lanou.bookstore.cart.CartItem;
import com.lanou.servlet.BaseServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by dllo on 17/9/21.
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {

    private BookServiceImpl bookService = new BookServiceImpl();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        得到 用户名
//        String username = (String) request.getSession().getAttribute("username");
//        得到以用户名创建出的车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
//        获取表单中 bid 和 count
        String bid = request.getParameter("bid");
        int count = Integer.parseInt(request.getParameter("count"));
//        通过 bid 获取 book 的详细内容
        Book book = bookService.findOnlyOne(bid);

//        创建一个 cart 类型的 Map 对象
        Map<String, CartItem> cartMap = cart.getCartMap();
        CartItem cartItem = new CartItem(book, count);
        cartMap.put(bid, cartItem);
        cart.setCartMap(cartMap);

        request.getSession().setAttribute("cart", cart);

        System.out.println(cart);


        return "f:/jsps/cart/list.jsp";


    }

    public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = new Cart();
        cart.setCartMap(new HashMap<>());

        request.getSession().setAttribute("cart", cart);

        return "f:/jsps/cart/list.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bid = request.getParameter("bid");

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.delete(cart, bid);

        return "f:/jsps/cart/list.jsp";


    }


}
