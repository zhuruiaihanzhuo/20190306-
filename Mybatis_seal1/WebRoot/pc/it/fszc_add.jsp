<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加数据</title>
    
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
  <div class="easyui-panel" title="添加数据" style="width:500px" data-options="fit:'true'">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post" action="">
	    <h2 style="color:#5bc0de ">添加数据</h2>
	    	<table cellpadding="5">
	    		<tr>
	    			
	    			<td>部门</td>
	    			 <td><input class="easyui-textbox" id="department" name="department" readonly="readonly" data-options="required:true" />
	    			
	    			<td style="padding-left:100px;">科室:</td>
	    			<td><input class="easyui-textbox" type="text" id="office" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>设备类型:</td>
	    			<td> <select class="easyui-combobox" id="category"  name="category"  labelPosition="top" style="width:100%;">
               
             
                <option value="电脑主机">电脑主机</option>
                <option value="显示器">显示器</option>
                <option value="打印机">打印机</option>
                <option value="电话">电话</option>
                <option value="投影仪">投影仪</option>
                <option value="终端机">终端机</option>
                <option value="雷达测速仪">雷达测速仪</option>
                <option value="PDA">PDA</option>
                <option value="一维扫描枪">一维扫描枪</option>
                <option value="二维扫描枪">二维扫描枪</option>
                 <option value="相机">相机</option>
                <option value="笔记本电脑">笔记本电脑</option>
                <option value="碎纸机">碎纸机</option>
                <option value="对讲机">对讲机</option>
                <option value="触摸一体机">触摸一体机</option>
                
            </select></td>
	    			<td style="padding-left:100px;">设备品牌:</td>
	    					<td> <select class="easyui-combobox" id="brand"  name="brand"  labelPosition="top" style="width:100%;">
               
             
                <option value="联想">联想</option>
                <option value="惠普">惠普</option>
                <option value="斑马">斑马</option>
                <option value="TCL">TCL</option>
                <option value="爱普生">爱普生</option>
                <option value="三星">三星</option>
                <option value="京瓷">京瓷</option>
                <option value="戴尔">戴尔</option>
            
            </select></td>
	    		</tr>
	    		<tr>
	    			<td>设备型号:</td>
	    			<td><input class="easyui-textbox" type="text" id="type" data-options="required:true"></input></td>
	    			<td style="padding-left:100px;">出厂编号:</td>
	    			<td><input class="easyui-textbox" type="text" id="ccnumber" data-options="required:true" ></input></td>
	    		
	    		</tr>
	    		<tr>
	    			<td>资产编码:</td>
	    			<td><input class="easyui-textbox" type="text" id="zcnumber" data-options="required:true"></input></td>
	    			<td style="padding-left:100px;">责任人:</td>
	    			 <td><input class="easyui-textbox" id="personIC" name="personIC" data-options="required:true" />
	    			</tr>
	    		
	    		<tr>
	    			<td>曾用人:</td>
	    			<td><input class="easyui-textbox" type="text" id="personCY" ></input></td>
	    			<td style="padding-left:100px;">现存地点:</td>
	    			 <td><input class="easyui-textbox" id="area" name="area" data-options="required:true" />
        
	    
	    		</tr>
	    		<tr>
	    			<td>自盘数量:</td>
	    			<td><input class="easyui-textbox" type="text" id="zpCount" data-options="required:true"></input></td>
	    			<td style="padding-left:100px;">使用状态:</td>
	    			 <td> <select class="easyui-combobox" id="state"  name="state"  labelPosition="top" style="width:100%;">
               
             
                <option value="正常使用">正常使用</option>
                <option value="损坏待维修">损坏待维修</option>
                <option value="暂时闲置">暂时闲置</option>
                <option value="淘汰待处理">淘汰待处理</option>
                <option value="闲置">闲置</option>
            
            </select></td>
	    		</tr>
	    		<tr>
	    			<td>新防拆标签码:</td>
	    			<td><input class="easyui-textbox" type="text" id="newfcNumber" data-options="required:true"></input></td>
	    			<td style="padding-left:100px;">硬件管理员:</td>
	    			 <td><input class="easyui-textbox" id="admin" name="admin" data-options="required:true" />
	    		</tr>
	    		<tr>
	    			<td >维修防拆标签码:</td>
	    			<td><input class="easyui-textbox" type="text" id="wxNumber" data-options="required:true"></input></td>
	    			<td style="padding-left:100px;">维修人员:</td>
	    			 <td><input class="easyui-textbox" id="wxPerson" name="wxPerson"  />
	    		</tr>
	    		<tr>
	    			<td>备注:</td>
	    			<td><input class="easyui-textbox" type="text" id="remarks" ></input></td>
	    			<td style="padding-left:100px;">录入人:</td>
	    			 <td><input class="easyui-textbox" id="lururen" name="lururen" data-options="required:true" readonly="readonly"/>
	    		</tr>
	    		
				
	    	</table>
	    </form>
	    <div style="text-align:left;padding:5px">
	    	<a href="javascript:void(0)" id="submit" class="easyui-linkbutton" onclick="submit_fszc()" style="color:#5bc0de">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="color:red">重填</a>
	    </div>
	    </div>
	</div>


<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/datagrid-filter/datagrid-filter.js"></script>
<script type="text/javascript" src="js/duan_fs/duan_fs.js"></script>
<script type="text/javascript">
   
        showUser();
	  
		

	
	
	
	
	function showUser(){
	
	var user="<%=session.getAttribute("name")%>";	
	var department="<%=session.getAttribute("bumen")%>";

	 if(user!="null"){
	$("#lururen").val(user);
	$("#department").val(department);

	}

	else{
	 if (window.top!=null && window.top.document.URL!=document.URL){  
            var urlStr = document.URL;  
             var endIndex = urlStr.indexOf('xxxxxxxxxx');  
             
            urlStr = urlStr.substring(0, 40); 
          
          window.top.location= urlStr + "/login.jsp";  // 跳转到登录页  
           
        }};
	

	
	}	
	
	
	

	function clearForm(){
			location.reload() ;                           
	  
		}
</script>
  </body>

</html>
