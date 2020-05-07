<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="" name="form1">
    <s:doubleselect
            label="请选择您喜欢的图书"
            name="author" list="{'陈凯歌', '陈哥哥'}"
            doubleList="top == '作者1' ? {'Spring2.0', 'hibernate 3' , 'struts2'} : 			                      {'JavaScript','Ajax in action'}"
            doubleName="book"/>
</s:form>
</body>
</html>
