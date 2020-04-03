<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-10-24
  Time: 下午5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" %>
<html>
<head>
    <title>用户变更2</title>
</head>
<body>

<%@ page import="java.sql.ResultSet" %>
<%@ page import="bean.JDBCConnection" %>
<% JDBCConnection connection = new JDBCConnection();
    String sql = "select * from PersonalInformation";
    ResultSet rs = connection.executeQuery(sql);
%>
<table width="500" border="1" align="center">
    <%try {%>
    <tr align="center;">
        <% ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        %>
        <td height="30"><%=rsmd.getColumnName(i) %>
        </td>
        <%}%>
    </tr>
    <% while (rs.next()) {%>
    <tr align="center">
        <td height="30" bgcolor="aqua"><%=rs.getString(1)%>
        </td>
        <td height="30" bgcolor="aqua"><%=rs.getString(2)%>
        </td>
        <td height="30" bgcolor="aqua"><%=rs.getString(3)%>
        </td>
        <td height="30" bgcolor="aqua"><%=rs.getString(4)%>
        </td>
        <td height="30" bgcolor="aqua"><%=rs.getString(5)%>
        </td>
    </tr>
    <%
            }
        } catch (Exception ex) {
        }
    %>

</table>

</body>
</html>
