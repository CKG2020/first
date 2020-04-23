<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="textml;charset=GBK"/>
    <title>使用s:push来将某个值放入VAlueStack的栈顶</title>
</head>
<body>
<h2>使用s:push来将某个值放入VAlueStack的栈顶</h2>
<s:bean name="com.ascent.po.Usr" id="u">
    <s:param name="username" value="'zhangsan'"/>
    <s:param name="password" value="1234"/>
</s:bean>
</body>

</html>
