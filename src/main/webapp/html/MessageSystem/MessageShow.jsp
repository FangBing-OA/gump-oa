<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>显示消息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" src="/gump-oa/staff/script/jquery.js"></script>
    <script language="javascript" src="/gump-oa/staff/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/staff/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/staff/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="/gump-oa/staff/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="/gump-oa/staff/style/blue/pageCommon.css" />
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="/gump-oa/staff/style/images/title_arrow.gif"/> 显示消息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
	<div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
		<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 信息内容 </DIV>  -->
	</div>
	
	<!-- 内容显示 -->
	<div class="ItemBlockBorder" style="margin: 15px;">
		<div class="ItemBlock">
			<table cellpadding="0" cellspacing="0" class="mainForm" style="font-size: 14px;"> 
				<tr height="25px"><td>发件人　：<s:property value="message.mesSender"/></td></tr>
				<tr height="25px"><td>收件人　：<s:property value="message.mesReceiver"/></td></tr>
				<tr height="25px"><td>发送时间：<s:property value="message.mesTime"/></td></tr>
				<tr height="25px"><td>标　题　：<s:property value="message.mesTitle"/></td></tr>
				<tr><td style="border-top: 1px dotted blue; padding-top: 15px;">
						<pre><s:property value="message.mesContent"/></pre>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div id="InputDetailBar">
		<a href="javascript:history.go(-1);"><img src="/gump-oa/staff/style/images/goBack.png"/></a>
	</div>
</div>

</body>
</html>
