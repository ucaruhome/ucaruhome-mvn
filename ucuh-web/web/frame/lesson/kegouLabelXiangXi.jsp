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
	function xianshang(id){
	 var xx=$("#kgleixing1"+id).attr("checked");
	 $("#kgleixing2"+id).attr("checked",false);
	 if(xx){
	 $("#kgleixingContent"+id).html("购买地址");
	 $("#kgleixingContent1"+id).val("");
	 }
	}
	
	function xianxia(id){
	 var xx=$("#kgleixing2"+id).attr("checked");
	 $("#kgleixing1"+id).attr("checked",false);
	 if(xx){
	 $("#kgleixingContent"+id).html("线下店地址");
	 $("#kgleixingContent1"+id).val("");
	 }
	}
	
	function saveAddress(){
	  //kgcId
	 var kgcIds="";
	 var strs="";
	 var kgcs=$("input[name='kgcId']");
	 $.each(kgcs, function(i,val){ 
	        if(i==kgcs.length-1){//判断是否是最后一个
	           kgcIds=kgcIds+val.value;
	        }else{
	           kgcIds=kgcIds+val.value+",";
	        }
	      var lxs=$("input[name='kgType"+val.value+"']"); 
	      $.each(lxs, function(i,val){ 
	       if($(val).attr("checked")){
	           strs=strs+val.value+",";
	       }    
	      });  
	   });
	 //alert(kgcIds);
	
	//var lxs=$("input[name='kgType']");
	//var strs="";
	//   $.each(lxs, function(i,val){ 
	//      if($(val).attr("checked")){
	//           strs=strs+val.value+",";
	//      }    
	//   }); 
	  // alert(strs);
	   //kgleixingContent1
	var strContents="";
	   var lxContents=$("input[name='kgleixingContent1']");
	   $.each(lxContents, function(i,val){ 
	        if(i==lxContents.length-1){//判断是否是最后一个
	           strContents=strContents+val.value;
	        }else{
	           strContents=strContents+val.value+",";
	        }
	   });
	   
	  // alert(strContents);
	 
	 
	 //ajax发送到后台保存
	 $.post(
	   "saveAddress.action",
	   {"kgcIds":kgcIds,"strs":strs,"strContents":strContents},
	   function(data){
	     if(data.ok==1){
	       top.Dialog.close();
	     }else{
	       top.Dialog.alert("保存失败！稍后重试！");
	     }
	   },
	   "json"
	 );
	}
</script>
</head>
<body>
    <fieldset> 
		<legend>可购标签</legend> 
		<table style="width: 100%;">
			<tr>
				<td style="width: 20%;">标签名称：</td><td>${kglabel.tagName }</td>
				<td style="width: 20%;">标签类型：</td><td>可购标签</td>
			</tr>
		</table>
		<table style="width: 100%;">
		<s:iterator value="kgcs" id="kgc">
			<tr>
				<td>可购类型：<input name="kgcId" type="hidden" value="${kgc.id}"/></td>
				<td>
				<s:if test="#kgc.kgType==0">
				<input id="kgleixing1${kgc.id}" name="kgType${kgc.id}" type="radio" value="0" checked="checked" onclick="xianshang(${kgc.id})"/>线上 &nbsp;&nbsp;
				
				<input id="kgleixing2${kgc.id}" name="kgType${kgc.id}" type="radio" value="1" onclick="xianxia(${kgc.id})"/>线下
				</s:if>
				<s:else>
				<input id="kgleixing1${kgc.id}" name="kgType${kgc.id}" type="radio" value="0" onclick="xianshang(${kgc.id})"/>线上 &nbsp;&nbsp;
				
				<input id="kgleixing2${kgc.id}" name="kgType${kgc.id}" type="radio" value="1" checked="checked" onclick="xianxia(${kgc.id})"/>线下
				</s:else>
				
				</td>
			</tr>
			<tr>
			<s:if test="#kgc.kgType==0">
				<td><span id="kgleixingContent${kgc.id}">购买地址：</span></td><td><input id="kgleixingContent1${kgc.id}" name="kgleixingContent1" type="text" class="default" style="width: 90%;" value="${kgc.content }"/></td>
		    </s:if>
			<s:else>
			    <td><span id="kgleixingContent${kgc.id}">线下店地址：</span></td><td><input id="kgleixingContent1${kgc.id}" name="kgleixingContent1" type="text" class="default" style="width: 90%;" value="${kgc.content }"/></td>
			</s:else>   
			</tr>
		</s:iterator>
		<tr>
		 <td colspan="2" style="text-align: center;"><input type="button" value="确定" onclick="saveAddress()"/></td>
		</tr>
		</table>
	</fieldset> 

</body>
</html>
