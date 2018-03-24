package com.gump.dao_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gump.dao.IDocumentDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Document;





public class DocumentDaoImpl implements IDocumentDao{
	 

		DataSource ds = PoolFactory.getDS();
		

	/**
	 * 向数据库中插入公文，用于回查
	 * @param doc
	 * @return 
	 * @throws
	 * @author Administrator
	 */
	public int insertDoc(Document doc) {
		// TODO Auto-generated method stub
		int result = 0;
	    try {
	    	//从连接池获取一个连接
			Connection conn = ds.getConnection();
			//待执行sql语句
			String sql = "insert into document(docSender,docReceiver,docTitle,docTime,docContent) values(?,?,?,?,?)";
			//给sql中参数
			Object [] params = {doc.getDocSender(),doc.getDocReceiver(),doc.getDocTitle(),doc.getDocTime(),doc.getDocContent()};
		     //执行语句
			QueryRunner qr = new QueryRunner();
			result = qr.update(conn, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
		return result;
	}

	public int removeDoc(int docId) {
		// TODO Auto-generated method stub
		int result=0;
		//从连接池获取一个连接
		try {
			Connection conn = ds.getConnection();
			//sql语句
			String sql = "delete from document where docId=?";
			//给sql中的参数
			Object [] params = {docId};
			 //执行语句
			QueryRunner qr = new QueryRunner();
			result = qr.update(conn, sql, params);
			//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Document> QueryByKeyword(String keyword) {
		// TODO Auto-generated method stub
		Set set = new HashSet();
		List<Document> TempdocumentList =null;
		List<Document> documentList =null;
		try {
			Connection conn = ds.getConnection();
			String sql ="select  * from document where docSender like '%"+keyword+"%'"
					+"or docTitle like '%"+keyword+"%'"
					+"or docReceiver like '%"+keyword+"%'"
					+"or docTime like '%"+keyword+"%'"
					+"or docContent like '%"+keyword+"%'"; 
			QueryRunner qr = new QueryRunner();
			TempdocumentList=qr.query(conn, sql,  new BeanListHandler<Document>(Document.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return TempdocumentList;
	}

	public Document modifyDoc(int docId) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ds.getConnection();
			String sql = "update document set docSender=?,docReceiver=?,docTitle=?,docTime=?,docContent=?";
			Document doc = QueryById(docId);
			Object [] params = {doc.getDocSender(),doc.getDocReceiver(),doc.getDocTitle(),doc.getDocTime(),doc.getDocContent()};
			QueryRunner qr = new QueryRunner();
			qr.update(conn, sql, params);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return QueryById(docId);
	}

	public Document QueryById(int docId) {
		Document document= null;
		try {
			//获取连接
			Connection conn = ds.getConnection();
			//sql语句
			String sql = "select * from document where docId=?";
			//待执行sql
			QueryRunner qr = new QueryRunner();
			 document = qr.query(conn,sql, new BeanHandler<Document>(Document.class), docId);
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return document;
	}

}
