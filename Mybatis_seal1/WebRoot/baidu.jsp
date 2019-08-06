<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加新闻- 新闻发布系统--最前沿的时尚信息、最有看点的社会聚焦、最富得浪漫的殿tang</title>
        <!-- 配置文件 -->
        <script type="text/javascript" src="./ueditor/ueditor.config.js"></script>
        <!-- 编辑器源码文件 -->
          <script type="text/javascript" src="./ueditor/ueditor.all.min.js"></script>
        <script type="text/javascript" src="./ueditor/ueditor.all.js"></script>
        <script type="text/javascript" src="./ueditor/lang/zh-cn/zh-cn.js"></script>
        <!-- <link rel="stylesheet" type="text/css" href="./udeditor/themes/default/css" />
        <link type="text/css"  rel="stylesheet"  href="./newsRealese.css"/> -->
    </head>
    <body id="body">
        <form action="mojuInfo/MojuInfo_add.do" method="post">
            <table  border="0" id="table">
                <tr>
                    <td width="5%"></td>
                    <td width="90%">    
                        <table  border="1" id="table">
                            <tr >
                                <td >模具编号</td> <td><input type="text" name="bianhao"></td>
                                <td >标题</td> <td><input type="text" name="shuoming"></td>
                                <td >录入人</td> <td><input type="text" name="lururen"></td>
                            </tr>

                        </table>
                    </td>
                    
                </tr>
               
                <tr>
                    <td> </td>
                    <td>
                        <div align="center" style="width:80%">  
                            <textarea id="newsEditor" name="content" style="height: 80%" > </textarea>  
                            <br/>  
                            <input type="submit" value="发 布">  
                            <script type="text/javascript">
                                UE.getEditor('newsEditor');
                               // var content = UE.getPlainTxt();//content就是编辑器的带格式的内容
                             
                               
                            </script>  
                        </div>
                    </td>
                    <td> </td>
                </tr>
            </table>   
        </form>
    </body>
</html>
