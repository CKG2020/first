<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-4-23
  Time: 下午12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
 String path=request.getContextPath();
 String basepath=request.getScheme()+"://"+ config.getServletName() +":"+request.getServerPort()+path+"/";
   %>

<html>

<head>
    <base href="<basePath%>">
    <title>s:sort tag page</title>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>&nbsp;
<s:bean id="mycomparator" name="tag.MyComparator"/>

<table border="1" width="200">
    <%--comparator：必填属性，指定进行排序的Comparator实例--%>
    <%--source：可选属性，指定被排序的集合。默认对valuestack栈顶的集合进行排序--%>
    <s:sort
            source="{'11111111111111','22222222','33333333333'}"
            comparator="#mycomparator">
        <s:iterator status="st">
            <tr<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
            <td><s:property/></td>
            </tr>
        </s:iterator>
    </s:sort>
</table>
</body>

</html>
