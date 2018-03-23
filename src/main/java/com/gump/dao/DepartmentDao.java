package com.gump.dao;

import java.util.List;

import com.gump.vo.Department;

public interface DepartmentDao {
	//查看所有部门
	public List<Department> selectdep();
	
	//根据部门名字查看部门信息    可以根据部门的name和id
	public Department namequert(Department d); 
	
	//根据部门名字查看部门信息    可以根据部门的name和id
	public Department idquert(Department d);
	
	//删除某部门    可以根据部门的name和id
	public int iddrop(int depId);
	
	//删除某部门    可以根据部门的name和id
    public int namedrop(String depName);
	
	//增加某部门
	public int addDep(Department department);
	
	//修改部门描述  可以根据部门的name和id
	public int nameupdatedepDescribe(Department d1,Department d2);
	
	

}
