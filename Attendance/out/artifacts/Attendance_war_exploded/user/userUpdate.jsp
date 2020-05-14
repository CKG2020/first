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

</head>

<body>
<form action="<%=basePath %>UpdateUser">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户管理</a></li>
    <li><a href="#">修改用户</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <input type="hidden" name="id" value="${user.id }"/>
    <ul class="forminfo">
    <li><font color="green">${message }</font></li>
    <li>
      <label>工号 <font color="red">*</font></label>
      </label><input name="account" type="text" class="scinput" value="${user.account }" readonly="readonly"/></li>
    <li>
      <label>密码 <font color="red">*</font></label>
      <input name=password type="password" class="dfinput" value="${user.password }"/>
    </li>
     <li>
      <label>确认密码 <font color="red">*</font></label><input name="" type="password" class="dfinput" />
    </li>
    <li>
      <label>姓名 <font color="red">*</font></label>
      </label><input name="name" type="text" class="dfinput" value="${user.name }"/>
      </li>
     <li><label>部门</label>  
        <div class="vocation">
        <select class="select3" name="department-id">
        <option value="0">--请选择--</option>
        
        </select>
        </div>
    </li>
    <li>
      <label>性别</label>
         <cite><input name="sex" type="radio" value="1" <c:if test="${'1' eq user.sex }">checked="checked" </c:if> />男
                                &nbsp;&nbsp;&nbsp;&nbsp;
               <input name="sex" type="radio" value="2" <c:if test="${'2' eq user.sex }">checked="checked" </c:if>/>女
         </cite>
     </li>
    <li><label>手机号码 <font color="red">*</font></label><input name="mobile" type="text" class="dfinput" value="${user.mobile }" /></li>
    <li><label>出生日期</label>
    <input name="birthday" type="text" class="dfinput" value="${user.birthday}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></li>
    <li><label>邮箱 <font color="red">*</font></label><input name="email" type="text" class="dfinput" value="${user.email}" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" /></li>
    </ul>
    </div>
</form>
</body>
</html>
