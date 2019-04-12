<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加类别</title>
    
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
  <div class="easyui-panel" title="添加类别" style="width:400px" data-options="iconCls:'icon-undo',fit='true'">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post" action="">
	    <h2 style="color:#5bc0de ">添加类别</h2>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>类别:</td>
	    			<td><input class="easyui-textbox" type="text" id="leibie" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>增设原因:</td>
	    			<td><input class="easyui-textbox" type="text" id="yuanyin" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>责任部门:</td>
	    			<td> <select class="easyui-combobox" id="zerendanwei"  name="zerendanwei"  labelPosition="top" style="width:100%;">
               
             
                <option value="物流部">物流部</option>
                <option value="采购部">采购部</option>
                <option value="质控部">质控部</option>
                <option value="工艺设备部">工艺设备部</option>
                <option value="总经办">总经办</option>
                <option value="财务部">财务部</option>
                <option value="生产部">生产部</option>
                <option value="总装分厂">总装分厂</option>
                <option value="注塑分厂">注塑分厂</option>
                <option value="控制器分层">控制器分层</option>
            </select></td>
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
			
	 
 	 if($("#leibie").val()!=null&& "" != $("#leibie").val() && $("#zerendanwei").val() !=null&&
			 "" != $("#zerendanwei").val() && $("#yuanyin").val() !=null&& "" != $("#yuanyin").val()){ 
		 $.ajax({
		type: "post",
		 url:"category/Category_addCategory.do",
		data:{
		
		leibie: $("#leibie").val(),
		zerendanwei: $("#zerendanwei").val(),
		beizhu : $("#beizhu").val(),
		yuanyin :$("#yuanyin").val(),
		
		},
		success: function () {
		
		$.messager.confirm('录入成功', '是否继续录入?', function(r){
				if (r){
					location.reload() ;
				}else{
				window.location.href="pc/zjb/category_query.jsp";
				
				
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
