<%@page import="com.gump.vo.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta charset="UTF-8">
<title>公告</title>
</head>
<body>
<table width="900" border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
  <tr>
    <td>公告id</td>
    <td>公告标题</td>
    <td>发  布  内  容</td>
    <td>发布人</td>
    <td>发布时间</td>
    <td>操作</td>
  </tr>
  <%
  		List<Notice> notices = (List<Notice>)request.getAttribute("notices");
  %>
<s:iterator var="data" value="notices">
  <tr>
  	<td><s:property value="%{#data.getNotId()}"/></td>
    <td><s:property value="%{#data.getNotTitle()}"/></td>
    <td><s:property value="%{#data.getNotContent()}"/></td>
    <td><s:property value="%{#data.getNotSender()}"/></td>
    <td><s:property value="%{#data.getNotDate()}"/></td>
    <td><a href="na!delete?notId=<s:property value="%{#data.getNotId()}"/>">删除</a> <a href="na!update?notId=<s:property value="%{#data.getNotId()}"/>">修改</a>
    </td>
  </tr>
</s:iterator>
</table>
<a href="NoticeSystem/NoticeAdd.jsp">添加公告</a>
</body>
</html>
