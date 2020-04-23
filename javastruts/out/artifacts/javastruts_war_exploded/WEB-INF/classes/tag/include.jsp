<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-type" content="textml;charset=GBK"/>
    <title>使用s:include标签来包含目标页面</title>
</head>
<body>
<h2>使用s:include标签来包含目标页面</h2>
<s:include value="if.jsp"/>
<hr>

<s:include value="if.jsp">
    <s:param name="author" value="'ssssss'"/>
</s:include>
</body>

</body>
</html>
