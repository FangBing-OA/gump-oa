package com.gump.dao;

import java.util.List;
import java.util.Set;

import com.gump.vo.Document;

public interface IDocumentDao {
	public int insertDoc(Document doc);//插入公文
	public int removeDoc(int docId);//删除公文
	public List<Document> QueryByKeyword(String keyword);//通过关键字查询公文
	public Document modifyDoc(int docId);//修改公文
	public Document QueryById(int docId);//通过id查询公文
}
