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
<script type="text/javascript" src="../js/framework.js"></script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css"/>
<link  rel="stylesheet" type="text/css" id="skin"/>
<!--框架必需end-->

<!--单行文本截取start-->
<script type="text/javascript" src="../js/text/text-overflow.js"></script>
<script type="text/javascript" src="../js/table/treeTable.js"></script>

<!--单行文本截取end-->
<script type="text/javascript">
	function tianjiaFenlei(){
	 var id=$("#fenleisAll").val();
	 var text=$("#fenleisAll"+id).html();
	 var informtionFlowId=$("#informtionFlowId").html();
	 //alert(id);
	 //alert(text);
	 //alert(informtionFlowId);
	 //ajax请求后台添加一个分类
	 top.Dialog.confirm("是否确定要删除？",function(){
	 $.post(
	 "okInformationflowFenlei.action",
	 {"informtionFlowId":informtionFlowId,"fenleiId":id},
	 function(data){
	   if(data.ok){
	    //添加一条分类信息
	    $.post(
	    "addInformationflowFenlei.action",
	    {"informtionFlowId":informtionFlowId,"fenleiId":id},
	    function(data){
	     if(data.ok){
	     //<input id="fenleiinput${infenlei.fenLei.id}" type="checkbox" value="${infenlei.fenLei.id }" checked="checked" disabled="disabled"/><span id="fenleispan${infenlei.fenLei.id}">${infenlei.fenLei.name }</span>
        //<input  type="button" value="删除" onclick="shanchuFenlei(${infenlei.fenLei.id })"/>&nbsp;&nbsp;&nbsp;
	       //将得到的数据添加到div中，并放到最后
	       $("#fenleis").append("<input id='fenleiinput"+id+"' type='checkbox' value='"+id+"' checked='checked' disabled='disabled'/><span id='fenleispan"+id+"'>"+text+"</span><input id='fenleibutton"+id+"'  type='button' value='删除' onclick='shanchuFenlei("+id+")'/>&nbsp;&nbsp;&nbsp;"); 
	     }else{
	       top.Dialog.alert("系统错误！添加失败！");
	     }
	    },
	    "json"
	    );
	   }else{
	    top.Dialog.alert("该分类已经存在！");
	   }
	 },
	 "json"
	 );
	 });
	}
	
	//删除分类
	function shanchuFenlei(id){
	var informtionFlowId=$("#informtionFlowId").html();
	top.Dialog.confirm("是否确定要删除？",function(){
	//ajax删除
	
	$.post(
	  "delInformationflowFenlei.action",
	  {"informtionFlowId":informtionFlowId,"fenleiId":id},
	  function(data){
	     if(data.ok){
	       $("#fenleiinput"+id).remove();
	       $("#fenleispan"+id).remove();
	       $("#fenleibutton"+id).remove();
	     }else{
	       top.Dialog.alert("删除失败！");
	     }
	  },
	  "json"
	);
	 });
	}
	//得到新增标签页面
	function xinzengBQ(id){
	  //alert(id);
	  //top.Dialog.open({URL:"lesson/xiTongLabelSelect1.action?photoId="+id,Title:"新增标签",Width:800,Height:600});
	  document.getElementById("xuanfu").style.cssText="position:absolute; z-index:2; width:100%; height:300px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;";
	  $("#id").val(id);
	}
	
	//点击照片改变照片的样式
	function change(id){
	 var photos=document.getElementsByName("photo");
	 for(var i=0;i<photos.length;i++){
	  photos[i].style.cssText="";
	 }
	 var photo1=document.getElementById("photo"+id);
	 photo1.style.cssText="border:1px solid red;";
	 $("#id").val(id);
	 $("#kgid").val(id);
	 document.getElementById("xuanfu").style.cssText="position:absolute; z-index:2; width:100%; height:600px; left:0px; top:0px; display: none;overflow: auto;border:1px solid #ddd;background-color:#fff;";
	 document.getElementById("xuanfu1").style.cssText="position:absolute; z-index:2; width:100%; height:600px; left:0px; top:0px; display: none;overflow: auto;border:1px solid #ddd;background-color:#fff;";
	 //通过class来选择所有的div
	 var bqdivs=document.getElementsByClassName("bqname");
	 var kgbqdivs=document.getElementsByClassName("kgbqname");
	 for(var i=0;i<bqdivs.length;i++){
	  bqdivs[i].style.cssText="display: none;";
	 }
	 for(var i=0;i<kgbqdivs.length;i++){
	  kgbqdivs[i].style.cssText="display: none;";
	 }
	 var bq=document.getElementById("bq"+id);
	 var kgbq=document.getElementById("kgbq"+id);
	 bq.style.cssText="";
	 kgbq.style.cssText="";
	 
	}
	
	//取消悬浮
	function quxiao(){
	 document.getElementById("xuanfu").style.cssText="position:absolute; z-index:2; width:100%; height:600px; left:0px; top:0px; display: none;overflow: auto;border:1px solid #ddd;background-color:#fff;";
	}
	//新增标签
	function xinzeng(){
	var id=$("#id").val();
	
    var radioList = $("input[name='xuanzexiang']:checked");
    var xuanzexiang=radioList.val();
    // alert("归类开始");
     $.post(
     "xiTongLabelAdd.action",
     {"photoId":id,"xuanzexiang":xuanzexiang},
     function(data){
       if(data.ok==false){
        top.Dialog.alert("该标签已经存在！");
       }else{
         //在table中新增一行
         $("#bqtable"+id).append("<tr><td>"+data.tagName+"</td><td>"+data.tagType+"</td><td id='scjieguo"+data.labelPhotoId+"'><input type='button' value='删除' onclick='shanchu("+data.labelPhotoId+")'/></td></tr>");
         document.getElementById("xuanfu").style.cssText="position:absolute; z-index:2; width:100%; height:600px; left:0px; top:0px; display: none;overflow: auto;border:1px solid #ddd;background-color:#fff;";
       }
     
      },
     "json"
     );
	}
	
	//删除一个标签信息
	function shanchu(id){
	 top.Dialog.confirm("是否确定要删除？",function(){
       //ajax访问后台删除
       $.post(
       "xiTongLabelDel.action",
       {"labelPhotoId":id},
       function(data){
        if(data.ok){
          top.Dialog.alert("删除成功！");
          
          var tr=$("#scjieguo"+id).parent();
          //$("#bqtable"+id).remove(tr);
          tr.remove();
        }else{
          top.Dialog.alert("删除失败！");
        }
       },
       "json"
       );
       

     });
	}
	
	//======================================================================可购标签部分=============================================================
	//得到新增标签页面
	function xinzengKGBQ(id){
	  //alert(id);
	  //top.Dialog.open({URL:"lesson/xiTongLabelSelect1.action?photoId="+id,Title:"新增标签",Width:800,Height:600});
	  document.getElementById("xuanfu1").style.cssText="position:absolute; z-index:2; width:100%; height:300px; left:0px; top:0px; overflow: auto;border:1px solid #ddd;background-color:#fff;";
	  $("#kgid").val(id);
	}
	
	//取消悬浮
	function quxiaoKGBQ(){
	 document.getElementById("xuanfu1").style.cssText="position:absolute; z-index:2; width:100%; height:600px; left:0px; top:0px; display: none;overflow: auto;border:1px solid #ddd;background-color:#fff;";
	}
	
	//可购选择项
	function kegouXuanze(id,name){
	 var xx=$("#xuanzexiang"+id).attr('checked');
	 //alert(xx);
	 if(xx){
	   //alert("可以复制拉！");
	   //标签名称：<input id="kglabelId" type="hidden" value=""/><input id="kglabelTagName" type="text"/>
	   $("#kglabelId").val(id);
	   $("#kglabelTagName").val(name);
	   // disabled="disabled"
	   $("#kglabelTagName").attr("disabled","disabled");
	   //alert($("#kglabelId").val());
	   //alert($("#kglabelTagName").val());
	 }
	}
	
	function qingkong(){
	  var id=$("#kglabelId").val();
	  if(id==""){
	    top.Dialog.alert("请填写标签名！");
	  }else{
	    $("#xuanzexiang"+id).attr("checked",false);
	    $("#kglabelId").val("");
	    $("#kglabelTagName").val("");
	    $("#kglabelTagName").attr("disabled","");
	  }
	}
	
	function xianshang(){
	 var xx=$("#kgleixing1").attr("checked");
	 $("#kgleixing2").attr("checked",false);
	 if(xx){
	 $("#kgleixingContent").html("购买地址");
	 }
	}
	
	function xianxia(){
	 var xx=$("#kgleixing2").attr("checked");
	 $("#kgleixing1").attr("checked",false);
	 if(xx){
	 $("#kgleixingContent").html("线下店地址");
	 }
	}
	
	//新增可购标签
	function xinzeng1(){
	 var photoId=$("#kgid").val();
	 var kglabelId=$("#kglabelId").val();
	 var kglabelTagName=$("#kglabelTagName").val();
	 //获取线上，线下单选框的值kgleixing
	 var radioList = $("input[name='kgleixing']:checked");
     var kgleixing=radioList.val();
	 var kgleixingContent1=$("#kgleixingContent1").val();
	 //alert(photoId);
	 //alert(kglabelId);
	 //alert(kglabelTagName);
	 //alert(kgleixing);
	 //alert(kgleixingContent1);
	 //ajax提交到后台
	 $.post(
	  "addKGLabel.action",
	  {"photoId":photoId,"labelId":kglabelId,"labelTagName":kglabelTagName,"kglx":kgleixing,"kglxContent":kgleixingContent1},
	  function(data){
	    if(data.ok==0){
	     top.Dialog.alert("新增失败！");
	    }else if(data.ok==1){
	     top.Dialog.alert("标签名不能为空！");
	    }else{
	      // <tr><td>${kegou.hchhLabel.tagName}</td><td>可购标签</td><td id="scjieguo${kegou.id}"><input type="button" value="删除" onclick="shanchu('${kegou.id}')"/>&nbsp;<input type="button" value="编辑地址" onclick="editAddress('${kegou.id}')"/></td></tr>
	      $("#kgbqtable"+photoId).append("<tr><td>"+data.labelTagName+"</td><td>可购标签</td><td id='scjieguo"+data.labelPhotoId+"'><input type='button' value='删除' onclick='kgshanchu("+data.labelPhotoId+")'/>&nbsp;<input type='button' value='编辑地址' onclick='editAddress("+data.labelPhotoId+")'/></td></tr>");
	      document.getElementById("xuanfu1").style.cssText="position:absolute; z-index:2; width:100%; height:600px; left:0px; top:0px; display: none;overflow: auto;border:1px solid #ddd;background-color:#fff;";
	     top.Dialog.alert("新增成功！");
	    }
	  },
	  "json"
	 );
	}
	
	//可购标签查询编辑地址
	function editAddress(id){
	  //alert(id);
	  top.Dialog.open({URL:"lesson/editAddress.action?labelPhotoId="+id,Title:"编辑 ",Width:400,Height:200});
	}
	//删除可购标签
	function kgshanchu(id){
	  //alert(id);
	  top.Dialog.confirm("是否确定要删除？",function(){
       //ajax访问后台删除
       $.post(
       "delKGLabel.action",
       {"labelPhotoId":id},
       function(data){
        if(data.ok==1){
          top.Dialog.alert("删除成功！");
          
          var tr=$("#scjieguo"+id).parent();
          //$("#bqtable"+id).remove(tr);
          tr.remove();
        }else{
          top.Dialog.alert("删除失败！");
        }
       },
       "json"
       );
       

     });
	}
	
	function tongguo(id){
	 top.Dialog.confirm("审核通过？",function(){
	   $.post(
	    "shenheInformationflow.action",
	    {"id":id,"informationflowState":1},
	    function(data){
	      if(data.ok){
	        top.window.frmright.location.href=top.window.frmright.location.href;
	        top.Dialog.close();
	      }else{
	        top.Dialog.alert("审核失败！");
	      }
	    },
	    "json"
	   );
	 });
	}
	
	function butongguo(id){
	 top.Dialog.confirm("审核不通过？",function(){
	   $.post(
	    "shenheInformationflow.action",
	    {"id":id,"informationflowState":2},
	    function(data){
	      if(data.ok){
	        top.window.frmright.location.href=top.window.frmright.location.href;
	        top.Dialog.close();
	      }else{
	        top.Dialog.alert("审核失败！");
	      }
	    },
	    "json"
	   );
	 });
	}
