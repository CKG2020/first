<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css" />
<link rel="stylesheet" href="<%=basePath %>css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/skin_/nav.css" />
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/global.js"></script>
<title>底部内容页</title>
</head>
<body>
<div id="rounded-corner" >
	<div id="bd">
    	<div class="sidebar">
        	<div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <ul class="nav">
                <li class="nav-li current">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">用户管理</span></a>
                    <ul class="subnav">
                     <li class="subnav-li" href="<%=basePath %>index.jsp" data-id="1"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">首页</span></a></li>
                      <li class="subnav-li" href="<%=basePath %>user/userFind" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">用户管理</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">部门管理</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" data-id="10"  href="<%=basePath %>deptFind" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">部门管理</span></a></li>
                    </ul>
                </li>
            
                <li class="nav-li last-nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">日报管理</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" data-id="12"  href="<%=basePath %>reportFind" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">日报管理</span></a></li>
                    </ul>
                </li>
                 <li class="nav-li last-nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">加班管理</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" data-id="13"  href="<%=basePath %>workFind" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">加班申请</span></a></li>
                    </ul>

                 <li class="nav-li last-nav-li">
                	<a  href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">个人信息修改</span></a>
                 <ul class="subnav">
                  <li class="subnav-li" data-id="17"  href="<%=basePath %>user/userPasswordUpdate.jsp" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">个人信息修改</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                	<a  href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">我的桌面</span></a>
                 <ul class="subnav">
                  <li class="subnav-li" data-id="18"  href="<%=basePath %>mydesktop/mydesktop.jsp" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">我的桌面</span></a></li>
                    </ul>
                </li>
            </ul>
            <div class="tree-list outwindow">
            	<div class="tree ztree"></div>
            </div>
        </div>
        <div class="main">
        	<div class="title">
                <i class="sidebar-show"></i>
                <ul class="tab ue-clear">
                   
                </ul>
                <i class="tab-more"></i>
                <i class="tab-close"></i>
            </div>
            <div class="content">
            </div>
        </div>
    </div>
</div>

<div class="more-bab-list">
	<ul></ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-bl"></div>
</div>
</body>
<script type="text/javascript" src="<%=basePath %>js/nav.js"></script>
<script type="text/javascript" src="<%=basePath %>js/Menu.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	var menu = new Menu({
		defaultSelect: $('.nav').find('li[data-id="1"]')	
	});
	
	
	$.fn.zTree.init($(".tree"), setting, zNodes);
	
	
	$('.sidebar h2').click(function(e) {
        $('.tree-list').toggleClass('outwindow');
		$('.nav').toggleClass('outwindow');
    });
	
	$(document).click(function(e) {
		if(!$(e.target).is('.tab-more')){
			 $('.tab-more').removeClass('active');
			 $('.more-bab-list').hide();
		}
    });
</script>
</html>