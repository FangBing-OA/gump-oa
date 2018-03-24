package com.gump.dao;

import java.util.List;

import com.gump.vo.Notice;

/**
 * 对notice表的操作
 * @author 26562
 *
 */

public interface INoticeDao {
	//查询所有公告信息
	public List<Notice> queryAll() throws Exception;
	//删除公告
	public void deleteNotByID(int notId) throws Exception;
	//根据Id修改公告
	public void updateNotById(Notice noticeVo) throws Exception;
	//根据ID查询公告
	public Notice queryById(int notId) throws Exception;
	//添加公告
	public void addNot(String notTitle,String notContent,String notSender) throws Exception;

}
