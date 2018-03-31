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
	     
	 <s:form theme="simple" action="ea!tofindbycom?currentPage=1" method="post">
	    <table border=0 cellspacing=3 cellpadding=5>
			<tr>
				<td>按关键字查询：</td>
				<td><s:textfield name="emp.empName"></s:textfield>
				</td>
				<td><a href="/gump-oa/ea!tofindbycom"><input type="IMAGE" src="/gump-oa/html/style/blue/images/button/query.PNG"/></a></td>
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
			<tr class="TableDetail1 template" align="center">
			   
				<td><s:property value="#emp.empName"/></td>
				<td><s:property value="#emp.empDepName"/></td>
				<td>	
				 	<s:property value="#emp.empSex"/>
				</td>
				<td><s:property value="#emp.empAge"/></td>
				<td><s:property value="#emp.empPosName"/></td>
				<td><s:property value="#emp.empTel"/></td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
     <div id="TableTail">
        <div id="TableTail_inside">
            <label>总数:  <s:property value="count"/></label>
            <label>总页数:  <s:property value="count/4+1"/></label>
            <label>当前页数:  <s:property value="currentPage"/></label>
           <a href="/gump-oa/ea!getAllEmp?currentPage=<s:property value="currentPage-1"/>">上一页</a>
           <a href="/gump-oa/ea!getAllEmp?currentPage=<s:property value="currentPage+1"/>">下一页</a>
       </div>
       <div>
      </div>
     </div>



</body>
</html>
