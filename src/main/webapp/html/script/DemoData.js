<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="/gump-oa/html/style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
              <s:form action="pa!updatePosition.action">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td><s:textfield name="position.posId" value='%{position.posId}' label="职位ID" cssStyle="border: 1px #91C0E3 solid;background:#FFFFFF;"/> </td>
                    </tr>
                    <tr>
                        <td><s:textfield name="position.posName" value='%{position.posName}' label="职位名称" style="border: 1px #91C0E3 solid;background:#FFFFFF"/> </td>
                    </tr>
                    <tr>
                        <td><s:textarea name="position.posDescribe" value='%{position.posDescribe}' label="职位描述" class="TextareaStyle"></s:textarea></td>
                    </tr>
                    <tr><td><s:submit value="修改"/></td></tr>
                </table>
              </s:form>
            </div>
        </div>
        
</body>
</html>
