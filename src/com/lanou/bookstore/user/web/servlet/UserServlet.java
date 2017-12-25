package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.cart.Cart;
import com.lanou.bookstore.user.dao.UserDao;
import com.lanou.bookstore.user.dao.impl.UserDaoImpl;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.service.UserException;
import com.lanou.bookstore.user.service.UserService;
import com.lanou.bookstore.user.service.impl.UserServiceImpl;
import com.lanou.commons.CommonUtils;
import com.lanou.mail.Mail;
import com.lanou.mail.MailUtils;
import com.lanou.servlet.BaseServlet;

import javax.mail.MessagingException;
import javax.mail.Session;
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
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();

    /**
     * 注册
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException, UserException, MessagingException {

        /*
        1. 获取请求参数, 封装到 user 中
         */
        User formUser = CommonUtils.toBean(request.getParameterMap(), User.class);
        formUser.setCode(CommonUtils.uuid());
        userService.register(formUser);

        // 发送邮件验证
        String email = request.getParameter("email");
        String code = formUser.getCode();
        Session session = MailUtils.createSession("smtp.163.com","15724516172@163.com","lifuxin54180");
        Mail mail = new Mail("15724516172@163.com",email,"激活验证","<a href='http://localhost:8080/UserServlet?method=activate&code="+code+"'>点击激活</a>");
        MailUtils.send(session,mail);
        request.setAttribute("msg","发送邮件成功!请打开邮件查收!");

        return "f:/jsps/user/login.jsp";
    }

    /**
     * 获得邮箱反馈的值
     * @param request
     * @param response
     * @return
     */
    public String activate(HttpServletRequest request,HttpServletResponse response){
        String code = request.getParameter("code");
        System.out.println("邮箱反馈的值: "+code);
        UserDao userDao = new UserDaoImpl();
        userDao.update_UUid(code);
        return "f:/jsps/user/activate.jsp";
    }
    // 登录
    public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean b = userService.loginUser(username, password);
        if (b){
            User user = userService.select(username);
            request.getSession().setAttribute("user",user);

            Cart cart = new Cart();
            cart.setCartMap(new HashMap<>());
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("cart",cart);
            request.getRequestDispatcher("/index.jsp").forward(request,response);

        }else {
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        }

    }
    // 用户退出功能
    public String quit(HttpServletRequest request,HttpServletResponse response){
        request.getSession().invalidate();
        return "f:/jsps/user/login.jsp";
    }


}
