package com.gump.dao;

import java.util.List;

import com.gump.vo.Employee;

/**
 * 员工的Dao层接口
 * @author Administrator
 *
 */
public interface IEmployeeDao {

	/**
	 * 获得所有员工信息
	 * @return
	 */
	List<Employee> getAllEmp();

	/**
	 * 通过ID获得员工信息
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

}
