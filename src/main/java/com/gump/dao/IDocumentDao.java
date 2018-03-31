package com.gump.dao;

import java.sql.SQLException;
import java.util.List;

import com.gump.vo.Document;
import com.gump.vo.Page;

public interface IDocumentDao {
	public int insertDoc(Document doc);//插入公文
	public int removeDoc(int docId);//鍒犻櫎鍏枃
	public List<Document> QueryByKeyword(String keyword);//閫氳繃鍏抽敭瀛楁煡璇㈠叕鏂�
	public Document modifyDoc(int docId);//淇敼鍏枃
	public Document QueryById(int docId);//閫氳繃id鏌ヨ鍏枃
	public List<Document> QueryAll();
	public List<Document> QueryBySender(String docSender);
	public List<Document> QueryByReceiver(String docReceiver);
	public int count () ;//查询总记录数
	public List<Document> queryByPage(Page page) throws SQLException;//分页查询
	public int counts(String keyword);//子查询记录数
	public List<Document> queryByPages(Page page,String keyword) throws SQLException;//子分页查询
	
}
