<%@page import="java.util.List"%>
<%@page import="com.gump.vo.Department"%>
<%@page import="com.gump.dao_impl.DepartmentImpl"%>
<%@page import="com.gump.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DepartmentDao de = new DepartmentImpl();
	Department d = new Department();
	Department d1 = new Department();
	d.setDepDescribe("这是管理中心");
	d.setDepName("管理部");
	d.setDepNum(57);
	de.idupdatedepDescribe(d, 1);

	List<Department> list = de.selectdep();
	System.out.print(list.get(0).getDepName());
	System.out.print(list.get(0).getDepDescribe());
	System.out.print(list.get(0).getDepNum());
	/* Object[] o= de.namequert("生产部"); 
	 de.addnum(1); 
	 System.out.println(o[0]);
	System.out.println(o[1]);
	System.out.println(o[2]);
	System.out.println(o[3]); */
/* 	List<Department> list = de.selectdep();
	System.out.print(list.get(0).getDepName());
	System.out.print(list.get(0).getDepDescribe());
	System.out.print(list.get(0).getDepNum()); */
	
%>
</body>
</html>