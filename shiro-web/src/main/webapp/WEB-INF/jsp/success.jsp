<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>成功页</title>
</head>
<body>
<h1>登录成功！！！</h1>
<shiro:hasAnyRoles name="admin">
    <shiro:principal/>拥有角色admin
</shiro:hasAnyRoles>
<jsp:include page="link.jsp"></jsp:include>
</body>
</html>