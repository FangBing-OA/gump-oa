<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>我的申请查询</title>
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

    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 部门查询
        </div>
        <div id="Title_End"></div>
    </div>


<div id="QueryArea">
	<div style="height: 30px">
		<s:form action="pa!listPosition" theme="simple">
			<s:textfield name="position.posName">按部门名称查询:</s:textfield>
			<s:textfield name="position.posId">按id查询</s:textfield>
			<s:submit  type="image" src="../style/blue/images/button/query.PNG"/>
		</s:form>
	</div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td width="50px">职位id</td>
				<td width="115px">职位名称</td>
				<td width="115px">职位描述</td>
				<td width="115px">相关操作</td>
			</tr>
		</thead>	
				
		<!--显示数据列表：被退回的我的表的单显示示例
		<tbody id="TableData" class="dataContainer" datakey="formList">
			-->
			<!-- 被退回的我的表的单显示示例 
			<tr class="TableDetail1 template">
				<td><a href="../Flow_Formflow/showForm.html">${form.title}</a></td>
				<td>${form.applicant.name}&nbsp;</td>
				<td>${form.applyTime}&nbsp;</td>
				<td>审批中&nbsp;</td>
				<td><a href="../Flow_Formflow/showForm.html">查看申请信息</a>
					<a href="../Flow_Formflow/approvedHistory.html">查看流转记录</a>
					<a href="../Flow_Formflow/editAndResubmitUI.html">修改后再次提交</a>
					<a href="#" onClick="return delConfirm()">删除</a>
				</td>
			</tr>
		</tbody>
		-->

		<!--显示数据列表：正在审批或审批完成的表单显示示例-->
        <tbody id="TableData" class="dataContainer" datakey="formList">
			<!-- 正在审批或审批完成的表单显示示例 -->
			<s:iterator value="positionList" > 
			  <s:form action="pa!goUpdatePositionPage">
				<tr class="TableDetail1 template">
					<td><s:property value="posId"/></td>
					<td><s:property value="posName"/></td>
					<td><s:property value="posDescribe"/></td>
					<td><a onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" href="pa!removePosition?position.posId">删除</a>
						<s:submit value="修改"/>
					</td>
				</tr>
			  </s:form> 
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
     <div id="TableTail">
        <div id="TableTail_inside">
            <a href="saveUI.html"><img src="../style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>
		页次：<s:param value="page.currentPage"/>/<s:param value="page.pageTotal"/>页 &nbsp;
		每页显示：<s:param value="page.pageSize"/>条 &nbsp;
		总记录数：<s:param value="page.count"/>条
	</div>
	<div id=PageSelectorSelectorArea>
		<!--
		<IMG SRC="../style/blue/images/pageSelector/firstPage2.png"/>
		-->
		<s:a href="pa!listPosition"  name="page.currentPage" value="1" title="首页" style="cursor: hand;">
			<img src="../style/blue/images/pageSelector/firstPage.png"/></s:a>
		
		
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">3</span>
		
		
		
		<!--
		<IMG SRC="../style/blue/images/pageSelector/lastPage2.png"/>
		-->
		<s:a href="pa!listPosition" value="page.pageTotal" title="尾页" style="cursor: hand;">
			<img src="../style/blue/images/pageSelector/lastPage.png"/></s:a>
		
		转到：
		<s:form action="pa!listPosition"><input onFocus="this.select();" maxlength="2" class="inputStyle" type="text" value="1" name="page.currentPage" tabindex="0"/>
		<input type="submit" name="goBtn" value="Go" class="MiddleButtonStyle" /></s:form>
	</div>
</div>

<div class="Description">
	说明：<br />
	<!--
	1，对于退回的表单，可以执行“修改后再次提交”与“删除”的操作。<br />&nbsp;&nbsp;
	   其他状态表单（正在审批的或是审批完成的）则没有这两个操作。<br />
	   2，删除退回的申请文档后，此文档相关的审批信息也要同时删除，对应的流程也终止了。<br />
	   -->
</div>

</body>
</html>
