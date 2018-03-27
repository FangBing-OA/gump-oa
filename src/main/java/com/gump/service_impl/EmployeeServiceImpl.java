package com.gump.service_impl;

import java.sql.SQLException;
import java.util.List;

import com.gump.dao.IEmployeeDao;
import com.gump.dao_impl.EmployeeDaoImpl;
import com.gump.service.IEmployeeService;
import com.gump.vo.Employee;

/**
 * 员工service层接口的实现类
 * @author Administrator
 *
 */
public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao iEmployeeDao = new EmployeeDaoImpl();
	
	/**
	 * 获得所有员工信息
	 */
	public List<Employee> getAllEmp() {
		return iEmployeeDao.getAllEmp();
	}
	
	/**
	 * 通过ID获得员工信息
	 */
	public Employee getEmpById(int empId) {
		return iEmployeeDao.getEmpById(empId);
	}
	
	/**
	 * 更新员工信息
	 */
	public void doUpdate(Employee emp) {
		iEmployeeDao.doUpdate(emp);
	}

	/**
	 * 新增员工
	 */
	public void doAdd(Employee emp) {
		iEmployeeDao.doAdd(emp);
	}

	/**
	 * 删除员工
	 */
	public void doDelete(int empId) {
		iEmployeeDao.doDelete(empId);
	}

	public List<Employee> findByCom(String empName, int empDepId) throws SQLException {		
		return iEmployeeDao.findByCom(empName, empDepId);
	}

	/**
	 * 通过账号查询用户并返回一个用户对象
	 */
	
	public Employee getEmpByAccount(String account) {
		// TODO Auto-generated method stub
		iEmployeeDao.getEmpByAccount(account);
		return null;
	}
}
