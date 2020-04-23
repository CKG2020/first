<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<base href="<%=basePath%>">--%>
    <title>My JSP 'tag_text.jsp' starting page</title>
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
<!--实例1-->
<s:i18n name="com.ascent.action.I18nTestAction">
    <s:text name="main.title"/>
</s:i18n>
<br>
<!--实例2-->
<s:text name="main.title"/>
<br>
<!--实例3-->
<s:text name="i18l.label.greetings">
    <s:param>Mr Smith</s:param>
</s:text>
</body>
</html>
