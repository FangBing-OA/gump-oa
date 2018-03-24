package com.gump.service_impl;

import java.util.List;

import com.gump.dao.IDocumentDao;
import com.gump.dao_impl.DocumentDaoImpl;
import com.gump.service.IDocumentService;
import com.gump.vo.Document;

public class DocumentServiceImpl implements IDocumentService {
	private IDocumentDao d = new DocumentDaoImpl();

	/**
	 * 插入公文
	 */
	public int insertDoc(Document doc) {
		// TODO Auto-generated method stub
		return d.insertDoc(doc);
	}
     /**
      * 删除公文
      */
	public int removeDoc(int docId) {
		// TODO Auto-generated method stub
		return d.removeDoc(docId);
	}
    /**
     * 通过关键字查询公文
     */
	public List<Document> QueryByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return d.QueryByKeyword(keyword);
	}
    /**
     * 通过id修改公文
     */
	public Document modifyDoc(int docId) {
		// TODO Auto-generated method stub
		return d.modifyDoc(docId);
	}
    /**
     * 通过id查询公文
     */
	public Document QueryById(int docId) {
		// TODO Auto-generated method stub
		return d.QueryById(docId);
	}

}
