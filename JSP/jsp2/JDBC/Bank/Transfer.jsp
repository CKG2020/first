<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 19-10-29
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="dbBean" scope="session" class="bean.JDBCConnection"/>
<% String name = request.getParameter("outAccount");
    String sex = request.getParameter("Password");
    String birthday = request.getParameter("inAccount");
    String address = request.getParameter("inName");
    String money = request.getParameter("money");
    int money1 = Integer.parseInt(money);
    if (dbBean.turn(name, sex, birthday, address, money1)) {
        response.sendRedirect("success.jsp");
    } else response.sendRedirect("failure.jsp");
    dbBean.closeConnection();

%>

</body>
</html>
