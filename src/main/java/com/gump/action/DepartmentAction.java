package com.gump.action;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

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
		return "success";
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
		String depName=(String) request.getParameter("department.depName");
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
		return "success4";
	}

	
}


