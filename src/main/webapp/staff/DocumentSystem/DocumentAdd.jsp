<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
	<title>用户信息</title>
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

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 添加公文
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="da!add" method="post" enctype="multipart/form-data">
        <div class="ItemBlock_Title1"><!-- 信息说明 ult><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="../style/blue/images/item_point.gif" /> 添加公文</div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                   
                    <tr><td>收件人</td>
                        <td> 
                       <select name="docReceiver">
                       <s:iterator value="employeeList" var="employee"> 
                       <option><s:property value="#employee.empName"/></option>
                       </s:iterator>                     
                       </select>
					
						</td>
                    </tr>
                    <tr><td>主题</td>
                        <td><input type="text" name="docTitle" class="InputStyle"/></td>
                    </tr>
					
				
                    <tr><td>附件</td>
                        <td><input type="file" name="img" class="InputStyle"/></td>
                    </tr>
                    
                </table>
            </div>
        </div>
        
		
		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="/gump-oa/staff/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="/gump-oa/staff/style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
	
</div>

</body>
</html>
