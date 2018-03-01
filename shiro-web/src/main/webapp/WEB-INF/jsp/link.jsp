<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<br/><a href="${pageContext.request.contextPath}/">首页</a><br/>
<br/><a href="${pageContext.request.contextPath}/login">登录</a><br/>
<br/><a href="${pageContext.request.contextPath}/unauthorized">不需要权限页</a><br/>
<br/><a href="${pageContext.request.contextPath}/authorized">需要权限页</a><br/>
<br/><a href="${pageContext.request.contextPath}/user/list">用户列表</a><br/>
</body>
</html>