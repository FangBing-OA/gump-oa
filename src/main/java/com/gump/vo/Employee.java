package com.gump.vo;

public class Employee {
	private int empId;// 员工ID
	private String empName;// 员工名
	private String empAccount;//员工账号
	private String empSex;// 员工性别
	private int empAge;// 员工年龄
	private int empDepId;// 员工部门ID
	private int empPosId;// 员工职位ID
	private String empStatus;// 员工状态
	private String empTel;// 员工电话
	
	public String getEmpAccount() {
		return empAccount;
	}
	public void setEmpAccount(String empAccount) {
		this.empAccount = empAccount;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public int getEmpDepId() {
		return empDepId;
	}
	public void setEmpDepId(int empDepId) {
		this.empDepId = empDepId;
	}
	public int getEmpPosId() {
		return empPosId;
	}
	public void setEmpPosId(int empPosId) {
		this.empPosId = empPosId;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpTel() {
		return empTel;
	}
	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}
	
}
