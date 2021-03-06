<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>用户信息</title>
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

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
      <form action="ea!doGx?currentPage=1" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="../style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
     
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">所属部门</td>
                        <td><select name="emp.empDepId" class="SelectStyle">
                                <s:iterator value="#request.lists" var="list">                             
                                <option value="<s:property value="#list.depId"/>"><s:property value="#list.depName"/></option>
                                </s:iterator>
                            </select> 
                        </td>
                    </tr>
                     <tr><td width="100">职位</td>
                        <td><select name="emp.empPosId" class="SelectStyle">
                           <s:iterator value="#request.listposs" var="listpos">                             
                                <option value="<s:property value="#listpos.posId"/>"><s:property value="#listpos.posName"/></option>
                                </s:iterator>
                            </select> 
                        </td>
                    </tr>
                    <tr><td>登录账号</td>
                       
                        <td><input type="text" name="emp.empAccount" class="InputStyle" value="<s:property value="#emp.empAccount"/>"/> *
							（登录账号要唯一）
							<input type="hidden" name="emp.empId"  value="<s:property value="#emp.empId"/>">
						</td>
                    </tr>
                    <tr><td>姓名</td>
                        <td><input type="text" name="emp.empName" class="InputStyle" value="<s:property value="#emp.empName"/>"/> *</td>
                    </tr>
					<tr><td>性别</td>
                        <td><input type="RADIO" name="emp.empSex" value="男" id="male"/><label for="male">男</label>
							<input type="RADIO" name="emp.empSex" value="女" id="female"/><label for="female">女</label>
						</td>
                    </tr>
					<tr><td>联系电话</td>
                        <td><input type="text" name="emp.empTel" class="InputStyle" value="<s:property value="#emp.empTel"/>"/></td>
                    </tr>
                    <tr><td>年龄</td>
                        <td><input type="text" name="emp.empAge" class="InputStyle" value="<s:property value="#emp.empAge"/>"/></td>
                    </tr>
                    <tr><td>备注</td>
                        <td><textarea name="description" class="TextareaStyle"></textarea></td>
                    </tr>
                </table>
               
            </div>
        </div>
        
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="../style/blue/images/item_point.gif" /> 岗位设置 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
 
            </div>
        </div>		
		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="submit" value="提交"> 
        </div>
    </form>
</div>

<div class="Description">
	说明：<br />
	1，用户的登录名要唯一，在填写时要同时检测是否可用。<br />
	2，新建用户后，密码被初始化为"1234"。<br />
	3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br />
	4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	6，修改用户信息时，登录名不可修改。
</div>

</body>
</html>
