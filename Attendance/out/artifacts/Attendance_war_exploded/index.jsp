<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.Calendar" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考勤管理系统-主页面</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/style2.css" />
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
		</ul>
	</div>

	<div class="mainindex">

		<div class="welinfo">
			<span><img src="images/sun.png" alt="天气" /></span> <b>${username }早上好，欢迎使用考勤管理系统</b>
		</div>
        <%
        Calendar today = Calendar.getInstance();
		String day = String.valueOf(today.get(Calendar.YEAR)) + "-"
				+ String.valueOf(today.get(Calendar.MONTH)+1) + "-"
				+ String.valueOf(today.get(Calendar.DAY_OF_MONTH));
		String time = String.valueOf(today.get(Calendar.HOUR_OF_DAY))+":"
				+ String.valueOf(today.get(Calendar.MINUTE))+":"
				+ String.valueOf(today.get(Calendar.SECOND));
        
        %>
		<div class="welinfo">
			<span><img src="images/time.png" alt="时间" /></span> <i>您本次次登录的时间：<%=day %>&nbsp;&nbsp;<%=time %></i>
		</div>
</body>
</html>