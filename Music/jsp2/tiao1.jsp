<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tiao1.jsp' starting page</title>
    
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
  <!--第一种-->
    　　<form name="form" method="post" action="page.jsp">
           　　 <input type="submit" value="跳转1">
        　　</form>
 <%--第二种--%>
        　　<input type="button" value="跳转2" onclick="next()">

      　　<script type="text/javascript">
            　　function next(){
                　　window.location = "page.jsp";
　　                                }
       　　</script>
 <!-- 第三种 -->
      　<% // response.sendRedirect("page.jsp"); %>　　　　　　　　　//sendRedirect()可以带参数传递,后面应该紧跟一句return
                                                                
　　　　<%  // response.setHeader("Refresh", "1;url=page.jsp"); %>　　//1秒后,刷新,并跳到,page2.jsp页面
 //这两种不显示中间过程直接跳转
 <%--第四种 --%>
      　<jsp:forward page="page.jsp" />　   //直接跳转
 <!-- 第五种 -->    
      <% request.getRequestDispatcher("page.jsp").forward(request, response);%>　　//直接跳转
  </body>
</html>
