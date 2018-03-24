package com.gump.vo;

public class Department {
	private int depId;			//部门id
	private String depName;		//部门名字
	private String depDescribe;	//部门描述
	private int depNum;			//部门人数
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepDescribe() {
		return depDescribe;
	}
	public void setDepDescribe(String depDescribe) {
		this.depDescribe = depDescribe;
	}
	public int getDepNum() {
		return depNum;
	}
	public void setDepNum(int depNum) {
		this.depNum = depNum;
	}
}
