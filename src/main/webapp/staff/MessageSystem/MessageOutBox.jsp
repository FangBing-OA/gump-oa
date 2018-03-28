<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>已发短消息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="/gump-oa/staff/script/jquery.js"></script>
    <script language="javascript" src="/gump-oa/staff/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/staff/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="/gump-oa/staff/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
    
    <style type="text/css">
    td{
		text-align:center
    }
    </style>
    
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="/gump-oa/staff/style/images/title_arrow.gif"/> 发件箱
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<s:if test="page.data.size>0">

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
				<td width="5%" style="color:red;"> ！</td>
                <td>标题</td>
				<td width="20%">收件人</td>
				<td width="25%">发送时间</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        	<s:iterator value="page.data" var="mes">
	            <tr class="TableDetail1 template">
	            	<s:if test="#mes.mesRead==false">
	            		<td style="color:red;">未读</td>
	            	</s:if>
	            	<s:else>
	            		<td>已读</td>
	            	</s:else>
	                <td><a href="ma!toShowMyself?messageId=<s:property value="#mes.mesId"/>"><s:property value="#mes.mesTitle"/></a></td>
					<td><s:property value="#mes.mesReceiver"/></td>
					<td><s:property value="#mes.mesTime"/></td>
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

<!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>
		页次：<s:property value="page.currentPage"/>/<s:property value="page.pageTotal"/>页 &nbsp;
		每页显示：<s:property value="page.pageSize"/>条 &nbsp;
		总记录数：<s:property value="page.count"/>条
	</div>
	<div id=PageSelectorSelectorArea>
    	<a href="ma!toOutBoxPage?messageCurrent=<s:property value="1"/>" ><img src="/gump-oa/staff/style/blue/images/pageSelector/firstPage.png"/></a>
    	<a href="ma!toOutBoxPage?messageCurrent=<s:property value="page.currentPage-1"/>" >上一頁</a>
    	<a href="ma!toOutBoxPage?messageCurrent=<s:property value="page.currentPage+1"/>" >下一頁</a>
    	<a href="ma!toOutBoxPage?messageCurrent=<s:property value="page.pageTotal"/>" ><img src="/gump-oa/staff/style/blue/images/pageSelector/lastPage.png"/></a>
	</div>
</div>
</s:if>
<s:else>
没有数据
</s:else>
</body>
</html>
