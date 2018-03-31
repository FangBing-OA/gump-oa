<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
    <title>我的申请查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="/gump-oa/staff/script/jquery.js"></script>
    <script language="javascript" src="/gump-oa/staff/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/staff/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/staff/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="/gump-oa/staff/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="/gump-oa/staff/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>

    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="/gump-oa/staff/style/images/title_arrow.gif"/> 公文查询
        </div>
        <div id="Title_End"></div>
    </div>
</div>


<div id="QueryArea">
	<div style="height: 30px">
		<form action="da!inquery">
		<table border=0 cellspacing=3 cellpadding=5>
			<tr>
				<td>按公文关键字查询：</td>
				<td><input type="text" name="keyword"/>
				</td>
				<td><a href=""><input type="IMAGE" src="/gump-oa/staff/style/blue/images/button/query.PNG"/></a></td>
			</tr>
		</table>
		</form>
	</div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td width="115px">公文接收者</td>
				<td width="115px">公文主题</td>
				<td width="115px">公文时间</td>
				<td width="115px">附件名</td>
				<td width="50px">操作</td>
			</tr>
		</thead>	
				
		

		<!--显示数据列表：正在审批或审批完成的表单显示示例-->
        <tbody id="TableData" datakey="formList">
			
			<!-- 正在审批或审批完成的表单显示示例 -->
			<s:iterator value="docList" var="doc">
			<tr align="center">
				<td width="115px"><s:property value="#doc.docReceiver"/></td>
				<td width="115px"><s:property value="#doc.docTitle"/></td>
				<td width="115px"><s:property value="#doc.docTime"/></td>
				<td width="115px"><a href="/gump-oa/da!download.action?fileName=<s:property value="#doc.fileName"/>"><s:property value="#doc.fileName"/></a></td>
				<td width="50px"><a onClick="return window.confirm('这将删除这条公文，确定吗？')" href="/gump-oa/da!remove.action?docId=<s:property value="#doc.docId"/>">删除</a>
					<a  href="/gump-oa/da!modify.action?docId=<s:property value="#doc.docId"/>">修改</a>
					
				</td>
			</tr>
			</s:iterator>
        </tbody>	
    </table>
    
    <!-- 其他功能超链接 -->
     <div id="TableTail">
        <div id="TableTail_inside">
            <a href="/gump-oa/da!newAdd.action"><img src="/gump-oa/staff/style/images/createNew.png" /></a>
        </div>
    </div>
    
    <a href="/gump-oa/da!pageMethod?g=<s:property value="page.currentPage-1"/>" title="上一页" style="cursor: hand; padding-left:900px">
			<img src="/gump-oa/staff/style/blue/images/pageSelector/firstPage.png"/></a>
    <a href="/gump-oa/da!pageMethod?g=<s:property value="page.currentPage+1"/>" title="下一页" style="cursor: hand; padding-left: 10px">
			<img src="/gump-oa/staff/style/blue/images/pageSelector/lastPage.png"/></a>
</div>




</body>
</html>
