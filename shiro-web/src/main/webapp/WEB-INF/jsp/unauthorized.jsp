<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有权限</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">您没有权限[${exception.message}]</div>
<br/><a href="${pageContext.request.contextPath}/">首页</a><br/>
<br/><a href="${pageContext.request.contextPath}/login">登录</a><br/>
<br/><a href="${pageContext.request.contextPath}/unauthorized">不需要权限页</a><br/>
<br/><a href="${pageContext.request.contextPath}/authorized">需要权限页</a><br/>
</body>
</html>