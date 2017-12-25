package com.lanou.bookstore.user.web.servlet;

import com.lanou.vcode.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by dllo on 17/9/29.
 */
@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 创建验证码类
        VerifyCode verifyCode = new VerifyCode();
        // 得到验证码图片
        BufferedImage img = verifyCode.getImage();
        // 保存图片上的内容, session 中
        request.getSession().setAttribute("session_vcode",verifyCode.getText());
        // 把图片响应到客户端
        VerifyCode.output(img,response.getOutputStream());
    }
}
