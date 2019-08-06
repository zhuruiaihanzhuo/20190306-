<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="../../css/mui/mui.min.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <style>
.over {position: fixed; left:0; top:0; width:100%; z-index:100;}
.tempContainer {position:fixed; width:100%; margin-right:0px; margin-left:0px; text-align:center; z-index:101;}
</style>
  <body>
   <div class="over"></div><!--背景层-->
<div class="logoImg amplifyImg"><!--注意：此处的amlifyImg不可少-->
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
     <img src="image/xiaofang/timg.jpg"/>
</div>
  </body>
  <script type="text/javascript" src="js/easyUI/jquery.min.js"></script>
   <script type="text/javascript" src="js/mui/mui.zoom.js"></script>
</html>
