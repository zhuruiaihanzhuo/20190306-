<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<link href="resource/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="resource/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected");
		$(this).addClass("selected");
	});	
});
</script>
</head>

<body style="background:url(resource/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="resource/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="view/main/left.jsp"  class="selected" target="leftFrame" ><img src="resource/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    <c:forEach items="${menulist }" var="menu">
    <c:if test="${menu.pmenuId==1}">
    <li><a href="view/main/left.jsp?menuId=${menu.menuId}" target="leftFrame" ><img src="resource/images/icon0${menu.menuSeq }.png" title="${menu.menuName }" /><h2>${menu.menuName }</h2></a></li>
  	 </c:if>
   </c:forEach>

    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="resource/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="login" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${user.userName }</span>
<!--     <i>消息</i>
    <b>5</b> -->
    </div>    
    
    </div>

</body>
</html>