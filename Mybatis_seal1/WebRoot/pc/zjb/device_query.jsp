<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>设备</title>
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

<!-- 	<div class="easyui-layout" data-options="fit:true"> -->
		
					<div class="easyui-panel"  id="dg" data-options="fit:true,title:'<center>设备信息查询</center>',tools:'#tool'">
						<table id="dg1">
							<thead>
								<tr>
									<th data-options="field:'lurushijian',align:'center',width:fixWidth(0.2),sortable:true">录入时间
										</th>
										<th data-options="field:'shebeibianhao',align:'center',width:fixWidth(0.1),sortable:true">设备编号
										</th>
									 <th data-options="field:'lururen',sortable:true,width:fixWidth(0.1),sortable:true">录入人
										</th>	
									<th data-options="field:'shuoming',align:'center',width:fixWidth(0.1),sortable:true">说明
										</th>
									<th data-options="field:'area',sortable:true,order:'asc',width:fixWidth(0.1),sortable:true">区域</th>
									 <th data-options="field:'leibie',sortable:true,order:'asc',width:fixWidth(0.1),sortable:true">设备类别</th>
								<th data-options="field:'beizhu',align:'center',width:fixWidth(0.3),sortable:true">备注</th>
								</tr>  
							</thead>
						</table>
		</div>
		<div id="tool">
		<a href="pc/zjb/device_add.jsp" class="icon-add"  title="添加设备"></a>
		<a href="pc/zjb/device_query.jsp" class="icon-reload" ></a>
	</div>
</body>
<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/datagrid-filter/datagrid-filter.js"></script>
<script>
	$(document).ready(function(){
	todatagrid();
	show();
	
	});
	window.addEventListener("orientationchange", function() {

				window.location.reload(); 
}, false);
		function fixWidth(percent)  {  
    return document.body.clientWidth * percent ;//这里你可以自己做调整  
}  
   		function  todatagrid(){
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
	function show(){
	$.ajax({
		url:'<%=path%>/device/Device_query.do',
		type:"post",
		dataType:"json",
		success:function(data){
		var data1=data.data;
		var result=[];
		 for ( var machine in data1) {
		
                var row_data = {
                    lurushijian : data1[machine].lurushijian,
                    shebeibianhao : data1[machine].shebeibianhao,
                   lururen : data1[machine].lururen,
                    shuoming : data1[machine].shuoming,
                    area : data1[machine].area.shuoming,
                    beizhu : data1[machine].beizhu,
                    leibie : data1[machine].leixing.leibie
                   
                };
               //因为html元素无法使用子对象.属性  ，所以先把需要的格式保存为集合，之后按照正常加载能够实现正常分页
               result.push(row_data);
               
              
               /*  $('#dg1').datagrid('appendRow',row_data); 
                 */
                } 
               
		$('#dg1').datagrid('loadData',result);
		
		
		
	
		
		}
	
	});
	}	
	
   </script>
</html>
