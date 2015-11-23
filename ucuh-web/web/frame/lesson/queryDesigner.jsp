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
        function quxiaoRZ(userId){
          top.Dialog.confirm("取消认证？",function(){
          $.post(
           "shenHeDesigner.action",
           {"userId":userId,"designerState":4},
           function(data){
            if(data.ok==1){
              top.window.frmright.location.href=top.window.frmright.location.href;
              top.Dialog.close();
            }
           },
           "json"
          );
          });
        }
        function tongguoRZ(userId){
          top.Dialog.confirm("确定通过？",function(){
           $.post(
           "shenHeDesigner.action",
           {"userId":userId,"designerState":3},
           function(data){
            if(data.ok==1){
              top.window.frmright.location.href=top.window.frmright.location.href;
              top.Dialog.close();
            }
           },
           "json"
          );
          });
        }
        
        function butongguoRZ(userId){
          top.Dialog.confirm("确定不用过？",function(){
           $.post(
           "shenHeDesigner.action",
           {"userId":userId,"designerState":2},
           function(data){
            if(data.ok==1){
              top.window.frmright.location.href=top.window.frmright.location.href;
              top.Dialog.close();
            }
           },
           "json"
          );
          });
        }
        </script>
<!--框架必需end-->
</head>
<body>
	<div class="box1" panelWidth="900px;">
	<fieldset> 
		<legend>设计师审核基本资料填写</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
			<tr>
				<td>认证类型</td>
				<td>认证状态</td>
				<td>公司/品牌名称</td>
				<td>职位/地址</td>
				<td>真实姓名</td>
				<td>联系电话</td>
				<td>工作邮箱</td>
			</tr>
			<tr>
				<td><input type="text" class="default" name="jbxx" style="width: 100px;" value="设计师" disabled="disabled"/></td>
				<td>
				<s:if test="designer.state==1">
				<input type="text" class="default" name="jbxx" style="width: 50px;" value="审核中" disabled="disabled"/>
				</s:if>
				<s:elseif test="designer.state==2">
				<input type="text" class="default" name="jbxx" style="width: 50px;" value="未通过" disabled="disabled"/>
				</s:elseif>
				<s:elseif test="designer.state==3">
				<input type="text" class="default" name="jbxx" style="width: 50px;" value="已通过" disabled="disabled"/>
				</s:elseif>
				<s:elseif test="designer.state==4">
				<input type="text" class="default" name="jbxx" style="width: 50px;" value="已取消" disabled="disabled"/>
				</s:elseif>
				<s:else>
				<input type="text" class="default" name="jbxx" style="width: 50px;" value="未申请" disabled="disabled"/>
				</s:else>
				</td>
				<td><input type="text" class="default" name="jbxx" style="width: 200px;" value="${designer.companyName} " disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 150px;" value="${designer.position}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 50px;" value="${designer.name}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 100px;" value="${designer.phone}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 200px;" value="${designer.email}" disabled="disabled"/></td>
			</tr>
			</table>
		</fieldset> 
		<fieldset> 
		<legend>设计师审核其它资料填写</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
			<tr>
			<s:iterator value="designer.wbs" id="wb">
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype" value="${wb.name }" disabled="disabled"/></td>
			</s:iterator>	
			</tr>
			<tr>
			<s:iterator value="designer.wbs" id="wb">
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue" value="${wb.value }" disabled="disabled"/>元/平方米</td>
			</s:iterator>	
			</tr>
			
			
		</table>
	</fieldset> 
	
	
	<div class="padding_top10">
		<table class="tableStyle" transMode="true" style="width: 100%;">
			<tr>
				<td colspan="4" style="text-align: center;">
					<input type="button" value="取消认证" onclick="quxiaoRZ('${designer.user.id}')"/><input type="button" value="通过" onclick="tongguoRZ('${designer.user.id}')"/><input type="button" value="不通过" onclick="butongguoRZ('${designer.user.id}')"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
</body>
</html>
