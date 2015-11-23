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
	//从数据库读取所有的管理员帐号
	function chakan(newsId){
	   //alert(newsId);
	   top.Dialog.open({URL:"<%=basePath%>findOneNews.action?newsId="+newsId,Title:"查看消息 ",Width:1500,Height:800});
	}
	
	function shanchu(newsId){
	top.Dialog.confirm("确定要删除吗？",function(){
	   $.post(
	     "delOneNews.action",
	     {"newsId":newsId},
	     function(data){
	       if(data.okey==1){
	         window.location.href=window.location.href;
	         top.Dialog.alert("删除成功");
	       }else if(data.okey==0){
	         top.Dialog.alert("删除失败");
	       }else{
	         top.Dialog.alert("系统异常");
	       }
	     },
	     "json"
	   );
	   //alert(userId);
	   });
	}
	
	function prePage(nowPage){
	top.window.frmright.location="newsList.action?nowPage="+nowPage;
	}
	
	function nextPage(nowPage){
	top.window.frmright.location="newsList.action?nowPage="+nowPage;
	}
</script>
</head>
<body>
<div id="scrollContent">
	<table class="tableStyle">
		<tr>
			<th width="3%">编号</th>
			<th width="10%">标题</th>
			<th width="3%">类型</th>
			<th width="10%">是否弹窗</th>
			<th>WAP链接</th>
			<th width="10%">发布时间</th>
			<th width="10%">操作</th>
		</tr>
		<s:iterator value="list" id="news1">
		<tr>
			<td>${news1.id }</td>
			<td>${news1.theme }</td>
			<td>${news1.type==0?"通知":"活动" }</td>
			<td>
				${news1.tanchuangYesOrNo==0?"-":"是" }
			</td>
			<td><a href="${news1.waplink}">${news1.waplink}</a></td>
			<td>
				${news1.time }
			</td>
			<td><span class="img_view hand" title="修改" onclick="chakan('${news1.id}')"></span><span class="img_delete hand" title="删除" onclick="shanchu('${news1.id}')"></span></td>
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
