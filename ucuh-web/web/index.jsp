<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>有车有房</title>
<link href="frame/login/skin1/style.css" rel="stylesheet" type="text/css" id="skin"/>
<script type="text/javascript" src="frame/js/jquery-1.4.js"></script>
<script type="text/javascript" src="frame/js/login.js"></script>

<!--引入弹窗组件start-->
<script type="text/javascript" src="frame/js/attention/zDialog/zDrag.js"></script>
<script type="text/javascript" src="frame/js/attention/zDialog/zDialog.js"></script>
<!--引入弹窗组件end-->

<!--修正IE6支持透明png图片start-->
<script type="text/javascript" src="frame/js/method/pngFix/supersleight.js"></script>
<!--修正IE6支持透明png图片end-->

<!--居中显示start-->
<script type="text/javascript" src="frame/js/method/center-plugin.js"></script>
<script>
	$(function(){
		 $('.login_main').center();
	})
</script>
<!--居中显示end-->
<style>
/*提示信息*/	
#cursorMessageDiv {
	position: absolute;
	z-index: 99999;
	border: solid 1px #cc9933;
	background: #ffffcc;
	padding: 2px;
	margin: 0px;
	display: none;
	line-height:150%;
}
/*提示信息*/
</style>
</head>
<body >
	<div class="login_main">
		<div class="login_top">
			<div class="login_title"></div>
		</div>
		<div class="login_middle">
			<div class="login_middleleft"></div>
			<div class="login_middlecenter">
					<form action="frame/loginTo.action" class="login_form" method="post">
					<div class="login_user"><input type="text" name="userName"></div>
					<div class="login_pass"><input type="password" name="passWord"></div>
					<div class="clear"></div>
					<div class="login_button">
						<div class="login_button_left"><input type="submit" value="" onfocus="this.blur()"/></div>
						<div class="login_button_right"><input type="reset" value="" onfocus="this.blur()"/></div>
						<div class="clear"></div>
					</div>
					</form>
					<div class="login_info" style="display:none;">您的密码有误，请重新输入。</div>
			</div>
			<div class="login_middleright"></div>
			<div class="clear"></div>
		</div>
		<div class="login_bottom">
			<div class="login_copyright">有车有房后台管理 COPYRIGHT 2010 @ www.quickui.net</div>
		</div>
	</div>
	<!--<div class="login_skin"><span onclick='top.Dialog.open({URL:"login/useSkin.html",Title:"皮肤更换方法",Width:720,Height:490});'>皮肤更换方法</span></div>
--></body>
</html>
