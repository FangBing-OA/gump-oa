package com.gump.action;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.gump.commons.JudgeRole;
import com.gump.dao.IDepartmentDao;
import com.gump.dao_impl.DepartmentImpl;
import com.gump.vo.Department;

public class DepartmentAction  implements Serializable{
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public String depList(){
		IDepartmentDao d = new DepartmentImpl(); 
		List<Department> list=d.selectdep();
		request.setAttribute("li", list);
		ServletActionContext.getRequest().getSession().setAttribute("lii",list);
		if(JudgeRole.isAdmin()){
			return "toadminlist";
		}else{
			return "tostafflist";
		}
	}
	
	public String addDep(){
		Department de =new Department();
		de.setDepName(department.getDepName());
		de.setDepNum(department.getDepNum());
		de.setDepDescribe(department.getDepDescribe());
		IDepartmentDao dep=new DepartmentImpl();
		dep.addDep(de);
		return "success1";
	}
	
	
	public String updateDep(){
		String depName=(String) ServletActionContext.getRequest().getSession().getAttribute("departmentName");
		
		Department de =new Department();
		de.setDepName(department.getDepName());
		de.setDepNum(department.getDepNum());
		de.setDepDescribe(department.getDepDescribe());
		IDepartmentDao dep=new DepartmentImpl();
		dep.nameupdatedepDescribe(de, depName);
		return "success1";
	}
	
	public String getName(){
		String depName=(String) request.getParameter("department.depName");
		IDepartmentDao ddo = new DepartmentImpl();
		setDepartment(ddo.selectDepartmentByName(depName));
		ServletActionContext.getRequest().getSession().setAttribute("departmentName",depName);
		return "success3";
	}
	
	public String selectByName(){
		String depName=request.getParameter("department.depName");
		IDepartmentDao ddo = new DepartmentImpl();
		setDepartment(ddo.selectDepartmentByName(depName));
		return "success4";
	}
	public String selectById(){
		int depId=Integer.valueOf(request.getParameter("department.depId"));
		IDepartmentDao ddo = new DepartmentImpl();
		setDepartment(ddo.selectDepartmentById(depId));
		if(JudgeRole.isAdmin()){
			return "toadminlistsel";
		}else{
			return "tostafflistsel";
		}
	}

	public String deleteDep(){
		String depName=request.getParameter("department.depName");
		System.out.print(depName);
		IDepartmentDao ddo = new DepartmentImpl();
		ddo.namedrop(depName);
		return "success1";
	}
}