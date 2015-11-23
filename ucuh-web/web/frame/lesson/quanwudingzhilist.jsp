<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

<!--单行文本截取start-->
<script type="text/javascript" src="../js/text/text-overflow.js"></script>

<!--单行文本截取end-->
<script type="text/javascript">
	function fanye(page){
	top.window.frmright.location="quanwudingzhislist.action?nowPage="+page;
	}
</script>
</head>
<body>
<div>
	<table class="tableStyle" sortMode="true" headFixMode="true" useMultColor="true" useCheckBox="true">
		<tr>
			<th width="100">申请者ID</th>
			<th width="100">申请者昵称</th>
			<th width="100">户型</th>
			<th width="100">设计费</th>
			<th>量房地址</th>
			<th width="100">申请者电话</th>
			<th width="100">设计师姓名</th>
			<th width="100">设计师电话</th>
			<th width="100">申请时间</th>
		</tr>
	</table>
</div>
<div id="scrollContent" >
	<table class="tableStyle"  useMultColor="true" useCheckBox="true">
	   <s:iterator value="list" id="qwdz">
		<tr>
			<td width="100">${qwdz.user.userName }</td>
			<td width="100">${qwdz.user.id }</td>
			<td width="100">${qwdz.cost.huxing }</td>
			<td width="100">${qwdz.cost.costMoney }</td>
			<td>${qwdz.hourseAdress}</td>
			<td width="100">${qwdz.user.phone }</td>
			<td width="100">${qwdz.cost.hchhDesigner.name }</td>
			<td width="100">${qwdz.cost.hchhDesigner.phone }</td>
			<td width="100">${qwdz.time}</td>
		</tr>
	   </s:iterator>
	</table>
</div>

<div style="height:35px;">
	<div class="float_right padding5 paging">
		<div class="float_left padding_top4">
		<s:if test="nowPage>1"><span><a href="javascript:" onclick="fanye('${nowPage-1}')">上一页</a></span></s:if>
		<s:else><span class="paging_disabled"><a href="javascript:">上一页</a></span></s:else>
		<!--<span class="paging_current"><a href="javascript:;">1</a></span>-->
		<s:iterator value="pages" id="p">
		<s:if test="nowPage==#p">
		 <span class="paging_current"><a href="javascript:">${p}</a></span>
		</s:if>
		<s:else>
		<span><a href="javascript:" onclick="fanye('${p}')">${p}</a></span>
		</s:else>
		</s:iterator>
		<s:if test="nowPage>=maxPage">
		<span class="paging_disabled"><a href="javascript:">下一页</a></span>
		</s:if>
		<s:else>
		<span><a href="javascript:" onclick="fanye('${nowPage+1}')">下一页</a></span></s:else> 每页
		</div>
		<div class="float_left">${maxPageCount}</div>
		<div class="float_left padding_top4">条记录</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
</div>
	

</body>
</html>
