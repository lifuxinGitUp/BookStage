<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style>
        body {
            margin-top: 200px;
            background: url("/storephoto/login.jpg");
        }

    </style>

</head>

<body style="text-align: center">
<h1 style="color: #1417eb">登录</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="${pageContext.request.contextPath}/UserServlet" method="post">
    <input type="hidden" name="method" value="login">
    &nbsp;&nbsp;用户名：<input type="text" name="username"  value=""/>&nbsp;&nbsp;<br/><br>
    密　码：<input type="password" name="password"/><br/><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="登录"/>
</form>
</body>

</html>
