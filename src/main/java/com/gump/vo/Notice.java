package com.gump.vo;
/**
 * 公告VO
 * @author 26562
 *
 */

public class Notice {
	//公告ID
	private int notId;
	//公告标题
	private String notTitle;
	//公告内容
	private String notContent;
	//公告日期
	private String notDate;
	//公告发布者
	private String notSender;
	public int getNotId() {
		return notId;
	}
	public void setNotId(int notId) {
		this.notId = notId;
	}
	public String getNotTitle() {
		return notTitle;
	}
	public void setNotTitle(String notTitle) {
		this.notTitle = notTitle;
	}
	public String getNotContent() {
		return notContent;
	}
	public void setNotContent(String notContent) {
		this.notContent = notContent;
	}
	public String getNotDate() {
		return notDate;
	}
	public void setNotDate(String notDate) {
		this.notDate = notDate;
	}
	public String getNotSender() {
		return notSender;
	}
	public void setNotSender(String notSender) {
		this.notSender = notSender;
	}
	
}
