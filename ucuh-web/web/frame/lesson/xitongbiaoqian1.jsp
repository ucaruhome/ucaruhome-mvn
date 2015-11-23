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
    function chakan(labelId){
     top.Dialog.open({URL:"lesson/queryPhotos.action?labelId="+labelId,Title:"查看 ",Width:800,Height:820});
    }
    function shezhi(id){
     //alert(id);
     top.Dialog.open({URL:"readLabelXXXX.action?id="+id,Title:"设置",Width:400,Height:300});
    }
    function shanchu(id){
     top.Dialog.confirm("是否确定要删除信息？",function(){
     $.post(
     "deleteLabel.action",
     {"id":id},
     function(data){
       if(data.ok==false){
        top.Dialog.alert("操作失败!");
       }else{
        top.window.frmright.location.href=top.window.frmright.location.href;
        top.Dialog.close();
       }
     
      },
     "json"
     );

     });
    }
    function xinzeng(){
    top.Dialog.open({URL:"lesson/readLabelXZ.action",Title:"新增",Width:800,Height:600});
    }
	</script>
</head>
<body leftFrame="true">
<div style="width: 100%; text-align: right;margin-top: 20px;margin-right: 20px;margin-bottom: 20px;">
  <input id="xinzeng" type="button" value="新增" onclick="xinzeng()"/>
</div>
<table class="treeTable">
	<tr>
		<th width="500">标签名称</th>
		<th width="200">标签封面</th>
		<th>照片数</th>
		<th>类型</th>
		<th width="500">操作</th>
	</tr>
	<!--<tr id="node-1">
		<td><span class="folder">根目录1</span></td>
		<td>--</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	-->
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
		<s:if test="#la.parentId==0">
		</s:if>
		   <s:else>
           <input type="button" value="查看" onclick="chakan('${la.id}')"/>
           <input type="button" value="设置" onclick="shezhi(${la.id})"/>
           <input type="button" value="删除" onclick="shanchu(${la.id})"/>
           </s:else>
        </td>
	</tr>
	</s:iterator>
	<!--<tr id="node-8" class="child-of-node-2">
		<td><span class="file">文件1</span></td>
		<td>52 KB</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-9" class="child-of-node-2">
		<td><span class="file">文件2</span></td>
		<td>4 KB</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-3" class="child-of-node-1">
		<td><span class="file">文件3</span></td>
		<td>4 KB</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-4" class="child-of-node-1">
		<td><span class="folder">二级目录2</span></td>
		<td>--</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-5" class="child-of-node-4">
		<td><span class="file">文件4</span></td>
		<td>56 KB</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-14">
		<td><span class="file">文件5</span></td>
		<td>4 KB</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-11">
		<td><span class="folder">根目录2</span></td>
		<td>--</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-12" class="child-of-node-11">
		<td><span class="file">文件6</span></td>
		<td>4 KB</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
--></table>
</body>

</html>