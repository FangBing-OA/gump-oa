package com.gump.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gump.service.IEmployeeService;
import com.gump.service_impl.EmployeeServiceImpl;
import com.gump.vo.Employee;

public class MessageVaildateAction {
	
	private String mesReceiver;
	private String flag;
	
    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMesReceiver() {
		return mesReceiver;
	}

	public void setMesReceiver(String mesReceiver) {
		this.mesReceiver = mesReceiver;
	}

	public String vaildateMesReceiver() { 
		HttpServletResponse response = ServletActionContext.getResponse();
		Employee employee = null;
		IEmployeeService ies = new EmployeeServiceImpl();
		employee = ies.getEmpByAccount(mesReceiver);
		if(employee == null){
			flag = "false";
		}else{
			flag = "true";
		}
		try {
			PrintWriter out = response.getWriter();
			out.write(flag);
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";  
    }  
}
