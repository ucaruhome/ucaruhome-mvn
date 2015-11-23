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
	function shanchu(id){
	  top.Dialog.confirm("确定要删除吗？",function(){
	  //ajax删除一条评论信息
	  $.post(
	   "delComment.action",
	   {"commentId":id},
	   function(data){
	     if(data.ok==1){
	      window.location.href=window.location.href;
	      top.Dialog.alert("删除成功");
	     }else if(data.ok==2){
	      top.Dialog.alert("系统异常！");
	     }else{
	      top.Dialog.alert("删除失败！");
	     }
	   },
	   "json"
	  );
	  });
	}
	
	function piliangShanchu(){
	  //alert("批量删除！");
	  var idss=document.getElementsByName("ids");
	  
	  var idsString="";
	  for(var i=0;i<idss.length;i++){
	  if(idss[i].checked==true){
	     //alert(idss[i].value);
	     idsString=idsString+idss[i].value+",";
	  }
	  }
	  //alert(idsString);
	  if(""==idsString){
	   top.Dialog.alert("请选择删除项！");
	  }else{
	  
	    top.Dialog.confirm("确定要删除吗？",function(){
	     //ajax批量删除
	       $.post(
	         "delManyComment.action",
	         {"ids":idsString},
	         function(data){
	           if(data.ok==1){
	             window.location.href=window.location.href;
	             top.Dialog.alert("删除成功");
	           }else if(data.ok==2){
	             top.Dialog.alert("系统异常！");
	           }else{
	             top.Dialog.alert("删除失败！");
	           }
	         },
	         "json"
	       );
	  });
	  }
	}
	
	function fanye(page){
	top.window.frmright.location="commentslist.action?nowPage="+page;
	}
</script>
</head>
<body>
<div>
	<table class="tableStyle" sortMode="true" headFixMode="true" useMultColor="true" useCheckBox="true">
		<tr>
			<th width="25"></th>
			<th width="80">照片缩略图</th>
			<th width="80">所属信息流ID</th>
			<th width="80">发布者ID</th>
			<th width="100">发布者昵称</th>
			<th>发布时间</th>
			<th width="140">操作</th>
		</tr>
	</table>
</div>
<div id="scrollContent" >
	<table class="tableStyle"  useMultColor="true" useCheckBox="true">
	<s:iterator value="list" id="photo">
		<tr>
			<td width="25"><input type="checkbox" name="ids" value="${photo.id }"/></td>
			<td width="80"><img src="${photo.hchhPhoto.photoPath }" width="30px;" height="30px;" /></td>
			<td width="80">${photo.hchhPhoto.informationflow.id }</td>
			<td width="80">
				${photo.hchhPhoto.informationflow.user.id }
			</td>
			<td width="100">${photo.hchhPhoto.informationflow.user.nickName }</td>
			<td>
				${photo.time}
			</td>
			<td width="140"><span class="img_delete hand" title="删除" onclick="shanchu('${photo.id }')"></span><input type="button" value="查看详情" class="default"/></td>
		</tr>
	</s:iterator>	
	</table>
</div>

<div style="height:35px;">
	<div class="float_left padding5">
		<input type="button" value="批量删除" onclick="piliangShanchu()"/>
	</div>
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