</script>
</head>
<body id="zhaopianfabuXiangXi">
<div id="scrollContent">
    <fieldset> 
		<legend>基本信息</legend> 
		<table style="width: 100%;">
		    <tr><td style="text-align:right;" colspan="8"><input type="button" value="通过" onclick="tongguo(${informationflow.id})"/>&nbsp;&nbsp;<input type="button" value="不通过" onclick="butongguo(${informationflow.id})"/></td></tr>
			<tr>
				<td>信息流ID：</td><td id="informtionFlowId">${informationflow.id}</td>
				<td>发布者ID：</td><td>${informationflow.user.id}</td>
				<td>昵称：</td><td>${informationflow.user.nickName}</td>
				<td>发布时间：</td><td>${informationflow.time}</td>
				
			</tr>
			<tr>
				<td>照片数量：</td><td>${informationflow.photoNum}</td>
				<td>点赞量：</td><td>${informationflow.dianzanNum}</td>
				<td>被收藏数：</td><td>${informationflow.shoucangNum}</td>
				<td>评论数：</td><td>${informationflow.pinglunNum}</td>
			</tr>
			<tr>
				
				<td colspan="8">
				简介：<textarea style="width: 100%;" disabled="disabled">${informationflow.des}</textarea>
				</td>
				
			</tr>
		</table>
	</fieldset> 
    <fieldset> 
		<legend>发布分类</legend> 
		<div>
		<select id="fenleisAll" class="default">
		<s:iterator value="fenleisAll" id="fenlei">
		<option id="fenleisAll${fenlei.id }" value="${fenlei.id}">${fenlei.name}</option>
		</s:iterator>
		</select> <input type="button" value="添加" onclick="tianjiaFenlei()"/>
		</div>
		<div id="fenleis">
		<s:iterator value="fenleis" id="infenlei">
		<input id="fenleiinput${infenlei.fenLei.id}" type="checkbox" value="${infenlei.fenLei.id }" checked="checked" disabled="disabled"/><span id="fenleispan${infenlei.fenLei.id}">${infenlei.fenLei.name }</span>
        <input id="fenleibutton${infenlei.fenLei.id}" type="button" value="删除" onclick="shanchuFenlei(${infenlei.fenLei.id })"/>&nbsp;&nbsp;&nbsp;
		</s:iterator>
		</div>
	</fieldset>
	
    <fieldset> 
		<legend>照片信息</legend> 
		
		<div>
		<s:iterator value="pals" id="photolabel" status="status">
		<s:if test="#status.index==0">
		<img id="photo${photolabel.photo.id}" name="photo" src="${photolabel.photo.photoPath}" alt="" width="50px;" height="50px;" style="border:1px solid red;" onclick="change('${photolabel.photo.id}')"/>&nbsp;&nbsp;
		</s:if>
		<s:else>
		<img id="photo${photolabel.photo.id}" name="photo" src="${photolabel.photo.photoPath}" alt="" width="50px;" height="50px;" onclick="change('${photolabel.photo.id}')"/>&nbsp;&nbsp;
		</s:else>
		</s:iterator>
		</div>
		<div style='position:relative;'>		   
		   
		   
		   <!-- 新增选项 悬浮的div设置-->
