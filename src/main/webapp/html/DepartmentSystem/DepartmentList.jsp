<%@page import="com.gump.vo.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.gump.dao_impl.DepartmentImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>我的申请查询</title>
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
<script type="text/javascript">
	function select(){
	    var id=document.getElementById("selectId");
	    if(id.value==123){
	    	alert("请选择部门");
	    	return false;
	    }
	}
</script>
</head>
<body>
	<div id="Title_bar_Head">
		<div id="Title_Head"></div>
		<div id="Title">
			<!--页面标题-->
			<img border="0" width="13" height="13"
				src="/gump-oa/html/style/images/title_arrow.gif" /> 部门查询
		</div>
		<div id="Title_End"></div>
	</div>
	<div id="QueryArea">
		<div style="height: 30px; float: left">
			<form action="DepartmentAction!selectById" method="post" onsubmit="return select();">
			
			<%-- <s:textfield name="department.depName">按部门名称查询：</s:textfield> --%>
			
				<s:select list="#request.li" name="department.depId" id="selectId" 
				theme="simple" listKey="depId" listValue="depName"
				 headerKey="123" headerValue="--请选择查询部门--" >按部门名称查询：</s:select>
				
				<s:submit type="image"
					src="/gump-oa/html/style/blue/images/button/query.PNG"
					theme="simple"></s:submit>
			</form>
		</div>
		<div style="height: 30px; float: left">&nbsp;&nbsp;&nbsp;</div>
		<div style="height: 30px; float: left">
			<%-- <form action="DepartmentAction!selectById" method="post">
				<s:textfield name="department.depId" theme="simple">按id查询：</s:textfield>
				<s:submit type="image"
					src="/gump-oa/html/style/blue/images/button/query.PNG"
					theme="simple"></s:submit>
				<!-- 			<input type="IMAGE" src="../style/blue/images/button/query.PNG"/> -->
			</form> --%>
		</div>

	</div>
	<div id="MainArea">
		<s:form action="DepartmentAction" method="post">
			<table cellspacing="0" cellpadding="0" class="TableStyle">
				<!-- 表头-->
				<thead>
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">
						<th width="50px">部门编号</th>
						<th width="115px">部门名称</th>
						<th width="115px">部门人数</th>
						<th width="115px">部门描述</th>
						<th width="115px">相关操作</th>
					</tr>
				</thead>
				<tbody id="TableData">
					<!-- 正在审批或审批完成的表单显示示例 -->
					<s:iterator value="#request.li" var="de" status="index">
						<tr class="TableDetail1 template" align="center">
							<td><s:property value="#index.index+1" /></td>
							<td><s:property value="#de.getDepName" /></td>
							<td><s:property value="#de.getDepNum" /></td>
							<td><s:property value="#de.getDepDescribe" /></td>
							<td><a
								onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')"
								href="DepartmentAction!deleteDep?department.depName=<s:property value="#de.getDepName"/>">删除</a>
								<a
								href="DepartmentAction!getName?department.depName=<s:property value="#de.getDepName"/>">修改</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:form>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="html/DepartmentSystem/DepartmenAdd.jsp"><img
					src="/gump-oa/html/style/images/createNew.png" /></a>
			</div>
		</div>
	</div>

	<%-- <!--分页信息-->
	<div id=PageSelectorBar>
		<div id=PageSelectorMemo>页次：7/13页 &nbsp; 每页显示：30条 &nbsp;
			总记录数：385条</div>
		<div id=PageSelectorSelectorArea>
			<!--
		<IMG SRC="../style/blue/images/pageSelector/firstPage2.png"/>
		-->
			<a href="javascript:void(0)" title="首页" style="cursor: hand;"> <img
				src="/gump-oa/html/style/blue/images/pageSelector/firstPage.png" /></a>

			<span class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">3</span> <span class="PageSelectorNum"
				style="cursor: hand;" onClick="gotoPageNum(2);">4</span> <span
				class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">5</span> <span class="PageSelectorNum"
				style="cursor: hand;" onClick="gotoPageNum(2);">6</span> <span
				class="PageSelectorNum PageSelectorSelected">7</span> <span
				class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">8</span> <span class="PageSelectorNum"
				style="cursor: hand;" onClick="gotoPageNum(2);">9</span> <span
				class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">10</span> <span class="PageSelectorNum"
				style="cursor: hand;" onClick="gotoPageNum(2);">11</span> <span
				class="PageSelectorNum" style="cursor: hand;"
				onClick="gotoPageNum(2);">12</span>

			<!--
		<IMG SRC="../style/blue/images/pageSelector/lastPage2.png"/>
		-->
			<a href="#" title="尾页" style="cursor: hand;"> <img
				src="/gump-oa/html/style/blue/images/pageSelector/lastPage.png" /></a>

			转到： <input onFocus="this.select();" maxlength="2" class="inputStyle"
				type="text" value="1" name="currPage" tabindex="0" /> <input
				type="submit" name="goBtn" value="Go" class="MiddleButtonStyle" />
		</div>
	</div> --%>

	<div class="Description">
		说明：<br />
		
	1，对于退回的表单，可以执行“修改后再次提交”与“删除”的操作。<br />&nbsp;&nbsp;
	   其他状态表单（正在审批的或是审批完成的）则没有这两个操作。<br />
	2，删除退回的申请文档后，此文档相关的审批信息也要同时删除，对应的流程也终止了。<br />
	   
	</div>

</body>
</html>