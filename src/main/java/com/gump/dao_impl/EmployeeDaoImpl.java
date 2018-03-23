package com.gump.dao_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gump.dao.IEmployeeDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Employee;

/**
 * 员工的dao层接口的实现类
 * @author Administrator
 *
 */
public class EmployeeDaoImpl implements IEmployeeDao {
	//获得连接的数据源
	DataSource ds = PoolFactory.getDS();
	/**
	 * 获得所有的员工信息
	 */
	public List<Employee> getAllEmp() {
		try {
			//获得连接对象
			Connection conn = ds.getConnection();
			List<Employee> emps = new QueryRunner().query(conn,"select * from employee",new BeanListHandler<Employee>(Employee.class));
			return emps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过ID获得员工
	 */
	public Employee getEmpById(int empId) {
		try {
			//获得连接对象
			Connection conn = ds.getConnection();
			Employee emp = new QueryRunner().query(conn,"select * from employee where empId=?",new BeanHandler<Employee>(Employee.class),empId);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 更新员工信息
	 */
	public void doUpdate(Employee emp) {
		try {
			//获得连接对象
			Connection conn = ds.getConnection();
			new QueryRunner().update(conn,"update employee set empName=?,empAccount=?,empSex=?,empAge=?,empDepId=?,empPosId=?,empStatus=?,empTel=?",emp.getEmpName(),emp.getEmpAccount(),emp.getEmpSex(),emp.getEmpAge(),emp.getEmpDepId(),emp.getEmpPosId(),emp.getEmpStatus(),emp.getEmpTel());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 新增员工
	 */
	public void doAdd(Employee emp) {
		try {
			//获得连接对象
			Connection conn = ds.getConnection();
			new QueryRunner().update(conn,"insert into employee (empName,empAccount,empSex,empAge,empDepId,empPosId,empStatus,empTel)values(?,?,?,?,?,?,?,?)",emp.getEmpName(),emp.getEmpAccount(),emp.getEmpSex(),emp.getEmpAge(),emp.getEmpDepId(),emp.getEmpPosId(),emp.getEmpStatus(),emp.getEmpTel());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除员工
	 */
	public void doDelete(int empId) {
		try {
			//获得连接对象
			Connection conn = ds.getConnection();
			new QueryRunner().update(conn,"delete from employee where empId=?",empId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
