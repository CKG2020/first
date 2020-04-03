<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-10-28
  Time: 下午7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账申请</title>
</head>
<body>
<h2>
    <center>转账申请单</center>
</h2>
<form name="form1" action="Transfer.jsp">
    <table align="center" border="1">
        <tr>
            <td rowspan="2">转出方</td>
            <td> 账号：<input type="text" name="outAccount"></td>
        </tr>
        <tr>
            <td>密码：<input type="password" name="Password"></td>
        </tr>
        <tr></tr>
        <tr>
            <td rowspan="2">转入方</td>
            <td> 账号：<input type="text" name="inAccount">
        </tr>
        <tr>
            <td>用户名：<input type="text" name="inName"></td>
        </tr>
        <tr>
            <td>转账金额：</td>
            <td><input type="text" name="money"></td>
        </tr>
        <tr>
            <td><input type="reset" name="reset" value="重置"></td>
            <td><input type="submit" value="提交" name="submit"></td>
        </tr>

    </table>
</form>
</body>
</html>
