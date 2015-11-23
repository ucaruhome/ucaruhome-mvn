<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<!--<script type="text/javascript" src="../js/framework.js"></script>-->
<script type="text/javascript" src="../js/cityList.js"></script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css"/>
<link  rel="stylesheet" type="text/css" id="skin"/>
<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
        <script type="text/javascript">
        function shenhe(state,userId){
          //alert(state);
          //alert(userId);
          //ajax请求审核
          $.post(
           "shenHe.action",
           {"userId":userId,"headPhotoState":state},
           function(data){
             if(data.ok){
               //刷新父页面，关闭弹窗
               top.window.frmright.location.href=top.window.frmright.location.href;
               top.Dialog.close();
             }else{
               top.Dialog.alert("审核失败！");
             }
           }
          );
        }
        </script>
<!--框架必需end-->
</head>
<body>
	<div class="box1" panelWidth="900px;">
	<div style="height: 35px;width: 100%; text-align: right;">
    <input type="button" value="审核通过" onclick="shenhe('1','${user.id}')"/> <input type="button" value="审核不通过" onclick="shenhe('2','${user.id}')"/>
    </div>
	<fieldset> 
		<legend>用户基本信息</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
		    <tr>
			    <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td  rowspan="5" colspan="2" style="text-align: center;">
				<s:if test="#user.headPhoto==null||#user.headPhoto==''">
				<img id="headPhoto" src="../image/head.jpg" alt="" width="100px;" height="100px;" class="default"/>
				</s:if>
				<s:else>
				<img id="headPhoto" src="${headPhotoPath }" alt="" width="100px;" height="100px;" class="default"/>
				</s:else>
				</td>
			</tr>
			<tr>
				<td width="10%">用户名：</td><td width="40%"><span>${user.userName}</span></td>
				<td width="10%">性别：</td>
				<td>
				 <span>${user.sex}</span>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td width="10%">姓名：</td>
				<td><span>${user.name}</span></td>
				<td>个人站点：</td>
				<td><span>${user.webSite}</span></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><span>${user.birthday}</span></td>
				<td>昵称：</td>
				<td><span>${user.nickName}</span></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
			
		</table>
	</fieldset> 
	
	<fieldset> 
		<legend>用户详细信息</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
			<tr>
				<td width="10%">区域：</td>
				<td width="40%">
                  <span>${user.area }</span>
				</td>
				<td>角色：</td>
				<td>
					<span>${user.role.roleName}</span>
				</td>
				<td>组别：</td>
				<td>
				<span>${user.group.groupName}</span>				
				</td>
			</tr>
			<!--<tr>
				<td>组别：</td>
				<td>
				<select id="sel2" class="default">
					    
					 </select>				
				</td>
				<td>头像上传：</td>
				<td><input type="file"/></td>
			</tr>
		--></table>
	</fieldset> 
	
	<fieldset> 
		<legend>用户其他信息</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
			<tr>
				<td width="40%">微博帐号：</td><td width="40%"><span>${user.microblog}</span></td>
				<td width="40%">微信帐号：</td><td width="40%"><span>${user.wechat}</span></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td></td><td></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">个人简介：</td>
				<td colspan="3">
					<span class="float_left">
					<textarea id="personalProfile" name="personalProfile" style="width:700px;" disabled="disabled">${user.personalProfile}</textarea>
					</span>
				</td>
			</tr>
		</table>
	</fieldset>
	</div>
</body>
</html>
