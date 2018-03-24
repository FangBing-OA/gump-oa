package com.gump.action;

import java.util.List;

import com.gump.service.IEmployeeService;
import com.gump.service_impl.EmployeeServiceImpl;
import com.gump.vo.Employee;

/**
 * 操作员工的Action
 * @author Administrator
 *
 */
public class EmployeeAction {
	//员工对象
	private Employee emp;
	//员工对象集合
	private List<Employee> emps;
	
	private IEmployeeService iEmployeeService = new EmployeeServiceImpl();
	
	
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	/**
	 * 获得所有员工信息
	 * @return
	 */
	public String getAllEmp(){
		//调用service层的方法
		setEmps(iEmployeeService.getAllEmp());
		return "empList";
	}
	
	/**
	 * 通过ID获得员工
	 * @param empId
	 * @return
	 */
	public String getEmpById(int empId){
		setEmp(iEmployeeService.getEmpById(empId));
		return "toEdit";
	}
	
	/**
	 * 更新员工信息
	 * @param emp
	 * @return
	 */
	public String doUpdate(Employee emp){
		iEmployeeService.doUpdate(emp);
		return "empList";
	}
	
	/**
	 * 跳转到新增员工的页面
	 * @return
	 */
	public String toAdd(){
		return "toAdd";
	}
	
	/**
	 * 新增员工
	 * @return
	 */
	public String doAdd(Employee emp){
		//调用service层的方法
		iEmployeeService.doAdd(emp);
		//获得所有的员工
		setEmps(iEmployeeService.getAllEmp());
		return "empList";
	}
	
	/**
	 * 删除员工
	 * @param empId
	 * @return
	 */
	public String doDelete(int empId){
		//调用service层的方法
		iEmployeeService.doDelete(empId);
		//获得所有的员工
		setEmps(iEmployeeService.getAllEmp());
		return "empList";
	}
}
