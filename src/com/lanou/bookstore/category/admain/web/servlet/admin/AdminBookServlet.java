package com.lanou.bookstore.category.admain.web.servlet.admin;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.impl.BookServiceImpl;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.CategoryService;
import com.lanou.bookstore.category.service.impl.CatehoryServiceImpl;
import com.lanou.commons.CommonUtils;
import com.lanou.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/9/26.
 */
@WebServlet("/AdminBookServlet")
public class AdminBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    private CategoryService categoryService = new CatehoryServiceImpl();

    // 查询所有图书
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        List books = bookService.findAll();
//        System.out.println(books);
        request.setAttribute("lists",books);
        return "f:/adminjsps/admin/book/list.jsp";
    }
    // 加载图书
    public String findOnlyOne(HttpServletRequest request,HttpServletResponse response){

        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories",categories);
        String bid = request.getParameter("bid");
        Book book = bookService.load(bid);
        request.setAttribute("book",book);

        return "f:/adminjsps/admin/book/desc.jsp";
    }
    // 添加图书
    public String addPre(HttpServletRequest request,HttpServletResponse response){
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories",categories);
        return "f:/adminjsps/admin/book/add.jsp";
    }
    // 删除图书
    public String del(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        bookService.del(bid);
//        System.out.println("删除图书了!!!");
        findAll(request,response);
        request.setAttribute("msg","删除成功");
        return "f:/adminjsps/admin/msg.jsp";
    }

    // 编辑图书
    public String edit(HttpServletRequest request,HttpServletResponse response){
        Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
        bookService.edit(book);
        findAll(request,response);
        request.setAttribute("msg","编辑成功");
        return "f:/adminjsps/admin/msg.jsp";
    }


}
