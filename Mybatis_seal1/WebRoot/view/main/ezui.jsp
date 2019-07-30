<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>设备后台管理系统</title>

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
		<!-- <div data-options="region:'south',split:true " style="height: 150px"
			title="south"></div> -->
		<div   id="mai"  class="easyui-tabs"  data-options="region:'center',split:true "
			style="height: 150px;background-image: url(image/background/2.jpg);background-size:100%">
		


		</div>
		<div data-options="region:'west',split:true " style="width: 150px;background-color: #DDDDDD"
			title="目录">
			
			<ul id="tt"></ul>
			<!-- <ul class="easyui-tree" data-options="method:'get',animate:true,lines:true">
			<li>
		<span>系统管理</span>
		<ul><li></li></ul>
		</li>
    <li>
		<span>设备点检管理</span>
		<ul>
			<li>
				<span>安全科点检管理</span>
				<ul>
						<li>
												<a href="show/zjb/query_area.jsp" >区域管理</a>
										
										</li>
						
						 <li data-url="url:'show/zjb/query_area.jsp'">区域管理</li> 
						<li>灭火器设备管理</li>
					
						
					
						<li>消防设备管理</li>
					</ul>
	
</ul>
		</li>
		<li>
		<span>生产信息管理</span>
		<ul><li></li></ul>
		</li>
		<li><span>招聘管理</span><ul><li></li></ul></li>
		<li><span>后勤管理</span><ul><li></li></ul></li>
		 -->
	
		
			</div>
		<div data-options="region:'north',split:true,title:'<center>后台管理系统</center>'" style="height: 66px;background-color: #99FFFF"
			><div    style=" color: #000033;" align="right"><b style="color: #663300"><%=session.getAttribute("name")%></b>
			欢迎您&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><a href="login.jsp" target="_parent">注销</a></b></div><div id="show"  align="right"></div></div>
		<!-- <div data-options="region:'east',split:true " style="width: 150px"
			title="east"></div> -->
<!-- 		<div id="mm" class="easyui-menu" style="width:120px;">
			<div>New</div>
			<div>
				<span>Open</span>
				<div class="menu-content" style="text-align:left;padding:10px">
					<div style="font-weight:bold;font-size:16px">Select your
						Language:</div>
					<ul style="margin:0;padding:0 0 0 40px">
						<li><a href="javascript:void(0)">Java</a></li>
						<li><a href="javascript:void(0)">Basic</a></li>
						<li><a href="javascript:void(0)">C++</a></li>
						<li><a href="javascript:void(0)">Fortran</a></li>
						<li><span>Other</span> <input></li>
					</ul>
					<div style="padding:10px 0 0 30px">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							data-options="iconCls:'icon-ok'">Ok</a>
					</div>
				</div>
			</div>
			<div data-options="iconCls:'icon-save'">Save</div>
			<div data-options="iconCls:'icon-print'">Print</div>
			<div class="menu-sep"></div>
			<div>Exit</div>
		</div> -->
