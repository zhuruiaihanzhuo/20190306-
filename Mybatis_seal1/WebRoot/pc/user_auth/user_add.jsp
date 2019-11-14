<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户</title>
    
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
  <div class="easyui-panel" title="添加用户" style="width:400px" data-options="fit:'true'">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post" action="">
	    <h2 style="color:#5bc0de ">添加用户</h2>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" id="username" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>姓名:</td>
	    			<td><input class="easyui-textbox" type="text" id="name" data-options="required:true"></input></td>
	    		</tr>
	    	
	    		<tr>
	    			<td>部门:</td>
	    			<td><input class="easyui-textbox" type="text" id="bumen" data-options="required:true" readonly="readonly"></input></td>
	    		</tr>
	    			<tr>
	    			<td>录入人:</td>
	    			<td><input class="easyui-textbox" type="text" id="lururen" data-options="required:true" readonly="readonly"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:left;padding:5px">
	    	<a href="javascript:void(0)" id="submit" class="easyui-linkbutton" onclick="submitForm()" style="color:#5bc0de">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="color:red">重填</a>
	    </div>
	    </div>
	</div>

  </body>
  
  <script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>

<script type="text/javascript" src="js/duan_fs/duan_fs.js"></script>

<script type="text/javascript">



 setname();
                              
function setname(){

var user="<%=session.getAttribute("name")%>";	
var bumen="<%=session.getAttribute("bumen")%>";	

	 if(user!="null"&&bumen!="null"&&user!=""&&bumen!=""){
	$("#lururen").val(user);
	
	$("#bumen").val(bumen);
            
	
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
