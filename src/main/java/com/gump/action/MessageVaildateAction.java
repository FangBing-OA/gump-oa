package com.gump.action;

public class MessageVaildateAction {
	private String mesReceiver;
	
    public String vaildateMesReceiver() {  
    	mesReceiver = "hello " + mesReceiver;  
        return "success";  
    }  
}
