<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>订单列表</title>

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
        * {
            font-size: 11pt;
        }

        div {
            border: solid 2px gray;
            width: 75px;
            height: 75px;
            text-align: center;
        }

        li {
            margin: 10px;
        }

        #buy {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -902px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }

        #buy:HOVER {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -938px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }
        body{
            background: url("/storephoto/swe.jpg");
        }
    </style>
</head>

<body>
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">
    <c:forEach items="${orders}" var="order">
        <tr bgcolor="gray" bordercolor="gray">
            <td colspan="6">
                订单编号：${order.oid}　成交时间：${order.ordertime}　金额：<font color="red"><b>${order.total}</b></font>　

                <a href="<c:url value='/OrderServlet?method=load&oid=${order.oid}'/>">
                    <c:choose>
                        <c:when test="${order.state == 1}">付款</c:when>
                        <c:when test="${order.state == 2}">未发货|</c:when>
                        <c:when test="${order.state == 3}">卖家已发货</c:when>
                    </c:choose>
                </a>

                <c:if test="${order.state == 3}">

                |运输中|
                </c:if>
                <a href="<c:url value='OrderServlet?method=confirm&oid=${order.oid}'/>">
                    <c:choose>
                        <c:when test="${order.state == 2}">提醒发货</c:when>
                        <c:when test="${order.state == 3}">确认收货</c:when>
                        <c:when test="${order.state == 4}">|交易已完成|</c:when>
                    </c:choose>
                </a>

            </td>
        </tr>
        <c:forEach var="orderItem" items="${order.orderItemList}">
            <tr bordercolor="gray" align="center">
                <td width="15%">
                    <div><img src="<c:url value='${orderItem.book.image}'/>" height="75"/></div>
                </td>
                <td>书名：${orderItem.book.bname}</td>
                <td>单价：${orderItem.book.price}</td>
                <td>作者：${orderItem.book.author}</td>
                <td>数量：${orderItem.count}</td>
                <td>小计：${orderItem.subtotal}</td>
            </tr>

        </c:forEach>
    </c:forEach>


</table>
</body>
</html>
