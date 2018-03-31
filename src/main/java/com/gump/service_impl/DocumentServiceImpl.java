package com.gump.service_impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import com.gump.dao.IDocumentDao;
import com.gump.dao_impl.DocumentDaoImpl;
import com.gump.service.IDocumentService;
import com.gump.vo.Document;
import com.gump.vo.Page;

public class DocumentServiceImpl implements IDocumentService {
	private IDocumentDao d = new DocumentDaoImpl();

	/**
	 * 鎻掑叆鍏枃
	 */
	public int insertDoc(Document doc) {
		// TODO Auto-generated method stub
		return d.insertDoc(doc);
	}
     /**
      * 鍒犻櫎鍏枃
      */
	public int removeDoc(int docId) {
		// TODO Auto-generated method stub
		Document doc=d.QueryById(docId);
		String path = doc.getDocContent();
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
		return d.removeDoc(docId);
	}
    /**
     * 閫氳繃鍏抽敭瀛楁煡璇㈠叕鏂�
     */
	public List<Document> QueryByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return d.QueryByKeyword(keyword);
	}
    /**
     * 閫氳繃id淇敼鍏枃
     */
	public Document modifyDoc(int docId) {
		// TODO Auto-generated method stub
		return d.modifyDoc(docId);
	}
    /**
     * 閫氳繃id鏌ヨ鍏枃
     */
	public Document QueryById(int docId) {
		// TODO Auto-generated method stub
		return d.QueryById(docId);
	}
	public List<Document> QueryAll() {
		// TODO Auto-generated method stub
		return d.QueryAll();
	}
	public List<Document> QueryBySender(String docSender) {
		// TODO Auto-generated method stub
		return d.QueryBySender(docSender);
	}
	public List<Document> QueryByReceiver(String docReceiver) {
		// TODO Auto-generated method stub
		return d.QueryByReceiver(docReceiver);
	}
	
	public int count() {
		return d.count();
	}
	public List<Document> queryByPage(Page page) throws SQLException {
		// TODO Auto-generated method stub
		return d.queryByPage(page);
	}
	

}
