<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>已收短消息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="../script/jquery.js"></script>
    <script language="javascript" src="../script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="../script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="../script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="../script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="../style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>
	<s:actionmessage />

	<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 收件箱
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<s:form action="" theme="simple">
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
				<td width="28px" style="color:red;"> ！</td>
                <td>标题</td>
				<td width="100px">发件人</td>
				<td width="120px">发送时间</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="messageList">
        	<s:iterator value="page.data" var="mes">
	            <tr class="TableDetail1 template">
	            	<td style="color:red;"><s:property value="#mes.mesRead"/></td>
	                <td><a href="show.html"><s:property value="#mes.mesTitle"/></a></td>
					<td><s:property value="#mes.mesSender"/></td>
					<td><s:property value="#mes.mesTime"/></td>
	                <td><a href="saveUI.html">回复</a>
						<!-- <a onClick="return delConfirm()" href="#">删除</a> -->
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        </div>
    </div>
</div>
</s:form>
<!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>
		页次：<s:property value="#page.currentPage"/>/<s:property value="#page.pageTotal"/>页 &nbsp;
		每页显示：<s:property value="#page.pageSize"/>条 &nbsp;
		总记录数：<s:property value="#page.count"/>条
	</div>
	<div id=PageSelectorSelectorArea>
		<!--
		<IMG SRC="../style/blue/images/pageSelector/firstPage2.png"/>
		-->
		<a href="javascript:void(0)" title="首页" style="cursor: hand;">
			<img src="../style/blue/images/pageSelector/firstPage.png"/></a>
		
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">3</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">4</span>
		
		<!--
		<IMG SRC="../style/blue/images/pageSelector/lastPage2.png"/>
		-->
		<a href="#" title="尾页" style="cursor: hand;"><img src="../style/blue/images/pageSelector/lastPage.png"/></a>
		
	</div>
</div>

</body>
</html>