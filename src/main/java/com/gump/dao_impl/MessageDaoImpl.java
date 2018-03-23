package com.gump.dao_impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gump.dao.MessageDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.MessageVo;
import com.gump.vo.Page;

public class MessageDaoImpl implements MessageDao {

	public boolean inMessage(MessageVo mes) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();//链接数据库
		
		int i = 0;
		//sql指令：添加消息
		String sql = "insert into message(mesTitle,mesSender,mesReceiver,mesContent,mesTime) values (?,?,?,?,?,?)";
		
		try {
			//使用dbutils操作MySQL数据库
			i = new QueryRunner(ds).update(sql, mes.getMseTitle(),mes.getMesSender(),mes.getMesReceiver(),
					mes.getMesContent(),mes.getMesTime(),mes.getMesSender());
			if(i > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deMessage(List<Integer> mesIdList) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		
		//判断mesIdList是否为空，不为空则操作数据库
		if(null != mesIdList){
			int i = 0;
			
			//生成sql指令：delete from message while mesId in (？,?...)	删除消息
			String sql = "delete from message while mesId in (";
			for(int num : mesIdList){
				sql += num + ","; 
			}
			sql = sql.substring(0, sql.lastIndexOf(',')) + ")"; 
			
			try {
				//使用dbutils操作MySQL数据库
				i = new QueryRunner(ds).update(sql);
				if(i > 0)
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public List<MessageVo> seMessageNotRead(String account, Page page) {
		// TODO Auto-generated method stub
		int pageSize = page.getPageSize();//每页显示多少条  
		int pageLimit = (page.getCurrentPage()-1)*pageSize;//从第pageLimit条数据拿值
		List<MessageVo> list = null;
		
		DataSource ds = PoolFactory.getDS();
		
		//sql:select * form message where mesRead = 0 while mesReceiver = ? limit ?,?
		String sql = "select * form message where mesRead = 0";
		//拼接用户帐号
		if(null != account){
			sql += "and mesReceiver = '" + account + "'";
		}
		//拼接分页及降序排列
		sql += " limit " + pageLimit + "," + pageSize + " order by (select str_to_date(mesTime,'%Y-%m-%d %H:%i:%s')) DESC";
		try {
			list = new QueryRunner(ds).query(sql,new BeanListHandler<MessageVo>(MessageVo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<MessageVo> seMessageInTimeQuantum(String timeStart, String timeEnd, String account, Page page) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		Integer pageSize = page.getPageSize();//每页显示多少条  
		Integer pageLimit = (page.getCurrentPage()-1)*pageSize;//从第pageLimit条数据拿值
		List<MessageVo> list = null;
		
		//查询某帐号在某时间段中的消息
		String sql = "select * from message while mesReceiver = ? and (select str_to_date(mesTime,'%Y-%m-%d %H:%i:%s')) >= "
				+ "(select str_to_date(?,'%Y-%m-%d %H:%i:%s')) and (select str_to_date(mesTime,'%Y-%m-%d %H:%i:%s')) <= "
				+ "(select str_to_date(?,'%Y-%m-%d %H:%i:%s')) limit "+ pageLimit +"," +pageSize;
		Object [] obj = new Object[5];
		obj[0] = account;
		obj[2] = timeStart;
		obj[3] = timeEnd;
		obj[4] = pageLimit;
		obj[5] = pageSize;
		try {
			list = new QueryRunner(ds).query(sql, obj, new BeanListHandler<MessageVo>(MessageVo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Integer countMessageNotRead(String account) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		
		Integer i = 0;
		String sql = "select count(*) form message where mesRead = 0";
		
		try {
			i = new QueryRunner(ds).update(sql);
			if(i > 0){
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Integer countMessageInTimeQuantum(String timeStart, String timeEnd, String account) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		//查询某帐号在某时间段中的消息总数
		String sql = "select count(*) from message while mesReceiver = ? and (select str_to_date(mesTime,'%Y-%m-%d %H:%i:%s')) >= "
				+ "(select str_to_date(?,'%Y-%m-%d %H:%i:%s')) and (select str_to_date(mesTime,'%Y-%m-%d %H:%i:%s')) <= "
				+ "(select str_to_date(?,'%Y-%m-%d %H:%i:%s'))";
		int i=0;
		Object [] obj = new Object[3];
		obj[0] = account;
		obj[2] = timeStart;
		obj[3] = timeEnd;
		try {
			i = new QueryRunner(ds).update(sql, obj);
			if(i > 0)
				return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
