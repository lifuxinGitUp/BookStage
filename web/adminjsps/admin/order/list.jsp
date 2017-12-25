<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	body{
		background: url("/storephoto/6666666.jpg");
	}
</style>
  </head>
  
  <body>
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	<c:forEach items="${orders}" var="order">
	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：${order.oid}　成交时间：${order.ordertime}　金额：<font color="red"><a>${order.total}</a></font>
			<a href="<c:url value='/AdminOrderServlet?method=send&oid=${order.oid}'/>">
			<c:choose>
				<c:when test="${order.state == 1}">提醒买家付款</c:when>
				<c:when test="${order.state == 2}">发货</c:when>
				<c:when test="${order.state == 3}">正在运输</c:when>
				<c:when test="${order.state == 4}">订单完成</c:when>
			</c:choose>
			</a>
		</td>
	</tr>
		<c:forEach items="${order.orderItemList}" var="orderItem">
	<tr bordercolor="rgb(78,78,78)" align="center">
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
