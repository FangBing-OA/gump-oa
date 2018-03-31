package com.gump.action;

import com.gump.dao.IDepartmentDao;
import com.gump.dao.IEmployeeDao;
import com.gump.dao_impl.DepartmentImpl;
import com.gump.dao_impl.EmployeeDaoImpl;
import com.gump.service.IEmployeeService;
import com.gump.service.IPositionService;
import com.gump.service_impl.EmployeeServiceImpl;
import com.gump.service_impl.PositionServiceImpl;
import com.gump.vo.Employee;
import com.opensymphony.xwork2.ActionContext;

public class EditEmployeeInfoAction {
	private IPositionService poService = new PositionServiceImpl();
	private IDepartmentDao departDao = new DepartmentImpl();
	private IEmployeeService empService = new EmployeeServiceImpl();
	//自动注入
	private Employee employee;
	private int empId;
	private String positionName;
	private String departmentName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	/**
	 * 将当前登录用户的所有个人信息取出来
	 * @return
	 * @throws Exception
	 */
	public String showEmployeeInfo() throws Exception {
		
		ActionContext context = ActionContext.getContext();
		employee = (Employee) context.getSession().get("account");
		setEmployee(employee);
		setDepartmentName(departDao.selectDepartmentById(employee.getEmpDepId()).getDepName());
		setPositionName(poService.getPositionById(employee.getEmpPosId()).get(0).getPosName());
		return "showempinfo";
	}
	
	/**
	 * 修改当前用户的个人信息
	 * @return
	 * @throws Exception
	 */
	public String modifyEmployeeInfo() throws Exception {
		IEmployeeDao iEmployeeDao = new EmployeeDaoImpl();
		// 通过员工ID获得员工信息
		Employee emp = iEmployeeDao.getEmpById(empId);
		setEmployee(emp);
		// 获得该员工的部门名称
		setDepartmentName(departDao.selectDepartmentById(employee.getEmpDepId()).getDepName());
		// 获得该员工的职位信息
		setPositionName(poService.getPositionById(employee.getEmpPosId()).get(0).getPosName());
		
		return "editUserInfoUI";
	}
	
	/**
	 * 保存修改
	 * @return
	 */
	public String saveEmp(){
		IEmployeeDao iEmployeeDao = new EmployeeDaoImpl();
		iEmployeeDao.doUpdate(employee);
		return "showempinfo";
	}
}
