package com.gump.vo;

public class Document {
	private int docId;//公文id
	private String docSender;//公文发送者
	private String docReceiver;//公文接收者
	private String docTitle;//公文标题
	private String docTime;//公文时间
	private String docContent;//公文内容
	
	
	
   //getter and settr method
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocSender() {
		return docSender;
	}
	public void setDocSender(String docSender) {
		this.docSender = docSender;
	}
	public String getDocReceiver() {
		return docReceiver;
	}
	public void setDocReceiver(String docReceiver) {
		this.docReceiver = docReceiver;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	public String getDocTime() {
		return docTime;
	}
	public void setDocTime(String docTime) {
		this.docTime = docTime;
	}
	public String getDocContent() {
		return docContent;
	}
	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}
	
}
