<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
                //KindEditor.ready(function(K) {
				//var editor = K.editor({
				//	allowFileManager : true
				//});
				//K('#J_selectImage').click(function() {
				//	editor.loadPlugin('multiimage', function() {
				//		editor.plugin.multiImageDialog({
				//			clickFn : function(urlList) {
				//				var div = K('#J_imageView');
				//				div.html('');
				//				K.each(urlList, function(i, data) {
				//					div.append('<img src="' + data.url + '">');
				//				});
				//				editor.hideDialog();
				//			}
				//		});
				//	});
				//	
				
				//});
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
   $("#shangchuan").append('<input type="file" id="'+id+'" style="width: 800px;" name="file"/><br/>');
   i++;
   }
   
}
//function fileUpload() {
//    alert("开始上传");
    //var files = ['file1','file2','file3'];  //将上传三个文件 ID 分别为file2,file2,file3
//    var files1=document.getElementsByName("file");
//    var files2="";
//    for(var i=0;i<files1.length;i++){
//     if(files2==""){
//     files2=files1[i].getAttribute("id");
//     }else{
//     files2=files2+","+files1[i].getAttribute("id");
//     }
//    }
//    var files=files2.split(",");
//    alert(files);
//    $.ajaxFileUpload( {
//      url : 'fileUploadAction',     //用于文件上传的服务器端请求地址  
//      secureuri : false,            //一般设置为false  
//      fileElementId : files,        //文件上传的id属性  <input type="file" id="file" name="file" />  
//      dataType : 'json',            //返回值类型 一般设置为json  
//      success : function(data, status) {
//        var fileNames = data.fileFileName; //返回的文件名 
//        var filePaths = data.filePath;     //返回的文件地址 
//        for(var i=0;i<data.fileFileName.length;i++){
          //将上传后的文件 添加到页面中 以进行下载
//          $("#down").after("<tr><td height='25'>"+fileNames[i]+
//              "</td><td><a href='downloadFile?downloadFilePath="+filePaths[i]+"'>下载</a></td></tr>")
//        }
//      }
//    })
//  }
function jiancha(){
  alert("无法提交");
  return false;
}
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
	       <span>发布人：</span><input name="userName" type="text" value="admin"/>
     </div>
     
     <div class="box2" panelTitle="发布分类" showStatus="false" style="width: 99%;height: 50px; margin-top: 20px;text-align: left;">
	       <input type="checkbox" name="fl" value="1"/> 设计师
	       <input type="checkbox" name="fl" value="2"/> 供应商
	       <input type="checkbox" name="fl" value="3"/> 车世界
	       <input type="checkbox" name="fl" value="4"/> 身边
	       <input type="checkbox" name="fl" value="5"/> 欣赏
	       <input type="checkbox" name="fl" value="6"/> 官方
     </div>
     <div class="box2" panelTitle="标签" showStatus="false" style="width: 99%;margin-top: 20px;text-align: left;">
	       <table class="tableStyle" useHover="false" useClick="false">
           <tr>
	         <td style="width: 5%;">标签名称</td><td style="width: 10%;"><input name="bqName" type="text" class="validate[required]"/></td>
	         <td style="width: 5%;">标签类型</td>
	         <td>
	         <input type="checkbox" value="1" name="bq"/> 普通标签
	         <input type="checkbox" value="2" name="bq"/> 其他标签
	         </td>
	         
	         <td style="width: 5%;"><input type="button" value="复制行" id="copyBtn"/></td>
           </tr>
           </table>
     </div>
     <div class="box2" panelTitle="可购信息" showStatus="false" style="width: 99%; margin-top: 20px;text-align: left;">
	       <table class="tableStyle" useHover="false" useClick="false">
           <tr>
	         <td style="width: 5%;">标签名称</td><td style="width: 10%;"><input name="kgName" type="text" class="validate[required]"/></td>
	         <td style="width: 5%;">可购类型</td>
	         <td>
 			 <input type="checkbox" name="kg" value="1"/> 线上
	         <input type="checkbox" name="kg" value="2"/> 线下
	         <input type="checkbox" name="kg" value="3"/> 线上或者线下
	         </td>
	         <td style="width: 5%;">购买网址</td><td><input name="kgWZ" type="text" class="validate[required]"/></td>
	         <td style="width: 5%;"><input type="button" value="复制行" id="copyBtn"/></td>
           </tr>
           </table>
     </div>
     <div  style="width: 99%;margin-top: 20px;"><span>上传图片：</span></div>
     <div  style="width: 99%;height: 100px; overflow:auto;" id="shangchuan" >
     <input type="file" id="file0" class="default" style="width: 800px;" name="file"/> <input  type="button" value="新增" onclick="add()"/><br/>
     </div>
     
     <div  style="width: 99%;height: 100px;">
       <table id="down"></table>
     </div>
     <div  style="width: 99%;text-align: center">
     <input type="submit" value="提交" onclick="return jiancha();"/>
     </div>
     </form>
     <!--<div  style="width: 99%;height: 300px;">
     <IFRAME scrolling="auto" width="100%" frameBorder=0 id=frmrightChild name=frmrightChild  src="<%=basePath%>demo_1.jsp"  allowTransparency="true" height="600px;"></IFRAME>
     </div>
     
     --><!--<div  style="width: 99%;margin-top: 20px;"></div>
     <input type="button" id="J_selectImage" value="批量上传" />
     <div id="J_imageView" style="height: 600px;"></div>
     <form name="newsMessage" method="post" enctype="multipart/form-data"  action="<%=basePath%>demo/kindEditorAction_save.action">
			<textarea id="content" name="content" class="default"></textarea>
			<input type="submit" value="提交" />
	</form>-->
	</div>	
</body>

</html>
