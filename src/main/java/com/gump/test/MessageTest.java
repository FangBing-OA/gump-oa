package com.gump.test;

import com.gump.dao_impl.MessageDaoImpl;
import com.gump.vo.MessageVo;

public class MessageTest {
	public static void main(String[] args) {
		MessageVo mv = new MessageVo();
		MessageDaoImpl md = new MessageDaoImpl();
		
		mv.setMesContent("消息测试第一次");
		mv.setMesRead(false);
		mv.setMesReceiver("2014302057");
		mv.setMesSender("2014302058");
		mv.setMesTime();
		mv.setMseTitle("消息测试第一次");
		
		boolean flag = md.inMessage(mv);
		System.out.println(flag);
	}
}
