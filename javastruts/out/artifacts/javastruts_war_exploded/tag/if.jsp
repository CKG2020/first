<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-22
  Time: 上午12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
<html>
<head>

    <title>Title</title>
</head>
<body>

<s:if test="%{false}">
    <div>Will not be excuted here 111</div>
</s:if>
<s:elseif test="%{true}">
    <div> Will be excuted here  CKG 0304180216</div>
</s:elseif>
<s:else >
    <div> Will not be excuted here 333</div>
</s:else>
</body>
</html>
