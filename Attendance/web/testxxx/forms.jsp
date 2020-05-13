<%--
  Created by IntelliJ IDEA.
  User: ckg
  Date: 20-5-13
  Time: 下午11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
    $(function(){
    var thisForm = document.forms['form1']; //获取name为form1的form表单
    //var thisForm = document.forms[0]; //获取第一个form表单
    console.info(thisForm.username.value); //输出表单name属性值为form1的 username的值
    console.info(thisForm.address.value);
    document.forms[0].submit(); //表单提交
    })
    </script>
</head>
<body>
<form action="x"name="form1">
<input type="text"name="username"value="zhangsan"/>
<input type="text"name="address"value="beijing"/>
</form>
</body>
</html>
