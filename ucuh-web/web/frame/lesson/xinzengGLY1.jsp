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
<!--<script type="text/javascript" src="../js/jquery-1.4.js"></script>-->
<script type="text/javascript" src="../js/jquery-1.6.4.min.js"></script>
<!--<script type="text/javascript" src="../js/framework.js"></script>-->
<script type="text/javascript" src="../js/cityList.js"></script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css"/>
<link  rel="stylesheet" type="text/css" id="skin"/>
<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
        <script type="text/javascript">
        var userId="";
        function ajaxFileUpload(){
        
        $("#loading").ajaxStart(function(){
            $(this).show();
        })//开始上传文件时显示一个图片
        .ajaxComplete(function(){
            $(this).hide();
        });//文件上传完成将图片隐藏起来
        
        $.ajaxFileUpload
        (
            {
                url:'fileUploadAction.action?userId='+userId,//用于文件上传的服务器端请求地址
                secureuri:false,//一般设置为false
                fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
                //data:{"hpId":"10"},
                dataType: 'json',//返回值类型 一般设置为json
                //data:{"userName":userName,"sex":sex,"name":name,"webSite":webSite,"birthday":birthday,"nickName":nickName,"area":area,"roleId":roleId,"groupId":groupId,"microblog":microblog,"wechat":wechat,"personalProfile":personalProfile},
                success: function (data, status)  //服务器成功响应处理函数
                {
                    alert(data.message);//从服务器返回的json中取出message中的数据,其中message为在struts2中action中定义的成员变量
                    if(data.hpId!=""){
                     //alert(data.hpId);
                     $("#headPhotoId").val(data.hpId);
                     //alert($("#headPhotoId").val());
                    }
                    if(data.url!=""){
                    //alert(data.url);
                    var bigimg = document.getElementById("headPhoto"); 
        			bigimg.src=data.url;
                    }
                    if(typeof(data.error) != 'undefined')
                    {
                        if(data.error != '')
                        {
                            alert(data.error);
                        }else
                        {
                            alert(data.message);
                            top.window.frmright.location.href=top.window.frmright.location.href;
                            top.Dialog.close();
                        }
                    }
                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
                    alert(e);
                }
            }
        );
        
        return false;
        

    }
        
        //新增一条用户信息
        function addAdminUser(){
          var headPhotoId=$("#headPhotoId").val();
          var userName=$("#userName").val();
          var sex="";
          var chkObjs = document.getElementsByName("sex");
                for(var i=0;i<chkObjs.length;i++){
                    if(chkObjs[i].checked){
                        sex = chkObjs[i].value+"";
                        break;
                    }
                }
          var name=$("#name").val();
          var webSite=$("#webSite").val();
          var birthday=$("#birthday").val();
          var nickName=$("#nickName").val();
          var area=$("#area").val();
          var roleId=$("#sel").val();
          var groupId=$("#sel2").val();
          var microblog=$("#microblog").val();
          var wechat=$("#wechat").val();
          var personalProfile=$("#personalProfile").val();
          //alert(headPhotoId);
          //alert(userName);
          //alert(sex);
          //alert(name);
          //alert(webSite);
          //alert(birthday);
          //alert(nickName);
          //alert(area);
          //alert(roleId);
          //alert(groupId);
          //alert(microblog);
          //alert(wechat);
          //alert(personalProfile);
          //发送ajax请求
          var userName1=$.trim(userName);
          var name1=$.trim(name);
          var birthday1=$.trim(birthday);
          var microblog1=$.trim(microblog);
          var wechat1=$.trim(wechat);
          var personalProfile1=$.trim(personalProfile);
          if(userName1==""||name1==""||birthday1==""||microblog1==""||wechat1==""||personalProfile1==""){
             top.Dialog.alert("必填项不能为空！");
          //}else if(headPhotoId==""){
          //top.Dialog.confirm("确定不上传头像吗？",function(){
          //   $.post(
          //    "addAdminUser.action",
           //   {"headPhotoId":headPhotoId,"userName":userName,"sex":sex,"name":name,"webSite":webSite,"birthday":birthday,"nickName":nickName,"area":area,"roleId":roleId,"groupId":groupId,"microblog":microblog,"wechat":wechat,"personalProfile":personalProfile},
           //   function(data){
           //     if(data.ok==1){
                 //刷新父页面，关闭弹窗
                 //top.window.frmright.location="yonghuzhongxinGL.jsp";
           //      top.window.frmright.location.href=top.window.frmright.location.href;
           //      $("#touxiang").css("display","");
            //     $("#tijiao").attr("disabled", true);
            //    }
            //  },
            // "json"
          //);
          //});
          }else{
          $.post(
              "addAdminUser.action",
              {"headPhotoId":headPhotoId,"userName":userName,"sex":sex,"name":name,"webSite":webSite,"birthday":birthday,"nickName":nickName,"area":area,"roleId":roleId,"groupId":groupId,"microblog":microblog,"wechat":wechat,"personalProfile":personalProfile},
              function(data){
                if(data.ok==1){
                 //刷新父页面，关闭弹窗
                 //top.window.frmright.location="yonghuzhongxinGL.jsp";
                 userId=data.userId;
                 top.window.frmright.location.href=top.window.frmright.location.href;
                 $("#touxiang").css("display","");
                 $("#tijiao").attr("disabled", true);
                }else if(data.ok==2){
                 top.Dialog.alert("该用户名已经存在！");
                }else{
                 top.Dialog.alert("保存失败！");
                }
              },
             "json"
          );
          }
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
				<div id="touxiang" style="display: none;">
				<img id="headPhoto" src="../image/head.jpg" alt="" width="100px;" height="100px;" class="default"/>
				<input type="file" id="file" name="file"/>
				<input type="button" value="上传" onclick="return ajaxFileUpload();"/>
                </div>
				</td>
			</tr>
			<tr>
				<td width="10%">用户名：</td><td width="40%"><input id="headPhotoId" name="headPhotoId" type="hidden" value=""/><input id="userName" name="userName" type="text"/><span style="color:red;">*</span></td>
				<td width="10%">性别：</td>
				<td><label for="radio-1">男</label><input type="radio" id="radio-1" checked="checked" name="sex" value="男" />
					<label for="radio-2">女</label><input type="radio" id="radio-2" name="sex" value="女"/>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td width="10%">姓名：</td>
				<td><input id="name" name="name"type="text"/><span style="color:red;">*</span></td>
				<td>个人站点：</td>
				<td><input id="webSite" type="text"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><input id="birthday" name="birthday" type="text" class="date" onclick="WdatePicker()"/><span style="color:red;">*</span></td>
				<td>昵称：</td>
				<td><input id="nickName" name="nickName" type="text"/></td>
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
				<!--<input id="citySelect" type="text" class="cityinput" value="城市名" />-->
				<input id="area" name="area" type="text" id="city" autocomplete="off" value="上海" name="s_cities" onclick="this.value='';GetCityList(this);" onkeyup="selCity(event)" class="default" />


				</td>
				<td>角色：</td>
				<td>
					<select id="sel" class="default">
					    <s:iterator value="roles" var="role">
					    <option value="${role.id }">${role.roleName }</option>
					    </s:iterator>
					 </select>
				</td>
				<td>组别：</td>
				<td>
				<select id="sel2" class="default">
					    <s:iterator value="groups" var="group">
					    <option value="${group.id }">${group.groupName }</option>
					    </s:iterator>
					 </select>				
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
				<td width="15%">微博帐号：</td><td width="40%"><input id="microblog" name="microblog" type="text"/><span style="color:red;">*</span></td>
				<td width="15%">微信帐号：</td><td width="40%"><input id="wechat" name="wechat" type="text"/><span style="color:red;">*</span></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td></td><td></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">个人简介：</td>
				<td colspan="3">
					<span class="float_left">
					<textarea id="personalProfile" name="personalProfile" style="width:700px;"></textarea><span style="color:red;">*</span>
					</span>
				</td>
			</tr>
		</table>
	</fieldset>
	<div class="padding_top10">
		<table class="tableStyle" transMode="true" style="width: 100%;">
			<tr>
				<td colspan="4" style="text-align: center;">
					<input id="tijiao" type="button" value=" 提 交 " onclick="addAdminUser()"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
</body>
</html>
