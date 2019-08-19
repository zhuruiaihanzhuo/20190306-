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
  <div class="easyui-panel" title="修改密码" style="width:400px" data-options="iconCls:'icon-undo',fit='true'">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post" action="">
	    <h2 style="color:#5bc0de ">修改密码</h2>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>账号:</td>
	    			<td><input class="easyui-textbox" type="text" id="uname" data-options="required:true" readonly="readonly"></input></td>
	    		</tr>
	    		<tr>
	    			<td>原密码:</td>
	    			<td><input class="easyui-textbox" type="text" id="pword" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>新密码:</td>
	    			<td><input class="easyui-textbox" type="text" id="pwordNew" data-options="required:true"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submit" class="easyui-linkbutton" onclick="submitForm()" style="color:#5bc0de">提交</a>
	    	
	    </div>
	    </div>
	</div>

  </body>
<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/datagrid-filter/datagrid-filter.js"></script>
<script type="text/javascript">

setname();
		function submitForm(){
			
	 
 	 if($("#uname").val()!=null&& "" != $("#uname").val() && $("#pword").val() !=null&&
			 "" != $("#pword").val() && $("#pwordNew").val() !=null&& "" != $("#pwordNew").val()){ 
			 alert($("#pword").val());
		 $.ajax({
		type: "post",
		 url:"login/Users_query2.do",
		data:{
		
		username: $("#uname").val(),
		password : $("#pword").val(),
		
		},
		success: function (data) {
		
		 $.ajax({
		type: "post",
		 url:"login/Users_update.do",
		data:{
		
		username: $("#uname").val(),
	
		passwordNew :$("#pwordNew").val()
		},
		success: function () {
		
	     alert("修改成功");
		
		window.location.href="pc/welcom.jsp";
		
	    },
	    error:function(){
	    	 $.messager.alert('修改失败','修改失败2，请联系管理员','error');
	    }
		 });
		
	    },
	    error:function(){
	    	 $.messager.alert('修改失败','修改失败1，原密码错误','error');
	    }
		 });
		
		 } else{
		 $.messager.alert('修改失败','必填项不完整，修改失败！！!','error');
		 
		 }


}
function setname(){

var user="<%=session.getAttribute("user")%>";	

	 if(user!="null"){
	$("#uname").val(user);
	
	
	}

	else{
	 if (window.top!=null && window.top.document.URL!=document.URL){  
            var urlStr = document.URL;  
             var endIndex = urlStr.indexOf('xxxxxxxxxx');  
             
            urlStr = urlStr.substring(0, 40); 
          
          window.top.location= urlStr + "/login.jsp";  // 跳转到登录页  
           
        }};
	




};

	
</script>
</html>
