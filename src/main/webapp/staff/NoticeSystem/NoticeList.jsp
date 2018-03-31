<%@page import="com.gump.vo.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>公告</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="/gump-oa/html/script/jquery.js"></script>
<script language="javascript" src="/gump-oa/html/script/pageCommon.js"
	charset="utf-8"></script>
<script language="javascript" src="/gump-oa/html/script/PageUtils.js"
	charset="utf-8"></script>
<script language="javascript" src="/gump-oa/html/script/DemoData.js"
	charset="utf-8"></script>
<script language="javascript"
	src="/gump-oa/html/script/DataShowManager.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="/gump-oa/html/style/blue/pageCommon.css" />

</head>
<body>
	<div id="Title_bar_Head">
		<div id="Title_Head"></div>
		<div id="Title">
			<!--页面标题-->
			<img border="0" width="13" height="13"
				src="/gump-oa/html/style/images/title_arrow.gif" /> 公告查询
		</div>
		<div id="Title_End"></div>
	</div>
	<div id="MainArea">
		<s:property value="page.currentPage"/>
		<s:form theme="simple">
			<table cellspacing="0" cellpadding="0" class="TableStyle">
				<!-- 表头-->
				<thead>
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">
						<th width="20px">公告编号</th>
						<th width="115px">公告标题</th>
						<th width="115px">发布内容</th>
						<th width="30px">发布人</th>
						<th width="100px">发布时间</th>
						<th width="30px">相关操作</th>
					</tr>
					
				</thead>
				<tbody id="TableData">
					<!-- 正在审批或审批完成的表单显示示例 -->
					<s:iterator value="page.data" var="nots">
			            <tr class="TableDetail1 template">
			                <td><s:property value="#nots.notId"/></td>
							<td><s:property value="#nots.notTitle"/></td>
							<td><s:property value="#nots.notContent"/></td>
			                <td><s:property value="#nots.notSender"/></td>
   							<td><s:property value="#nots.notDate"/></td>
			            </tr>
		            </s:iterator>
				</tbody>
			</table>
			<a href="NoticeSystem/NoticeAdd.jsp">添加公告</a>
			</s:form>
	</div>

<!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>
		页次：<s:property value="page.currentPage"/>/<s:property value="page.pageTotal"/>页 &nbsp;
		每页显示：<s:property value="page.pageSize"/>条 &nbsp;
		总记录数：<s:property value="page.count"/>条
	</div>
	<div id=PageSelectorSelectorArea>
    	<a href="na!execute?noticeCurrent=<s:property value="1"/>" ><img src="/gump-oa/staff/style/blue/images/pageSelector/firstPage.png"/></a>
    	<a href="na!execute?noticeCurrent=<s:property value="page.currentPage-1"/>" >上一頁</a>
    	<a href="na!execute?noticeCurrent=<s:property value="page.currentPage+1"/>" >下一頁</a>
    	<a href="na!execute?noticeCurrent =<s:property value="page.pageTotal"/>" ><img src="/gump-oa/staff/style/blue/images/pageSelector/lastPage.png"/></a>
	</div>
</div>

</body>
</html>