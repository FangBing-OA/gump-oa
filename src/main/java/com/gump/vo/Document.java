package com.gump.vo;
 
import com.gump.service_impl.DocumentServiceImpl;

public class Document {
	private int docId;//鍏枃id
	private String docSender;//鍏枃鍙戦�佽��
	private String docReceiver;//
	private String docTitle;//鍏枃鏍囬
	private String docTime;//鍏枃鏃堕棿
	private String docContent;//鍏枃鍐呭
	private String fileName;
	
	
	
	
	
   public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
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
	//constructor method
	public Document(){
		
	}
	public Document(String docSender, String docReceiver, String docTitle, String docTime, String docContent) {
		super();
		this.docSender = docSender;
		this.docReceiver = docReceiver;
		this.docTitle = docTitle;
		this.docTime = docTime;
		this.docContent = docContent;
	}
	@Override
	public String toString() {
		return "Document [docId=" + docId + ", docSender=" + docSender + ", docReceiver=" + docReceiver + ", docTitle="
				+ docTitle + ", docTime=" + docTime + ", docContent=" + docContent + "]";
	}
	
	
	
}
