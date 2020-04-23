<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>URL</title>
</head>
<body>
<h3>URL</h3>
<s:a href="xxx.action?id=1">添加</s:a>
<!--参数传递-->
<!--第一种方式，在标签内使用标签时用-->
<s:a href="xxx.action?id=1">编辑</s:a>

<!--第二种 创建url包含参数 a标签中使用该url-->
<s:url id="url" action="xxx.action">
    <s:param name="id" value="i"></s:param>
</s:url>
<s:a href="%{url}">删除</s:a>
<!--第三种a标签中直接使用url-->
<a href="<s:url action="xxx.action">
        <s:param name="id" value="1"/></s:url>">删除2</a>
</body>
</html>
