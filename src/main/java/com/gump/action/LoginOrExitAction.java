package com.gump.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gump.dao.IEmployeeDao;
import com.gump.dao.INoticeDao;
import com.gump.dao.IPositionDao;
import com.gump.dao_impl.EmployeeDaoImpl;
import com.gump.dao_impl.NoticeDaoImpl;
import com.gump.dao_impl.PositionDaoImpl;
import com.gump.utils.MD5Utils;
import com.gump.vo.Employee;
import com.gump.vo.Notice;
import com.gump.vo.Position;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginOrExitAction extends ActionSupport {

	/**
	 * 登录和退出的处理action 作者：张含
	 */
	private static final long serialVersionUID = 1L;

	// 定义一个账号属性
	private String loginname;

	// 定义一个一个密码属性
	private String password;

	// 调用用户接口不知道为什么server不行
	   IEmployeeDao ims = new EmployeeDaoImpl();

	// 调用职位接口不知道为什么不行
	 IPositionDao ips = new PositionDaoImpl();

	


	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		// 进行MD5加密
		password = MD5Utils.md5(password);
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 登录方法
	public void Login() throws Exception {
		// 查找该账号对象
		Employee empByAccount = ims.getEmpByAccount(getLoginname());
		// 如果查询为空返回登录
		if (null==empByAccount){
			// 弹窗提示。href是点击确定后跳转的地方
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write("<html><head><meta charset='UTF-8'></head>"
					+ "<script language='javascript'>alert('账号或密码不正确');window.location.href='/gump-oa/LoginAndExit/Login.jsp';</script>");

			// 如果存在且密码配对成功就进去页面
		} else if (empByAccount.getEmpAccount().equals(getLoginname())&&empByAccount.getEmpPassword().equals(getPassword())) {
			// 把登录账号放在session里面
			ServletActionContext.getRequest().getSession().setAttribute("account", empByAccount);
			// 查询职位
			 List<Position> selectPosById = ips.getPositionById(empByAccount.getEmpPosId());
			 Position position = selectPosById.get(0);
			// 职位id 为4是普通员工staff，为2是管理员html
			 //获得最新的公告
			 INoticeDao iNoticeDao = new NoticeDaoImpl();
			 Notice notice = iNoticeDao.getNewestNot();
			if (position.getPosId() == 4) {
				ActionContext.getContext().getSession().put("noticeTitle", notice.getNotTitle());
				ServletActionContext.getResponse().getWriter().write("<html><head><meta charset='UTF-8'></head>"
						+ "<script language='javascript'>window.location.href='/gump-oa/staff/index.jsp';</script>");
			} else if (position.getPosId()==2 ) {
				ActionContext.getContext().getSession().put("noticeTitle", notice.getNotTitle());
				ServletActionContext.getResponse().getWriter().write("<html><head><meta charset='UTF-8'></head>"
						+ "<script language='javascript'>window.location.href='/gump-oa/html/index.jsp';</script>");
			}

		}
		// 如果密码不正确就显示
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().write("<html><head><meta charset='UTF-8'></head>"
				+ "<script language='javascript'>alert('密码不正确');window.location.href='/gump-oa/LoginAndExit/Login.jsp';</script>");

	}

	// 退出方法
	public String Exit() {
		// 退出的时候把员工对象删除
		ServletActionContext.getRequest().getSession().removeAttribute("account");
		return "ToExit";
	}

}
