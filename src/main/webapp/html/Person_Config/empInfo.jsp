<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>个人信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="http://localhost:8080/gump-oa/html/script/jquery.js"></script>
    <script language="javascript" src="http://localhost:8080/gump-oa/html/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="http://localhost:8080/gump-oa/html/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="http://localhost:8080/gump-oa/html/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="http://localhost:8080/gump-oa/html/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="http://localhost:8080/gump-oa/html/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="http://localhost:8080/gump-oa/html/style/images/title_arrow.gif"/> 个人信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="../System_User/list.html" enctype="multipart/form-data">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 个人信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
                        <td width="150">账号</td>
                        <td><s:property value='employee.empAccount'/></td>
						<td rowspan="5" align="right">
							<img src="http://localhost:8080/gump-oa/html/style/images/defaultAvatar.gif"/>
						</td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td><s:property value='employee.empName'/></td>
                    </tr>
					<tr>
                        <td>性别</td>
                        <td><s:property value='employee.empSex'/></td>
                    </tr>
					<tr>
                        <td>年龄</td>
                        <td><s:property value='employee.empAge'/></td>
                    </tr>
					<tr>
                        <td>部门</td>
                        <td><input type="hidden" name="employee.empDepId" value="<s:property value='employee.empDepId'/>">
                        	<s:property value='departmentName'/></td>
                    </tr>
					<tr>
                        <td>职位</td>
                        <td><input type="hidden" name="employee.empPosId" value="<s:property value='employee.empPosId'/>">
                        	<s:property value='positionName'/></td>
                    </tr>
					<tr>
                        <td>状态</td>
                        <td><s:property value='employee.empStatus'/></td>
                    </tr>
					<tr>
                        <td>电话</td>
                        <td><s:property value='employee.empTel'/></td>
                    </tr>
                </table>
            </div>
        </div>
       
        <!-- 表单操作 -->
        <div id="InputDetailBar">
        	<a href="EditEmployeeInfoAction!modifyEmployeeInfo?empId=<s:property value='employee.empId'/>">修改个人信息</a>
            <input type="image" src="../style/images/save.png"/>
            <!-- 点击保存执行editUserInfoUI的modifyEmployeeInfo方法 -->
            <a href="/gump-oa/editUserInfoUI_modifyEmployeeInfo.action"><img src="http://localhost:8080/gump-oa/html/style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
	验证规则：<br />
	1，可以修改自已的头像，在右侧是头像的预览。<br />
</div>

</body>
</html>
