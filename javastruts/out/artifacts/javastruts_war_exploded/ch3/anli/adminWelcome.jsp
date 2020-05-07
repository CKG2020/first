<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"//"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);
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
欢迎管理员登录!<br/>
<s:url id="urll" action="UsrManagerAction.action" ></s:url>
<s:a href="%{urll}">用户管理</s:a>

<%--<form action="UsrManagerAction.action" method="post">--%>

    <%--<input type="submit" value="登录"/>--%>
</form>
</body>
</html>
