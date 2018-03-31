<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>发送消息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%-- <script language="javascript" src="/gump-oa/staff/script/jquery.js"></script> --%>
    <script language="javascript" src="/gump-oa/staff/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/staff/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/staff/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="/gump-oa/staff/script/DataShowManager.js" charset="utf-8"></script>
	<script language="javascript" src="/gump-oa/js/jquery-1.11.3.min.js" charset="utf-8"></script>
	<script language="javascript" src="/gump-oa/js/jquery.validate.min.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="/gump-oa/staff/style/blue/pageCommon.css" />
	<script language="javascript" src="/gump-oa/staff/script/fckeditor/fckeditor.js" charset="utf-8"></script>

<script type="text/javascript">
$(function(){
	
	/* $("#message.mesReceiver").change(function(){
		var $mesReceiver = $("#message.mesReceiver");
		var count = $mesReceiver.val();
		
		$ajax({
			url:"/mesvalidate/pluginAjax!vaildateMesReceiver",
			type:"get",
			contentType :'charset=utf-8',
			date:"mesReceiver=" + count,
			success:funtion(data, textStatus){
				alert("进入");
			}
		});
	}); */
/* 	function gg(){
		$.ajax({
                url: "meajax!vaildateMesReceiver.action",
                type: "get",
                data: {
                	mesReceiver: function() {
                        return document.getElementById("message.mesReceiver").value;
                    }
                },
                dataType: "text",
                dataFilter: function(data, type) {
                	alert(data);
                    if (data == "true")
                        return true;
                    else
                        return false;
                },
                success:function(data){
                	 label.text(" ").addClass("success");
                },
                error:function(){
                	alert("出错了");
                }
		});
			
	} */
	
	$("#send").validate({
		rules:{
			"message.mesReceiver":{
				"required":true,
				"rangelength":[0,50],
				/* "remote": {
					url: "meajax!vaildateMesReceiver.action",
	                data: {
	                	mesReceiver: function() {
	                        return document.getElementById("message.mesReceiver").value;
	                    }
	                },
	                dataType: "text",
				} */
			},
			"message.mesTitle":{
				"required":true,
				"rangelength":[0,20]
			},
			"message.mesContent":{
				"required":true,
				"rangelength":[0,200]
			}
		},
		messages:{
			"message.mesReceiver":{
				"required":"账号不能为空",
				"rangelength":"账号不能超过50字",
				/* "remote":jQuery.format("账号不存在") */
			},
			"message.mesTitle":{
				"required":"标题不能为空",
				"rangelength":"标题不能超过20字"
			},
			"message.mesContent":{
				"required":"内容不能为空",
				"rangelength":"密码不能超过200字"
			}
		}
	});
});

</script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="/gump-oa/staff/style/images/title_arrow.gif"/> 发送消息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form  id="send" name="send" action="ma!doSave" theme="simple">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 信息内容 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
                        <td width="65px">接收人</td>
                        <td><input type="text" id="message.mesReceiver" name="message.mesReceiver" value="<s:property value="message.mesReceiver"/>"  class="InputStyle" style="width:400px; float:left;"/>
 						</td>
                    </tr>
					 <tr>
                        <td>标题</td>
                        <td><input type="text" name="message.mesTitle" class="InputStyle" style="width:400px;"/></td>
                    </tr>
                    <tr>
                        <td>内容</td>
                        <td><textarea name="message.mesContent" class="TextareaStyle" style="width: 400px; height: 300px;"></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
			<input type="image" src="/gump-oa/staff/style/blue/images/button/send.png"/>
			<a href="javascript:history.go(-1);"><img src="/gump-oa/staff/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

</body>
</html>
