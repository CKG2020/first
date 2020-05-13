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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门修改</title>
<link href="<%=basePath %>css/style2.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/select-ui.min.js"></script>
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
 document.forms[0].action="${pageContext.request.contextPath }/updateDept";
 document.forms[0].submit();
}
</script>


</head>

<body>
<form action="<%=basePath %>UpdateDept">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">部门管理</a></li>
    <li><a href="#">修改部门</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <input type="hidden" name="id" value="${dept.id }"/>
    <ul class="forminfo">
    <li><font color="green">${message }</font></li>
    <li>
      <label>部门编号</label>
      </label><input name="departmentId" type="text" class="dfinput" readonly="readonly" value="${dept.departmentId }"/><i>部门号不允许修改</i></li>
    <li>
      <label>部门名称</label>
      <input name="departmentName" type="text" class="dfinput" value="${dept.departmentName }"/>
    </li>
     <li>
      <label>负责人 </label>
       <div class="vocation">
    <select class="select3" name="manager">
    <option value="">--请选择--</option>
    <option value="1" <c:if test="${'1' eq dept.manager }">selected </c:if>>余力</option>
    <option value="2" <c:if test="${'2' eq dept.manager }">selected </c:if>>张安娜</option>
    <option value="3" <c:if test="${'3' eq dept.manager }">selected </c:if>>张楠</option>
    <option value="4" <c:if test="${'4' eq dept.manager }">selected </c:if>>张丽丽</option>
    </select>
    </div>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" /></li>
    </ul>
    </div>
</form>
</body>
</html>
