package com.gump.vo;

public class PositionVo {
	
	private int posId;//部门ID
	private String posName;//部门名称
	private String posDescribe;//部门描述
	
	
	public int getPosId() {
		System.out.println(posId);
		return posId;
	}
	public void setPosId(int posId) {
		this.posId = posId;
	}
	public String getPosName() {
		System.out.println(posId);
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getPosDescribe() {
		System.out.println(posId);
		return posDescribe;
	}
	public void setPosDescribe(String posDescribe) {
		this.posDescribe = posDescribe;
	}
}
