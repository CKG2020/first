<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-10-11
  Time: 上午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品页面</title>
</head>
<body>
<center><h2>选购商品</h2></center>
<form action="buyitem" method="post">
    <input type="checkbox" name="item" value="0">图书
    <input type="checkbox" name="item" value="1">化妆品
    <input type="checkbox" name="item" value="2">衣服
    <input type="submit" name="submit" value="加入购物车">
</form>
</body>
</html>
