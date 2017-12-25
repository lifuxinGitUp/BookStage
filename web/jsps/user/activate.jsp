<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/9/21
  Time: 下午2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>激活成功返回验证</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UserServlet" method="post">
    <input type="hidden" name="method" value="activate">
    <h1>激活成功</h1>
    <a href="/jsps/user/login.jsp">返回登录</a>
</form>
</body>
</html>
