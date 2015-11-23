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
	//从数据库读取所有的管理员帐号
	$(function(){
	    //alert("执行");
		//window.location="findAdminUsers.action";
	});
	function chakan(userId){
	   //alert(userId);
	   top.Dialog.open({URL:"lesson/queryUser.action?userId="+userId,Title:"查看用户 ",Width:950,Height:600});
	}
	
	
	function xiugai(userId){
	   //alert(userId);
	   top.Dialog.open({URL:"lesson/updateUser.action?userId="+userId,Title:"更新用户 ",Width:800,Height:500});
	}
	
	
	function shanchu(userId){
	top.Dialog.confirm("确定要删除吗？",function(){
	   $.post(
	     "delUser.action",
	     {"userId":userId},
	     function(data){
	       if(data.ok==1){
	         window.location.href=window.location.href;
	         top.Dialog.alert("删除成功");
	         
	       }else{
	         alert("删除失败");
	       }
	     },
	     "json"
	   );
	   //alert(userId);
	   });
	}
	
	function prePage(nowPage){
	top.window.frmright.frmrightChild.location="findPutongUsers.action?nowPage="+nowPage;
	}
	
	function nextPage(nowPage){
	top.window.frmright.frmrightChild.location="findPutongUsers.action?nowPage="+nowPage;
	}
</script>
</head>
<body>
<div id="scrollContent">
    <div style="height: 35px;width: 100%; text-align: right;">
    <input type="button" value="新增管理员 " onclick='top.Dialog.open({URL:"lesson/findRolesAndGroups.action",Title:"新增帐户 ",Width:850,Height:600});'/><!--
    <button><span class="icon_page" onclick='top.Dialog.open({URL:"lesson/chapter3-2-content1.html",Title:"自定义宽高 ",Width:800,Height:600});'>新增用户</span></button>
    --></div>
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
			<th>状态</th>
		</tr>
		<s:iterator value="list" id="user">
		<tr>
			<td>${user.userName }</td>
			<td>${user.sex }</td>
			<td>${user.birthday }</td>
			<td>
				<span class="float_left">${user.name }</span>
				<span class="img_light" title="${user.name }"></span>
			</td>
			<td>${user.nickName }</td>
			<td>
				<span class="text_slice" style="width:200px;" title="微博">${user.microblog }</span>
			</td>
			<td>${user.wechat }</td>
			<td><span class="img_view hand" title="查看" onclick="chakan('${user.id}')"></span><s:if test="#user.headPhotoRZ!=1"><span class="img_edit hand" title="修改" onclick="xiugai('${user.id}')"></span></s:if><!--<span class="img_delete hand" title="删除" onclick="shanchu('${user.id}')"></span>--></td>
		    <td>
		    <s:if test="#user.headPhotoRZ==0">
		           头像未审核
		    </s:if>
		    <s:elseif test="#user.headPhotoRZ==1">
		           头像已审核通过
		    </s:elseif>
		    <s:elseif test="#user.headPhotoRZ==2">
		           头像已审核未通过
		    </s:elseif>
		    <s:else>
		           头像未上传
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
