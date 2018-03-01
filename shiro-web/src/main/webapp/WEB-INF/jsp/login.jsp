<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>
<h1>用户登录页</h1>
<div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="username"><br/>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
<jsp:include page="link.jsp"></jsp:include>
</body>
</html>