package com.gump.dao;

import java.util.List;

import com.gump.vo.MessageVo;
import com.gump.vo.Page;

public interface MessageDao {
	
	/**
	 * 添加消息
	 * @param message
	 * @return
	 */
	public boolean inMessage(MessageVo message);
	
	/**
	 * 删除消息
	 * @param mesIdList
	 * @return
	 */
	public boolean deMessage(List<Integer> mesIdList);
	
	/**
	 * 查询未读消息
	 * @param mesReceiver
	 * @param page
	 * @return
	 */
	public List<MessageVo> seMessageNotRead(String mesReceiver ,Page page);
	
	/**
	 * 查询某时间段的消息
	 * @param timeStart
	 * @param timeEnd
	 * @param account
	 * @param page
	 * @return
	 */
	public List<MessageVo> seMessageInTimeQuantum(String timeStart,String timeEnd,String account,Page page);
} 
