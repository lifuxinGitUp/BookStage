package com.lanou.bookstore.category.admain.web.servlet;

import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.impl.BookServiceImpl;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.CategoryException;
import com.lanou.bookstore.category.service.CategoryService;
import com.lanou.bookstore.category.service.impl.CatehoryServiceImpl;
import com.lanou.commons.CommonUtils;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
@WebServlet("/AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CatehoryServiceImpl();
    private BookService bookService = new BookServiceImpl();

    // 管理员登录
    public void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        String password = request.getParameter("password");
        boolean b = categoryService.adminLogin(adminname, password);
        if (b) {
            request.getSession().setAttribute("adminname",adminname);
            request.getRequestDispatcher("/adminjsps/admin/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/adminjsps/login.jsp").forward(request, response);
        }
    }

    // 查询所有分类
    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Category> all = categoryService.findAll();
//        System.out.println(all);
        request.setAttribute("all", all);
        return "f:/adminjsps/admin/category/list.jsp";
    }

    // 添加分类
    public String add(HttpServletRequest request, HttpServletResponse response) {
        Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
        category.setCid(CommonUtils.uuid());
        categoryService.add(category);
        return findAll(request, response);
    }

    // 删除分类
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        String cid = request.getParameter("cid");
        try {
            categoryService.delete(cid);
            request.setAttribute("msg", "删除成功");
        } catch (CategoryException e) {
            request.setAttribute("msg", e.getMessage());
        }
        return "f:/adminjsps/msg.jsp";
    }

    public String deletePre(HttpServletRequest request, HttpServletResponse response) {
        String cid = request.getParameter("cid");
        Category category = categoryService.editPre(cid);
        request.setAttribute("category", category);
        return "f:/adminjsps/admin/category/del.jsp";

    }

    // 修改分类
    public String updatePre(HttpServletRequest request, HttpServletResponse response) {
        String cid = request.getParameter("cid");
        Category category = categoryService.editPre(cid);
        request.setAttribute("category",category);
        return "f:/adminjsps/admin/category/mod.jsp";
    }
    public String update(HttpServletRequest request,HttpServletResponse response){
        Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
        categoryService.updatePre(category);
        findAll(request,response);
        request.setAttribute("msg","修改成功");
        return "f:/adminjsps/msg.jsp";
    }



}
