package com.gump.dao_impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.gump.dao.DepartmentDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Department;

public class DepartmentImpl implements DepartmentDao {
	DataSource ds= PoolFactory.getDS();
	//查看所有部门
	
	public List<Department> selectdep() {
		String sql = "select * from department";
		try {
			return new QueryRunner(ds).query(sql,new BeanListHandler<Department>(Department.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据部门名字查看部门信息
	public Object[] namequert(String depName) {
		String sql = "select * from department where depName=?";
		try {
			return new QueryRunner(ds).query(sql, new ArrayHandler(),depName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据部门id查看部门信息
	public Object[] idquert(int id) {
		String sql = "select * from department where depId=?";
		try {
			return new QueryRunner(ds).query(sql, new ArrayHandler(),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据id删除某部门////-------------------------------
	public int iddrop(int depId) {
		int result=0;
		String sql = "delete from department where depId=?";
		try {
			result = new QueryRunner(ds).update(sql,depId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//根据name删除某部门
	public int namedrop(String depName) {
		String sql = "delete from department where depName=?";
		int result=0;
		try {
			result = new QueryRunner(ds).update(sql,depName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	//增加某部门
	public int addDep(Department department) {
		String sql = "insert into department(depName,depDescribe,depNum) values(?,?,?)";
		int result=0;
		try {
			result = new QueryRunner(ds).update(sql,department.getDepName(),department.getDepDescribe(),department.getDepNum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//根据部门名字修改部门描述
	public int nameupdatedepDescribe(Department d , String depName) {
		String sql="update department set depDescribe=?,depName=?,depNum=? where depName = ?";
		int result=0;
		try {
			result = new QueryRunner(ds).update(sql,d.getDepDescribe(),d.getDepName(),d.getDepNum(),depName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//根据部门id修改部门描述
		public int idupdatedepDescribe(Department d , int depId) {
			String sql="update department set depDescribe=?,depName=?,depNum=? where depId = ?";
			int result=0;
			try {
				result = new QueryRunner(ds).update(sql,d.getDepDescribe(),d.getDepName(),d.getDepNum(),depId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}


	//减少部门人数
	public int deletenum(int id) {
		String sql = "update department set depNum = depNum-1 where depId = ?";
		int result=0;
		try {
			result = new QueryRunner(ds).update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	//增加部门人数
	public int addnum(int id) {
		String sql = "update department set depNum=depNum+1 where depId = ?";
		int result=0;
		try {
			result = new QueryRunner(ds).update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		}
}
