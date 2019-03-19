<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>easyUI-domo</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="resource/easyui/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="resource/easyui/css/themes/icon.css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style="padding: 5px">

	<div class="easyui-layout" data-options="fit:true">
		<!-- <div data-options="region:'south',split:true " style="height: 150px"
			title="south"></div> -->
		<div data-options="region:'center',split:true, "
			style="height: 150px" title="">
		


		</div>
		<div data-options="region:'west',split:true " style="width: 150px"
			title="目录">
			<ul id="tt" class="easyui-tree">
    <li>
		<span>设备点检管理</span>
		<ul>
			<li>
				<span>安全科点检管理</span>
				<ul>
					
						<li>区域管理</li>
						<li>新增灭火器设备</li>
					
						
					
						<li>新增消防设备</li>
					</ul>
	
</ul>
		</li>
		<li>
		<span>生产信息管理</span>
		<ul><li></li></ul>
		</li>
		<li><span>招聘管理</span><ul><li></li></ul></li>
		<li><span>后勤管理</span><ul><li></li></ul></li>
		
	
		
			</div>
		<div data-options="region:'north',split:true,title:'<center>后台管理系统</center>'" style="height: 66px;"
			></div>
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
<script type="text/javascript" src="resource/easyui/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="resource/easyui/js/datagrid-filter/datagrid-filter.js"></script>
<script>
   		$(function(){
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
       			alert($('#dg').datagrid('getSelections').name);
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
		
   </script>
</html>
