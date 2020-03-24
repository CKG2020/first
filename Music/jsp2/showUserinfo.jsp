<%@ page language="java" import="java.util.*"  import="com.bean.Userinfo" pageEncoding="UTF-8"%>



<html>
  <head>
    
    
    <title>My JSP 'showUserinfo.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<jsp:useBean id="userinfo"  class="bean.Userinfo" scope="request"/>
<jsp:setProperty name="userinfo"  property="*"/>
账号：<%=new String (userinfo.getAccount().getBytes("ISO8859_1"),"GBK") %>
密码：<%=new String (userinfo.getPassword().getBytes("ISO8859_1"),"GBK") %>
真实姓名：<%=new String (userinfo.getRealname().getBytes("ISO8859_1"),"GBK") %>
Email地址：<%=new String (userinfo.getEmail().getBytes("ISO8859_1"),"GBK") %>
性别：<%=new String (userinfo.getSex().getBytes("ISO8859_1"),"GBK") %>
  </body>
</html>
