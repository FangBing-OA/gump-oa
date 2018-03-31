package com.gump.service;

import java.sql.SQLException;
import java.util.List;

import com.gump.vo.Document;
import com.gump.vo.Page;

public interface IDocumentService {
	/**
	 * 鎻掑叆鍏枃
	 * @param doc
	 * @return
	 */
	public int insertDoc(Document doc);
    /**
     * 鍒犻櫎鍏枃
     * @param docId
     * @return
     */
	public int removeDoc(int docId);//鍒犻櫎鍏枃
	/**
	 * 閫氳繃鍏抽敭瀛楁煡璇㈠叕鏂�
	 * @param keyword
	 * @return
	 */
	public List<Document> QueryByKeyword(String keyword);//閫氳繃鍏抽敭瀛楁煡璇㈠叕鏂�
	/**
	 * 淇敼鍏枃
	 * @param docId
	 * @return
	 */
	public Document modifyDoc(int docId);//淇敼鍏枃
	/**
	 * 閫氳繃id鏌ヨ鍏枃
	 * @param docId
	 * @return
	 */
	public Document QueryById(int docId);//閫氳繃id鏌ヨ鍏枃
	public List<Document> QueryAll();
	public List<Document> QueryBySender(String docSender);
	public List<Document> QueryByReceiver(String docReceiver);
	public int count () ;//查询总记录数
	public List<Document> queryByPage(Page page) throws SQLException;//分页查询
}