</body>
<script type="text/javascript" src="resource/easyui/jquery.min.js"></script>
<script type="text/javascript" src="resource/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="resource/easyui/seal/datagrid-filter/datagrid-filter.js"></script>
<script>
	showTime();
   		$(function(){
   		
   		$("#tt").tree({
   			url: "login/Users_queryAuth.do?username=<%=session.getAttribute("user")%>",
   			 method:"post",
	        
	          /* lines:true, */
   			 loadFilter: function(data){ 
   		
				return data.data;
					}, 

				
				
				onClick: function(node){
				
				if(node.href){
				var tab=$('#mai').tabs("getTab",node.text);
				if(tab){
				$('#mai').tabs("select",node.text);
			
				}
					else{
					$('#mai').tabs('add',{
					title: node.text,
					content:'<iframe class="easyui-panel"  fit="true" src="'+node.href+'" style="padding:10px"></iframe>',
					closable:true
					});
					}
					}
				}
   		
   		
   		
   		
   		});
   		
   		
   		
   		
   		
   		
   		
			$(document).bind('contextmenu',function(e){
				e.preventDefault();
				$('#mm').menu('show', {
					left: e.pageX,
					top: e.pageY
				});
			});
		$('#dg').datagrid({
        	
        columns:[[
       		 {field:'sid',checkbox:true,sortable:true},
    		{field:'code',title:'Code',width:100},
    		{field:'name',title:'Name',width:100},
    		{field:'price',title:'Price',width:100,align:'right'}
        ]],
       data:[{'name':'duan1','price':'5'},{'name':'duan2','price':'5'},{'name':'duan3','price':'5'}],
       singleSelect:true,
       rownumbers:true,
       toolbar:[
       	{
       		text:'删除',
       		iconCls:'icon-cut',
       	 	handler:function(){
       			
       			console.log($('#dg').datagrid('getSelections'));
       		} 
       		}]
       
    });

	
    var dg1=$('#dg1').datagrid({
    		url:'<%=path%>/kzq/TongWang_query',
    		
    		
    	   singleSelect:true,
    	   pagination:true,
    	   remoteSort:false
    	   
 });
            
              dg1.datagrid('enableFilter', [{
                field:'listprice',
                type:'numberbox',
                options:{precision:1},
                op:['equal','notequal','less','greater']
            },{
                field:'unitcost',
                type:'numberbox',
                options:{precision:1},
                op:['equal','notequal','less','greater']
            },{
                field:'status',
                type:'combobox',
                options:{
                    panelHeight:'auto',
                    data:[{value:'',text:'All'},{value:'P',text:'P'},{value:'N',text:'N'}],
                    onChange:function(value){
                        if (value == ''){
                            dg1.datagrid('removeFilterRule', 'status');
                        } else {
                            dg1.datagrid('addFilterRule', {
                                field: 'status',
                                op: 'equal',
                                value: value
                            });
                        }
                        dg1.datagrid('doFilter');
                    }
                }
            }]); 
       
 
    $('#tt').bind('click',function(){
    		/* console.log($('#dg').datagrid('getSelected')); */
    	/* 	console.log($('#dg').datagrid('getSelections')); */
    	console.log($('#dg').datagrid('options'));
    });
		});
		//此处是easyui的json格式
var tree = {
	id:'',
	text:'',
	state:'',
	checked:'',
	attributes:'',
	children:''
};
//此处是把后台传过来的json数据转成easyui规定的格式
function bl(item){
	
	var tree = new Object();
	tree.id = item.id;
	tree.text = item.name;
	tree.state = 'open';
	tree.checked = 'false';
	tree.attributes = item.url;
	
	tree.children = jsonbl(item.permissionsList);

	return tree;
}
function jsonbl(data){

	var easyTree = [];
	
	$.each(data,function(index,item){
	
	 easyTree[index] = bl(item);
	 });
	return easyTree;
} 

	function checkTime(i){  //补位处理
    if(i<10)  
    {
       i="0"+i;     //当秒分小于10时，在左边补0；
    }
    return i;
  }
  function showTime(){
    var now=new Date();
    var year=now.getFullYear();
    var month=now.getMonth()+1; //js获取的月份是从0开始；
    var day=now.getDate();
    var h=now.getHours();
    var m=now.getMinutes();
    var s=now.getSeconds();
    m=checkTime(m)
    s=checkTime(s)

    var weekday=new Array(7)
    weekday[0]="星期日"
    weekday[1]="星期一"
    weekday[2]="星期二"
    weekday[3]="星期三"
    weekday[4]="星期四"
    weekday[5]="星期五"
    weekday[6]="星期六"
    var w=weekday[now.getDay()]; //js获取的星期是0~6,0是星期天；
    document.getElementById("show").innerHTML=year+"年"+month+"月"+day+"日 "+w+"  "+h+":"+m+":"+s;
    t=setTimeout('showTime()',500)
  }
		
   </script>
</html>
