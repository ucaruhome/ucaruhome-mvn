<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
	function chakan(userId){
	   //alert(userId);
	   top.Dialog.open({URL:"lesson/findOneSupplierUser.action?userId="+userId,Title:"设计师信息 ",Width:950,Height:400});
	}
	
	
	function prePage(nowPage){
	top.window.frmright.frmrightChild.location="findSupplierUsersShenHeOver.action?designer=0&nowPage="+nowPage;
	}
	
	function nextPage(nowPage){
	top.window.frmright.frmrightChild.location="findSupplierUsersShenHeOver.action?designer=0&nowPage="+nowPage;
	}
</script>
</head>
<body>
<div id="scrollContent">
	<table class="tableStyle">
		<tr>
			<th width="10%">用户名</th>
			<th width="3%">性别</th>
			<th width="5%">出生年月</th>
			<th width="20%">姓名</th>
			<th width="15%">昵称</th>
			<th width="20%">微博</th>
			<th width="10%">微信</th>
			<th width="10%">操作</th>
		</tr>
		<s:iterator value="list" var="user">
		<tr>
			<td>${user.userName }</td>
			<td>${user.sex }</td>
			<td>${user.birthday }</td>
			<td>
				<span class="float_left">${user.name }</span>
				<span class="img_light" title="${user.role.roleName }"></span>
			</td>
			<td>${user.nickName }</td>
			<td>
				<span class="text_slice" style="width:200px;" title="微博">${user.microblog }</span>
			</td>
			<td>${user.wechat }</td>
			<td><span class="img_view hand" title="查看" onclick="chakan('${user.id}')"></span>
			<s:if test="#user.supplier==2">
			审核未通过
			</s:if>
			<s:elseif test="#user.supplier==3">
			审核已通过
			</s:elseif>
			<s:elseif test="#user.supplier==4">
			已取消认证
			</s:elseif>
			<s:else>
			审核中
			</s:else>
			</td>
		</tr>
		</s:iterator>
	</table>
	
<div style="height:35px;">
	<div class="float_left padding5"></div>
	<div class="float_right padding5 paging">
		<div class="float_left padding_top4">
		<s:if test="nowPage>1"><span><a href="javascript:"  onclick="prePage('${nowPage-1}')">上一页</a></span></s:if>
		<s:else><span class="paging_disabled"><a href="javascript:">上一页</a></span></s:else>
		
		<s:if test="nowPage>=maxPage">
		<span class="paging_disabled"><a href="javascript:">下一页</a></span></s:if>
		<s:else><span><a href="javascript:"  onclick="nextPage('${nowPage+1}')">下一页</a></span></s:else>  每页
		</div>
		<div class="float_left"><span>${maxPageCount}</span></div>
		<div class="float_left padding_top4">条记录</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
</div>

</div>
</body>
</html>
