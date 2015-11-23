<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
<script type="text/javascript" src="../js/table/treeTable.js"></script>
	<script type="text/javascript">
    //ajax访问后台对自定义标签在系统标签中归类
    $(function(){
    var id=$("#id").val();
    //alert(id);
    $("#guilei").click(function(){
    var radioList = $("input[name='xuanzexiang']:checked");
    var xuanzexiang=radioList.val();
    // alert("归类开始");
     $.post(
     "xiTongLabelSave.action",
     {"id":id,"xuanzexiang":xuanzexiang},
     function(data){
       if(data.ok==false){
        top.Dialog.alert("操作失败：选择不正确或者选择的系统标签不存在！");
       }else{
         top.window.frmright.location.href=top.window.frmright.location.href;
        top.Dialog.close();
       }
     
      },
     "json"
     );
    });
    
    });
	</script>
</head>
<body leftFrame="true">
<div style="width: 100%; text-align: left;margin-top: 20px;margin-right: 20px;margin-bottom: 20px;">
  标签名称：<input id="biaoqianming" name="biaoqianming" type="text" value="${label.tagName }" disabled="disabled"/><input type="hidden" id="id" name="id" value="${label.id }"/>
</div>
<table class="treeTable">
	<tr>
		<th width="500">标签名称</th>
		<th width="200">标签封面</th>
		<th>照片数</th>
		<th>类型</th>
		<th width="500">选择</th>
	</tr>
	<s:iterator value="listYX" id="la">
	<tr id="node-${la.id }" class="child-of-node-${la.parentId }">
		<td><span class="file">${la.tagName}</span></td>
		<td style="text-align: center;">
		<s:if test="#la.photoPath==''||#la.photoPath==null">
		  无
		</s:if>
		<s:else>
		<img src="${la.photoPath }" alt="" width="30px;" height="30px;"/>
		</s:else>
		</td>
		<td style="text-align: center;">${la.photoNum }</td>
		<td>
		<s:if test="#la.typeT==1">
		地点标签
		</s:if>
		<s:elseif test="#la.typeT==2">
		可购标签
		</s:elseif>
		<s:elseif test="#la.typeT==3">
		额外标签
		</s:elseif>
		<s:else>
		普通标签
		</s:else>
		</td>
		<td style="text-align: center;">
		<s:if test="#la.grade>=3">
           <input name="xuanzexiang" value="${la.id }" type="radio" disabled="disabled"/>
        </s:if>
        <s:else><input name="xuanzexiang" value="${la.id }" type="radio"/></s:else>
        </td>
	</tr>
	</s:iterator>
	</table>
<div style="width: 100%; text-align: right;margin-top: 20px;margin-right: 20px;margin-bottom: 20px;">
  <input id="guilei" type="button" value="确定"/>
</div>
</body>

</html>