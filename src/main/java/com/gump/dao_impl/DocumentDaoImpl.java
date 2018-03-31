package com.gump.dao_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.gump.dao.IDocumentDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Document;
import com.gump.vo.Page;





public class DocumentDaoImpl implements IDocumentDao{
	 

		DataSource ds = PoolFactory.getDS();
		

	/**
	 * 閸氭垶鏆熼幑顔肩氨娑擃厽褰冮崗銉ュ彆閺傚浄绱濋悽銊ょ艾閸ョ偞鐓�
	 * @param doc
	 * @return 
	 * @throws
	 * @author Administrator
	 */
	public int insertDoc(Document doc) {
		// TODO Auto-generated method stub
		int result = 0;
	    try {
	    	//娴犲氦绻涢幒銉︾潨閼惧嘲褰囨稉锟芥稉顏囩箾閹猴拷
			Connection conn = ds.getConnection();
			//瀵板懏澧界悰瀹籷l鐠囶厼褰�
			String sql = "insert into document(docSender,docReceiver,docTitle,docTime,docContent) values(?,?,?,?,?)";
			//缂佹獨ql娑擃厼寮弫锟�
			Object [] params = {doc.getDocSender(),doc.getDocReceiver(),doc.getDocTitle(),doc.getDocTime(),doc.getDocContent()};
		     //閹笛嗩攽鐠囶厼褰�
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
		//娴犲氦绻涢幒銉︾潨閼惧嘲褰囨稉锟芥稉顏囩箾閹猴拷
		try {
			Connection conn = ds.getConnection();
			//sql鐠囶厼褰�
			String sql = "delete from document where docId=?";
			//缂佹獨ql娑擃厾娈戦崣鍌涙殶
			Object [] params = {docId};
			 //閹笛嗩攽鐠囶厼褰�
			QueryRunner qr = new QueryRunner();
			result = qr.update(conn, sql, params);
			//閸忔娊妫存潻鐐村复
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
			System.out.println(keyword);
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
			String sql = "update document set docSender=?,docReceiver=?,docTitle=?,docTime=?,docContent=? where docId=?";
			Document doc = QueryById(docId);
			Object [] params = {doc.getDocSender(),doc.getDocReceiver(),doc.getDocTitle(),doc.getDocTime(),doc.getDocContent(),docId};
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
			//閼惧嘲褰囨潻鐐村复
			Connection conn = ds.getConnection();
			//sql鐠囶厼褰�
			String sql = "select * from document where docId=?";
			//瀵板懏澧界悰瀹籷l
			QueryRunner qr = new QueryRunner();
			 document = qr.query(conn,sql, new BeanHandler<Document>(Document.class), docId);
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return document;
	}

	
	public List<Document> QueryAll() {
		// TODO Auto-generated method stub
		List<Document> TempdocumentList =null;
		List<Document> documentList =null;
		try {
			Connection conn = ds.getConnection();
			String sql = "select * from document";
			QueryRunner qr = new QueryRunner();
			TempdocumentList=qr.query(conn, sql,  new BeanListHandler<Document>(Document.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return TempdocumentList;
	}

	public List<Document> QueryBySender(String docSender) {
		List<Document> TempdocumentList =null;
		List<Document> documentList =null;
		try {
			Connection conn = ds.getConnection();
			String sql = "select * from document where docSender=?";
			QueryRunner qr = new QueryRunner();
			TempdocumentList=qr.query(conn, sql,  new BeanListHandler<Document>(Document.class),docSender);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return TempdocumentList;
	}

	public List<Document> QueryByReceiver(String docReceiver) {
		List<Document> TempdocumentList =null;
		List<Document> documentList =null;
		try {
			Connection conn = ds.getConnection();
			String sql = "select * from document where docReceiver=?";
			QueryRunner qr = new QueryRunner();
			TempdocumentList=qr.query(conn, sql,  new BeanListHandler<Document>(Document.class),docReceiver);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return TempdocumentList;
	}

	/**
	 * 鏌ヨ鎬昏褰曟暟
	 * @return
	 * 
	 */
	public int count() {
		// TODO Auto-generated method stub
		Number n =null;
		
		try {
			Connection conn = ds.getConnection();
			String sql = "select count(*) from document";
			QueryRunner qr = new QueryRunner();
			 n = (Number)qr.query(conn,sql,new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n.intValue();
	}
	/**
	 * 鍒嗛〉鏌ヨ
	 * @param offet len
	 * @throws SQLException
	 */
	public List<Document> queryByPage(Page page ) throws SQLException {
		//鑾峰緱姣忛〉鐨勮褰曟暟
		int pageSize = page.getPageSize();
	    //璁＄畻浠庣澶氬皯鏉″紑濮嬪彇
		int pageLimt = (page.getCurrentPage()-1)*pageSize;
		
		String sql ="select * from document limit ?,?";
		Connection conn = ds.getConnection();
		QueryRunner qr = new QueryRunner();
		return qr.query(conn, sql,  new BeanListHandler<Document>(Document.class),pageLimt,pageSize);
	}

	public int counts(String keyword) {
            Number n =null;
		try {
			Connection conn = ds.getConnection();
			String sql = "select count(*) from document where docId in (select docId from document where docSender like '%"+keyword+"%'"
					+"or docTitle like '%"+keyword+"%'"
					+"or docReceiver like '%"+keyword+"%'"
					+"or docTime like '%"+keyword+"%'"
					+"or docContent like '%"+keyword+"%')";
			QueryRunner qr = new QueryRunner();
			 n = (Number)qr.query(conn,sql,new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n.intValue();
	}

	public List<Document> queryByPages(Page page,String keyword) throws SQLException {
		// TODO Auto-generated method stub
		//鑾峰緱姣忛〉鐨勮褰曟暟
				int pageSize = page.getPageSize();
			    //璁＄畻浠庣澶氬皯鏉″紑濮嬪彇
				int pageLimt = (page.getCurrentPage()-1)*pageSize;
				
				String sql ="select * from document where docId in (select docId from document where docSender like '%"+keyword+"%'"
					+"or docTitle like '%"+keyword+"%'"
					+"or docReceiver like '%"+keyword+"%'"
					+"or docTime like '%"+keyword+"%'"
					+"or docContent like '%"+keyword+"%') limit ?,?";
				Connection conn = ds.getConnection();
				QueryRunner qr = new QueryRunner();
				return qr.query(conn, sql,  new BeanListHandler<Document>(Document.class),pageLimt,pageSize);

	}


}
