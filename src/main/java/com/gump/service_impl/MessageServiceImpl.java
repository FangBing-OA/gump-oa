package com.gump.service_impl;

import java.util.List;

import com.gump.dao.IMessageDao;
import com.gump.service.IMessageService;
import com.gump.vo.Message;
import com.gump.vo.Page;

public class MessageServiceImpl implements IMessageService {
	private IMessageDao md;

	public boolean saveMessage(Message message) {
		// TODO Auto-generated method stub
		return md.saveMessage(message);
	}

	public boolean removeMessage(List<Integer> mesIdList) {
		// TODO Auto-generated method stub
		return md.removeMessage(mesIdList);
	}

	public boolean updateMessageRead(int mesId) {
		// TODO Auto-generated method stub
		return md.updateMessageRead(mesId);
	}

	public List<Message> listMessageNotRead(String account, Page page) {
		// TODO Auto-generated method stub
		return md.listMessageNotRead(account, page);
	}

	public List<Message> listMessageInTimeQuantum(String timeStart, String timeEnd, String account, Page page) {
		// TODO Auto-generated method stub
		return md.listMessageInTimeQuantum(timeStart, timeEnd, account, page);
	}

	public List<Message> listSendMseeage(String account, Page page) {
		// TODO Auto-generated method stub
		return md.listSendMseeage(account, page);
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

	public Message getMessageById(int mesId) {
		// TODO Auto-generated method stub
		return md.getMessageById(mesId);
	}

}