<div id="xuanfu"  style='position:absolute; z-index:2; width:100%; height:600px; left:0px; top:0px; display: none; overflow: auto;border:1px solid #ddd;background-color:#fff;'>
<div style="width: 100%; text-align: left;margin-top: 20px;margin-right: 20px;margin-bottom: 20px;">
  <input type="hidden" id="id" name="id" value=""/>
</div>
<table class="treeTable">
	<tr>
		<th width="500">标签名称</th>
		<th width="200">标签封面</th>
		<th>照片数</th>
		<th>类型</th>
		<th width="500">选择</th>
	</tr>
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
		<s:if test="#la.parentId==0"><input name="xuanzexiang" value="${la.id }" type="radio" disabled="disabled"/></s:if>
		<s:else><input name="xuanzexiang" value="${la.id }" type="radio"/></s:else>
        </td>
	</tr>
	</s:iterator>
	</table>
<div style="width: 100%; text-align: right;margin-top: 20px;margin-right: 20px;margin-bottom: 20px;">
  <input id="xinzeng" type="button" value="确定" onclick="xinzeng()"/> &nbsp;<input id="quxiao" type="button" value="取消" onclick="quxiao()"/>
</div>
</div>
		   
		   
		   
<!-- 新增选项 悬浮的div设置------可购标签-->
<div id="xuanfu1"  style='position:absolute; z-index:2; width:100%; height:600px; left:0px; top:0px; display: none; overflow: auto;border:1px solid #ddd;background-color:#fff;'>
<div style="width: 100%; text-align: left;margin-top: 20px;margin-right: 20px;margin-bottom: 20px;">
  <input type="hidden" id="kgid" name="id" value=""/>
