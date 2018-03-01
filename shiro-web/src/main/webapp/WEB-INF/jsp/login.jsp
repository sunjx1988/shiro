<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
<br/><a href="${pageContext.request.contextPath}/">首页</a><br/>
<br/><a href="${pageContext.request.contextPath}/login">登录</a><br/>
<br/><a href="${pageContext.request.contextPath}/unauthorized">不需要权限页</a><br/>
<br/><a href="${pageContext.request.contextPath}/authorized">需要权限页</a><br/>
</body>
</html>