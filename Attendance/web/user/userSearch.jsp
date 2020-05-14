<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>用户管理</title>
<link href="<%=basePath%>css/style2.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/select.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/select-ui.min.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>

<script>
  function UserDel() {
	  var ids="";
	    var $chkBoxes = $('#userTable').find('input:checked');   //找到被选中的checkbox集
	    if ($chkBoxes.length == 0) {         //如果不勾选弹出警告框
	      alert('请至少选择一个数据集');
	      return false;
	    }
	     //遍历被选中的checkbox集
	    $($chkBoxes).each(function () { 
	      ids +=$(this).attr('data-id')+",";
	    })
	    //ids = ids.substr(10,ids.length-1);
		if (confirm("您确定要删除选中的用户信息吗?"))
			 window.location="<%=basePath%>deleteUser?ids=" + ids;
	}
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

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">用户管理</a></li>
		</ul>
	</div>
	<!--查询条件-->
	<br />
	<br />
	<form action="<%=basePath%>userFind" method="post">
		<ul class="seachform">
			<li><label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					姓名</label><input name="name" type="text" class="scinput" /></li>
			<li><label>部门</label>
				<div class="vocation">
					<select class="select3" name="user_type">
						<option value="">请选择</option>
						<option value="0">研发一部</option>
						<option value="1">研发二部</option>
						<option value="2">研发三部</option>

						
					</select>
				</div></li>
			<li><label>&nbsp;</label><input name="" type="submit"
				class="scbtn" value="查询" /></li>
	</form>
	</ul>
	</div>

	<div class="tools">

		<ul class="toolbar">
			<li class="click"><span><img
					src="<%=basePath%>images/t01.png" /></span><a
				href="<%=basePath%>user/userInsert.jsp" target="_self">添加</a></li>
			<li class="click"><img src="<%=basePath%>images/trash.png" /></span><a
				href="javascript:UserDel()">删除</a></li>
		</ul>
	</div>
	<tbody>
		<tr>
			<td><table class="tablelist" id="userTable">
					<thead>
						<tr>
							<th><input name="" type="checkbox" value="" /></th>
							<th width="7%">工号<i class="sort"><img
									src="<%=basePath%>images/px.gif" /></i></th>
							<th width="11%">姓名</th>
							<th width="10%">部门</th>
							<th width="9%">职务</th>
							<th width="11%">注册时间</th>
							<th width="5%">性别</th>
							<th width="10%">手机</th>
							<th width="9%">出生日期</th>
							<th width="12%">邮箱</th>
							<th width="13%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfouser.list}" var="user">
							<tr>
								<td><input name="user_ids" data-id="${user.id }"
									type="checkbox" value="${user.id }" /></td>
								<td>${user.account }</td>
								<td>${user.name }</td>
								<td>${user.department_id }</td>
								<td><c:if test="${user.user_type =='0'}">
			                           超级管理员
			        </c:if> <c:if test="${user.user_type == '1'}">
			                            部门主管
			        </c:if> <c:if test="${user.user_type == '2'}">
			                            普通员工
			        </c:if></td>
								<td>${user.create_time }</td>
								<td><c:if test="${user.sex =='1'}">
			                           男
			        </c:if> <c:if test="${user.sex == '2'}">
			                          女
			        </c:if></td>
								<td>${user.mobile }</td>
								<td>${user.birthday }</td>
								<td>${user.email}</td>
								<td><span> <a
										href="<%=basePath %>modifyUser?id=${user.id}"
										class="tablelink"><img
											src="<%=basePath%>images/user_edit.png" />修改</a> <a
										href="<%=basePath %>deleteUser?ids=${user.id}"
										class="tablelink" onclick="confirm('确定要删除吗？')"> <img
											src="<%=basePath%>images/trash.png" />删除
									</a>
								</span></td>


							</tr>
						</c:forEach>
					</tbody>
				</table></td>
		</tr>
	</tbody>
	</table>
	</td>
	</tr>
	</tbody>
	</table>
	</td>
	</tr>
	</tbody>
	</table>




	<div class="pagin">
		<div class="message">
			共<i class="blue">${pageInfouser.total}</i>条记录，当前显示第&nbsp;<i
				class="blue">${pageInfouser.pageNum}&nbsp;</i>页
		</div>
		<ul class="paginList">
			<li class="paginItem"><a href="javascript:;"><span
					class="pagepre"></span></a></li>
			<li class="paginItem"><a href="<%=basePath%>userFind?pn=1">1</a></li>
			<li class="paginItem"><a href="<%=basePath%>userFind?pn=2">2</a></li>
			<li class="paginItem"><a href="<%=basePath%>userFind?pn=3">3</a></li>
			<li class="paginItem"><a href="<%=basePath%>userFind?pn=4">4</a></li>
			<li class="paginItem"><a href="<%=basePath%>userFind?pn=5">5</a></li>
			<li class="paginItem"><a href="javascript:;"><span
					class="pagenxt"></span></a></li>
		</ul>
	</div>




	<div class="tip">
		<div class="tiptop">
			<span>提示信息</span><a></a>
		</div>

		<div class="tipinfo">
			<span><img src="<%=basePath%>images/ticon.png" /></span>
			<div class="tipright">
				<p>是否确认对信息的修改 ？</p>
				<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
			</div>
		</div>

		<div class="tipbtn">
			<input name="" type="button" class="sure" value="确定" />&nbsp; <input
				name="" type="button" class="cancel" value="取消" />
		</div>
	</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
