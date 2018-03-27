<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>我的申请查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="/gump-oa/html/script/jquery.js"></script>
    <script language="javascript" src="/gump-oa/html/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/html/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/html/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="/gump-oa/html/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="/gump-oa/html/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>

<body>
<div>
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="/gump-oa/html/style/images/title_arrow.gif"/> 员工查询
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="QueryArea">
	<div style="height: 30px">
	     
	 <s:form theme="simple" action="ea!tofindbycom" method="post">
	    <table border=0 cellspacing=3 cellpadding=5>
			<tr>
				<td>按员工姓名查询：</td>
				<td><s:textfield name="emp.empName"></s:textfield>
				</td>
				<td>按部门id查询：</td>
				<td><s:textfield name="emp.empDepId"></s:textfield>
				</td>
				<td><a href=""><input type="IMAGE" src="/gump-oa/html/style/blue/images/button/query.PNG"/></a></td>
			</tr>
		</table>    
	 </s:form>

		
	</div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">          
				<td width="115px">员工姓名</td>
				<td width="115px">员工部门名称</td>
				<td width="115px">员工性别</td>
				<td width="115px">员工年纪</td>
				<td width="115px">员工职位</td>
				<td width="115px">员工号码</td>
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
        <tbody id="TableData"  datakey="formList">
			<!-- 正在审批或审批完成的表单显示示例 -->
		    <s:iterator value="emps" var="emp">
			<tr class="TableDetail1 template">
			   
				<td><s:property value="#request.emp.empName"/></td>
				<td><s:property value="#emp.empDepId"/></td>
				<td>	
				 	<s:property value="#emp.empSex"/>
				</td>
				<td><s:property value="#emp.empAge"/></td>
				<td><s:property value="#emp.empPosId"/></td>
				<td><s:property value="#emp.empTel"/></td>
				<td><a href="/gump-oa/ea!doDelete?empId=<s:property value="#emp.empId"/>">删除
				</a>
					<a href="/gump-oa/ea!doUpdate?empId=<s:property value="#emp.empId"/>">修改</a>
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
     <div id="TableTail">
        <div id="TableTail_inside">
            <a href="html/StaffSystem/StaffAdd.jsp"><img src="/gump-oa/html/style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>
		页次：7/13页 &nbsp;
		每页显示：30条 &nbsp;
		总记录数：385条
	</div>
	<div id=PageSelectorSelectorArea>
		<!--
		<IMG SRC="../style/blue/images/pageSelector/firstPage2.png"/>
		-->
		<a href="javascript:void(0)" title="首页" style="cursor: hand;">
			<img src="../style/blue/images/pageSelector/firstPage.png"/></a>
		
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">3</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">4</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">5</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">6</span>
		<span class="PageSelectorNum PageSelectorSelected">7</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">8</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">9</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">10</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">11</span>
		<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(2);">12</span>
		
		<!--
		<IMG SRC="../style/blue/images/pageSelector/lastPage2.png"/>
		-->
		<a href="#" title="尾页" style="cursor: hand;">
			<img src="../style/blue/images/pageSelector/lastPage.png"/></a>
		
		转到：
		<input onFocus="this.select();" maxlength="2" class="inputStyle" type="text" value="1" name="currPage" tabindex="0"/>
		<input type="submit" name="goBtn" value="Go" class="MiddleButtonStyle" />
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
