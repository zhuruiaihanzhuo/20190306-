<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电热鼓风干燥箱点检信息查询</title>
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
		
					<div class="easyui-panel"  id="dg" data-options="fit:true,title:'<center>电热鼓风干燥箱点检信息查询</center>',tools:'#tool'">
						<table id="dg1">
							<thead>
								<tr>
								<th data-options="field:'shebeibianhao',align:'center',width:fixWidth(0.07),sortable:true">设备资产编号
										</th>
									<th data-options="field:'lurushijian',align:'center',width:fixWidth(0.07),sortable:true">检查日期
										</th>
									<th data-options="field:'lururen',align:'center',width:fixWidth(0.07),sortable:true">检查人
										</th>
									<th data-options="field:'bumen',align:'center',width:fixWidth(0.07),sortable:true">部门</th>
									
									<th data-options="field:'beizhu',align:'center',width:fixWidth(0.12),sortable:true">异常情况
										</th>
										<th data-options="field:'one',align:'center',width:fixWidth(0.12),sortable:true">设备整体表面无灰尘，散热装置运行良好
										</th>
									
									
									<th data-options="field:'two',align:'center',width:fixWidth(0.12),sortable:true">检查各漏电保护开关是否正常</th>
								<th data-options="field:'three',align:'center',width:fixWidth(0.12),sortable:true">检查试验箱体内部无脏污，无试验物料残留，清洁整理</th>
								
								<th data-options="field:'four',align:'center',width:fixWidth(0.12),sortable:true">高温轴承定期加油，轴承无摩擦响声</th>
									
									<th data-options="field:'five',align:'center',width:fixWidth(0.12),sortable:true">测试仪表通讯显示良好
										</th>
										<th data-options="field:'six',align:'center',width:fixWidth(0.12),sortable:true">试验按钮良好
										</th>
									
									
									<th data-options="field:'seven',align:'center',width:fixWidth(0.12),sortable:true">各禁锢螺钉状态良好</th>
								<th data-options="field:'eight',align:'center',width:fixWidth(0.12),sortable:true">各电器接线柱紧固</th>
								<th data-options="field:'nine',align:'center',width:fixWidth(0.12),sortable:true">风轮电机工作是否正常</th>
								</tr>
							</thead>
						</table>
		</div>
		</div>
		<div id="tool">
	
		<a href="show/zk/drgfgzx1_query.jsp" class="icon-reload" title="刷新数据" ></a>
	</div>
</body>
<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/datagrid-filter/datagrid-filter.js"></script>
<script>
	$(document).ready(function(){
	todatagrid1();
	show1();
	
	});
	window.addEventListener("orientationchange", function() {

				window.location.reload(); 
}, false);
		function fixWidth(percent)  {  
    return document.body.clientWidth * percent ;//这里你可以自己做调整  
}  
   		function  todatagrid1(){
		/* 	$(document).bind('contextmenu',function(e){
				e.preventDefault();
				$('#mm').menu('show', {
					left: e.pageX,
					top: e.pageY
				});
			}); */
		
        	
       

	
    var dg1=$('#dg1').datagrid({
    	  	 title:"记录列表",
    		 idField:'id', 
    		 loadMsg:'Processing, please wait …', 
    		 singleSelect:true,
    		 pagination:true,
    		 remoteSort:false,
     		 width:'auto',              
			 height:'auto'
   
    	   
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
       
 

		};
	function show1(){
	$.ajax({
		url:'<%=path%>/drgfgzx1/Drgfgzx1_query.do',
		type:"post",
		dataType:"json",
		success:function(data){
		
		var data1=data.data;
		var result=[];
		 for ( var machine in data1) {
		
                var row_data = {
                    lurushijian : data1[machine].lurushijian,
                    
                    shebeibianhao : data1[machine].device_id.shebeibianhao,
                   lururen : data1[machine].lururen,
                   
                    beizhu : data1[machine].beizhu,
                    bumen : data1[machine].bumen,
                       one: data1[machine].one,
                       two:	data1[machine].two,
                     three: data1[machine].three,
                     four : data1[machine].four,
                     five : data1[machine].five,
                     six  : data1[machine].six,
                     seven: data1[machine].seven,
                     eight:	data1[machine].eight,
                     nine : data1[machine].nine
                   
                };
               //因为html元素无法使用子对象.属性  ，所以先把需要的格式保存为集合，之后按照正常加载能够实现正常分页
               result.push(row_data);
              
				$('#dg1').datagrid('loadData',result);
				};
},
			error: function (jqXHR, textStatus, errorThrown) {
			
		
        }

				
				
	});
	
	}	
   </script>
</html>