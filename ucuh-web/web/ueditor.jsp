<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>  
<title>编辑器完整版实例</title>  
<script type="text/javascript" src="ueditor/ueditor.config.js"></script>  
<script type="text/javascript" src="ueditor/ueditor.all.js"></script>  
<link rel="stylesheet" href="ueditor/themes/default/dialogbase.css"/>
<script type="text/javascript" src="frame/js/jquery-1.4.js"></script>
<script type="text/javascript">
  function baocun(){
    //alert("保存");
    var newsId=$("#newsId").val();
    var html=UE.getEditor('myEditor').getAllHtml();
    //获取标题
    var theme=$("#theme").val();
    //alert(theme);
    //获取选中的类型
    var radioList = $("input[name='type']:checked");
    var type=radioList.val();
    var radioList1 = $("input[name='tanchuangYesOrNo']:checked");
    var tanchuangYesOrNo=radioList1.val();
    var remark=$("#remark").html();
    var content=UE.getEditor('myEditor').getContent();
    if(theme==""||html==""||remark==""){
      alert("所填项不能为空！");
    }else{
     //ajax提交后台
     $.post(
       "addNews.action",
       {"type":type,"theme":theme,"content":html,"newsId":newsId,"tanchuangYesOrNo":tanchuangYesOrNo,"remark":remark,"content1":content},
       function(data){
         if(data.ok){
            document.getElementById("xuanfu").style.cssText="position:absolute; z-index:2; width:300px; height:60px; left:900px; top:200px; overflow: auto;border:1px solid #ddd;background-color:#fff; text-align: center;";
            $("#quxiao").val("继续发布");
            $("#newsId").val(data.newsId);
            $("#newsId1").val(data.newsId);
            //$("#ceshi").html(data.content);
         }
       }
     );
  }
  }
  
  function quxiao(){
   top.window.frmright.location.href="ueditor.jsp";
  }
  
  function check(){
    var file=$("#file").val();
    if(file==null||file==""){
      alert("文件上传不能为空！");
      return false;
    }
  }
</script>

<style>

</style>
</head>

<body>
<div style="width: 99%;height: 700px; overflow:auto;">
<div>
<span style="font-size: 20px;font-weight: 5px;">消息发布</span>
</div>
<div style="margin-top: 20px;">
标题:<input type="text" id="theme" name="theme" class="default" style="width: 46%;"/><input type="hidden" id="newsId"/>
</div>
<div style="margin-top: 20px;">
描述:<textarea id="remark" name="remark" rows="3" cols="60" style="width: 46%;"></textarea>
</div>
<div style="margin-top: 20px;">
类型:<input name="type" type="radio" value="0" checked="checked"/>通知&nbsp;&nbsp;&nbsp;<input name="type" type="radio" value="1"/>活动
</div>
<div style="margin-top: 20px;">
是否弹窗:<input name="tanchuangYesOrNo" type="radio" value="0" checked="checked"/>否&nbsp;&nbsp;&nbsp;<input name="tanchuangYesOrNo" type="radio" value="1"/>是
</div>
<div style="margin-top: 20px;">
<div id="myEditor"></div>
</div>
</div>
<!--<div id="ceshi">
</div>
-->
<div>
<input id="baocun" type="button" value="保存" onclick="baocun()"/>&nbsp;<input id="quxiao" type="button" value="取消" onclick="quxiao()"/>
</div>

<!-- 得到一个悬浮窗口 -->
<div id="xuanfu"  style='position:absolute; z-index:2; width:300px; height:60px; left:900px; top:200px; overflow: auto;border:1px solid #ddd;background-color:#fff; text-align: center;display: none;'>
 <form action="newsFengmianfileUpload.action" method="post" enctype="multipart/form-data">
 <input id="file" type="file" name="file"/><input id="newsId1" name="newsId" type="hidden"/>
<br/>
 <input type="submit" value="上传封面" onclick="return check();"/>
 </form>
</div>
<div></div>
</body>

<script type="text/javascript">  
        var option = {  
            initialContent : '',//初始化编辑器的内容  
            minFrameHeight : 400,//设置高度  
            textarea : 'content'//设置提交时编辑器内容的名字，之前我们用的名字是默认的editorValue  
        };  
        var editor = new baidu.editor.ui.Editor(option);  
        editor.render("myEditor");  
</script>
</html>
