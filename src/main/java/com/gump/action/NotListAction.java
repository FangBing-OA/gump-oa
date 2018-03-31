package com.gump.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gump.commons.JudgeRole;
import com.gump.dao.INoticeDao;
import com.gump.dao_impl.NoticeDaoImpl;
import com.gump.vo.Employee;
import com.gump.vo.Notice;
import com.gump.vo.Page;


public class NotListAction {

	private Page page;//页面信息---------------------//使用时要new
	private int noticeCurrent;//当前页数，用于从前台传值
	// 删除时提交的ID
	private int notId;
	// 用于存放查询所有内容的集合
	private List<Notice> notices;
	// 添加界面提交的标题
	private String title;
	// 添加提交的内容
	private String content;
	//更改时的标题
	private String updateTitle;
	//更改时提交的内容
	private String updateContent;
	//更改提交的ID
	private int updateId;
	
	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public String getUpdateTitle() {
		return updateTitle;
	}

	public void setUpdateTitle(String updateTitle) {
		this.updateTitle = updateTitle;
	}

	public String getUpdateContent() {
		return updateContent;
	}

	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNotId() {
		return notId;
	}

	public void setNotId(int notId) {
		this.notId = notId;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	/**
	 * 查询所有信息（后台）
	 * 
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {

		INoticeDao ndi = new NoticeDaoImpl();
		//获得总记录数
		int count = (int)ndi.countAllNotice();
		//判断有无数据
		if(count!=0){
			page = new Page();
			page.setCount((int)count);
			page.setCurrentPage(noticeCurrent);
			
			//获得返回消息集合
			List<Notice> list = ndi.queryAll(page);
			page.setData(list);
		}
		return "toallSa";


//		INoticeDao noticeDao = new NoticeDaoImpl();
//		notices = noticeDao.queryAll(page);
//		if(JudgeRole.isAdmin()){
//			return "toadminlist";
//		}else{
//			return "tostafflist";
//		}
	}
	
	
	/**
	 * 查询所有信息（员工）
	 * @return
	 * @throws Exception
	 */
	public String executeEmp() throws Exception {

		INoticeDao ndi = new NoticeDaoImpl();
		//获得总记录数
		int count = (int)ndi.countAllNotice();
		//判断有无数据
		if(count!=0){
			page = new Page();
			page.setCount((int)count);
			page.setCurrentPage(noticeCurrent);
			
			//获得返回消息集合
			List<Notice> list = ndi.queryAll(page);
			page.setData(list);
		}
	/*	System.out.println(page.getCount());
		System.out.println(page.getCurrentPage());
		System.out.println(page.getData().size());*/
		return "toallSaEmp";
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getNoticeCurrent() {
		return noticeCurrent;
	}

	public void setNoticeCurrent(int noticeCurrent) {
		this.noticeCurrent = noticeCurrent;
	}

	/**
	 * 删除信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		INoticeDao noticeDao = new NoticeDaoImpl();
		noticeDao.deleteNotByID(getNotId());
		notices = noticeDao.queryAll(page);
		return "success";
	}
	
	/**
	 * 转到添加页面
	 * @return
	 */
	public String toAdd(){
		return "toadd";
	}

	/**
	 * 添加公告
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		if (getTitle() == null||getContent()==null||getTitle().equals("")||getContent().equals("")) 
		{
			INoticeDao noticeDao = new NoticeDaoImpl();
			notices = noticeDao.queryAll(page);
			return "sb";
		} else {
			
			Employee account = (Employee)ServletActionContext.getRequest().getSession().getAttribute("account");
			INoticeDao noticeDao = new NoticeDaoImpl();
			noticeDao.addNot(getTitle(), getContent(),account.getEmpName());
			notices = noticeDao.queryAll(page);
			return "bs";
		}
	}
	/**
	 * 调到更改的页面自动锁定更改的内容
	 * @throws Exception 
	 */
	public String update() throws Exception{
		//通过ID查询公告的标题和内容
		INoticeDao noticeDao = new NoticeDaoImpl();
		
		setUpdateTitle(noticeDao.queryById(getNotId()).getNotTitle());
		setUpdateContent(noticeDao.queryById(getNotId()).getNotContent());
		setUpdateId(noticeDao.queryById(getNotId()).getNotId());
		return "fail";
	}
	
	/**
	 * 更改公告内容
	 * @throws Exception 
	 */
	public String doUpdate() throws Exception{
		INoticeDao noticeDao = new NoticeDaoImpl();
		noticeDao.updateNotById(getUpdateId(), getUpdateTitle(), getUpdateContent());
		notices = noticeDao.queryAll(page);
		return "doUpdate";
	}
}
