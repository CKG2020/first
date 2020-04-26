<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "//" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>

<%--<form action="usrLoginAction.action" method="post">--%>
<%--用户名:<input type="text" name="username"/><br/>--%>
<%--密码:<<input type="password" name="password" ><br/>--%>
<%--<input type="submit" value="登录"/>--%>
<%--</form>--%>
<s:form action="usrLoginAction.action" method="post">
    <s:textfield name="username" label="用户名"></s:textfield>
    <s:textfield name="password" label="密码"></s:textfield>
    <s:submit value="登录"></s:submit>
</s:form>
a
</body>
</html>
