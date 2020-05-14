<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户添加</title>
<link href="<%=basePath %>css/style2.css" rel="stylesheet" type="text/css" />

<link href="<%=basePath %>css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/WdatePicker.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>


<script language="javascript">
function saveButton(){
 document.forms[0].action="userSearch.html";
 document.forms[0].submit();
}
</script>

<script language="javascript">
function saveButton(){
 document.forms[0].action="userSearch.html";
 document.forms[0].submit();
}
</script>
</head>

<body>
<form action="<%=basePath %>userAdd">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="<%=basePath %>userFind">用户管理</a></li>
    <li><a href="#">添加用户</a></li>
    </ul>
    </div>    
    <div class="formbody">
    <div class="formtitle"><span>基本信息</span></div>
    <ul class="forminfo">
     <li><font color="green">${message }</font></li>
    <li>
      <label>工号 <font color="red">*</font></label>
      <input name="account" type="text" class="dfinput" /></li>
    <li>
      <label>密码 <font color="red">*</font></label>
      <input name="password" type="password" class="dfinput" />
    </li>
    <li>
      <label>确认密码 <font color="red">*</font></label>
      <input name="password2" type="password" class="dfinput" />
    </li>
    <li>
      <label>姓名 <font color="red">*</font></label>
      <input name="name" type="text" class="dfinput" />
     </li>
     <li><label>部门</label>  
        <div class="vocation">
        <select class="select3"   name="department_id">
        <option>--请选择--</option>
        <option>研发一部</option>
        <option>研发二部</option>
        <option>研发三部</option>
        <option>测试</option>
        </select>
        </div>
    </li>
    <li>
      <label>性别</label>
        <input name="sex" type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
    	<input name="sex" type="radio" value="2" />女
    </li>
    <li><label>手机号码 <font color="red">*</font></label>
        <input name="mobile" type="text" class="dfinput" value="" /></li>
    <li><label>出生日期</label>
        <input name="birthday" type="text" class="dfinput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></li>
    <li><label>邮箱 <font color="red">*</font></label>
        <input name="email" type="text" class="dfinput" value="" /></li>
          <li>
      <label>职务</label>
       <div class="vocation">
    <select class="select3" name="user_type">
    <option value="">--请选择--</option>
    <option value="0">超级管理员</option>
    <option value="1">部门主管</option>
    <option value="2">普通员工</option>
    </select>
    </div>
    </li> 
    <li><label>&nbsp;</label>
        <input name="" type="submit" class="btn" value="确认保存" /></li>
      
    </ul>
    </div>
</form>
</body>
</html>
