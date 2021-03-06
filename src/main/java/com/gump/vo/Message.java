package com.gump.vo;

import java.util.Date;

import com.gump.utils.TimeCycleUtils;

public class Message {
	private int mesId;//信息ID
	private String mesTitle;//信息主题
	private String mesSender;//信息发送者
	private String mesReceiver;//信息接受者
	private String mesContent;//信息内容
	private String mesTime;//信息发送时间
	private boolean mesRead;//是否阅读
	
	public int getMesId() {
		return mesId;
	}
	public void setMesId(int mesId) {
		this.mesId = mesId;
	}
	public String getMesTitle() {
		return mesTitle;
	}
	public void setMesTitle(String mesTitle) {
		this.mesTitle = mesTitle;
	}
	public String getMesSender() {
		return mesSender;
	}
	public void setMesSender(String mesSender) {
		this.mesSender = mesSender;
	}
	public String getMesReceiver() {
		return mesReceiver;
	}
	public void setMesReceiver(String mesReceiver) {
		this.mesReceiver = mesReceiver;
	}
	public String getMesContent() {
		return mesContent;
	}
	public void setMesContent(String mesContent) {
		this.mesContent = mesContent;
	}
	public String getMesTime() {
		return mesTime;
	}
	public void setMesTime(String mesTime) {
		this.mesTime = mesTime;
	}
	public boolean isMesRead() {
		return mesRead;
	}
	public void setMesRead(boolean mesRead) {
		this.mesRead = mesRead;
	}
	
	public void setTime(){
		Date date = new Date();
		String timeString = TimeCycleUtils.dateToDetailString(date);
		this.mesTime = timeString;
	}
	
}
