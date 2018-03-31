package com.gump.dao_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gump.dao.IEmployeeDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Employee;
import com.gump.vo.FindEmployee;

/**
 * 员工的dao层接口的实现类
 * @author Administrator
 *
 */
public class EmployeeDaoImpl implements IEmployeeDao {
	//获得连接的数据源
	DataSource ds = PoolFactory.getDS();
	/**
	 * 根据部门id得到员工表中部门所有的人数
	 * 传入值为部门id为int型
	 * 返回值为一个int型 返回的为员工数
	 * 方法名为countEmpByDepId
	 */
	public Integer countEmpByDepId(int depid)
	{
		try {
			//获得连接对象
			Connection conn = ds.getConnection();
			//进入查询
		//	System.out.println("进入dao层查询");
			String sql="select * from employee where empDepId =?";
			List<Employee> emps = new QueryRunner().query(conn,sql,new BeanListHandler<Employee>(Employee.class),depid);
			int count=emps.size();
			System.out.println("根据id查询到的部门人数"+count);
			//return emps;
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据部门id值确定员工表中是否还有员工
	 * 传入值为部门id为int型
	 * 返回值为一个boolean值 返回true代表有员工 返回false代表没有员工
	 * 方法名:bEmpByDepId
	 */
	public boolean  bEmpByDepId(int depid)
	{
		
			//获得连接对象
			Connection conn = null;
			try {
				conn = ds.getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//进入查询
			System.out.println("进入根据部门查询员工方法");
			String sql="select * from employee where empDepId =?";
			 Number query;
			try {
				query = (Number) new QueryRunner().query(conn,sql,new ScalarHandler<>(),depid);
				System.out.println("查询到的人数的部门id"+query);	
				if(query==null)
				{
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            return true;
	
	}
	/**
	 *查询所有的员工人数
	 *无传入值 
	 *返回值为int类型的员工数目
	 * @throws SQLException 
	 */
	public int countEmployee() throws SQLException
	{	
		//获得连接对象
		Connection conn = ds.getConnection();
		String sql="select * from employee";
		List<Employee> emps=new QueryRunner().query(conn, sql,new BeanListHandler<Employee>(Employee.class));
		int count =emps.size();
		conn.close();
		return count;
	}
	/**
	 * 获得所有的员工信息
	 */
	public List<Employee> getAllEmp() {
		try {
			//获得连接对象
			Connection conn = ds.getConnection();
			//进入查询
			List<Employee> emps = new QueryRunner().query(conn,"select * from employee",new BeanListHandler<Employee>(Employee.class));
			conn.close();
			return emps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获得所有的员工信息
	 */
	public List<Employee> getAllEmp(int currentPage) {
		try {
			//获得连接对象
			Connection conn = ds.getConnection();
			//进入查询
			System.out.println("进入dao层分页查询");
			if(currentPage<=1)
			{
				currentPage=1;
			}
			int curr=(currentPage-1)*4;
			System.out.println("curr的值"+curr);
			List<Employee> emps = new QueryRunner().query(conn,"select * from employee limit ?,4 ",new BeanListHandler<Employee>(Employee.class),curr);
			System.out.println("abcd"+emps);
			conn.close();
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
			System.out.println("empid的值为"+emp.getEmpId());
			Connection conn = ds.getConnection();
			new QueryRunner().update(conn,"update employee set empName=?,empAccount=?,empSex=?,empAge=?,empDepId=?,empPosId=?,empStatus=?,empTel=? where empId=?",emp.getEmpName(),emp.getEmpAccount(),emp.getEmpSex(),emp.getEmpAge(),emp.getEmpDepId(),emp.getEmpPosId(),emp.getEmpStatus(),emp.getEmpTel(),emp.getEmpId());
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
			new QueryRunner().update(conn,"insert into employee (empName,empAccount,empSex,empAge,empDepId,empPosId,empStatus,empTel)values(?,?,?,?,?,?,?,?)",emp.getEmpName(),emp.getEmpAccount(),emp.getEmpSex(),emp.getEmpAge(),emp.getEmpDepId(),emp.getEmpPosId(),"在职",emp.getEmpTel());
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

	public List<Employee> findByCom(String empName) throws SQLException {
	     
		//获得连接对象
		Connection conn = ds.getConnection();
		//进入查询
		System.out.println("进入联合查询");
		List<FindEmployee> findemps;
		//List<Employee> emps = null;
		try {
			String sql1="select c.empId,c.empName,c.posName,c.depName,c.empSex ,c.empAge,c.empTel from (select * from position p join (select * from (select * from employee e join department d on e.empDepId=d.depId)t )e on p.posId=e.empPosId)c  ";
			String sql2=" "+"where c.empName LIKE"+"'"+"%"+empName+"%"+"'"+" OR c.posName LIKE"+"'"+"%"+empName+"%"+"'"+" OR c.depName LIKE"+"'"+"%"+empName+"%"+"'"+" OR c.empSex LIKE"+"'"+"%"+empName+"%"+"'"+" OR c.empAge LIKE"+"'"+"%"+empName+"%"+"'"+" ";
			String sql3=sql1+sql2;
			System.out.println("关键字查询的sql语句"+sql3);			
			findemps = new QueryRunner().query(conn,sql3,new BeanListHandler<FindEmployee>(FindEmployee.class));
			List<Employee> emps =new ArrayList<Employee>();
			for(FindEmployee findemp:findemps)
			{
				//List<Employee> emps;
				Employee emp=new Employee();
				emp.setEmpAge(findemp.getEmpAge());
				//emp.setEmpDepId(findemp.getEmpId());
				emp.setEmpId(findemp.getEmpId());
				System.out.println("员工id"+findemp.getEmpId());
				emp.setEmpDepName(findemp.getDepName());
				emp.setEmpPosName(findemp.getPosName());
				emp.setEmpName(findemp.getEmpName());
				System.out.println("姓名"+findemp.getEmpName());
				emp.setEmpSex(findemp.getEmpSex());
				emp.setEmpTel(findemp.getEmpTel());
				emps.add(emp);			
			}
			System.out.println(emps);
			return emps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("abcd"+emps);
		return null;
	}
	
	/**
	 * 通过账号获得员工
	 * 
	 * @return
	 */
	public Employee getEmpByAccount(String account) {
		try {
			// 获得连接对象
			Connection conn = ds.getConnection();
			Employee emp = new QueryRunner().query(conn, "select * from employee where empAccount=?",
					new BeanHandler<Employee>(Employee.class), account);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


}
