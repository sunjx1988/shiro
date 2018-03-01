<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<h1>用户列表</h1>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/login">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/logout">点击退出</a><br/>
</shiro:user>
<br/>
<ul>
        <li>用户名</li>
    <c:forEach items="${list}" var="user">
        <li>${user.username}</li>
    </c:forEach>
</ul>
<br/>
<jsp:include page="../link.jsp"></jsp:include>
</body>
</html>