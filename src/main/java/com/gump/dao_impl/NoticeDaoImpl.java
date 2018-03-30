package com.gump.dao_impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gump.dao.INoticeDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Notice;

public class NoticeDaoImpl implements INoticeDao{
	
	/**
	 * 查询所有公告
	 */
	public List<Notice> queryAll() throws Exception {
		// TODO Auto-generated method stub
		
		//获取数据源
		DataSource ds = PoolFactory.getDS();
		QueryRunner queryRunner = new QueryRunner(ds);
		String sql = "select * from notice";
		List<Notice> notices = queryRunner.query(sql, new BeanListHandler<Notice>(Notice.class));
		return notices;
	}
	/**
	 * 根据Id删除指定的公告
	 */
	public void deleteNotByID(int notId) throws Exception {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		QueryRunner queryRunner = new QueryRunner(ds);
		String sql = "delete from notice where notId = ?";
		queryRunner.update(sql,notId);
	}
	/**
	 * 根据Id更改指定的公告
	 * 
	 */
	public void updateNotById(int notId,String notTitle,String notCntent) throws Exception {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		QueryRunner queryRunner = new QueryRunner(ds);
		String sql = "update notice set notTitle=?,notContent=? where notId=?";
		queryRunner.update(sql,notTitle,notCntent,notId);
		
	}
	/**
	 * 根据ID查询最新一条公告
	 */

	public Notice queryById(int notId) throws Exception {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		QueryRunner queryRunner = new QueryRunner(ds);
		String sql = "select * from notice where notId=?";
		Notice notice = queryRunner.query(sql, new BeanHandler<Notice>(Notice.class),notId);
		return notice;
	}
	
	public void addNot(String notTitle, String notContent, String notSender) throws Exception {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		QueryRunner queryRunner = new QueryRunner(ds);
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(d);
		String sql = "insert into notice(notTitle,notContent,notDate,notSender) values(?,?,?,?)";
		queryRunner.update(sql, notTitle,notContent,date,notSender);
	}
	public Notice getNewestNot(){
		DataSource ds = PoolFactory.getDS();
		Notice notice;
		try {
			QueryRunner queryRunner = new QueryRunner(ds);
			String sql = "select * from notice order by notId desc limit 0,1";
			notice = queryRunner.query(sql, new BeanHandler<Notice>(Notice.class));
			return notice;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
