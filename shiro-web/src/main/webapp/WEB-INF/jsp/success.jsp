<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<shiro:hasAnyRoles name="admin">
    <shiro:principal/>拥有角色admin
</shiro:hasAnyRoles>
<br/><a href="${pageContext.request.contextPath}/">首页</a><br/>
<br/><a href="${pageContext.request.contextPath}/login">登录</a><br/>
<br/><a href="${pageContext.request.contextPath}/unauthorized">不需要权限页</a><br/>
<br/><a href="${pageContext.request.contextPath}/authorized">需要权限页</a><br/>
</body>
</html>