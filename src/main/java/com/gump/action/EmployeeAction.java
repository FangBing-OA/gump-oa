package com.gump.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Parameter.Request;

import com.gump.commons.JudgeRole;
import com.gump.dao.IDepartmentDao;
import com.gump.dao.IPositionDao;
import com.gump.dao_impl.DepartmentImpl;
import com.gump.dao_impl.EmployeeDaoImpl;
import com.gump.service.IEmployeeService;
import com.gump.service.IPositionService;
import com.gump.service_impl.EmployeeServiceImpl;
import com.gump.service_impl.PositionServiceImpl;
import com.gump.vo.Department;
import com.gump.vo.Employee;
import com.gump.vo.Page;
import com.gump.vo.Position;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 操作员工的Action
 * @author Administrator
 *
 */
public class EmployeeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//员工对象
	private Employee emp;
	//员工对象集合
	private List<Employee> emps;
	//员工ID
	private int empId;
	//当前页数
	private int currentPage;
	//总数
	private int count;

	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	private Page page;
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	private IEmployeeService iEmployeeService = new EmployeeServiceImpl();
	
	private EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	private IDepartmentDao ddo = new DepartmentImpl();
	
	public String execute(){
		return "empList";
	}
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
	 * 根据员工姓名和部门来查询
	 * 传入的值为员工姓名或者部门名称 
	 * 返回值为list<employee>
	 * @throws SQLException 
	 */
	public String tofindbycom() throws SQLException
	{
		 String empName=getEmp().getEmpName();
		setEmps(iEmployeeService.findByCom(empName));
	//	int count=iEmployeeService.findByCom(empName).size();
		//System.out.println("=============传过来的页数"+currentPage);
		//System.out.println("=============总页数"+count);
		//System.out.println("传过来的部门id------"+empDepId);
		
		return "tofindbycom";
	}

	/**
	 * 获得所有员工信息
	 * @return
	 * @throws SQLException 
	 */
	public String getAllEmp() throws SQLException{
		
		//调用service层的方法 此方法为查询所有的用户
               //int count=iEmployeeService.countEmpByDepId(9);
		 List<Employee> allEmps = iEmployeeService.getAllEmp(currentPage);
	//	 System.out.println("传过来的页数"+currentPage);
		 //传过来的页数currentPage
			if(currentPage<1)
			{
				currentPage=1;
			}
		   count=employeeDaoImpl.countEmployee();
		   int count1=(count/4+1);
			if(currentPage<1)
			{
				currentPage=1;
			}
			if(currentPage>count1)
			{
				currentPage=count1+1;
			}
		 Page page=new Page();
		 IPositionService ipos=new PositionServiceImpl();
		 DepartmentImpl dep=new DepartmentImpl();
		  for(Employee emp:allEmps)
		  {
			 Department depart= dep.selectDepartmentById(emp.getEmpDepId());
			 //System.out.println("部门名称++++"+depart.getDepName());
			 //depart.getDepName();
			 emp.setEmpDepName(depart.getDepName());
			 List<Position> posit = ipos.getPositionById(emp.getEmpPosId());
			 emp.setEmpPosName(posit.get(0).getPosName());
		  }
		    setEmps(allEmps);
		    page.setData(allEmps); //将page的数据
		 //   page.setPageSize(pageSize);
		   // page.setCount(count);
		    page.setCurrentPage(currentPage);  
		    setPage(page);
		    
	   // List<Employee> emps=iEmployeeService.getAllEmp();
		//ActionContext.getContext().put("emps",emps);
		if(JudgeRole.isAdmin()){
			return "toadminlist";
		}else{
			return "tostafflist";
		}
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
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	public String doUpdate(){
	   DepartmentImpl dep=new DepartmentImpl();
	   IPositionService ipos=new PositionServiceImpl();
	    List<Position> listposs=ipos.AllPosition();
	  List<Department> lists=dep.selectdep();
	  ActionContext.getContext().put("lists",lists);	
	  ActionContext.getContext().put("listposs",listposs);
		//setEmp(iEmployeeService.getEmpById(empId));
		Employee emp=iEmployeeService.getEmpById(empId);
		 //黄小强写的  下一行
		ddo.deletenum(emp.getEmpDepId());
		ActionContext.getContext().put("emp",emp);
		return "toupdate";
	}
	
	public String doGx(){
		//setEmp(iEmployeeService.getEmpById(empId));
		 iEmployeeService.doUpdate(emp);
		//黄小强写的  下一行
		 ddo.addnum(emp.getEmpDepId());
		//ActionContext.getContext().put("emp",emp);
		return "togx";
	}
	/**
	 * 跳转到新增员工的页面
	 * @return
	 */
	/*public String toAdd(){
		return "toAdd";
	}*/
	
	/**
	 * 新增员工
	 * @return
	 */
	public String doAdd(){
		//调用service层的方法

		iEmployeeService.doAdd(emp);
		 //黄小强写的  下两行
		int depId =emp.getEmpDepId();
		ddo.addnum(depId);
		
		//获得所有的员工
		setEmps(iEmployeeService.getAllEmp(currentPage));
		return "toadd";
	}
	/**
	 * 动态生成部门和职位的下拉框
	 * @return
	 */
	public String select()
	{
		DepartmentImpl dep=new DepartmentImpl();
		IPositionService ipos=new PositionServiceImpl();
	    List<Position> listposs=ipos.AllPosition();
	  List<Department> lists=dep.selectdep();
	  ActionContext.getContext().put("lists",lists);	
	  ActionContext.getContext().put("listposs",listposs);
		return "select";
	}
	
	/**
	 * 删除员工
	 * @param empId
	 * @return
	 */
	public String doDelete(){
		//调用service层的方法
		// 超链接传参数 不用<s:a>标签 参数直接在？后面接参数名 然后用<s:property>添加参数 超链接默认把参数放入到栈顶 所以要在action对象里面建立和
		//传的参数相同的私有化的属性
		
		// HttpServletRequest request=ServletActionContext.getRequest();
		//System.out.println("获取的id值"+getEmp().getEmpId());
		/*int empId=12;
		System.out.println(empId);*/
		 
		 //黄小强写的  下两行
		 int depId=iEmployeeService.getEmpById(empId).getEmpDepId();
		 ddo.deletenum(depId);
		iEmployeeService.doDelete(empId);
		/*System.out.println("进入删除方法");*/
		//获得所有的员工
		setEmps(iEmployeeService.getAllEmp(currentPage));
		return "dodelete";
	}
}
