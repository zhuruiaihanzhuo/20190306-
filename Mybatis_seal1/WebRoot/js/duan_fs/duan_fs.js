function  user_todatagrid(){
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
		
		function showUser(){
			$.ajax({
				url:'user/Users_queryAll.do',
				type:"post",
				dataType:"json",
					success:function(data){
				var data1=data.data;
				var result=[];
				 for ( var machine in data1) {
				
		                var row_data = {
		                    username : data1[machine].username,
		                    name : data1[machine].name,
		                   lururen : data1[machine].lururen,
		                    bumen : data1[machine].bumen,
		                    createtime : data1[machine].createtime
		                   
		                   
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
		
		
		
		function submitForm(){
			
			 alert($("#username").val()+$("#bumen").val()+$("#name").val()+$("#lururen").val());
		 	 if($("#username").val()!=null&& "" != $("#username").val() && $("#name").val() !=null&&
					 "" != $("#name").val() && $("#lururen").val() !=null&& "" != $("#lururen").val()&&
					 $("#bumen").val() !=null&& "" != $("#bumen").val()){ 
				 $.ajax({
				type: "post",
				 url:"user/Users_addUser.do",
				data:{
				
				username: $("#username").val(),
				bumen: $("#bumen").val(),
				name : $("#name").val(),
				lururen : $("#lururen").val()
				
				
				},
				success: function () {
				
				$.messager.confirm('录入成功', '是否继续录入?', function(r){
						if (r){
							location.reload() ;
						}else{
						window.location.href="pc/user_auth/user_query.jsp";
						
						
						}
					});
				
				
				
			    },
			    error:function(){
			    	 $.messager.alert('录入失败','录入失败，请联系管理员','error');
			    }
				 });
				
				 } else{
				 $.messager.alert('录入失败','必填项不完整，录入失败！！!','error');
				 
				 }


		}
			function clearForm(){
					location.reload() ;                           
			  
				};
			
			
			
			
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
				url:'fszc/Fszc_queryByDepartment.do',
				type:"post",
				dataType:"json",
				data:{
					 department:$("#department").val()
				},
				success:function(data){
				
				var data1=data.data;
				var result=[];
				 for ( var machine in data1) {
				
		                var row_data = {
		                    lurushijian : data1[machine].lurushijian,      
		                   lururen : data1[machine].lururen,		                   
		                   department : data1[machine].department,
		                    office : data1[machine].office,
		                       category: data1[machine].category,
		                       brand:	data1[machine].brand,
		                     type: data1[machine].type,
		                    ccNumber : data1[machine].ccNumber,
		                     zcNumber : data1[machine].zcNumber,
		                     personIC  : data1[machine].personIC,
		                     personCY: data1[machine].personCY,
		                     area:	data1[machine].area,
		                     zpCount : data1[machine].zpCount,
		                     state : data1[machine].state,
		                     newfcNumber : data1[machine].newfcNumber,
		                     admin  : data1[machine].admin,
		                     wxNumber: data1[machine].wxNumber,
		                     wxPerson:	data1[machine].wxPerson,
		                     remarks : data1[machine].remarks
		                   
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
			
			
			
			
			function submit_fszc(){
				
				 
			 	 if($("#department").val()!=null&& "" != $("#department").val()  && $("#office").val() !=null&& "" != $("#office").val() &&
						 $("#category").val()!=null&& "" != $("#category").val() && $("#brand").val() !=null&&"" != $("#brand").val()&&
						  $("#type").val()!=null&& "" != $("#type").val()  && $("#ccnumber").val() !=null&& "" != $("#ccnumber").val() &&
						 $("#zcnumber").val()!=null&& "" != $("#zcnumber").val() && $("#personIC").val() !=null&&"" != $("#personIC").val()&&
						 $("#personCY").val()!=null&& "" != $("#personCY").val()  && $("#area").val() !=null&& "" != $("#area").val() &&
						 $("#zpCount").val()!=null&& "" != $("#zpCount").val() && $("#state").val() !=null&&"" != $("#state").val() &&
						   $("#newfcNumber").val()!=null&& "" != $("#newfcNumber").val()  && $("#admin").val() !=null&& "" != $("#admin").val() &&
						 $("#wxNumber").val()!=null&& "" != $("#wxNumber").val() && $("#wxPerson").val() !=null&&"" != $("#wxPerson").val()&&
						 $("#remarks").val()!=null&& "" != $("#remarks").val()  && $("#lururen").val() !=null&& "" != $("#lururen").val()
						 ){ 
					 $.ajax({
					type: "post",
					 url:"fszc/Fszc_add.do",
					data:{
					
					department: $("#department").val(),
					office: $("#office").val(),
					category: $("#category").val(),
					brand: $("#brand").val(),
					type: $("#type").val(),
					ccNumber : $("#ccnumber").val(),
					zcNumber :$("#zcnumber").val(),
					personIC: $("#personIC").val(),
					personCY: $("#personCY").val(),
					area: $("#area").val(),
					zpCount: $("#zpCount").val(),
					state : $("#state").val(),
					newfcNumber :$("#newfcNumber").val(),
					admin: $("#admin").val(),
					wxNumber: $("#wxNumber").val(),
					wxPerson: $("#wxPerson").val(),
					remarks: $("#remarks").val(),
					lururen : $("#lururen").val()
					
					
					},
					success: function () {
					
					$.messager.confirm('录入成功', '是否继续录入?', function(r){
							if (r){
								location.reload() ;
							}else{
							window.location.href="pc/zjb/device_query.jsp";
							
							
							}
						});
					
					
					
				    },
				    error:function(){
				    	 $.messager.alert('录入失败','录入失败，请联系管理员','error');
				    }
					 });
					
					 } else{
					 $.messager.alert('录入失败','必填项不完整，录入失败！！!','error');
					 
					 }


			}
			
			
			