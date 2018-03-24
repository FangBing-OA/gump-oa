package com.gump.service;

import java.util.List;

import com.gump.vo.Document;

public interface IDocumentService {
	/**
	 * 插入公文
	 * @param doc
	 * @return
	 */
	public int insertDoc(Document doc);
    /**
     * 删除公文
     * @param docId
     * @return
     */
	public int removeDoc(int docId);//删除公文
	/**
	 * 通过关键字查询公文
	 * @param keyword
	 * @return
	 */
	public List<Document> QueryByKeyword(String keyword);//通过关键字查询公文
	/**
	 * 修改公文
	 * @param docId
	 * @return
	 */
	public Document modifyDoc(int docId);//修改公文
	/**
	 * 通过id查询公文
	 * @param docId
	 * @return
	 */
	public Document QueryById(int docId);//通过id查询公文
}
