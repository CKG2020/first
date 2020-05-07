<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
 String path=request.getContextPath();
 String basePath=request.getScheme()+"//"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);
%>
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


<center>
    <h1>用户列表</h1>
    <table border="1" width="80%">
        <tr><td>ID</td> <td>用户名</td></tr>
        <s:iterator value="#request.allUser">
            <tr>
                <td><s:property value="id"></s:property></td>
                <td><s:property value="username"></s:property> </td>
                <td><s:if test="superuser==1">普通用户</s:if>
                    <s:elseif test="superuser==2">高权用户</s:elseif>
                    <s:elseif test="superuser==3">管理员</s:elseif>
                </td>
            </tr>

        </s:iterator>
    </table>
</center>
</body>
</html>
