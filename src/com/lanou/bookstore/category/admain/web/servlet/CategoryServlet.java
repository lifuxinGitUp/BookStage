package com.lanou.bookstore.category.admain.web.servlet;

import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.CategoryService;
import com.lanou.bookstore.category.service.impl.CatehoryServiceImpl;
import com.lanou.servlet.BaseServlet;
import com.sun.xml.internal.rngom.parse.host.Base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/29.
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CatehoryServiceImpl();
    public String findAll(HttpServletRequest request,HttpServletResponse response){
        List<Category> list = categoryService.findAll();
        request.setAttribute("categories",list);
        return "f:/jsps/left.jsp";
    }
}

