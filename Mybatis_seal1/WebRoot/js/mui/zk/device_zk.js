;
window.onload = function(){
	$('#user1').val(decodeURIComponent(QueryString("UserName")));//处理链接过来乱码
	$('#bumen').val(decodeURIComponent(QueryString("DeptName")));
    showTime();     //网页一加载就调用showTime()函数；

    
  };
  $("#btndrg").click(function(){

	  var one=$('input:radio[name="radio1"]:checked').val();
	  var two=$('input:radio[name="radio2"]:checked').val();
	  var three=$('input:radio[name="radio3"]:checked').val();
	  var four=$('input:radio[name="radio4"]:checked').val();
	  var five=$('input:radio[name="radio5"]:checked').val();
	  var six=$('input:radio[name="radio6"]:checked').val();
	  var seven=$('input:radio[name="radio7"]:checked').val();
	  var eight=$('input:radio[name="radio8"]:checked').val();
	  var nine=$('input:radio[name="radio9"]:checked').val();
	  var beizhu=$('#beizhu').val();
	  var lururen=$("#user1").html();
	  var bumen=$("#bumen").html();
	  var shebeibianhao=decodeURIComponent(QueryString("shebeibianhao"));
	  if(lururen!=""&&bumen!=""){
	  if(one!=null&&two!=null&&three!=null&&four!=null&&five!=null&&six!=null&&seven!=null&&eight!=null&&nine!=null){
		 if((one!="Y"||two!="Y"||three!="Y"||four!="Y"||five!="Y"||six!="Y"||seven!="Y"||eight!="Y"||nine!="Y")&&beizhu==""){
			  alert("请填写异常描述!!!");
			 
		 }
		 else{
			alert(lururen+"111402");
			
			$.ajax({
				type: "post",
				 url:"../../drgfgzx1/Drgfgzx1_add.do",
				data:{
				
				one	  : one,
				two   : two,
				three : three,
				four  : four,
				five  : five,
				six   : six,
				seven : seven,
				eight : eight,
				nine  : nine,
				beizhu: beizhu,
				bumen : bumen,
				lururen:lururen,
				shebeibianhao:shebeibianhao
				
				},
				success: function () {
					alert("录入成功");
					 window.location.href="zkmain_add.html";
			    },
			    error:function(){
			    	alert("录入失败------");
			    }
				 });
				 
 
	  }
		  
	  }else{
		  alert("请填写完整！！！");
	  }
	  }else{
		  alert("点检人或者部门信息为空，请重新登录，如有疑问请联系系统管理员！");
	  };
});
function show1(){
	
	   XuntongJSBridge.call('scanQRCode', { 'needResult': 1, 'scanType': ['qrCode'] }, function (result) {
	       
	    // var device=result.data.qrcode_str;
	        var shebeibianhao=result.data.qrcode_str;
	     var username=decodeURIComponent(QueryString("UserName"));
	     var bumen=decodeURIComponent(QueryString("DeptName"));
	    
   // var username="丽媛";
   // var bumen="小大姐";
    //var shebeibianhao=$("#txtFireCode").val();

	     $.post("../../DeviceServlet?shebeibianhao="+shebeibianhao,function(data){	  
			    if(data =="null"	)
				{	
			    	alert('无此设备，请扫描正确条码');
				}   
			   else{
				   var a=JSON.parse(data);
				   if(a.url!=null && a.url!=""){
				   
			
				   window.location.href="../"+a.url+"?username="+username+"&bumen="+bumen+"&shebeibianhao="+shebeibianhao;
				   }else{
					   alert("此设备未开发点检页面，请检查是否扫描错误，如有疑问请联系系统管理员！！");
				   };
  
			   }; 			   
		   });	
	     
	   });
	    };

function QueryString(name) {
    var AllVars = window.location.search.substring(1);
    var Vars = AllVars.split("&");
    for (i = 0; i < Vars.length; i++) {
        var Var = Vars[i].split("=");
        if (Var[0] == name) return Var[1];
    }
    return "";
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
    m=checkTime(m);
    s=checkTime(s);

    var weekday=new Array(7);
    weekday[0]="星期日";
    weekday[1]="星期一";
    weekday[2]="星期二";
    weekday[3]="星期三";
    weekday[4]="星期四";
    weekday[5]="星期五";
    weekday[6]="星期六";
    var w=weekday[now.getDay()]; //js获取的星期是0~6,0是星期天；
    document.getElementById("show").innerHTML="检查时间 ：           "+year+"年"+month+"月"+day+"日 "+w+"  "+h+":"+m+":"+s;
    t=setTimeout('showTime()',500);
  }
