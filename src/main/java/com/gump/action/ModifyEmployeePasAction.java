package com.gump.action;

import javax.servlet.ServletOutputStream;

import org.apache.struts2.ServletActionContext;

import com.gump.service_impl.EmployeeServiceImpl;
import com.gump.vo.Employee;
import com.opensymphony.xwork2.ActionContext;

public class ModifyEmployeePasAction {
	 private String oldPassword;
	 private String password;
	 private String password2;
	 
	 public String execute() throws Exception{
		 Employee employee = (Employee) ActionContext.getContext().getSession().get("account");
		 if (employee != null && employee.getEmpPassword().equals(oldPassword)){
			 if (password != null && password.equals(password2)){
				 employee.setEmpPassword(password);
				 new EmployeeServiceImpl().doUpdate(employee);
			 }else {
				ServletActionContext.getResponse().getWriter().write("<script type=\"text/javascript\">alert('两次密码不一致')</script>");
			}
		 }else {
			 ServletActionContext.getResponse().getWriter().write("<script type=\"text/javascript\">alert('密码不正确')</script>");
		}
		 return "modify";
	 }
}
