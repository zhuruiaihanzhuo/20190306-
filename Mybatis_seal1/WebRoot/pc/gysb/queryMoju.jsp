<%@ page language="java" import="java.util.*"      pageEncoding="UTF-8"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>模具查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		
					<div class="easyui-panel"  id="dgg" data-options="fit:true,title:'<center>模具列表</center>',tools:'#tool'">
						<table id="dg11">
							<thead>
								<tr>
									<th data-options="field:'id',align:'center',width:fixWidth(0.02)">序号</th>
									<th data-options="field:'sid',width:fixWidth(0.02),checkbox:true"></th>
									<th data-options="field:'bianhao',align:'center',width:fixWidth(0.1),sortable:true">模具编号</th>
									<th data-options="field:'shuoming',align:'center',sortable:true,order:'asc',width:fixWidth(0.3),sortable:true">说明</th>
										
									<th data-options="field:'lururen',align:'center',width:fixWidth(0.1)">录入人</th>		
								<th data-options="field:'lurushijian',align:'center',width:fixWidth(0.1)">录入时间</th>	
								<th data-options="field:'genggairen',align:'center',width:fixWidth(0.1)">更改人
										</th>
								<th data-options="field:'genggaishijian',align:'center',width:fixWidth(0.1),sortable:true">更改时间</th>
								
								</tr>
							</thead>
						</table>
		</div>
		<div id="tool">
	
		<a href="pc/gysb/queryMoju.jsp" class="icon-reload" ></a>
	</div>
</body>
<script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"src="js/datagrid-filter/datagrid-filter.js"></script>
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
		
        	
       

	
    var dg1=$('#dg11').datagrid({
    	  	 title:"记录列表",
    		 idField:'id', 
    		
    		 loadMsg:'Processing, please wait …', 
    		 singleSelect:true,
    		 pagination:true,
    		 remoteSort:false,
     		 width:'auto',              
			 height:'auto' 	,
			  toolbar:[
       	{
       		text:'修改',
       		iconCls:'icon-edit',
       	 	handler:function(){
       	 	
       	 	 //判断是否选中一条记录
            var data=$('#dg11').datagrid('getSelected');
       	 	if(data)
                {
                var bianhao=data.bianhao;
                var biaoti=data.shuoming;
                var neirong=data.neirong;
           
                
               
                window.location.href="pc/gysb/updateMoju.jsp?bianhao="+encodeURI(encodeURI(bianhao))+"&&biaoti="+encodeURI(encodeURI(biaoti))+"&&neirong="+encodeURI(encodeURI(neirong));;
                }
            else
                {
                $.messager.alert('选定失败','未选定数据','error');
                }	 	
/*        			 var row = $('#dg1').datagrid('getSelected');
	if (row){
	alert('Item ID:'+row.id+"Price:"+row.bianhao);
} */
       		} 
       		}]
			 
			 
			    
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
		url:'<%=path%>/mojuInfo/MojuInfo_queryAll.do',
		type:"post",
		dataType:"json",
		success:function(data){
		$('#dg11').datagrid('loadData',data.data);
		},
	
	});
	}	
	
   </script>
</html>
