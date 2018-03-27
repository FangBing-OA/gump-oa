package com.gump.dao;

import java.sql.SQLException;
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
	/**
	 * 根据员工姓名和部门名称查询人数
	 * @throws SQLException 
	 */
	List<Employee> findByCom(String empName,int empDepId) throws SQLException;

	/**
	 * 通过账号获得员工信息
	 * @return
	 */
	
	Employee getEmpByAccount(String account);
}
