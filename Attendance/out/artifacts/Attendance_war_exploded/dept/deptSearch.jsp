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
<title>部门管理</title>
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
 <script>
  function DeptDel() {
	  var ids="";
	    var $chkBoxes = $('#deptTable').find('input:checked');   //找到被选中的checkbox集
	    if ($chkBoxes.length == 0) {         //如果不勾选弹出警告框
	      alert('请至少选择一个数据集');
	      return false;
	    }
	     //遍历被选中的checkbox集
	    $($chkBoxes).each(function () { 
	      ids +=$(this).attr('data-id')+",";
	    })
	    //ids = ids.substr(10,ids.length-1);
		if (confirm("您确定要删除选中的部门信息吗?"))
			 window.location="<%=basePath%>deleteDept?ids="+ids; 
	}
  </script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">部门管理</a></li>
    </ul>
    </div>
   
	<!--查询条件-->
    <br />
    <br />
    <form action="<%=basePath %>deptFind" method="post">
    <ul class="seachform">
  
    <li>
      <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门名称</label><input name="departmentName" type="text" class="scinput" /></li>

    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
    
    </ul>
    </div>

    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="<%=basePath %>images/t01.png" /></span><a href="<%=basePath %>dept/deptInsert.jsp" target="_self">添加</a></li>
        <li class="click"><img src="<%=basePath %>images/trash.png" /></span><a href="javascript:DeptDel()"  >删除</a></li>
        </ul></form>
    </div>
    
    
    <table class="tablelist"><tbody><tr><td><table class="tablelist"><tbody><tr><td><table class="tablelist">
      <tbody>
        <tr>
          <td><table class="tablelist" id="deptTable">
              <thead>
                <tr>
                <th width="5%" height="83"><input name="" type="checkbox" value="" checked="checked"/></th>
                  <th width="12%">部门编号<i class="sort"><img src="<%=basePath %>images/px.gif" /></i></th>
                  <th width="16%">部门名称</th>
                  <th width="15%">负责人</th>
                  <th width="13%">人数</th>
                  <th width="21%">注册时间</th>
                  <th width="18%">操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${pageInfodept.list}" var="dept">
		        <tr>
		        <td><input name="dept_ids" data-id="${dept.id }" type="checkbox" value="${dept.id }" /></td>
		        <td>${dept.departmentId }</td>
		        <td>${dept.departmentName }</td>
		        <td> <c:if test="${dept.manager =='1'}">
			                           肖勇
			        </c:if>
			        <c:if test="${dept.manager == '2'}">
			                         祝文健
			        </c:if>
			         <c:if test="${dept.manager == '3'}">
			                           王凤森
			        </c:if>
			         <c:if test="${dept.manager== '4'}">
			                           张娜
			        </c:if>
			        
			        </td>
		        <td>${dept.totalUser }</td>
		        <td>${dept.createTime}</td>
		        <td><span>
		          <a href="<%=basePath %>modifyDept?id=${dept.id}" class="tablelink"><img src="<%=basePath %>images/user_edit.png" />修改</a> 
		          <a href="<%=basePath %>deleteDept?ids=${dept.id}" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="<%=basePath %>images/trash.png" />删除</a>
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
    </table></td>
        </tr>
    </tbody>
    </table>
    
   
<div class="pagin">
    	<div class="message">共<i class="blue">${pageInfodept.total}</i>条记录，当前显示第&nbsp;<i class="blue">${pageInfodept.pageNum}&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span
					class="pagepre"></span></a></li>
			<li class="paginItem"><a href="<%=basePath%>deptSelect?pn=1">1</a></li>
			<li class="paginItem"><a href="<%=basePath%>deptSelect?pn=2">2</a></li>
			<li class="paginItem"><a href="<%=basePath%>deptSelect?pn=3">3</a></li>
			<li class="paginItem"><a href="<%=basePath%>deptSelect?pn=4">4</a></li>
			<li class="paginItem"><a href="<%=basePath%>deptSelect?pn=5">5</a></li>
			<li class="paginItem"><a href="javascript:;"><span
					class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
