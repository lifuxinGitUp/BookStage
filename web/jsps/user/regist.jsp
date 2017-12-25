<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <script type="text/javascript">
		  //创建异步对象
		  function createXMLHttpRequest() {
			  try {
				  return new XMLHttpRequest();//大多数浏览器
			  } catch (e) {
				  try {
					  return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
				  } catch (e) {
					  try {
						  return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本
					  } catch (e) {
						  alert("哥们儿，您用的是什么浏览器啊？");
						  throw e;
					  }
				  }
			  }
		  }
		  window.onload = function () {

			  var userEle = document.getElementById("usernameEle");
			  userEle.onblur = function () {
				  // 得到异步对象
				  var xmlHttp = createXMLHttpRequest();
				  // 打开连接
				  xmlHttp.open("post", "<c:url value="/AServlet"/>", true);
				  // 设置请求头
				  xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  // 发送请求 , 给出请求体
				  xmlHttp.send("username=" + userEle.value);
				  // 给xmlHttp 的 onreadystatechange 事件注册监听
				  xmlHttp.onreadystatechange = function () {
					  if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
						  // 双重判断
						  // 获取服务器的响应,判断是否为1
						  // 是: 获取span, 添加内容:"用户名已被注册"
						  var text = xmlHttp.responseText;
						  var span = document.getElementById("errorSpan");
						  if (text == "1") {
							  span.innerHTML = "用户名已被注册";
							  span.style.color = "red";
						  } else {
							  span.innerHTML = "用户名可以使用";
							  span.style.color = "green";
						  }
					  }
				  }

			  }
		  }
	  </script>

	  <style>
		  body{

			  margin-top: 200px;
			  margin-left: 500px;
			  background: url("/storephoto/login.jpg");
		  }

	  </style>
	  <script type="text/javascript">
		  function _change() {
			  // 获取 img 元素
			  var img = document.getElementById("verifyCode");
			  img.src = "<c:url value="/VerifyCodeServlet"/>?time=" + new Date().getTime();
		  }
	  </script>

  </head>
  <%--InvocationTargetException 调用目标异常--%>
  <body>
  <h1 style="margin-left: 95px">注册</h1>
<p style="color: red; font-weight: 900">${msg}</p>
<form action="/UserServlet" method="post">
	<input type="hidden" name="method" value="register"/>
	用户名：<input type="text" name="username" id="usernameEle" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="errorSpan"></span><br/><br>
	密　码：<input type="password" name="password"/><br/><br>
	邮　箱：<input type="text" name="email" value=""/><br/><br>
	验证码:&nbsp;&nbsp; <input type="text" name="verifyCode" style="width: 60px">
	<img id="verifyCode" src="<c:url value="VerifyCodeServlet"/>" border="2">

	<a href="javascript:_change()" style="color: blue; font-size: small">看不清?换一张</a><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="注册"/>
</form>
  </body>
</html>
