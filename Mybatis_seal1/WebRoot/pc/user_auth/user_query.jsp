<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>类别</title>
 <meta name="viewport" content="width=device-width,minimum-scale=1.0, maximum-scale=2.0" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="resource/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="resource/easyui/themes/icon.css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style="padding: 5px">

<!-- 	<div class="easyui-layout" data-options="fit:true"> -->
		
					<div class="easyui-panel"  id="dg" data-options="fit:true,title:'<center>用户查询</center>',tools:'#tool'">
						<table id="dg1">
							<thead>
								<tr>
									<th data-options="field:'username',align:'center',width:fixWidth(0.1),sortable:true">用户名
										</th>
									<th data-options="field:'name',sortable:true,width:fixWidth(0.1),sortable:true">姓名
										</th>
									<th data-options="field:'bumen',sortable:true,order:'asc',width:fixWidth(0.1),sortable:true">部门</th>
									
									<th data-options="field:'createtime',align:'center',width:fixWidth(0.1),sortable:true">录入时间
										</th>
									
									
									
								<th data-options="field:'lururen',align:'center',width:fixWidth(0.1),sortable:true">录入人</th>
								</tr>
							</thead>
						</table>
		</div>
		<div id="tool">
		<a href="pc/zjb/category_add.jsp" class="icon-add"  title="添加区域"></a>
		<a href="pc/zjb/category_query.jsp" class="icon-reload" onclick="refresh()"></a>
	</div>
</body>
<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/duan_fs/duan_fs.js"></script>
<script type="text/javascript"
	src="js/datagrid-filter/datagrid-filter.js"></script>
<script>
	$(document).ready(function(){
	 user_todatagrid();
	showUser();
	
	});
	window.addEventListener("orientationchange", function() {

				window.location.reload(); 
}, false);
		function fixWidth(percent)  {  
    return document.body.clientWidth * percent ;//这里你可以自己做调整  
}  
   		

	
   </script>
</html>
