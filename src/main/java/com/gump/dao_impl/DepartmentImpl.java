package com.gump.dao_impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gump.dao.DepartmentDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Department;

public class DepartmentImpl implements DepartmentDao {
	DataSource ds= PoolFactory.getDS();
	//查看所有部门
	public List<Department> selectdep() {
		String sql = "select * from Department";
		try {
			return new QueryRunner(ds).query(sql,new BeanListHandler<Department>(Department.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
				
	}
	
	//根据部门名字查看部门信息
	public Department namequert(Department d) {
		String sql = "select * from Department where depName=?";
		try {
			return new QueryRunner(ds).query(sql, new BeanHandler<Department>(Department.class),d.getDepName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据部门名字查看部门信息
	public Department idquert(Department d) {
		String sql = "select * from Department where depId=?";
		try {
			return new QueryRunner(ds).query(sql, new BeanHandler<Department>(Department.class),d.getDepId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//根据id删除某部门
	public int iddrop(int depId) {
		int result=0;
		String sql = "delete from Department where depId=?";
		try {
			result = new QueryRunner().update(sql,depId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//根据name删除某部门
	public int namedrop(String depName) {
		String sql = "delete from Department where depName=?";
		int result=0;
		try {
			result = new QueryRunner().update(sql,depName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	//增加某部门
	public int addDep(Department department) {
		String sql = "insert into Department(depName,depDescribe) values(?,?)";
		int result=0;
		try {
			result = new QueryRunner().update(sql,department.getDepName(),department.getDepDescribe());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//根据部门名字修改部门描述
	public int nameupdatedepDescribe(Department d,Department d1) {
		String sql="update Deparetment set depDescribe=?,depname=? where depName = ? or depId = ?";
		/*if(!d.getDepName().equals("")&&null!=d.getDepName()){
			sql+="depName=?";
		}
		if(0!=d.getDepId()&&!d.getDepId().equals("")){
			
		}*/
		/*depName=? and depId=?";*/
		int result=0;
		try {
			result = new QueryRunner().update(sql,d.getDepName(),d.getDepDescribe(),d1.getDepName(),d1.getDepId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
