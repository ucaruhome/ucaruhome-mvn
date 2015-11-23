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
<script src="../js/form/validationEngine-cn.js" type="text/javascript"></script>
<script src="../js/form/validationEngine.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/jquery-1.4.js"></script>
<script type="text/javascript" src="../js/framework.js"></script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../js/ajaxfileupload1.js"></script>
<link  rel="stylesheet" type="text/css" id="skin"/>
<script type="text/javascript">
var i=0;
  $(function(){
	$("#copyBtn").live("click",function(){
		//克隆按钮所在的tr并添加到table的末尾
		$(this).parents("tr").clone(true).appendTo($(this).parents("table"));
		//找到table最后一个tr的最后一个td中的button按钮
		var $lastBtn=$(this).parents("table").find("tr").last().find("td").last().find("input[type='button']");
		//更改按钮的显示文字
		$lastBtn.val("删除行");
		//修正按钮在复制时产生的样式错误
		$lastBtn.removeClass("button_hover");
		$lastBtn.addClass("button");
		//对该按钮重新监听点击事件
		$lastBtn.click(function(e){
			//阻止默认行为，即复制行为
			e.stopPropagation();
			//将所在的行删除
			$(this).parents("tr").remove()
		})
	})
});
                
function add(){
   //alert("新建一个input");
   var j=i+1;
   var id="file"+j;
   var id1="file"+i;
   var obj=$("#"+id1).val();
   //alert(obj);
   if(obj==""){
   top.Dialog.alert("请添加照片后再新增");
   //i--;
   }else{
   $("#shangchuan").append('<input type="file" id="'+id+'" name="file"/><br/>');
   i++;
   }
   
}
function addXiTongLabel(){
 top.Dialog.open({URL:"lesson/xiTongLabelSelect.action?id="+id,Title:"归类",Width:800,Height:600});
}

function jiancha(){
  return true;
}
//function jiancha(){
//  alert("无法提交");
//  return false;
//}
</script>
<!--框架必需end-->
</head>
<body>

<div class="position">
	<div class="center">
	<div class="left">
	<div class="right">
		<span style="">官方发布照片</span>
	</div>	
	</div>	
	</div>
</div>
<div style="width: 99%;height: 700px; overflow:auto;">
     <form action="fileUpload.action" enctype="multipart/form-data" method="post">
     <div class="box2" panelTitle="确认发布者" showStatus="false" style="width: 99%;height: 50px; text-align: left;">
	       <span>发布人：</span><input name="userName" type="text" value="${user.userName }"/><input name="userId" type="hidden" value="${user.id }"/>
     </div>
     
     <div class="box2" panelTitle="发布分类" showStatus="false" style="width: 99%;height: 50px; margin-top: 20px;text-align: left;">
	       <!--<input type="checkbox" name="fl" value="1"/> 设计师
	       <input type="checkbox" name="fl" value="2"/> 供应商
	       <input type="checkbox" name="fl" value="3"/> 车世界
	       <input type="checkbox" name="fl" value="4"/> 身边
	       <input type="checkbox" name="fl" value="5"/> 欣赏
	       <input type="checkbox" name="fl" value="6"/> 官方
     -->
     <s:iterator value="fenleis" id="fenlei">
     <input type="checkbox" name="fl" value="${fenlei.id }"/> ${fenlei.name }
     </s:iterator>
     </div>
     <div class="box2" panelTitle="添加描述" showStatus="false" style="width: 99%;height: 200px; text-align: left;">
           标题：<input name="theme" type="text" /><br/>
	描述：<textarea style="width:350px;height:150px;" name="des"></textarea>
     </div>
     <div  style="width: 99%;margin-top: 20px;"><span>上传图片：</span></div>
     <div  style="width: 99%;height: 100px; overflow:auto;" id="shangchuan" >
     <input type="file" id="file0" class="default" name="file"/> <input  type="button" value="新增" onclick="add()"/><br/>
     </div>
     
     <div  style="width: 99%;height: 100px;">
       <table id="down"></table>
     </div>
     <div  style="width: 99%;text-align: center">
     <input type="submit" value="提交" onclick="return jiancha();"/>
     </div>
     </form>
	</div>	
</body>

</html>
