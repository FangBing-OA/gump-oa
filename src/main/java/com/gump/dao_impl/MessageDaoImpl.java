package com.gump.dao_impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gump.dao.IMessageDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Message;
import com.gump.vo.Page;

public class MessageDaoImpl implements IMessageDao {

	public boolean saveMessage(Message mes) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();//链接数据库
		
		int i = 0;
		//sql指令：添加消息
		String sql = "insert into message(mesTitle,mesSender,mesReceiver,mesContent,mesTime,mesRead) values (?,?,?,?,?,?)";		
		try {
			//使用dbutils操作MySQL数据库
			i = new QueryRunner(ds).update(sql, mes.getMesTitle(),mes.getMesSender(),mes.getMesReceiver(),
					mes.getMesContent(),mes.getMesTime(),mes.isMesRead());
			if(i > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeMessage(List<Integer> mesIdList) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		//判断mesIdList是否为空，不为空则操作数据库
		if(null != mesIdList){
			int i = 0;
			
			//生成sql指令：delete from message where mesId in (？,?...)	删除消息
			String sql = "delete from message where mesId in (";
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

	public List<Message> listMessageNotRead(String account, Page page) {
		// TODO Auto-generated method stub
		int pageSize = page.getPageSize();//每页显示多少条  
		int pageLimit = (page.getCurrentPage()-1)*pageSize;//从第pageLimit条数据拿值
		List<Message> list = null;
		
		DataSource ds = PoolFactory.getDS();
		
		//sql:select * from message where mesRead = 0 where mesReceiver = ? limit ?,?
		String sql = "select * from message where mesRead = 0";
		//拼接用户帐号
		if(null != account){
			sql += " and mesReceiver = '" + account + "'";
		}
		//拼接分页及降序排列
		sql += " order by mesTime DESC" + " limit " + pageLimit + "," + pageSize;
		try {
			list = new QueryRunner(ds).query(sql,new BeanListHandler<Message>(Message.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Message> listMessageInTimeQuantum(String timeStart, String timeEnd, String account, Page page) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		Integer pageSize = page.getPageSize();//每页显示多少条  
		Integer pageLimit = (page.getCurrentPage()-1)*pageSize;//从第pageLimit条数据拿值
		List<Message> list = null;
		
		//查询某帐号在某时间段中的消息
		String sql = "select * from message where mesReceiver = ? and mesTime >= ? and mesTime <= ? order by mesTime "
				+ "DESC limit ?,?";
		Object [] obj = new Object[5];
		obj[0] = account;
		obj[1] = timeStart;
		obj[2] = timeEnd;
		obj[3] = pageLimit;
		obj[4] = pageSize;
		try {
			list = new QueryRunner(ds).query(sql, new BeanListHandler<Message>(Message.class), obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public long countMessageNotRead(String account) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		
		long i = 0;
		String sql = "select count(*) from message where mesRead = 0 and mesReceiver = ?";
		
		try {
			i = new QueryRunner(ds).query(sql,account, new ScalarHandler<Long>(1));
			if(i > 0){
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public long countMessageInTimeQuantum(String timeStart, String timeEnd, String account) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		//查询某帐号在某时间段中的消息总数
		String sql = "select count(*) from message where mesReceiver = ? and mesTime >= ? and mesTime <= ?";
		long i = 0;
		Object [] obj = new Object[3];
		obj[0] = account;
		obj[1] = timeStart;
		obj[2] = timeEnd;
		try {
			i = new QueryRunner(ds).query(sql, obj,new ScalarHandler<Long>(1));
			if(i > 0)
				return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Message> listSendMseeage(String account, Page page) {
		// TODO Auto-generated method stub
		int pageSize = page.getPageSize();//每页显示多少条  
		int pageLimit = (page.getCurrentPage()-1)*pageSize;//从第pageLimit条数据拿值
		List<Message> list = null;
		
		DataSource ds = PoolFactory.getDS();
		
		//sql:select * from message where mesReceiver = ? limit ?,?		查询已发送消息
		String sql = "select * from message where mesSender = ? order by mesTime DESC limit ?,?";
		Object obj[] = new Object[3];
		obj[0] = account;
		obj[1] = pageLimit;
		obj[2] = pageSize;
		try {
			list = new QueryRunner(ds).query(sql,new BeanListHandler<Message>(Message.class),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public long countSendMessage(String account) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		
		long i = 0;
		//查询已发送消息条数
		String sql = "select count(*) from message where mesSender = ?";
		
		try {
			i = new QueryRunner(ds).query(sql,account,new ScalarHandler<Long>(1));
			System.out.println("-----"+i);
			if(i > 0){
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean updateMessageRead(int mesId) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		//标记已读
		String sql = "update message set mesRead = 1 where mesId =?";
		
		try {
			int i = new QueryRunner(ds).update(sql,mesId);
			if(i == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Message getMessageById(int mesId) {
		// TODO Auto-generated method stub
				DataSource ds = PoolFactory.getDS();
				Message message = null;
				//查询某帐号在某时间段中的消息
				String sql = "select * from message where mesId = ?";
				try {
					message = new QueryRunner(ds).query(sql, new BeanHandler<Message>(Message.class), mesId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return message;
	}
	
	/***************************************SA DAO***************************************************/
	
	
	public long countAllMessage() {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		
		long i = 0;
		//查询已发送消息条数
		String sql = "select count(*) from message";
		
		try {
			i = new QueryRunner(ds).query(sql,new ScalarHandler<Long>(1));
			if(i > 0){
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public long countMessageByKeyword(String keyword) {
		// TODO Auto-generated method stub
		DataSource ds = PoolFactory.getDS();
		long i = 0;
		//查询已发送消息条数
		String sql = "select count(*) from message where mesTitle like '%"+keyword+"%' "
				+ "or mesSender like '%"+keyword+"%' "
				+ "or mesReceiver like '%"+keyword+"%' or "
				+ "mesContent like '%"+keyword+"%' order by mesTime DESC";
		
		try {
			i = new QueryRunner(ds).query(sql,new ScalarHandler<Long>(1));
			if(i > 0){
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public List<Message> listAllMseeage(Page page) {
		// TODO Auto-generated method stub
		int pageSize = page.getPageSize();//每页显示多少条  
		int pageLimit = (page.getCurrentPage()-1)*pageSize;//从第pageLimit条数据拿值
		List<Message> list = null;
		
		DataSource ds = PoolFactory.getDS();
		
		//sql:select * from message where mesReceiver = ? limit ?,?		查询已发送消息
		String sql = "select * from message order by mesTime DESC limit ?,?";
		Object obj[] = new Object[2];
		obj[0] = pageLimit;
		obj[1] = pageSize;
		try {
			list = new QueryRunner(ds).query(sql,new BeanListHandler<Message>(Message.class),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Message> listMessageByKeyword(String keyword,Page page){
		List<Message> list = null;
		DataSource ds = PoolFactory.getDS();
		int pageSize = page.getPageSize();//每页显示多少条  
		int pageLimit = (page.getCurrentPage()-1)*pageSize;//从第pageLimit条数据拿值
		
		//sql:select * from message where mesReceiver = ? limit ?,?		查询已发送消息
		String sql = "select * from message where mesTitle like '%"+keyword+"%' "
				+ "or mesSender like '%"+keyword+"%' "
				+ "or mesReceiver like '%"+keyword+"%' or "
				+ "mesContent like '%"+keyword+"%' order by mesTime DESC limit ?,?";
		try {
			list = new QueryRunner(ds).query(sql,new BeanListHandler<Message>(Message.class),pageLimit,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}