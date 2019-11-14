<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>附属资产信息查询</title>
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

	<div class="easyui-layout" data-options="fit:true">
		
					<div class="easyui-panel"  id="dg" data-options="fit:true,title:'<center>附属资产信息查询</center>',tools:'#tool'">
						<table id="dg1">
							<thead>
								<tr>
								<th data-options="field:'department',align:'center',width:fixWidth(0.05),sortable:true">部门
										</th>
									<th data-options="field:'office',align:'center',width:fixWidth(0.05),sortable:true">科室
										</th>
									<th data-options="field:'category',align:'center',width:fixWidth(0.05),sortable:true">设备类型
										</th>
									<th data-options="field:'brand',align:'center',width:fixWidth(0.05),sortable:true">品牌</th>
									
									<th data-options="field:'type',align:'center',width:fixWidth(0.05),sortable:true">型号
										</th>
										<th data-options="field:'ccNumber',align:'center',width:fixWidth(0.05),sortable:true">出厂编号
										</th>
									
									
									<th data-options="field:'zcNumber',align:'center',width:fixWidth(0.05),sortable:true">资产编号</th>
								<th data-options="field:'personIC',align:'center',width:fixWidth(0.05),sortable:true">责任人</th>
								
								<th data-options="field:'personCY',align:'center',width:fixWidth(0.05),sortable:true">曾用人</th>
									
									<th data-options="field:'area',align:'center',width:fixWidth(0.05),sortable:true">现存地点
										</th>
										<th data-options="field:'zpCount',align:'center',width:fixWidth(0.05),sortable:true">自盘数量
										</th>
									
									
									<th data-options="field:'state',align:'center',width:fixWidth(0.05),sortable:true">状态</th>
								<th data-options="field:'newfcNumber',align:'center',width:fixWidth(0.05),sortable:true">新防拆标签码</th>
								<th data-options="field:'admin',align:'center',width:fixWidth(0.05),sortable:true">硬件管理员</th>
									<th data-options="field:'wxNumber',align:'center',width:fixWidth(0.05),sortable:true">维修防拆标签码
										</th>
										<th data-options="field:'wxPerson',align:'center',width:fixWidth(0.05),sortable:true">维修人员
										</th>
									
									
									<th data-options="field:'remarks',align:'center',width:fixWidth(0.05),sortable:true">备注</th>
								<th data-options="field:'lururen',align:'center',width:fixWidth(0.05),sortable:true">录入人</th>
								<th data-options="field:'lurushijian',align:'center',width:fixWidth(0.07),sortable:true">录入时间</th>
								</tr>
							</thead>
						</table>
		</div>
		</div>
		<input id="department" type="text">
		<div id="tool">
	
		<a href="pc/it/fszc_query.jsp" class="icon-reload" title="刷新数据" ></a>
	</div>
</body>
<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/datagrid-filter/datagrid-filter.js"></script>
	<script type="text/javascript" src="js/duan_fs/duan_fs.js"></script>
<script>
	$(document).ready(function(){
	var department="<%=session.getAttribute("bumen")%>";
	$('#department').val(department);
	todatagrid1();
	show1();
	
	});
	window.addEventListener("orientationchange", function() {

				window.location.reload(); 
}, false);
		function fixWidth(percent)  {  
    return document.body.clientWidth * percent ;//这里你可以自己做调整  
}  
   		
   </script>
</html>