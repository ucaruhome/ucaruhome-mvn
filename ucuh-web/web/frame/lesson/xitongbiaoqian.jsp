<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="../js/jquery-1.4.js"></script>
<script type="text/javascript" src="../js/framework.js"></script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css"/>
<link  rel="stylesheet" type="text/css" id="skin"/>
<!--框架必需end-->
<script type="text/javascript" src="../js/tree/dtree/dtree.js"></script>
<link href="../js/tree/dtree/dtree.css" rel="stylesheet" type="text/css"/>
	
</head>
<body leftFrame="true">
	<div style="text-align:center;" >
	<br />
	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	</div>
	<div id="scrollContent">
	<script type="text/javascript">
	d = new dTree('d');
	d.add(9,-1,'系统标签');
	//读取数据库中的标签记录
	//$(function(){
	
	//alert("读取开始");
	$.post(
	   "readLabelXT.action",
	   {"":""},
	   function(data){
	     //alert(data.listS);
	     //alert(data.list);
	     $.each(data.list,function(i,valueZ){ 
            //alert(valueZ.tagName);
            d.add(valueZ.id,valueZ.parentId,"'"+valueZ.tagName+"'",'chapter4-1.html',"'"+valueZ.tagName+"'",'frmright');
         });
        document.write(d);
	   },
	   "json"
	);
	//});
         
		
		

		
	</script>
</div>
</body>

</html>