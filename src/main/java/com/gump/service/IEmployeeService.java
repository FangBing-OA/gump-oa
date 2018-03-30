package com.gump.service;

import java.sql.SQLException;
import java.util.List;

import com.gump.vo.Employee;

/**
 * 员工的service层接口
 * @author Administrator
 *
 */
public interface IEmployeeService {

	/**
	 * 获得所有的员工信息
	 * @return
	 */
	List<Employee> getAllEmp();

	/**
	 * 通过ID获得员工
	 * @return
	 */
	Employee getEmpById(int empId);

	/**
	 * 更新员工信息
	 * @param emp
	 */
	void doUpdate(Employee emp);

	/**
	 * 新增员工
	 * @param emp
	 */
	void doAdd(Employee emp);

	/**
	 * 删除员工
	 * @param empId
	 */
	void doDelete(int empId);
	
	List<Employee> findByCom(String empName) throws SQLException;
	
	/**
	 * 通过账号获得员工
	 * @return
	 */
	Employee getEmpByAccount(String account);
}
