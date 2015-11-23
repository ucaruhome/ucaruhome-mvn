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
<link href="../css/import_basic.css" rel="stylesheet" type="text/css"/>
<link  rel="stylesheet" type="text/css" id="skin"/>
<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
        <script type="text/javascript">
        <%   String userId = request.getParameter("userId");%>
         var userId=<%=userId%>
         //alert(userId);
         //获取页面的数据信息
function tijiaoRZ(){
         var jbxxOk=true;
         var jbxxsStr="";
         var jbxxs=document.getElementsByName("jbxx");
         for(var i=0;i<jbxxs.length;i++){
          if(trim(jbxxs[i].value)==""){
           jbxxOk=jbxxOk&&false;
          }
          jbxxsStr=jbxxsStr+""+trim(jbxxs[i].value)+","
         }
         
         var qtxxtypes=document.getElementsByName("qtxxtype");
         var qtxxtypesStr="";
         for(var i=0;i<qtxxtypes.length;i++){
          if(trim(qtxxtypes[i].value)==""){
          qtxxtypesStr=qtxxtypesStr+""+"空"+",";
          }else{
          qtxxtypesStr=qtxxtypesStr+""+trim(qtxxtypes[i].value)+",";
          }
         }
         
         var qtxxvalues=document.getElementsByName("qtxxvalue");
         var qtxxvaluesStr="";
         for(var i=0;i<qtxxvalues.length;i++){
         if(trim(qtxxvalues[i].value)==""){
          qtxxvaluesStr=qtxxvaluesStr+""+"空"+",";
         }else{
          qtxxvaluesStr=qtxxvaluesStr+""+trim(qtxxvalues[i].value)+",";
          }
         }
         if(!jbxxOk){
           top.Dialog.alert("基本信息不能为空！");
         }else{
         //alert(jbxxsStr);
         //alert(qtxxtypesStr);
         //alert(qtxxvaluesStr);
         //ajax提交设计师认证
         $.post(
          "lesson/designerRZ.action",
          {"userId":userId,"jbxxsStr":jbxxsStr,"qtxxtypesStr":qtxxtypesStr,"qtxxvaluesStr":qtxxvaluesStr},
          function(data){
            if(data.ok==1){
              top.Dialog.alert("提交成功！");
              //window.parent.location.reload();
              //top.Dialog.parent.window.location.reload()
	          top.Dialog.close();
            }else if(data.ok==2){
              top.Dialog.alert("系统异常！");
            }else{
              top.Dialog.alert("提交失败！");
            }
          },
          "json"
         );
         }
};
         
         function trim(str){
         
         return str.replace(/^(\s|\u00A0)+/,'').replace(/(\s|\u00A0)+$/,'');
         }
        </script>
<!--框架必需end-->
</head>
<body>
	<div class="box1" panelWidth="800">
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
				<td><input type="text" class="default" name="jbxx" style="width: 50px;" value="待认证" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 200px;" value="宁波有车有房网络科技有限公司" onfocus="if(this.value == '宁波有车有房网络科技有限公司') this.value = ''" onblur="if(this.value =='') this.value = '宁波有车有房网络科技有限公司'"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 150px;" value="室内设计部主管" onfocus="if(this.value == '室内设计部主管') this.value = ''" onblur="if(this.value =='') this.value = '室内设计部主管'"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 50px;" value="曹传奎" onfocus="if(this.value == '曹传奎') this.value = ''" onblur="if(this.value =='') this.value = '曹传奎'"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 100px;" value="15924300533" onfocus="if(this.value == '15924300533') this.value = ''" onblur="if(this.value =='') this.value = '15924300533'"/></td>
				<td><input type="text" class="default" name="jbxx" style="width: 200px;" value="caochuankui2008@qq.com" onfocus="if(this.value == 'caochuankui2008@qq.com') this.value = ''" onblur="if(this.value =='') this.value = 'caochuankui2008@qq.com'"/></td>
			</tr>
			</table>
		</fieldset> 
		<fieldset> 
		<legend>设计师审核其它资料填写</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
			<tr>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype" value="小户型" onfocus="if(this.value == '小户型') this.value = ''" onblur="if(this.value =='') this.value = '小户型'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype" value="普通户型" onfocus="if(this.value == '普通户型') this.value = ''" onblur="if(this.value =='') this.value = '普通户型'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype" value="大户型" onfocus="if(this.value == '大户型') this.value = ''" onblur="if(this.value =='') this.value = '大户型'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype" value="别墅" onfocus="if(this.value == '别墅') this.value = ''" onblur="if(this.value =='') this.value = '别墅'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype" value="办公楼" onfocus="if(this.value == '办公楼') this.value = ''" onblur="if(this.value =='') this.value = '办公楼'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype" value="商铺" onfocus="if(this.value == '商铺') this.value = ''" onblur="if(this.value =='') this.value = '商铺'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype" value="其它" onfocus="if(this.value == '其它') this.value = ''" onblur="if(this.value =='') this.value = '其它'"/></td>
			</tr>
			<tr>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>元/平方米</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>元/平方米</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>元/平方米</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>元/平方米</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>元/平方米</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>元/平方米</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>元/平方米</td>
			</tr>
			
			
		</table>
	</fieldset> 
	
	
	<div class="padding_top10">
		<table class="tableStyle" transMode="true" style="width: 100%;">
			<tr>
				<td colspan="4" style="text-align: center;">
					<input type="button" value=" 提交认证 " onclick="tijiaoRZ()"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
</body>
</html>
