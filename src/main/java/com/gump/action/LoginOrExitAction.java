package com.gump.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gump.dao.IEmployeeDao;
import com.gump.dao.IPositionDao;
import com.gump.dao_impl.EmployeeDaoImpl;
import com.gump.dao_impl.PositionDaoImpl;
import com.gump.vo.Employee;
import com.gump.vo.Position;
import com.opensymphony.xwork2.ActionSupport;

public class LoginOrExitAction extends ActionSupport {

	/**
	 * 登录和退出的处理action 作者：张含
	 */
	private static final long serialVersionUID = 1L;

	// 定义一个账号属性
	private String account;

	// 定义一个一个密码属性
	private String password;

	// 调用用户接口不知道为什么server不行
	   IEmployeeDao ims = new EmployeeDaoImpl();

	// 调用职位接口不知道为什么不行
	 IPositionDao ips = new PositionDaoImpl();

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 登录方法
	public String Login() throws Exception {
		System.out.println("进来了action" +"\n"+"account>>>>"+account+"\npassword>>>>"+password);
		System.out.println(getAccount());
		// 查找该账号对象
		Employee empByAccount = ims.getEmpByAccount(getAccount());
		System.out.println("职位id"+empByAccount.getEmpPosId());
		// 如果查询为空返回登录
		if (empByAccount.equals(null)){
			System.out.println("empByAccount为空");
			// 弹窗提示。href是点击确定后跳转的地方
			ServletActionContext.getResponse().getWriter().write("<html><head><meta charset='UTF-8'></head>"
					+ "<script language='javascript'>alert('请先登录');window.location.href='/gump-oa/LoginAndExit/Login.jsp';</script>");
			return "ToLogin";

			// 如果存在且密码配对成功就进去页面
		} else if (empByAccount.getEmpPassword().equals(getPassword())) {
			System.out.println("--------------------------------------");
			// 把登录账号放在session里面
			ServletActionContext.getRequest().getSession().setAttribute("NowStaff", empByAccount);
			// 查询职位
			 List<Position> selectPosById = ips.getPositionById(empByAccount.getEmpPosId());
			 Position position = selectPosById.get(0);
			// 职位id 为1是普通员工staff，为2是管理员html
			if (position.getPosId() == 1) {
				return "ToStaffIndex";
			} else if (position.getPosId()==2 ) {
				return "ToHtmlIndex";
			}

		}
		// 如果密码不正确就显示
		ServletActionContext.getResponse().getWriter().write("<html><head><meta charset='UTF-8'></head>"
				+ "<script language='javascript'>alert('账号或者密码不正确');window.location.href='/gump-oa/LoginAndExit/Login.jsp';</script>");
		return "ToLogin";

	}

	// 退出方法
	public String Exit() {
		// 退出的时候把员工对象删除
		ServletActionContext.getRequest().getSession().removeAttribute("NowStaff");
		return "ToExit";

	}

}
