<%@ page language="java" import="java.util.*"   pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../../resource/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../resource/easyui/themes/icon.css">
	  <script type="text/javascript" src="../../js/easyUI/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/easyUI/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../../js/datagrid-filter/datagrid-filter.js"></script>
        <title>添加模具信息</title>
       
        <!-- <link rel="stylesheet" type="text/css" href="./udeditor/themes/default/css" />
        <link type="text/css"  rel="stylesheet"  href="./newsRealese.css"/> -->
    </head>
    <body id="body">
    <div class="easyui-panel" title="添加设备" style="width:1000px" data-options="iconCls:'icon-undo',fit='true'">
     
            <table  border="0" id="table">
                <tr>
                    <td width="5%"></td>
                    <td width="90%">    
                        <table  border="1" id="table">
                            <tr >
                                <td >模具编号</td> <td><input type="text" id="bianhao" name="bianhao" data-options="required:true" readonly="readonly"></td>
                                <td >标题</td> <td><input type="text" id="shuoming" name="shuoming" data-options="required:true"></td>
                                <td >更改人</td> <td><input style="text-align: center;color: blue;background: yellow;" data-options="required:true" readonly="readonly" type="text" name="genggairen" id="genggairen"></td>
                            </tr>

                        </table>
                    </td>
                    
                </tr>
               
                <tr>
                    <td> </td>
                    <td>
                        <div align="center" style="width:80%">  
                           <form name="ueditor" id="ueditor">
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>   
							</form>
                            <button  id="submit" class="easyui-linkbutton" onclick="submitForm()" style="color:#5bc0de;width: 180px;height: 50px;font-size: large;text-align: center;">保存</button> 
                           
                        </div>
                    </td>
                    <td> </td>
                </tr>
            </table>   
      
        </div>
        <script type="text/javascript" src="../../ueditor/ueditor.config.js"></script>
        <!-- 编辑器源码文件 -->
          <script type="text/javascript" src="../../ueditor/ueditor.all.min.js"></script>
        <script type="text/javascript" src="../../ueditor/ueditor.all.js"></script>
      
        <script type="text/javascript" src="../../ueditor/lang/zh-cn/zh-cn.js"></script>
       
       
         <script type="text/javascript">
         
          
 setname();
                              
function setname(){
var bianhao1="<%= request.getParameter("bianhao")%>";	

var user="<%=session.getAttribute("name")%>";	
var shuoming1="<%=request.getParameter("biaoti")%>";
var shuoming=decodeURI(shuoming1);
var bianhao=decodeURI(bianhao1);
var neirong1="<%=request.getParameter("neirong")%>";
var neirong=decodeURI(neirong1);
	 if(user!="null"){
	$("#genggairen").val(user);
	$("#bianhao").val(bianhao);
	$("#shuoming").val(shuoming);
	var ue = UE.getEditor('editor');
   ue.addListener("ready", function () {  
           // editor准备好之后才可以使用  
           ue.setContent(neirong);  
   });

            
	
	}

	else{
	 if (window.top!=null && window.top.document.URL!=document.URL){  
            var urlStr = document.URL;  
             var endIndex = urlStr.indexOf('xxxxxxxxxx');  
             
            urlStr = urlStr.substring(0, 40); 
          
          window.top.location= urlStr + "/login.jsp";  // 跳转到登录页  
           
        }};

};
/* var ue = UE.getEditor('editor'); */
		function submitForm(){
		var bianhao1="<%= request.getParameter("bianhao")%>";
		var bianhao=decodeURI(bianhao1);
		var bianhaoNew=$("#bianhao").val();
		if(bianhao==bianhaoNew){
		
		var data = UE.getEditor('editor').getContent();
	 		
 	 if($("#genggairen").val()!=null&& "" != $("#genggairen").val() && $("#bianhao").val() !=null&&
			 "" != $("#bianhao").val() && $("#shuoming").val() !=null&& "" != $("#shuoming").val() &&
			  data !=null&& "" !=data){ 
			
			
		 $.ajax({
		type: "post",
		 url:"../../mojuInfo/MojuInfo_update.do",
		data:{
		
		genggairen: $("#genggairen").val(),
		bianhaoNew : $("#bianhao").val(),
		bianhao :    bianhao,
		shuoming :$("#shuoming").val(),
		content:data
		},
		
		success: function () {
		
		$.messager.confirm('录入成功', '是否继续录入?', function(r){
				if (r){
					window.location.href="queryMoju.jsp";
				}else{
				window.location.href="../welcom.jsp";
				
				
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

		}else{
		 $.post("../../mojuInfo/MojuInfo_checkByBianhao.do",{bianhao: $("#bianhao").val()},function(data){
		 
		 if(data.result=="1"){
						  $.messager.alert('录入失败','模具编号已存在','error');
						   $('#bianhao').val(null);
					}else{

			var data = UE.getEditor('editor').getContent();
	 		
 	 if($("#genggairen").val()!=null&& "" != $("#genggairen").val() && $("#bianhao").val() !=null&&
			 "" != $("#bianhao").val() && $("#shuoming").val() !=null&& "" != $("#shuoming").val() &&
			  data !=null&& "" !=data){ 
			
			
		 $.ajax({
		type: "post",
		 url:"../../mojuInfo/MojuInfo_update.do",
		data:{
		
		genggairen: $("#genggairen").val(),
		bianhaoNew : $("#bianhao").val(),
		bianhao :    bianhao,
		shuoming :$("#shuoming").val(),
		content:data,
		},
		
		success: function () {
		
		$.messager.confirm('录入成功', '是否继续录入?', function(r){
				if (r){
					window.location.href="queryMoju.jsp";
				}else{
				window.location.href="../welcom.jsp";
				
				
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
});
}
}
                               
                            </script>  
        
        
    </body>
</html>
