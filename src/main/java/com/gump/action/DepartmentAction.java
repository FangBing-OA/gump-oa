package com.gump.action;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.gump.commons.JudgeRole;
import com.gump.dao.IDepartmentDao;
import com.gump.dao_impl.DepartmentImpl;
import com.gump.dao_impl.EmployeeDaoImpl;
import com.gump.service.IEmployeeService;
import com.gump.service_impl.EmployeeServiceImpl;
import com.gump.vo.Department;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport{
	IDepartmentDao dep=new DepartmentImpl();
	IDepartmentDao ddo=new DepartmentImpl();
	
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void validateAddDep() {
		IDepartmentDao dao=new DepartmentImpl();
		List<Department> list=dao.selectdep();
		if(department==null||department.getDepName()==null||department.getDepName().equals("")){
			return;
		}else{
		for(int i=0;i<list.size();i++){
			if(department.getDepName().equals(list.get(i).getDepName())){
				this.addFieldError("depName.forminput", getText("部门名称已经存在，请更换！！！"));
			}
		}
		super.validate();
		}
	}
	
	public String depList(){
		List<Department> list=ddo.selectdep();
		request.setAttribute("li", list);
		ServletActionContext.getRequest().getSession().setAttribute("lii",list);
		if(JudgeRole.isAdmin()){
			return "toadminlist";
		}else{
			return "tostafflist";
		}
	}
	public String addDep(){
		dep.addDep(department);
		return "success1";
	}
	
	
	public String updateDep(){
		String depName=(String) ServletActionContext.getRequest().getSession().getAttribute("departmentName");
		dep.nameupdatedepDescribe(department, depName);
		return "success1";
	}
	
	public String getName(){
		String depName=(String) request.getParameter("department.depName");
		setDepartment(ddo.selectDepartmentByName(department.getDepName()));
		ServletActionContext.getRequest().getSession().setAttribute("departmentName",depName);
		return "success3";
	}
	
	public String selectByName(){
		setDepartment(ddo.selectDepartmentByName(department.getDepName()));
		return "success4";
	}
	
	public String selectById(){
		setDepartment(ddo.selectDepartmentById(department.getDepId()));
		if(JudgeRole.isAdmin()){
			return "toadminlistsel";
		}else{
			return "tostafflistsel";
		}
	}
	
	/**
	 * 删除部门
	 * @return
	 */
	public String deleteDep(){
		String depName=request.getParameter("department.depName");
		Department department=ddo.selectDepartmentByName(depName);
		int depid=department.getDepId();
		//查看是否有员工；有员工就不删除，没有员工就删除
		IEmployeeService emp=new EmployeeServiceImpl();
		if(emp.bEmpByDepId(depid)){
			List<Department> list=ddo.selectdep();
			request.setAttribute("li", list);
			super.addActionError("<script type='text/javascript'>alert('部门删除失败');</script>");
			/*super.addActionError("部门删除失败");*/
		/*	this.addActionMessage(aMessage);  */
			return "toadminlist";
		}else{
		ddo.namedrop(depName);
		return "success1";
		}
	}
	
}