<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加区域</title>
    
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
  
  <body>
  <div class="easyui-panel" title="添加区域" style="width:400px" data-options="iconCls:'icon-undo',fit='true'">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post" action="">
	    <h2 style="color:#5bc0de ">添加区域</h2>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>录入人:</td>
	    			<td><input class="easyui-textbox" type="text" id="lururen" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>区域代码:</td>
	    			<td><input class="easyui-textbox" type="text" id="quyudaima" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>说明:</td>
	    			<td><input class="easyui-textbox" type="text" id="shuoming" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>责任部门:</td>
	    			<td><input class="easyui-textbox" type="text" id="zerenbumen" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>备注:</td>
	    			<td><input class="easyui-textbox"  type="text" id="beizhu" data-options="multiline:true" style="height:60px"></input></td>
	    		</td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submit" class="easyui-linkbutton" onclick="submitForm()" style="color:#5bc0de">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="color:red">重填</a>
	    </div>
	    </div>
	</div>

  </body>
<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/datagrid-filter/datagrid-filter.js"></script>
<script type="text/javascript">
		function submitForm(){
			
	 
 	 if($("#lururen").val()!=null&& "" != $("#lururen").val() && $("#zerenbumen").val() !=null&&
			 "" != $("#zerenbumen").val() && $("#quyudaima").val() !=null&& "" != $("#quyudaima").val()
			 	&& $("#shuoming").val() !=null&& "" != $("#shuoming").val()){ 
		 $.ajax({
		type: "post",
		 url:"area/Area_addArea.do",
		data:{
		
		lururen: $("#lururen").val(),
		quyudaima : $("#quyudaima").val(),
		beizhu : $("#beizhu").val(),
		zerenbumen :$("#zerenbumen").val(),
		shuoming :$("#shuoming").val()
		},
		success: function () {
		
		$.messager.confirm('录入成功', '是否继续录入?', function(r){
				if (r){
					location.reload() ;
				}else{
				window.location.href="pc/area_query.jsp";
				
				
				}
			});
		
		
		
	    },
	    error:function(){
	    	 $.messager.alert('录入失败','录入失败，请联系管理员','error');
	    }
		 });
		
		 } else{
		 $.messager.alert('录入失败','必填项不完整，录入失败！！!','error');
		 
		 }


}
	function clearForm(){
			location.reload() ;                           
	  
		}
</script>
</html>
