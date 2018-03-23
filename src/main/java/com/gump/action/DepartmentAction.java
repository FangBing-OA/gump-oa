package com.gump.action;

import com.gump.vo.Department;

public class DepartmentAction {
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public String execute(){
		return "success";
	}

}
