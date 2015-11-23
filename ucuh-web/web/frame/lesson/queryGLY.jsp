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
          function designerRZ(userId){
          //alert(userId);
           //top.Dialog.open({URL:"lesson/designerRZ.jsp?userId="+userId,Title:"查看用户 ",Width:1000,Height:300});
           document.getElementById("xuanfu").style.cssText="position:absolute; z-index:2; width:100%; height:450px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;";
          }
          
          function designerBJ(userId){
           document.getElementById("xuanfu2").style.cssText="position:absolute; z-index:2; width:100%; height:450px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;";
          }
          function quxiao(userId){
          //alert(userId);
           //top.Dialog.open({URL:"lesson/designerRZ.jsp?userId="+userId,Title:"查看用户 ",Width:1000,Height:300});
           document.getElementById(""+userId).style.cssText="position:absolute; z-index:2; width:100%; height:450px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;display: none;";
          }
          //查看
          function designerCK(userId){
          document.getElementById("xuanfu1").style.cssText="position:absolute; z-index:2; width:100%; height:450px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;";
          }
         function tijiaoRZ(userId){
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
              //top.Dialog.alert("提交成功！");
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
}
         function tijiaoCXRZ(userId){
         var jbxxOk=true;
         var jbxxsStr="";
         var jbxxs=document.getElementsByName("jbxx2");
         for(var i=0;i<jbxxs.length;i++){
          if(trim(jbxxs[i].value)==""){
           jbxxOk=jbxxOk&&false;
          }
          jbxxsStr=jbxxsStr+""+trim(jbxxs[i].value)+","
         }
         
         var qtxxtypes=document.getElementsByName("qtxxtype2");
         var qtxxtypesStr="";
         for(var i=0;i<qtxxtypes.length;i++){
          if(trim(qtxxtypes[i].value)==""){
          qtxxtypesStr=qtxxtypesStr+""+"空"+",";
          }else{
          qtxxtypesStr=qtxxtypesStr+""+trim(qtxxtypes[i].value)+",";
          }
         }
         
         var qtxxvalues=document.getElementsByName("qtxxvalue2");
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
         //ajax提交设计师认证
         $.post(
          "lesson/designerRZ.action",
          {"userId":userId,"jbxxsStr":jbxxsStr,"qtxxtypesStr":qtxxtypesStr,"qtxxvaluesStr":qtxxvaluesStr},
          function(data){
            if(data.ok==1){
              //top.Dialog.alert("提交成功！");
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
         }
         
         
//================================供应商操作====================================================================================================================
         function supplierRZ(userId){
          //alert(userId);
           //top.Dialog.open({URL:"lesson/designerRZ.jsp?userId="+userId,Title:"查看用户 ",Width:1000,Height:300});
           document.getElementById("xuanfu_gongyingshang").style.cssText="position:absolute; z-index:2; width:100%; height:450px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;";
          }
         //查看
          function supplierCK(userId){
          document.getElementById("xuanfu1_gongyingshang").style.cssText="position:absolute; z-index:2; width:100%; height:450px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;";
          }
          
          function supplierBJ(userId){
           document.getElementById("xuanfu2_gongyingshang").style.cssText="position:absolute; z-index:2; width:100%; height:500px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;";
          }
          
         function tijiaoRZ_gongyingshang(userId){
         alert(userId);
         var jbxxOk=true;
         var jbxxsStr="";
         var jbxxs=document.getElementsByName("jbxx_gongyingshang");
         for(var i=0;i<jbxxs.length;i++){
          if(trim(jbxxs[i].value)==""){
           jbxxOk=jbxxOk&&false;
          }
          jbxxsStr=jbxxsStr+""+trim(jbxxs[i].value)+","
         }
         
         var qtxxtypes=document.getElementsByName("qtxxtype_gongyingshang");
         var qtxxtypesStr="";
         for(var i=0;i<qtxxtypes.length;i++){
          if(trim(qtxxtypes[i].value)==""){
          qtxxtypesStr=qtxxtypesStr+""+"空"+",";
          }else{
          qtxxtypesStr=qtxxtypesStr+""+trim(qtxxtypes[i].value)+",";
          }
         }
         
         var qtxxvalues=document.getElementsByName("qtxxvalue_gongyingshang");
         var qtxxvaluesStr="";
         for(var i=0;i<qtxxvalues.length;i++){
         if(trim(qtxxvalues[i].value)==""){
          qtxxvaluesStr=qtxxvaluesStr+""+"空"+",";
         }else{
          qtxxvaluesStr=qtxxvaluesStr+""+trim(qtxxvalues[i].value)+",";
          }
         }
         
         //得到当前活动类型的选中值
         var intHot=0;
         var temp = document.getElementsByName("activityType");  
         for(var i=0;i<temp.length;i++){     
         if(temp[i].checked){           
         intHot = temp[i].value;
         }  
         }
         //alert(jbxxsStr);
         //alert(qtxxtypesStr);
         //alert(qtxxvaluesStr);
         //alert(intHot);
         //alert(jbxxOk);
         if(!jbxxOk){
           top.Dialog.alert("基本信息不能为空！");
         }else{
         //ajax提交供应商认证
         $.post(
          "lesson/supplierRZ.action",
          {"userId":userId,"jbxxsStr":jbxxsStr,"qtxxtypesStr":qtxxtypesStr,"qtxxvaluesStr":qtxxvaluesStr,"activityType":intHot},
          function(data){
            if(data.ok==1){
              //top.Dialog.alert("提交成功！");
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
         }
     
     function tijiaoCXRZ_supplier(userId){
     var jbxxOk=true;
         var jbxxsStr="";
         var jbxxs=document.getElementsByName("jbxx2_gongyingshang");
         for(var i=0;i<jbxxs.length;i++){
          if(trim(jbxxs[i].value)==""){
           jbxxOk=jbxxOk&&false;
          }
          jbxxsStr=jbxxsStr+""+trim(jbxxs[i].value)+","
         }
         
         var qtxxtypes=document.getElementsByName("qtxxtype2_gongyingshang");
         var qtxxtypesStr="";
         for(var i=0;i<qtxxtypes.length;i++){
          if(trim(qtxxtypes[i].value)==""){
          qtxxtypesStr=qtxxtypesStr+""+"空"+",";
          }else{
          qtxxtypesStr=qtxxtypesStr+""+trim(qtxxtypes[i].value)+",";
          }
         }
         
         var qtxxvalues=document.getElementsByName("qtxxvalue2_gongyingshang");
         var qtxxvaluesStr="";
         for(var i=0;i<qtxxvalues.length;i++){
         if(trim(qtxxvalues[i].value)==""){
          qtxxvaluesStr=qtxxvaluesStr+""+"空"+",";
         }else{
          qtxxvaluesStr=qtxxvaluesStr+""+trim(qtxxvalues[i].value)+",";
          }
         }
         
         //得到当前活动类型的选中值
         var intHot=0;
         var temp = document.getElementsByName("activityType1_gongyingshang");  
         for(var i=0;i<temp.length;i++){     
         if(temp[i].checked){           
         intHot = temp[i].value;
         }  
         }
         if(!jbxxOk){
           top.Dialog.alert("基本信息不能为空！");
         }else{
         //ajax提交设计师认证
         $.post(
          "lesson/supplierRZ.action",
          {"userId":userId,"jbxxsStr":jbxxsStr,"qtxxtypesStr":qtxxtypesStr,"qtxxvaluesStr":qtxxvaluesStr,"activityType":intHot},
          function(data){
            if(data.ok==1){
              //top.Dialog.alert("提交成功！");
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
     }    
//===========================工具类============         
         function trim(str){
         
         return str.replace(/^(\s|\u00A0)+/,'').replace(/(\s|\u00A0)+$/,'');
         }
        </script>
<!--框架必需end-->
</head>
<body>
	<div class="box1" panelWidth="800">
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
				<img id="headPhoto" src="${user.headPhoto }" alt="" width="100px;" height="100px;" class="default"/>
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
				<td width="80%">微博帐号：</td><td width="40%"><span>${user.microblog}</span></td>
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
			<s:if test="user.role.roleName=='普通用户'">
			<tr>
				<td colspan="2">设计师认证：
                <s:if test="user.designer==1">
                                            提交审核
                </s:if>
                <s:elseif test="user.designer==2">
                                           审核未通过
                </s:elseif>
                <s:elseif test="user.designer==3">
                                            审核已通过
                </s:elseif>
                <s:elseif test="user.designer==4">
                                           已取消认证
                </s:elseif>
                <s:else>
                                            未认证
                </s:else>
                </td>
				<td colspan="2">
				<s:if test="user.designer==1">
				<input type="button" value="查看" onclick="designerCK('${user.id}')"/>
				</s:if>
				<s:elseif test="user.designer==4||user.designer==2||user.designer==3">
				<input type="button" value="编辑" onclick="designerBJ('${user.id}')"/>
				</s:elseif>
				<s:else>
				<input type="button" value="设计师认证" onclick="designerRZ('${user.id}')"/>
				</s:else>
				</td>
				</tr>
				<tr>
				<td colspan="2">供应商认证：
                <s:if test="user.supplier==1">
                                            提交审核
                </s:if>
                <s:elseif test="user.supplier==2">
                                           审核未通过
                </s:elseif>
                <s:elseif test="user.supplier==3">
                                            审核已通过
                </s:elseif>
                <s:elseif test="user.supplier==4">
                                           已取消认证
                </s:elseif>
                <s:else>
                                            未认证
                </s:else>
                </td>
				<td colspan="2">
				<s:if test="user.supplier==1">
				<input type="button" value="查看" onclick="supplierCK('${user.id}')"/>
				</s:if>
				<s:elseif test="user.supplier==4||user.supplier==2||user.supplier==3">
				<input type="button" value="编辑" onclick="supplierBJ('${user.id}')"/>
				</s:elseif>
				<s:else>
				<input type="button" value="供应商认证" onclick="supplierRZ('${user.id}')"/>
				</s:else>
				</td>
			</tr>
			<!--<tr>
				<td colspan="2">经销商认证：
                <s:if test="user.distributor==1">
                                            提交审核
                </s:if>
                <s:elseif test="user.distributor==2">
                                           审核未通过
                </s:elseif>
                <s:elseif test="user.distributor==3">
                                            审核已通过
                </s:elseif>
                <s:elseif test="user.distributor==4">
                                           已取消认证
                </s:elseif>
                <s:else>
                                            未认证
                </s:else>
                </td>
				<td colspan="2">
				<s:if test="user.distributor==1">
				<input type="button" value="查看"/>
				</s:if>
				<s:elseif test="user.distributor==4||user.distributor==2||user.distributor==3">
				<input type="button" value="编辑"/>
				</s:elseif>
				<s:else>
				<input type="button" value="经销商认证"/>
				</s:else>
				</td>
			</tr>-->
			</s:if>  
		</table>
	</fieldset>
	</div>
	<!-- ===================设计师新增============== -->
	<div id="xuanfu"  style='position:absolute; z-index:2; width:100%; height:300px; left:0px; top:0px; display: none; overflow: auto;border:1px solid #ddd;background-color:#fff;'>
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
					<input type="button" value=" 提交认证 " onclick="tijiaoRZ('${user.id}')"/><input type="button" value="取消" onclick="quxiao('xuanfu')"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
	
	
	
	
	
	<!-- =====================设计师查看===================================================================== -->
	<div id="xuanfu1"  style='position:absolute; z-index:2; width:100%; height:300px; left:0px; top:0px; display: none; overflow: auto;border:1px solid #ddd;background-color:#fff;'>
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
				<td><input type="text" class="default" name="jbxx1" style="width: 100px;" value="设计师" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1" style="width: 50px;" value="审核中" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1" style="width: 200px;" value="${designer.companyName} " disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1" style="width: 150px;" value="${designer.position}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1" style="width: 50px;" value="${designer.name}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1" style="width: 100px;" value="${designer.phone}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1" style="width: 200px;" value="${designer.email}" disabled="disabled"/></td>
			</tr>
			</table>
		</fieldset> 
		<fieldset> 
		<legend>设计师审核其它资料填写</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
			<tr>
			<s:iterator value="designer.wbs" id="wb">
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype1" value="${wb.name }" disabled="disabled"/></td>
			</s:iterator>	
			</tr>
			<tr>
			<s:iterator value="designer.wbs" id="wb">
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue1" value="${wb.value }" disabled="disabled"/>元/平方米</td>
			</s:iterator>	
			</tr>
			
			
		</table>
	</fieldset> 
	
	
	<div class="padding_top10">
		<table class="tableStyle" transMode="true" style="width: 100%;">
			<tr>
				<td colspan="4" style="text-align: center;">
					<input type="button" value="取消" onclick="quxiao('xuanfu1')"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
	
	<!-- ===================设计师更新============== -->
	<div id="xuanfu2"  style='position:absolute; z-index:2; width:100%; height:450px; left:0px; top:0px; display: none; overflow: auto;border:1px solid #ddd;background-color:#fff;'>
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
				<td><input type="text" class="default" name="jbxx2" style="width: 100px;" value="设计师" disabled="disabled"/></td>
				<td>
				<s:if test="user.designer==1">
                                            提交审核<input type="hidden" class="default" name="jbxx2" style="width: 100px;" value="1"/>
                </s:if>
                <s:elseif test="user.designer==2">
                                           审核未通过<input type="hidden" class="default" name="jbxx2" style="width: 100px;" value="2"/>
                </s:elseif>
                <s:elseif test="user.designer==3">
                                            审核已通过<input type="hidden" class="default" name="jbxx2" style="width: 100px;" value="3"/>
                </s:elseif>
                <s:elseif test="user.designer==4">
                                           已取消认证<input type="hidden" class="default" name="jbxx2" style="width: 100px;" value="4"/>
                </s:elseif>
                <s:else>
                                            未认证<input type="hidden" class="default" name="jbxx2" style="width: 100px;" value="0"/>
                </s:else>
				</td>
				<td><input type="text" class="default" name="jbxx2" style="width: 200px;" value="${designer.companyName} "/></td>
				<td><input type="text" class="default" name="jbxx2" style="width: 150px;" value="${designer.position}"/></td>
				<td><input type="text" class="default" name="jbxx2" style="width: 50px;" value="${designer.name}"/></td>
				<td><input type="text" class="default" name="jbxx2" style="width: 100px;" value="${designer.phone}"/></td>
				<td><input type="text" class="default" name="jbxx2" style="width: 200px;" value="${designer.email}"/></td>
			</tr>
			</table>
		</fieldset> 
		<fieldset> 
		<legend>设计师审核其它资料填写</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
		<s:iterator value="designer.wbs" id="wb">
			<tr>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype2" value="${wb.name }" /></td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue2" value="${wb.value }" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>元/平方米</td>
			</tr>
		</s:iterator>
		</table>
	</fieldset> 
	
	
	<div class="padding_top10">
		<table class="tableStyle" transMode="true" style="width: 100%;">
			<tr>
				<td colspan="4" style="text-align: center;">
					<input type="button" value=" 提交重新认证  " onclick="tijiaoCXRZ('${user.id}')"/><input type="button" value="取消" onclick="quxiao('xuanfu2')"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
	<!-- =====================供应商新增============================================================================================================ -->
	
	<div id="xuanfu_gongyingshang"  style='position:absolute; z-index:2; width:100%; height:300px; left:0px; top:0px; display: none; overflow: auto;border:1px solid #ddd;background-color:#fff;'>
	<fieldset> 
		<legend>供应商审核基本资料填写</legend> 
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
				<td><input type="text" class="default" name="jbxx_gongyingshang" style="width: 100px;" value="供应商" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx_gongyingshang" style="width: 50px;" value="待认证" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx_gongyingshang" style="width: 200px;" value="宁波有车有房网络科技有限公司" onfocus="if(this.value == '宁波有车有房网络科技有限公司') this.value = ''" onblur="if(this.value =='') this.value = '宁波有车有房网络科技有限公司'"/></td>
				<td><input type="text" class="default" name="jbxx_gongyingshang" style="width: 150px;" value="室内设计部主管" onfocus="if(this.value == '室内设计部主管') this.value = ''" onblur="if(this.value =='') this.value = '室内设计部主管'"/></td>
				<td><input type="text" class="default" name="jbxx_gongyingshang" style="width: 50px;" value="曹传奎" onfocus="if(this.value == '曹传奎') this.value = ''" onblur="if(this.value =='') this.value = '曹传奎'"/></td>
				<td><input type="text" class="default" name="jbxx_gongyingshang" style="width: 100px;" value="15924300533" onfocus="if(this.value == '15924300533') this.value = ''" onblur="if(this.value =='') this.value = '15924300533'"/></td>
				<td><input type="text" class="default" name="jbxx_gongyingshang" style="width: 200px;" value="caochuankui2008@qq.com" onfocus="if(this.value == 'caochuankui2008@qq.com') this.value = ''" onblur="if(this.value =='') this.value = 'caochuankui2008@qq.com'"/></td>
			</tr>
			</table>
		</fieldset> 
		<fieldset> 
		<legend>供应商审核其它资料填写</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
			<tr>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype_gongyingshang" value="全场折上折" onfocus="if(this.value == '全场折上折') this.value = ''" onblur="if(this.value =='') this.value = '全场折上折'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype_gongyingshang" value="1000~5000元" onfocus="if(this.value == '1000~5000元') this.value = ''" onblur="if(this.value =='') this.value = '1000~5000元'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype_gongyingshang" value="5001~10000元" onfocus="if(this.value == '5001~10000元') this.value = ''" onblur="if(this.value =='') this.value = '5001~10000元'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype_gongyingshang" value="10001~50000元" onfocus="if(this.value == '10001~50000元') this.value = ''" onblur="if(this.value =='') this.value = '10001~50000元'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype_gongyingshang" value="50001~100000元" onfocus="if(this.value == '50001~100000元') this.value = ''" onblur="if(this.value =='') this.value = '50001~100000元'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype_gongyingshang" value="100000以上" onfocus="if(this.value == '100000以上') this.value = ''" onblur="if(this.value =='') this.value = '100000以上'"/></td>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype_gongyingshang" value="其它" onfocus="if(this.value == '其它') this.value = ''" onblur="if(this.value =='') this.value = '其它'"/></td>
			</tr>
			<tr>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue_gongyingshang" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>折</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue_gongyingshang" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>折</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue_gongyingshang" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>折</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue_gongyingshang" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>折</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue_gongyingshang" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>折</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue_gongyingshang" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>折</td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue_gongyingshang" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>折</td>
			</tr>
			<tr><td colspan="3">是否与店内活动共享：</td><td colspan="4"><input type="radio" name="activityType" value="0" checked="checked"/>否 &nbsp;<input type="radio" name="activityType" value="1"/>是 </td></tr>
			
		</table>
	</fieldset> 
	
	
	<div class="padding_top10">
		<table class="tableStyle" transMode="true" style="width: 100%;">
			<tr>
				<td colspan="4" style="text-align: center;">
					<input type="button" value=" 提交认证 " onclick="tijiaoRZ_gongyingshang('${user.id}')"/><input type="button" value="取消" onclick="quxiao('xuanfu_gongyingshang')"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
	<!-- =====================供应商查看===================================================================== -->
	<div id="xuanfu1_gongyingshang"  style='position:absolute; z-index:2; width:100%; height:300px; left:0px; top:0px; display: none; overflow: auto;border:1px solid #ddd;background-color:#fff;'>
	<fieldset> 
		<legend>供应商审核基本资料填写</legend> 
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
				<td><input type="text" class="default" name="jbxx1_gongyingshang" style="width: 100px;" value="供应商" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1_gongyingshang" style="width: 50px;" value="审核中" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1_gongyingshang" style="width: 200px;" value="${supplier.companyName} " disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1_gongyingshang" style="width: 150px;" value="${supplier.position}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1_gongyingshang" style="width: 50px;" value="${supplier.name}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1_gongyingshang" style="width: 100px;" value="${supplier.phone}" disabled="disabled"/></td>
				<td><input type="text" class="default" name="jbxx1_gongyingshang" style="width: 200px;" value="${supplier.email}" disabled="disabled"/></td>
			</tr>
			</table>
		</fieldset> 
		<fieldset> 
		<legend>供应商审核其它资料填写</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
			<tr>
			<s:iterator value="supplier.wbs" id="wb">
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype1_gongyingshang" value="${wb.name }" disabled="disabled"/></td>
			</s:iterator>	
			</tr>
			<tr>
			<s:iterator value="supplier.wbs" id="wb">
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue1_gongyingshang" value="${wb.value }" disabled="disabled"/>折</td>
			</s:iterator>	
			</tr>
			<tr><td colspan="3">是否与店内活动共享：</td>
			
			<td colspan="4">
			<s:if test="supplier.type==0">
			<input type="radio" name="activityType_gongyingshang" value="0" checked="checked" disabled="disabled"/>否 &nbsp;<input type="radio" name="activityType_gongyingshang" value="1" disabled="disabled"/>是 
			</s:if>
			<s:else>
			<input type="radio" name="activityType_gongyingshang" value="0" disabled="disabled"/>否 &nbsp;<input type="radio" name="activityType_gongyingshang" value="1" checked="checked" disabled="disabled"/>是 
			</s:else>
			</td>
			
			</tr>
			
		</table>
	</fieldset> 
	
	
	<div class="padding_top10">
		<table class="tableStyle" transMode="true" style="width: 100%;">
			<tr>
				<td colspan="4" style="text-align: center;">
					<input type="button" value="取消" onclick="quxiao('xuanfu1_gongyingshang')"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
	
	<!-- ===================供应商更新============== -->
	<div id="xuanfu2_gongyingshang"  style='position:absolute; z-index:2; width:100%; height:450px; left:0px; top:0px; display: none; overflow: auto;border:1px solid #ddd;background-color:#fff;'>
	<fieldset> 
		<legend>供应商审核基本资料填写</legend> 
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
				<td><input type="text" class="default" name="jbxx2_gongyingshang" style="width: 100px;" value="供应商" disabled="disabled"/></td>
				<td>
				<s:if test="user.supplier==1">
                                            提交审核<input type="hidden" class="default" name="jbxx2_gongyingshang" style="width: 100px;" value="1"/>
                </s:if>
                <s:elseif test="user.supplier==2">
                                           审核未通过<input type="hidden" class="default" name="jbxx2_gongyingshang" style="width: 100px;" value="2"/>
                </s:elseif>
                <s:elseif test="user.supplier==3">
                                            审核已通过<input type="hidden" class="default" name="jbxx2_gongyingshang" style="width: 100px;" value="3"/>
                </s:elseif>
                <s:elseif test="user.supplier==4">
                                           已取消认证<input type="hidden" class="default" name="jbxx2_gongyingshang" style="width: 100px;" value="4"/>
                </s:elseif>
                <s:else>
                                            未认证<input type="hidden" class="default" name="jbxx2_gongyingshang" style="width: 100px;" value="0"/>
                </s:else>
				</td>
				<td><input type="text" class="default" name="jbxx2_gongyingshang" style="width: 200px;" value="${supplier.companyName} "/></td>
				<td><input type="text" class="default" name="jbxx2_gongyingshang" style="width: 150px;" value="${supplier.position}"/></td>
				<td><input type="text" class="default" name="jbxx2_gongyingshang" style="width: 50px;" value="${supplier.name}"/></td>
				<td><input type="text" class="default" name="jbxx2_gongyingshang" style="width: 100px;" value="${supplier.phone}"/></td>
				<td><input type="text" class="default" name="jbxx2_gongyingshang" style="width: 200px;" value="${supplier.email}"/></td>
			</tr>
			</table>
		</fieldset> 
		<fieldset> 
		<legend>供应商审核其它资料填写</legend> 
		<table class="tableStyle" transMode="true" footer="normal">
		<s:iterator value="supplier.wbs" id="wb">
			<tr>
				<td><input type="text" class="default" style="width: 100px;" name="qtxxtype2_gongyingshang" value="${wb.name }" /></td>
				<td><input type="text" class="default" style="width: 50px;" name="qtxxvalue2_gongyingshang" value="${wb.value }" onKeyUp="this.value=this.value.replace(/[^\.\d]/g,'');if(this.value.split('.').length>2){this.value=this.value.split('.')[0]+'.'+this.value.split('.')[1]}"/>折</td>
			</tr>
		</s:iterator>
		<tr><td colspan="3">是否与店内活动共享：</td>
			
			<td colspan="4">
			<s:if test="supplier.type==0">
			<input type="radio" name="activityType1_gongyingshang" value="0" checked="checked" />否 &nbsp;<input type="radio" name="activityType1_gongyingshang" value="1" />是 
			</s:if>
			<s:else>
			<input type="radio" name="activityType1_gongyingshang" value="0" />否 &nbsp;<input type="radio" name="activityType1_gongyingshang" value="1" checked="checked" />是 
			</s:else>
			</td>
			
		</tr>
		</table>
	</fieldset> 
	
	
	<div class="padding_top10">
		<table class="tableStyle" transMode="true" style="width: 100%;">
			<tr>
				<td colspan="4" style="text-align: center;">
					<input type="button" value=" 提交重新认证  " onclick="tijiaoCXRZ_supplier('${user.id}')"/><input type="button" value="取消" onclick="quxiao('xuanfu2_gongyingshang')"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
</body>
</html>
