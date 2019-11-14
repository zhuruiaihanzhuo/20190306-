<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加设备</title>
    
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
  <div class="easyui-panel" title="添加设备" style="width:500px" data-options="fit:'true'">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post" action="">
	    <h2 style="color:#5bc0de ">添加设备</h2>
	    	<table cellpadding="5">
	    		<tr>
	    			
	    			<td>设备类别:</td>
	    			 <td><input class="easyui-combobox" id="leibie" name="leibie" data-options="valueField:'id',textField:'leibie',editable:false" />
	    			<td style="color: red">(请准确选择)</td>
	    		</tr>
	    		<tr>
	    			<td>录入人:</td>
	    			<td><input class="easyui-textbox" type="text" id="lururen" data-options="required:true" readonly="readonly"></input></td>
	    		</tr>
	    		<tr>
	    			<td>设备编号:</td>
	    			<td><input class="easyui-textbox" type="text" id="shebeibianhao" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>说明:</td>
	    			<td><input class="easyui-textbox" type="text" id="shuoming" data-options="required:true"></input></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>区域:</td>
	    			 <td><input class="easyui-combobox" id="quyu" name="quyu" data-options="valueField:'id',textField:'shuoming',editable:false" />
        			<td style="color: red">(请准确选择)</td>
        
	    
	    		</tr>
	    		<tr>
	    			<td>备注:</td>
	    			<td><input class="easyui-textbox"  type="text" id="beizhu" data-options="multiline:true" style="height:60px"></input></td>
	    	
	    		</tr>
	    		
				
	    	</table>
	    </form>
	    <div style="text-align:left;padding:5px">
	    	<a href="javascript:void(0)" id="submit" class="easyui-linkbutton" onclick="submitForm()" style="color:#5bc0de">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="color:red">重填</a>
	    </div>
	    </div>
	</div>


<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/datagrid-filter/datagrid-filter.js"></script>
<script type="text/javascript">
        showArea();
        showLeibie();
	  
		function submitForm(){
			
	 
 	 if($("#leibie").val()!=null&& "" != $("#leibie").val()  && $("#lururen").val() !=null&& "" != $("#lururen").val() &&
			 $("#shuoming").val()!=null&& "" != $("#shuoming").val() && $("#quyu").val() !=null&&"" != $("#quyu").val()){ 
		 $.ajax({
		type: "post",
		 url:"device/Device_addDevice.do",
		data:{
		shebeibianhao: $("#shebeibianhao").val(),
		shuoming: $("#shuoming").val(),
		leibie: $("#leibie").val(),
		lururen: $("#lururen").val(),
		beizhu : $("#beizhu").val(),
		quyu :$("#quyu").val(),
		
		
		},
		success: function () {
		
		$.messager.confirm('录入成功', '是否继续录入?', function(r){
				if (r){
					location.reload() ;
				}else{
				window.location.href="pc/zjb/device_query.jsp";
				
				
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
function showArea(){

	$.ajax({
		url:'<%=path%>/area/Area_queryShuoming.do',
		type:"post",
		dataType:"json",
		success:function(data){
		var data1=data.data;
		var test=[];
		 var i=0;
		 for ( var machine in data1) {
		       i=i++;
                test.push({
                    "id" : data1[machine].id,
                    "shuoming" : data1[machine].shuoming
                });
                  // alert("i==="+i+"==="+data1[i].shuoming+"==data1[machine].id="+data1[machine].id);
                   $("#quyu").combobox("loadData", test);   
                  $("#quyu").combobox('setValue', data1[0].id);
                 // $("#quyu").combobox('setValue', data1[0].shuoming);
            
               }
            /*     $('#quyu').combobox('reload',row_data);} */
	}
	});
	}	
	
	
	
	
	
	function showLeibie(){
	
	var user="<%=session.getAttribute("name")%>";	

	 if(user!="null"){
	$("#lururen").val(user);
	
	$.ajax({
		url:'<%=path%>/category/Category_queryLeibie.do',
		type:"post",
		dataType:"json",
		success:function(data){
		var data1=data.data;
		var test=[];
		 var i=0;
		 for ( var machine in data1) {
		       i=i++;
                test.push({
                    "id" : data1[machine].id,
                    "leibie" : data1[machine].leibie
                });
                
                   $("#leibie").combobox("loadData", test);   
                  $("#leibie").combobox('setValue', data1[0].id);
                
            
               };}
            
	});
	}

	else{
	 if (window.top!=null && window.top.document.URL!=document.URL){  
            var urlStr = document.URL;  
             var endIndex = urlStr.indexOf('xxxxxxxxxx');  
             
            urlStr = urlStr.substring(0, 40); 
          
          window.top.location= urlStr + "/login.jsp";  // 跳转到登录页  
           
        }};
	

	
	}	
	
	
	
	function show2(){
		
	alert($("#zerenbumen").val());
	}	

	function clearForm(){
			location.reload() ;                           
	  
		}
</script>
  </body>

</html>
