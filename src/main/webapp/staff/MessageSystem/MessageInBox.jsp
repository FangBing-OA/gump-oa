<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>已收短消息</title>
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
	<s:actionmessage />

	<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="/gump-oa/staff/style/images/title_arrow.gif"/> 收件箱
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
        <tbody id="TableData" class="dataContainer">
        	<s:iterator value="page.data" var="mes">
	            <tr class="TableDetail1 template">
	            	<s:if test="#mes.mesRead==false">
	            		<td style="color:red;">未读</td>
	            	</s:if>
	            	<s:else>
	            		<td>已读</td>
	            	</s:else>
	                <td><a href="ma!toShow?messageId=<s:property value="#mes.mesId"/>"><s:property value="#mes.mesTitle"/></a></td>
					<td><s:property value="#mes.mesSender"/></td>
					<td><s:property value="#mes.mesTime"/></td>
	                <td><s:a action="ma!toSave" >回復
	                		<s:param name="message.mesSender" value="#mes.mesReceiver"></s:param>
	               		<s:param name="message.mesReceiver" value="#mes.mesSender"></s:param>
	                	</s:a>
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
		页次：<s:property value="page.currentPage"/>/<s:property value="page.pageTotal"/>页 &nbsp;
		每页显示：<s:property value="page.pageSize"/>条 &nbsp;
		总记录数：<s:property value="page.count"/>条
	</div>
	<div id=PageSelectorSelectorArea>
    	<a href="ma!toInBoxAllPage?messageCurrent=<s:property value="1"/>" ><img src="/gump-oa/staff/style/blue/images/pageSelector/firstPage.png"/></a>
    	<a href="ma!toInBoxAllPage?messageCurrent=<s:property value="page.currentPage-1"/>" >上一頁</a>
    	<a href="ma!toInBoxAllPage?messageCurrent=<s:property value="page.currentPage+1"/>" >下一頁</a>
    	<a href="ma!toInBoxAllPage?messageCurrent=<s:property value="page.pageTotal"/>" ><img src="/gump-oa/staff/style/blue/images/pageSelector/lastPage.png"/></a>
	</div>
</div>

</body>
</html>
