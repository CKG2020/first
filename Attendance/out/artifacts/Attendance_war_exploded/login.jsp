<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考勤管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/body.css"/> 
</head>
<body>
<div class="container">
	<section id="content">
		<form action="<%=basePath %>loginController">
			<h1>考勤管理系统</h1>
			<div>
				<input type="text" placeholder="用户名" required="" name="name" />
			</div>
			<div>
				<input type="password" placeholder="密码" required="" name="password" />
			</div>
			<font color="red">${error }</font> </br>
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div> 
			<div>
				<!-- <input type="submit" value="Log in" /> -->
				<input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
              
			</div>
      </form><!-- form --> 

	</section><!-- content -->
</div>
<br><br><br><br>

</body>
</html>