package com.gump.service_impl;

import java.util.List;

import com.gump.dao.IMessageDao;
import com.gump.service.IMessageService;
import com.gump.vo.Message;
import com.gump.vo.Page;

public class MessageServiceImpl implements IMessageService {
	private IMessageDao md;

	public boolean inMessage(Message message) {
		// TODO Auto-generated method stub
		return md.inMessage(message);
	}

	public boolean deMessage(List<Integer> mesIdList) {
		// TODO Auto-generated method stub
		return md.deMessage(mesIdList);
	}

	public boolean upMessageRead(int mesId) {
		// TODO Auto-generated method stub
		return md.upMessageRead(mesId);
	}

	public List<Message> seMessageNotRead(String account, Page page) {
		// TODO Auto-generated method stub
		return md.seMessageNotRead(account, page);
	}

	public List<Message> seMessageInTimeQuantum(String timeStart, String timeEnd, String account, Page page) {
		// TODO Auto-generated method stub
		return md.seMessageInTimeQuantum(timeStart, timeEnd, account, page);
	}

	public List<Message> seSendMseeage(String account, Page page) {
		// TODO Auto-generated method stub
		return md.seSendMseeage(account, page);
	}

	public long countMessageNotRead(String account) {
		// TODO Auto-generated method stub
		return md.countMessageNotRead(account);
	}

	public long countMessageInTimeQuantum(String timeStart, String timeEnd, String account) {
		// TODO Auto-generated method stub
		return md.countMessageInTimeQuantum(timeStart, timeEnd, account);
	}

	public long countSendMessage(String account) {
		// TODO Auto-generated method stub
		return md.countSendMessage(account);
	}

}