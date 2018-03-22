package com.gump.dao_impl;

import java.util.List;

import com.gump.dao.MessageDao;
import com.gump.vo.MessageVo;
import com.gump.vo.Page;

public class MessageDaoImpl implements MessageDao {

	public boolean inMessage(MessageVo message) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deMessage(List<Integer> mesIdList) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<MessageVo> seMessageNotRead(String mesReceiver, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MessageVo> seMessageInTimeQuantum(String timeStart, String timeEnd, String account, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

}
