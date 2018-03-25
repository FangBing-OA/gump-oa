package com.gump.dao;

import java.util.List;

import com.gump.vo.Message;
import com.gump.vo.Page;

public interface IMessageDao {
	
	/**
	 * 添加消息
	 * @param message
	 * @return
	 */
	public boolean saveMessage(Message message);
	
	/**
	 * 删除消息:集合中为消息ID
	 * @param mesIdList
	 * @return
	 */
	public boolean removeMessage(List<Integer> mesIdList);
	
	/**
	 * 标记已读
	 * @param mesId
	 * @return
	 */
	public boolean updateMessageRead(int mesId);
	
	/**
	 * 通过Id查看消息
	 * @param mesId
	 * @return
	 */
	public Message getMessageById(int mesId);
	
	/**
	 * 查询未读消息(接受的消息)
	 * @param mesReceiver
	 * @param page
	 * @return
	 */
	public List<Message> listMessageNotRead(String account ,Page page);
	
	/**
	 * 查询某时间段的消息(接受的消息)
	 * @param timeStart
	 * @param timeEnd
	 * @param account
	 * @param page
	 * @return
	 */
	public List<Message> listMessageInTimeQuantum(String timeStart,String timeEnd,String account,Page page);
	
	/**
	 * 查询发送的消息
	 * @param account
	 * @param page
	 * @return
	 */
	public List<Message> listSendMseeage(String account ,Page page); 
	
	/**
	 * 查询未读消息总数(接受的消息)
	 * @param account
	 * @return
	 */
	public long countMessageNotRead(String account);
	
	/**
	 * 查询某时间段的消息总数(接受的消息)
	 * @param timeStart
	 * @param timeEnd
	 * @param account
	 * @return
	 */
	public long countMessageInTimeQuantum(String timeStart,String timeEnd,String account);
	
	/**
	 * 查询发送的消息的总数
	 * @param account
	 * @return
	 */
	public long countSendMessage(String account);

	
	
} 