</div>
<table class="treeTable">
	<tr>
		<th width="500">标签名称</th>
		<th width="200">标签封面</th>
		<th>照片数</th>
		<th>类型</th>
		<th width="500">选择</th>
	</tr>
	<s:iterator value="listYX1" id="la">
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
		<s:if test="#la.parentId==0"><input id="xuanzexiang${la.id}" name="xuanzexiang" value="${la.id }" type="radio" onclick="kegouXuanze('${la.id }','${la.tagName }')" disabled="disabled"/></s:if>
		<s:else><input id="xuanzexiang${la.id}" name="xuanzexiang" value="${la.id }" type="radio" onclick="kegouXuanze('${la.id }','${la.tagName }')"/></s:else>
        </td>
	</tr>
	</s:iterator>
	</table>
	标签名称：<input id="kglabelId" type="hidden" value=""/><input id="kglabelTagName" type="text"/>&nbsp;<input type="button" value="清空" onclick="qingkong()"/>
	<br/>
	可购类型：<input id="kgleixing1" name="kgleixing" type="radio" value="0" checked="checked" onclick="xianshang()"/>线上&nbsp; &nbsp;<input id="kgleixing2" name="kgleixing" type="radio" value="1" onclick="xianxia()"/>线下
	<br/>
	<span id="kgleixingContent">购买地址：</span><input id="kgleixingContent1"  type="text" class="default" style="width: 50%;"/>
	
