<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-5-6
  Time: 下午9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Form with Multilingual Support</title>
</head>

<body>
<h1><s:text name="xxx.heading"/></h1>

<s:url id="indexEN"  action="Locale.action" >
    <s:param name="request_locale" >en</s:param>
</s:url>


<s:url id="indexZH" action="Locale.action" >
    <s:param name="request_locale" >zh</s:param>
</s:url>



<s:url id="indexFR"  action="Locale.action">
    <s:param name="request_locale" >fr</s:param>
</s:url>


<s:a href="%{indexEN}" >English</s:a>
<s:a href="%{indexZH}" >Chinese</s:a>
<s:a href="%{indexFR}" >France</s:a>


<s:form action="Employee.action" method="post" >
    <s:textfield name="name" key="xxx.name" size="20" />
    <s:textfield name="age" key="xxx.age" size="20" />
    <s:submit name="submit" key="xxx.submit" />
</s:form>

</body>
</html>
