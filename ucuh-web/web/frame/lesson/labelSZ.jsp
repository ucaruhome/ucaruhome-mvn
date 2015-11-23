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
	<script type="text/javascript">
   
	</script>
</head>
<body leftFrame="true">
<div style="width: 100%;height: 100px; text-align: center;">
<span>封面预览</span><br />
<s:if test="label.photoPath==null||label.photoPath==''">
<img src="${urlT }/frame/image/head.jpg" alt="" style="width:80px;height: 80px;"/>
</s:if>
<s:else>
<img src="${label.photoPath}" alt="" style="width:80px;height: 80px;"/>
</s:else>

</div>
<form action="updateLabel.action" method="post" enctype="multipart/form-data">
   <table>
   <tr>
         <td><span>标签名称</span></td><td><input type="hidden" name="id" value="${label.id}"/><input name="tagName" type="text" style="width:300px;" value="${label.tagName }"/></td>
   </tr>
   <tr>
         <td><span>标签类型</span></td>
         <td>
         <select name="typeT">
          <s:if test="label.typeT==1">
          <option value="0">普通标签</option>
          <option value="1" selected="selected">地点标签</option>
          <option value="2">可购标签</option>
          <option value="3">额外标签</option>
          </s:if>
          <s:elseif test="label.typeT==2">
          <option value="0">普通标签</option>
          <option value="1">地点标签</option>
          <option value="2" selected="selected">可购标签</option>
          <option value="3">额外标签</option>
          </s:elseif>
          <s:elseif test="label.typeT==3">
          <option value="0">普通标签</option>
          <option value="1">地点标签</option>
          <option value="2">可购标签</option>
          <option value="3" selected="selected">额外标签</option>
          </s:elseif>
          <s:else>
          <option value="0" selected="selected">普通标签</option>
          <option value="1">地点标签</option>
          <option value="2">可购标签</option>
          <option value="3">额外标签</option>
          </s:else>
         </select>
         </td>
   </tr>
   <tr>
         <td><span>上传封面</span></td><td><input name="file" type="file" style="width:300px;" /></td>
   </tr>
   <tr>
         <td colspan="2" style="text-align: center;"> <input type="submit" value="提交"/></td>
   </tr>
   </table>
</form>
</body>

</html>