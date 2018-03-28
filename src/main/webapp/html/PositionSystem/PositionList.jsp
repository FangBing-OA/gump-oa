<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>我的申请查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="/gump-oa/html/script/jquery.js"></script>
    <script language="javascript" src="/gump-oa/html/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="/gump-oa/html/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="/gump-oa/html/style/blue/pageCommon.css" />
    <script type="text/javascript">
    function qq(){
    	var id=document.getElementById("id");
    	if(id.value=="111"){
    		alert("请选择职位！");
    		return false;
    	}
    	
    }
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
		<s:form action="pa!getPositionById" theme="simple" onsubmit="return qq()">
			<s:select list="listName" listKey="posId" listValue='posName' name="position.posId" id="id" headerKey="111" headerValue="---请选择职位---" theme="simple" label="按职位名称查询"/>
			<s:submit  type="image" src="/gump-oa/html/style/blue/images/button/query.PNG"/>
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
		<!--显示数据列表：正在审批或审批完成的表单显示示例-->
        <tbody id="TableData" class="dataContainer" >
			<!-- 正在审批或审批完成的表单显示示例 -->
			<s:iterator value="positionList" var="pos"> 
			  <s:form action="pa!goUpdatePositionPage" theme="simple">
			   
				<tr>
				    <td align="center"><s:textfield name="position.posId" value='%{posId}' cssStyle="border: 0px red solid; text-align:center; background:#F3F9FD"/></td>
					<td align="center"><s:textfield name="position.posName" value='%{posName}' cssStyle="border: 0px red solid; text-align:center;  background:#F3F9FD"/> </td>
					<td align="center"><s:textfield name="position.posDescribe" value='%{posDescribe}' cssStyle="border: 0px red solid; text-align:center;  background:#F3F9FD"/></td>
					<td align="center"><a onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" href="pa!removePosition?position.posId=<s:property value='%{posId}'/>">删除</a>
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
            <a href="pa!goAddPositionPage"><img src="/gump-oa/html/style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>
		页次：<s:property value='page.currentPage'/>/<s:property value='page.pageTotal'/>页 &nbsp;
		每页最多显示：<s:property value='page.pageSize'/>条 &nbsp;
		总记录数：<s:property value='page.count'/>条
	</div>
	<div id=PageSelectorSelectorArea>
		<a href="pa!listPosition?g=<s:property value='page.currentPage-1'/>"  name="first" title="上一页" style="cursor: hand;">
			<img src="/gump-oa/html/style/blue/images/pageSelector/firstPage.png"/></a>
		<a href="pa!listPosition?g=<s:property value='page.currentPage+1'/>" name="last"  title="下一页" style="cursor: hand;">
			<img src="/gump-oa/html/style/blue/images/pageSelector/lastPage.png"/></a>
	</div>
</div>
</body>
</html>
