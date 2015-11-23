<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="../js/jquery-1.4.js"></script>
<script type="text/javascript" src="../js/framework.js"></script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css"/>
<link  rel="stylesheet" type="text/css" id="skin"/>
<!--框架必需end-->

<!--去除链接虚线start-->
<style>
a {
	behavior:url(../js/method/focus.htc)
}
</style>
<!--去除链接虚线end-->
<body>
	
<div id="scrollContent">
	<table width="100%">
		<tr>
			<td width="220" class="ver01">
				<div class="list_menu3" style="position: absolute;">
					<div class="current"><span><a href="findAdminUsers.action" target="frmrightChild">管理员帐号</a></span></div>
					<div><span><a href="findPutongUsers.action" target="frmrightChild">普通用户帐号</a></span></div>
					<div><span><a href="findUsersDRZ.action" target="frmrightChild">待审核用户</a></span></div>
					<div><span><a href="findUsersYSHTG.action" target="frmrightChild">已审核用户</a></span></div>
					<div><span><a href="findUsersYSHWTG.action" target="frmrightChild">未通过用户</a></span></div>
					<!--<div><span><a href="chapter9-1-1-content2.html" target="frmrightChild">选项5</a></span></div>
					<div><span><a href="chapter9-1-1-content3.html" target="frmrightChild">选项6</a></span></div>
				--></div>
			</td>
			<td class="ver01">
				<div class="box1">
					<IFRAME scrolling="auto" width="100%" frameBorder=0 id=frmrightChild name=frmrightChild onload="iframeHeight('frmrightChild')" src="findAdminUsers.action"  allowTransparency="true"></IFRAME>
				</div>
			</td>
		</tr>
	</table>
</div>				
</body>
</html>
