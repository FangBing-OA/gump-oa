package com.gump.action;

import java.util.List;

import com.gump.dao.INoticeDao;
import com.gump.dao_impl.NoticeDaoImpl;
import com.gump.vo.Notice;


public class NotListAction {

	// 删除时提交的ID
	private int notId;
	// 用于存放查询所有内容的集合
	private List<Notice> notices;
	// 添加界面提交的标题
	private String title;
	// 添加提交的内容
	private String content;

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
	 * 查询所有信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		INoticeDao noticeDao = new NoticeDaoImpl();
		notices = noticeDao.queryAll();
		return "success";
	}

	/**
	 * 删除信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		System.out.println(getNotId());
		INoticeDao noticeDao = new NoticeDaoImpl();
		noticeDao.deleteNotByID(getNotId());
		notices = noticeDao.queryAll();
		return "success";
	}

	/**
	 * 添加公告
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		if (getTitle() == null||getContent()==null||getTitle().equals("")||getContent().equals("")) {
			System.out.println("11111111");
			return "sb";
		} else {
			System.out.println("222222222");
			INoticeDao noticeDao = new NoticeDaoImpl();
			noticeDao.addNot(getTitle(), getContent(), "GZB");
			return "bs";
		}
	}
}
