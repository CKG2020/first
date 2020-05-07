<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!--使用s:text标签输出welcomeTip对应的国际化信息-->
  <s:text name="welcomeTip">
    <!--使用s:param为国际化信息的占位符传入参数-->
  	<s:param><s:property value="username"/></s:param>
  </s:text>
  <br><br>
  <!-- 输出request范围内的user值（资源文件取值）-->
  request：${requestScope.user}
  <br>
    <a href="getBooks.action"><s:text name="welcomeLink"/></a>
  </body>
</html>
