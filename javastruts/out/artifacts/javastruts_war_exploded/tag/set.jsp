<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<base href="<%=basePath%>">--%>
    <title>Set Test</title>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<body>
<s:bean name="test2" id="1">
    <s:param name="username" value="'ckg'"/>
    <s:param name="password" value="0304180216"/>
</s:bean>
讲Stack Context中的u值放入默认值范围内。<br>
<s:set value="#u" name="usr" scope="request"/>
<s:property value="#request.uer.username"/><br>
</body>
</html>
