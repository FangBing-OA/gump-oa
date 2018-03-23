package com.gump.service;

import java.util.List;

import com.gump.vo.MessageVo;
import com.gump.vo.Page;

public interface MessageService {

	/**
	 * 添加消息
	 * @param message
	 * @return
	 */
	public boolean inMessage(MessageVo message);
	
	/**
	 * 删除消息:集合中为消息ID
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
	public List<MessageVo> seMessageNotRead(String account ,Page page);
	
	/**
	 * 查询某时间段的消息
	 * @param timeStart
	 * @param timeEnd
	 * @param account
	 * @param page
	 * @return
	 */
	public List<MessageVo> seMessageInTimeQuantum(String timeStart,String timeEnd,String account,Page page);
	
	/**
	 * 查询未读消息总数
	 * @param account
	 * @return
	 */
	public Integer countMessageNotRead(String account);
	
	/**
	 * 查询某时间段的消息总数
	 * @param timeStart
	 * @param timeEnd
	 * @param account
	 * @return
	 */
	public Integer countMessageInTimeQuantum(String timeStart,String timeEnd,String account);

	
}
