
function InItData(){
	var phoneIp =  plusReady();
	//alert(phoneIp);
	$.ajax({
		type : "post",
		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
		async : false,
		url : "./DriverServlet",
		data : "method=queryTidanMsg" + "&phoneIp=" + phoneIp,
		dataType : "json",
		success : function(result) {
 			//alert(result.res);
				if(result.res == 0){
					mui.toast("即将跳转页面...");
				    mui.openWindow({
						url: '/carsControl_phone/personalMsg.jsp?phoneNo=' + phoneIp
					});
// 				    self.href = '/carsControl_phone/personalMsg.jsp?phoneNo=' + phoneIp;
				}else{
					setPageData();
				}

		},
		error : function(errorMsg, a, b) { //请求失败时执行该函数
			alert(b);
		}
	});
}


function setData() {
	$.ajax({
		type : "post",
		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
		async : false,
		url : "./DriverServlet",
		data : "method=queryTidanMsgAll",
		dataType : "json",
		success : function(result) {
			var gree1 = "";
			var gree2 = "";
			
			if(result.gree1 == null || result.gree1==""){
				gree1 = "0";
			}else {
				gree1 = result.gree1;
			}
			if(result.gree2 == null || result.gree2==""){
				gree2 = "0";
			}else {
				gree2 = result.gree2;
			}
			var lingda1 = "";
			var lingda2 = "";
			var lingda3 = "";
			var lingda4 = "";
			var lingda5 = "";
			var lingda6 = "";
			var lingda7 = "";
			var lingda8 = "";
			var lingda9 = "";
			
			if(result.lingda1 == null || result.lingda1 == ""){
				lingda1 = "0";
			}else {
				lingda1 = result.lingda1;
			}
			if(result.lingda2 == null || result.lingda2 == ""){
				lingda2 = "0";
			}else {
				lingda2 = result.lingda2;
			}
			if(result.lingda3 == null || result.lingda3 == ""){
				lingda3 = "0";
			}else {
				lingda3 = result.lingda3;
			}
			if(result.lingda4 == null || result.lingda4 == ""){
				lingda4 = "0";
			}else {
				lingda4 = result.lingda4;
			}
			if(result.lingda5 == null || result.lingda5 == ""){
				lingda5 = "0";
			}else {
				lingda5 = result.lingda5;
			}
			if(result.lingda6 == null || result.lingda6 == ""){
				lingda6 = "0";
			}else {
				lingda6 = result.lingda6;
			}
			if(result.lingda7 == null || result.lingda7 == ""){
				lingda7 = "0";
			}else {
				lingda7 = result.lingda7;
			}
			if(result.lingda8 == null || result.lingda8 == ""){
				lingda8 = "0";
			}else {
				lingda8 = result.lingda8;
			}
			if(result.lingda9 == null || result.lingda9 == ""){
				lingda9 = "0";
			}else {
				lingda9 = result.lingda9;
			}
			var kaibangjingxin = "";
			if(result.kaibangjingxin == null || result.kaibangjingxin == ""){
				kaibangjingxin = "0";
			}else{
				kaibangjingxin = result.kaibangjingxin;
			}
			$('#gree1').attr("placeholder","前边已排队\t"+gree1+"\t车次");
			$('#gree2').attr("placeholder","前边已排队\t"+gree2+"\t车次");
			$('#lingda1').attr("placeholder","前边已排队\t"+lingda1+"\t车次");
			$('#lingda2').attr("placeholder","前边已排队\t"+lingda2+"\t车次");
			$('#lingda3').attr("placeholder","前边已排队\t"+lingda3+"\t车次");
			$('#lingda4').attr("placeholder","前边已排队\t"+lingda4+"\t车次");
			$('#lingda5').attr("placeholder","前边已排队\t"+lingda5+"\t车次");
			$('#lingda6').attr("placeholder","前边已排队\t"+lingda6+"\t车次");
			$('#lingda7').attr("placeholder","前边已排队\t"+lingda7+"\t车次");
			$('#lingda8').attr("placeholder","前边已排队\t"+lingda8+"\t车次");
			$('#lingda9').attr("placeholder","前边已排队\t"+lingda9+"\t车次");
			$('#kaibangjingxin').attr("placeholder","前边已排队\t"+kaibangjingxin+"\t车次");
		},
		error : function(errorMsg, a, b) { //请求失败时执行该函数
			alert(b);
		}
	});	
}

