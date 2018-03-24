package com.gump.service_impl;

import java.util.List;

import com.gump.dao.MessageDao;
import com.gump.service.MessageService;
import com.gump.vo.MessageVo;
import com.gump.vo.Page;

public class MessageServiceImpl implements MessageService {
	private MessageDao md;
	public boolean inMessage(MessageVo message) {
		// TODO Auto-generated method stub
		return md.inMessage(message);
	}

	public boolean deMessage(List<Integer> mesIdList) {
		// TODO Auto-generated method stub
		return md.deMessage(mesIdList);
	}

	public List<MessageVo> seMessageNotRead(String account, Page page) {
		// TODO Auto-generated method stub
		return md.seMessageNotRead(account, page);
	}

	public List<MessageVo> seMessageInTimeQuantum(String timeStart, String timeEnd, String account, Page page) {
		// TODO Auto-generated method stub
		return md.seMessageInTimeQuantum(timeStart, timeEnd, account, page);
	}

	public Integer countMessageNotRead(String account) {
		// TODO Auto-generated method stub
		return md.countMessageNotRead(account);
	}

	public Integer countMessageInTimeQuantum(String timeStart, String timeEnd, String account) {
		// TODO Auto-generated method stub
		return md.countMessageInTimeQuantum(timeStart, timeEnd, account);
	}

}
