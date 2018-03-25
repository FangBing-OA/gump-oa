package com.gump.dao;

import java.util.List;

import com.gump.vo.Department;

public interface IDepartmentDao {
	//查看所有部门
	public List<Department> selectdep();
	
	//根据部门名字查看部门信息
	public Department selectDepartmentByName(String name); 
	
	//根据部门id查看部门信息
	public Department selectDepartmentById(int id);
	
	//删除某部门    可以根据部门的name和id
	public int iddrop(int depId);
	
	//删除某部门    可以根据部门的name和id
    public int namedrop(String depName);
	
	//增加某部门
	public int addDep(Department department);
	
	//修改部门描述  可以根据部门的name
	public int nameupdatedepDescribe(Department d1,String depName);
	
	//修改部门描述  可以根据部门的name
    public int idupdatedepDescribe(Department d1,int depId);
	
	//部门人数减少
	public int deletenum(int id);
	
	//部门人数增加
	public int addnum(int id);
	

}
