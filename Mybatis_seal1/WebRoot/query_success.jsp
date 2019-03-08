<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query_success.jsp' starting page</title>
    <meta name="viewport" content="width=device-width,minimum-scale=1.0, maximum-scale=2.0" /> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
*{
border: 1;
background-color: olive;
}

</style>
  </head>
  
  <body>
   <div>
   	<table class="default" width="100%">
	<col width="35%">
	<col width="15%">
	<col width="15%">
	<col width="15%">
	<col width="20%">

	<tr class="title">
				<td>日期</td>
				<td>检点人</td>
				<td>数量</td>
				<td>部门</td>
				<td>编号</td>
	</tr>
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.result" var="stu">
	<tr class="list">
		<td><s:date name="#stu.date" format="yyyy年MM月dd日"/></td>
		<td><s:property value="#stu.jiancharen"/></td>
		
		<td><s:property value="#stu.shuliang"/></td>
	
		<td><s:property value="#stu.bumen"/></td>
		<td><s:property value="#stu.shebeibianhao"/></td>
		</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>
   
   </div>
  </body>
</html>
