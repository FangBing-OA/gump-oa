package com.gump.dao_impl;

import com.gump.vo.Department;

public class DepartTestAction {
	private Department dep;

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}
	
	
	public String execute(){
		return "success";
	}

}
