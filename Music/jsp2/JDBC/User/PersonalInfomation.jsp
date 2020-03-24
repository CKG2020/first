<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-10-21
  Time: 下午4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>变更用户</title>
</head>
<%request.setCharacterEncoding("UTF-8");%>
<h2><center>已注册用户信息</center></h2>
<jsp:directive.page import="bean.JDBCConnection"/>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%
    JDBCConnection connection=new JDBCConnection();
    String sql="select * from PersonalInformation";
    ResultSet rs=connection.executeQuery(sql);
%>
<body>

<table border="1" align="center">

    <% try{ %>
    <tr align= "center">
       <%  ResultSetMetaData rsmd=rs.getMetaData();
        for(int i=1;i<=rsmd.getColumnCount();i++){
           %>
        <td height="30"><%=rsmd.getColumnName(i) %></td>
        <%}%>
    </tr>
       <% while(rs.next()){  %>

    <tr>
        <td><%=rs.getString(1)%></td><td><%=rs.getString(2)%></td> <td><%=rs.getString(3)%></td> <td><%=rs.getString(4)%></td>
        <td><%=rs.getString(5)%></td>
    </tr>
    <%
        }}
        catch(Exception e){ }
        finally {
        connection.closeConnection();
    }
    %>
</table>
</form>

<h2><center>添加新用户</center></h2>
<form id="form1" name="form1" method="get" action="addUsers.jsp">
    <table width="551" border="6" align="center">
    <tr>
        <td>用户名：</td><td><input type="text" name="name" size="20"> </td>
    </tr>
    <tr>
        <td>性别：</td><td>男<input type="radio" name="sex" value="M" checked="checked">
        女
            <input type="radio"name="sex" value="F">
        </td>
    </tr>
<tr>
    <td>出生日期：</td><td><input type="text" name="birthday" size="20"> </td>
</tr>
<tr>
    <td>家庭地址：</td><td><input type="text" name="address" size="20"> </td>

</tr>
    <tr>
        <td>手机号：</td><td><input type="text" name="tel" size="20"> </td>
    </tr>

<tr><td><input type="submit" name="submit" value="提交" size="11" >
</td>
    <td>
        <input type="reset" name="reset" value="重置"size="11" >
    </td>

</tr>
</table>
</form>
</body>
</html>
