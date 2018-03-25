package com.gump.action;

import com.gump.dao_impl.DepartmentImpl;
import com.gump.service.IEmployeeService;
import com.gump.service.IPositionService;
import com.gump.service_impl.EmployeeServiceImpl;
import com.gump.service_impl.PositionServiceImpl;
import com.gump.vo.Employee;
import com.opensymphony.xwork2.ActionContext;

public class EditEmployeeInfoAction {
	private IPositionService poService = new PositionServiceImpl();
	private DepartmentImpl departDao = new DepartmentImpl();
	private IEmployeeService empService = new EmployeeServiceImpl();
	//自动注入
	private Employee employee;
	private String positionName;
	private String departmentName;

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
		context.put("positionName",poService.selectPositionById(employee.getEmpPosId()));
		context.put("departmentName", departDao.selectDepartmentById());
		return "editUserInfoUI";
	}
	
	/**
	 * 修改当前用户的个人信息
	 * @return
	 * @throws Exception
	 */
	public String modifyEmployeeInfo() throws Exception {
		employee.setEmpPosId(poService.selectPositionByName(positionName).getPosId());
		employee.setEmpDepId(departDao.selectDepartmentByName().getDepId());
		empService.doUpdate(employee);
		
		return "editUserInfoUI";
	}
}
