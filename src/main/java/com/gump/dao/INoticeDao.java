package com.gump.dao;

import java.util.List;

import com.gump.vo.Notice;
import com.gump.vo.Page;

/**
 * 对notice表的操作
 * @author 26562
 *
 */

public interface INoticeDao {
	/**
	 * 查询所有公告信息
	 * @return
	 * @throws Exception
	 */
	public List<Notice> queryAll(Page page) throws Exception;
	
	/**
	 * 删除公告
	 * @param notId
	 * @throws Exception
	 */
	public void deleteNotByID(int notId) throws Exception;
	
	/**
	 * 根据Id修改公告
	 * @param notId
	 * @param notTitle
	 * @param notCntent
	 * @throws Exception
	 */
	public void updateNotById(int notId,String notTitle,String notCntent) throws Exception;
	
	/**
	 * 根据ID查询公告
	 * @param notId
	 * @return
	 * @throws Exception
	 */
	public Notice queryById(int notId) throws Exception;
	/**
	 * 添加公告
	 * @param notTitle
	 * @param notContent
	 * @param notSender
	 * @throws Exception
	 */
	public void addNot(String notTitle,String notContent,String notSender) throws Exception;
	
	/**
	 * 查询所有公告数
	 * @return
	 */
	public long countAllNotice();

	/**
	 * 获得最新的一条公告信息
	 * @return
	 */
	public Notice getNewestNot();
}
