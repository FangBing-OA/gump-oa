package com.gump.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.gump.service_impl.DocumentServiceImpl;
import com.gump.service_impl.EmployeeServiceImpl;
import com.gump.vo.Document;
import com.gump.vo.Employee;
import com.gump.vo.Page;
import com.opensymphony.xwork2.ActionContext;

public class DocumentAction {
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	private int docId;//
	private String docSender;//閸忣剚鏋冮崣鎴︼拷浣斤拷锟�
	private String docReceiver;//閸忣剚鏋冮幒銉︽暪閼帮拷
	private String docTitle;//閸忣剚鏋冮弽鍥暯
	private String docTime;//閸忣剚鏋冮弮鍫曟？
	private String docContent;//閸忣剚鏋冮崘鍛啇
	private String fileName;
	private File img;
	private String imgFileName;
	private String keyword;//鍏抽敭璇�
	private InputStream is;//
	private List<Employee> employeeList;
	private Page page = new Page();//椤甸潰瀵归潰
	private List<Document> currentPageData;
	private int g;
	//鍒涘缓涓�涓湇鍔″疄渚�
	private DocumentServiceImpl DSI = new DocumentServiceImpl();
	
	

	
	
	/*
	 * 浠庨〉闈㈣幏鍙栧彂閫佽�咃紝鏀朵欢鑰咃紝绯荤粺鏃堕棿锛岄檮浠惰矾寰勶紝澶囨敞绛夋儏鍐�
	 * 灏佽鍒癉ocument涓幓锛岀劧鍚庢坊鍔犲埌鏁版嵁搴�
	 */
	public String add(){
		//鑾峰彇鐧诲綍鍚�
		
		docSender = ((Employee) ActionContext.getContext().getSession().get("account")).getEmpName();
	
		EmployeeServiceImpl ESI = new EmployeeServiceImpl();
		List<Employee> employeeList = ESI.getAllEmp();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		docTime = df.format(new Date());
		if(img!=null){
			String path = ServletActionContext.getServletContext().getRealPath("/images/");
			File file =new File(path,imgFileName);
			try {
				FileUtils.copyFile(img, file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			docContent = path+"\\"+imgFileName;
			Document doc = new Document(docSender,docReceiver,docTitle,docTime,docContent);
			DSI.insertDoc(doc);
			return "add_success";
		}
		return "error";	
	}
	/*
	 * 杩欎釜鏌ヨ搴旇鐩稿綋浜庢敹浠剁,搴旇鏄寜濮撳悕鏌ヨ锛屽叧閿瘝鏌ヨ
	 */
	public String inquery() throws UnsupportedEncodingException{
		
		List<Document> doc=null;
		List<String> fileNames= new ArrayList<String>();
		String s = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
		doc=DSI.QueryByKeyword(s);
		for( int i=0;i<doc.size();i++){
			String path = doc.get(i).getDocContent();
			fileName = path.substring(path.lastIndexOf("\\")+1, path.length());
			doc.get(i).setFileName(fileName);
		}
		ActionContext.getContext().put("docList", doc);
		if(doc!=null){
			return "inquery_success";
		}else{
			return  "error";
		}	
	}
	/*
	 * 閫氳繃ID鍒犻櫎鐩稿簲鐨勫叕鏂�
	 */
	public String remove(){
		if(DSI.removeDoc(docId)>0){
			return "remove_success";
		}else{
			return "error";
		}
	}
    
	public String inqueryAll(){
		List<Document> doc=null;
	
		doc=DSI.QueryAll();
		for( int i=0;i<doc.size();i++){
			String path = doc.get(i).getDocContent();
			fileName = path.substring(path.lastIndexOf("\\")+1, path.length());
			doc.get(i).setFileName(fileName);
			
		}
		ActionContext.getContext().put("docList", doc);
		if(doc!=null){
			ActionContext.getContext().put("docList", doc);
			return "inqueryAll_success";
		}else{
			return "error";
		}
		
	}

 public String modify(){
	 Document doc = null;
	 doc = DSI.modifyDoc(docId);
	 if(doc!=null){
		 ActionContext.getContext().put("doc", doc);
		 
		 return "modify_success";
	 }else{
		 return "error";
	 }
 }
  public String download(){
	  
	  try {
		  String path = ServletActionContext.getServletContext().getRealPath("/images/");
		  File file = new File(path+"\\"+fileName);
		  fileName = new String(fileName.getBytes("utf-8"),"ISO8859-1");
		 is = new FileInputStream(file);
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return "download_success";
  }

  
  public String QueryBySender(){
	  //鑾峰彇绛夊綍鑰�
		docSender = ((Employee) ActionContext.getContext().getSession().get("account")).getEmpName();
	
	   List<Document> doc=null;
	   doc =DSI.QueryBySender(docSender);
	   for( int i=0;i<doc.size();i++){
			String path = doc.get(i).getDocContent();
			fileName = path.substring(path.lastIndexOf("\\")+1, path.length());
			doc.get(i).setFileName(fileName);
			
		}
	   if(doc!=null){
			ActionContext.getContext().put("docList", doc);
			return "inqueryBySender_success";
		}else{
			return "error";
		}
	   
  }
  public String QueryByReceiver(){

	  docSender = ((Employee) ActionContext.getContext().getSession().get("account")).getEmpName();
	   List<Document> doc=null;
	   doc =DSI.QueryByReceiver(docSender);
	   for( int i=0;i<doc.size();i++){
			String path = doc.get(i).getDocContent();
			fileName = path.substring(path.lastIndexOf("\\")+1, path.length());
			doc.get(i).setFileName(fileName);
			
		}
	   if(doc!=null){
			ActionContext.getContext().put("docList", doc);
			return "inqueryByReceiver_success";
		}else{
			return "error";
		}
  }
  
  public String newAdd(){
	 
	  EmployeeServiceImpl ESI = new EmployeeServiceImpl();
		List<Employee> employeeList = ESI.getAllEmp();
		setEmployeeList(employeeList);
		if(employeeList!=null){
			return "newAdd_success";
		}else
		{
			return "error";
		}
	  
  }
  /**
   * 鍒嗛〉澶勭悊鏂规硶
   * @return
 * @throws SQLException 
   */
  public String pageMethod() throws SQLException {
	  //鏌ヨ鏌ヨ鎬昏褰曟暟
	  int count =DSI.count();
	  //鏌ヨ褰撻〉鐨勬暟鎹�
	  int currentPage = g;
	  //鏋勯�犱竴涓柊鐨刾age瀵硅薄锛屽苟灏哻urrentPage鍜宑ount璁剧疆杩涘幓
	  page.setCount(count);
	  page.setCurrentPage(currentPage);
	  //鑾峰彇褰撻〉璁板綍
	  List<Document> doc = DSI.queryByPage(page); 
	  page.setData(doc); 
		for( int i=0;i<doc.size();i++){
			String path = doc.get(i).getDocContent();
			fileName = path.substring(path.lastIndexOf("\\")+1, path.length());
			doc.get(i).setFileName(fileName);
			
		}
	  return "page_success";
	  
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


	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDocTime() {
		return docTime;
	}


	public void setDocTime(String docTime) {
		this.docTime = docTime;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public String getDocContent() {
		return docContent;
	}

	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Document> getCurrentPageData() {
		return currentPageData;
	}
	public void setCurrentPageData(List<Document> currentPageData) {
		this.currentPageData = currentPageData;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	

	
}
