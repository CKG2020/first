<%@ page import="bean.JDBCConnection" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="sun.nio.cs.ext.GBK" %><%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-10-21
  Time: 下午8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="dbBean" scope="page" class="bean.JDBCConnection"/>
<%
    String name=request.getParameter("name");
    String sex=request.getParameter("sex");
//
//    System.out.print(request.getParameter("name"));
//    String sex=new String(request.getParameter("
//    String birthday=new String(request.getParameter("birthday").getBytes("ISO8859-1"), StandardCharsets.UTF_8);
//    String address=new String(request.getParameter("address").getBytes("ISO8859-1"), StandardCharsets.UTF_8);
//    String tel=new String(request.getParameter("tel").getBytes("ISO8859-1"), StandardCharsets.UTF_8);
    String  birthday=request.getParameter("birthday");
    String address=request.getParameter("address");
    String tel=request.getParameter("tel");
    String sqladd="insert into PersonalInformation values('"+name+"','"+sex+"','"+birthday+"','"+address+"','"+tel+"')";
    dbBean.executeUpdate(sqladd);
    dbBean.closeConnection();
    response.sendRedirect("PersonalInfomation.jsp");
%>

<body>
</body>
</html>
