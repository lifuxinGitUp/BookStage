<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>top</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        body {
            background: url("/storephoto/top.jpg");
        }

        a {
            text-transform: none;
            text-decoration: none;
            color: red;
        }

        a:hover {
            text-decoration: underline;
        }

    </style>
</head>

<body>


<h1 style="text-align: center; color: #3509ff">网络书城</h1>
<c:if test="${username != null}">

    <strong style="font-size: 13pt">您好：</strong>${username}&nbsp;&nbsp;&nbsp;&nbsp;
    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url
        value='/jsps/cart/list.jsp'/>" target="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;

    <a href="<c:url value='/OrderServlet?method=findByUid'/>" target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
    <a href="javascript:history.back(-1)">返回上一页</a>
    &nbsp;|&nbsp<a href="/UserServlet?method=quit" target="_parent">退出</a>
</c:if>
<c:if test="${username == null}">

    <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">登录</a> |&nbsp;
    <a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册</a>
</c:if>


</body>
</html>
