<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <style>
		  body{
			  background: url("/storephoto/login.jpg");
			  text-align: center;
			  margin-top: 100px;
		  }
	  </style>

  </head>
  
  <body>
<h1>管理员登录页面</h1>
<hr/>
  <p style="font-weight: 900; color: red">${msg }</p>
<form action="<c:url value='/AdminCategoryServlet?method=adminLogin'/>" method="post">
	管理员账户：<input type="text" name="adminname" value=""/><br/><br>
	密　　　码：<input type="password" name="password"/><br/><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="进入后台"/>
</form>
  </body>
</html>
