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
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
<!-- 	<div class="lefttop"><span></span>通讯录</div> -->
    
    <dl class="leftmenu">
        
    <dd>
    
    <c:if test="${param.menuId!=null}">
    
    <div class="title">
     <c:forEach items="${menulist }" var="menu">
    <c:if test="${menu.menuId==param.menuId }">
    <span><img src="resource/images/leftico01.png" /></span>${menu.menuName }
    </c:if>
    </c:forEach>
    </div>
    	<ul class="menuson">
    	 <c:forEach items="${menulist }" var="menu2">
    	  <c:if test="${menu2.pmenuId==param.menuId }">
       		 <li><cite></cite><a href="${menu2.menuUrl }" target="rightFrame">${menu2.menuName }</a><i></i></li>
       	 </c:if>	 
        </c:forEach>

		</ul>    

</c:if>

    <c:if test="${param.menuId==null}">
    
    <div class="title">

    <span><img src="resource/images/leftico01.png" /></span>工作台


    </div>
    	<ul class="menuson">
       		 <li><cite></cite><a href="view/main/index.jsp" target="rightFrame">工作台</a><i></i></li>
		</ul>    

</c:if>

    </dd>
    </dl>
    
</body>
</html>