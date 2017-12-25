package com.lanou.bookstore.book.web.servlet;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.impl.BookServiceImpl;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
    private BookService service = new BookServiceImpl();

    /**
     * 查询所有
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List books = service.findAll();
        System.out.println("aa"+ books);
        request.setAttribute("books",books);
        return "f:/jsps/book/list.jsp";
    }

    /**
     * 查询分类
     * @param request
     * @param response
     * @return
     */
    public String findOne(HttpServletRequest request,HttpServletResponse response){
        String cid = request.getParameter("cid");
        List books = service.findOne(cid);
        request.setAttribute("books",books);
        return "f:/jsps/book/list.jsp";

    }

    // 查询单本书的信息
    public String findOnlyOne(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Book books = service.findOnlyOne(bid);
        request.setAttribute("books",books);

        return "f:/jsps/book/desc.jsp";

    }
    // 查询一本书的详细信息
    public String findOnlyOne1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
//        System.out.println(bid);
        Book books = service.findOnlyOne(bid);
        request.setAttribute("books1",books);
        return "f:/jsps/cart/list.jsp";

    }






}