<div style="width: 100%; text-align: right;margin-top: 20px;margin-right: 20px;margin-bottom: 20px;">
  <input id="xinzeng" type="button" value="确定" onclick="xinzeng1()"/> &nbsp;<input id="quxiao" type="button" value="取消" onclick="quxiaoKGBQ()"/>
</div>
</div>


	  
		<s:iterator value="pals" id="pal" status="status">
		<s:if test="#status.index==0">
		<div id="bq${pal.photo.id}" class="box4 bqname" panelWidth="100%"  panelTitle="标签" >
		   <input type="button" value="新增" onclick="xinzengBQ('${pal.photo.id}')"/>

		   <br/>
		   <table class="tableStyle" id="bqtable${pal.photo.id}">
		   <s:iterator value="#pal.lpsPutong" id="putong">
		    <tr><td>${putong.hchhLabel.tagName}</td><td>普通标签</td><td id="scjieguo${putong.id}"><input type="button" value="删除" onclick="shanchu('${putong.id}')"/></td></tr>
		   </s:iterator>
		   <s:iterator value="#pal.lpsDidian" id="didian">
		    <tr><td>${didian.hchhLabel.tagName}</td><td>地点标签</td><td id="scjieguo${didian.id}"><input type="button" value="删除" onclick="shanchu('${didian.id}')"/></td></tr>
		   </s:iterator>
		   <s:iterator value="#pal.lpsEwai" id="ewai">
		    <tr><td>${ewai.hchhLabel.tagName}</td><td>额外标签</td><td id="scjieguo${ewai.id}"><input type="button" value="删除" onclick="shanchu('${ewai.id}')"/></td></tr>
		   </s:iterator>
		   </table>
		</div>
		<div  id="kgbq${pal.photo.id}" class="box4 kgbqname" panelWidth="100%"  panelTitle="可购标签">
		   <input type="button" value="新增" onclick="xinzengKGBQ(${pal.photo.id})"/>
		   <br/>
		   <table class="tableStyle" id="kgbqtable${pal.photo.id}">
		   <s:iterator value="#pal.lpsKegou" id="kegou">
		    <tr><td>${kegou.hchhLabel.tagName}</td><td>可购标签</td><td id="scjieguo${kegou.id}"><input type="button" value="删除" onclick="kgshanchu('${kegou.id}')"/>&nbsp;<input type="button" value="编辑地址" onclick="editAddress('${kegou.id}')"/></td></tr>
		   </s:iterator>
		   </table>
		</div>
		</s:if>
		
		<s:else>
		<div id="bq${pal.photo.id}" class="box4 bqname" panelWidth="100%" panelTitle="标签" style="display: none;">
		   <input type="button" value="新增" onclick="xinzengBQ('${pal.photo.id}')"/>
		   <br/>
		   <table class="tableStyle" id="bqtable${pal.photo.id}">
		   <s:iterator value="#pal.lpsPutong" id="putong">
		    <tr><td>${putong.hchhLabel.tagName}</td><td>普通标签</td><td id="scjieguo${putong.id}"><input type="button" value="删除" onclick="shanchu('${putong.id}')"/></td></tr>
		   </s:iterator>
		   <s:iterator value="#pal.lpsDidian" id="didian">
		    <tr><td>${didian.hchhLabel.tagName}</td><td>地点标签</td><td id="scjieguo${didian.id}"><input type="button" value="删除" onclick="shanchu('${didian.id}')"/></td></tr>
		   </s:iterator>
		   <s:iterator value="#pal.lpsEwai" id="ewai">
		    <tr><td>${ewai.hchhLabel.tagName}</td><td>额外标签</td><td id="scjieguo${ewai.id}"><input type="button" value="删除" onclick="shanchu('${ewai.id}')"/></td></tr>
		   </s:iterator>
		   </table>
		</div>
		<div id="kgbq${pal.photo.id}" class="box4 kgbqname" panelWidth="100%"  panelTitle="可购标签" style="display: none;">
		   <input type="button" value="新增" onclick="xinzengKGBQ(${pal.photo.id})"/>
		   <br/>
		   <table class="tableStyle" id="kgbqtable${pal.photo.id}">
		   <s:iterator value="#pal.lpsKegou" id="kegou">
		    <tr><td>${kegou.hchhLabel.tagName}</td><td>可购标签</td><td id="scjieguo${kegou.id}"><input type="button" value="删除" onclick="kgshanchu('${kegou.id}')"/>&nbsp;<input type="button" value="编辑地址" onclick="editAddress('${kegou.id}')"/></td></tr>
		   </s:iterator>
		   </table>
		</div>
		
		</s:else>
		</s:iterator>
		</div>
	</fieldset>
	
</div>


 
</body>
</html>
