package com.gump.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.gump.service.IMessageService;
import com.gump.service_impl.MessageServiceImpl;
import com.gump.utils.TimeCycleUtils;
import com.gump.vo.Employee;
import com.gump.vo.Message;
import com.gump.vo.Page;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction implements SessionAware,ModelDriven<Message>{
	private Page page;//页面信息---------------------//使用时要new
	private Message message;//消息
	private int messageCurrent;//当前页数，用于从前台传值
	private int messageId;//消息Id，用于从前台传值
	private List<Integer> idList;//消息Id集合
	private static String keyword;//关键字，用于Sa查询
	private IMessageService ims = new MessageServiceImpl();//實例化IMessageService
	private Map<String, Object> mySession;
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getMessageCurrent() {
		return messageCurrent;
	}
	public void setMessageCurrent(int messageCurrent) {
		this.messageCurrent = messageCurrent;
	}
	public Map<String, Object> getMySession() {
		return mySession;
	}
	public void setMySession(Map<String, Object> mySession) {
		this.mySession = mySession;
	}

	public IMessageService getIms() {
		return ims;
	}
	public void setIms(IMessageService ims) {
		this.ims = ims;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public List<Integer> getIdList() {
		return idList;
	}
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.mySession = arg0;
	}
	
	/************************发送界面**********************************/	
	/**
	 * 轉到发送界面
	 * @return
	 */
	public String toSave(){
		return "tosave";
	}
	
	/**
	 * 执行发送,转到发件箱
	 * @return
	 */
	public String doSave(){
		ims = new MessageServiceImpl();
		//得到帐号
		/************>>>>>>>>>>>>>>>未确定******************/
		Employee nowStaff = (Employee)mySession.get("NowStaff");
		message.setMesSender(nowStaff.getEmpAccount());
		message.setTime();
		message.setMesRead(false);
		boolean flag = ims.saveMessage(message);
		return "dosave";
	}
	/***************************************************************/	
	

	/**
	 * 执行删除：转到当前页面（不行就转到收件箱）
	 * @return
	 */
	public String doRemove(){
		ims = new MessageServiceImpl();
		boolean flag = ims.removeMessage(idList);
		return "doremove";
	}
	
	/************************显示消息**********************************/	
	/**
	 * 转到查看信息页面
	 * @return
	 */
	public String toShow(){
		ims.updateMessageRead(messageId);
		message = ims.getMessageById(messageId);
		return "toshow";
	}
	
	/**
	 * 转到查看信息页面(自己查看)
	 * @return
	 */
	public String toShowMyself(){
		message = ims.getMessageById(messageId);
		return "toshow";
	}
	
	/**
	 * 返回上一界面(判断是发件箱，还是收件箱 ，根据条件返回：注意页数 )
	 * @return
	 */
	public String doReturn(){//试得到请求的地址
		return "";
	}
	/***************************************************************/	
	
	/************************收件箱**********************************/	
	
	/**
	 * 转到收件箱
	 * @return
	 */
	public String toInBox(){
		//ActionContext context = ActionContext.getContext();
		//Map<String, Object> session = context.getSession();
		
		//得到当前时间
		Date date = new Date();
		String timeEnd = TimeCycleUtils.dateToDetailString(date);
		//得到帐号
		/************>>>>>>>>>>>>>>>未确定******************/
		Employee nowStaff = (Employee)mySession.get("NowStaff");
		String account = (String)mySession.get(nowStaff.getEmpAccount());
		//获得总记录数
		long count = ims.countMessageInTimeQuantum("1990-01-01 00:00:00", timeEnd, account);
		page.setCount((int)count);
		//从session中获得当前页
		Page pageSession = (Page)mySession.get("messageInBox");
		page.setCurrentPage(pageSession.getCurrentPage());
		
		//获得返回消息集合
		List<Message> list = ims.listMessageInTimeQuantum("1990-01-01 00:00:00", timeEnd, account, page);
		page.setData(list);
		
		//将数据存入session
		mySession.put("messageInBox", page);
		return "toinbox";
	}
	
	/**
	 * 重定向转到收件箱（从左侧菜单栏跳转）
	 * @return
	 */
	public String toRedirectInBox(){
		ims = new MessageServiceImpl();
		//得到当前时间
		Date date = new Date();
		String timeEnd = TimeCycleUtils.dateToDetailString(date);
		//得到帐号
		//ActionContext context = ActionContext.getContext();
		//Map<String, Object> session = context.getSession();
		/************>>>>>>>>>>>>>>>未确定******************/
		Employee nowStaff = (Employee)mySession.get("NowStaff");
		String account = (String)mySession.get(nowStaff.getEmpAccount());
		//获得总记录数
		int count = (int)(ims.countMessageInTimeQuantum("1990-01-01 00:00:00", timeEnd, account));
		page = new Page();
		page.setCount(count);
		page.setCurrentPage(1);
		
		//获得返回消息集合
		List<Message> list = ims.listMessageInTimeQuantum("1990-01-01 00:00:00", timeEnd, account, page);
		page.setData(list);
		
		//将数据存入session
		mySession.put("messageInBox", page);
		return "toreinbox";
	}
	
	/**
	 * 获得所有消息的指定页数的信息，刷新页面(上一页、下一页、首页、尾页、跳转至未读消息的按钮)
	 * @return
	 */
	public String toInBoxAllPage(){
		//得到当前时间
		Date date = new Date();
		String timeEnd = TimeCycleUtils.dateToDetailString(date);
		//得到帐号
		//ActionContext context = ActionContext.getContext();
		//Map<String, Object> session = context.getSession();
		/************>>>>>>>>>>>>>>>未确定******************/
		Employee nowStaff = (Employee)mySession.get("NowStaff");
		String account = (String)mySession.get(nowStaff.getEmpAccount());
		//获得总记录数
		page = new Page();
		long count = ims.countMessageInTimeQuantum("1990-01-01 00:00:00",timeEnd,account);
		page.setCount((int)count);
		page.setCurrentPage(messageCurrent);
		
		//获得返回消息集合
		List<Message> list = ims.listMessageInTimeQuantum("1990-01-01 00:00:00", timeEnd, account, page);
		page.setData(list);
		
		//将数据存入session
		mySession.put("messageInBox", page);
		
		return "toall";
	}
	
	/**
	 * 获得未读消息的指定页数的信息，刷新页面(上一页、下一页、首页、尾页、跳转至所有消息的按钮)
	 * @return
	 */
	public String toInBoxNotReadPage(){
		//得到帐号
		//ActionContext context = ActionContext.getContext();
		//Map<String, Object> session = context.getSession();
		/************>>>>>>>>>>>>>>>未确定******************/
		Employee nowStaff = (Employee)mySession.get("NowStaff");
		String account = (String)mySession.get(nowStaff.getEmpAccount());
		//得到总总记录数
		long count = ims.countMessageNotRead(account);
		page.setCount((int)count);
		page.setCurrentPage(page.getCurrentPage());
		
		//获得返回消息集合
		List<Message> list = ims.listMessageNotRead(account, page);
		page.setData(list);
		
		//将数据存入session
		mySession.put("messageNotReadInBox", page);
		
		return "tonot";
	}
	
	/**
	 * 跳转到回复页面(发送界面)
	 * @return
	 */
	public String toReplyPage(){
		if(null != message.getMesSender()){
			
		}else{
			message.setMesSender("");
		}
		return "toreply";
	}
	
	/*****************************************************************************************/
	
	/**********************************发件箱***************************************************/
	
	/**
	 * 转到发件箱(存放所有发送消息)
	 * @return
	 */
	public String toOutbox(){
		ims = new MessageServiceImpl();
		//得到帐号
		//ActionContext context = ActionContext.getContext();
		//Map<String, Object> session = context.getSession();
		/************>>>>>>>>>>>>>>>未确定******************/
		Employee nowStaff = (Employee)mySession.get("NowStaff");
		String account = (String)mySession.get(nowStaff.getEmpAccount());
		//获得总记录数
		long count = ims.countSendMessage(account);
		page.setCount((int)count);
		//从session中获得当前页
		Page pageSession = (Page)mySession.get("messageInBox");
		page.setCurrentPage(pageSession.getCurrentPage());	
		
		//获得返回消息集合
		List<Message> list = ims.listSendMseeage(account, page);
		System.out.println("-------------"+list.size());
		page.setData(list);
		
		//将数据存入session
		mySession.put("messageOutBox", page);
		return "toout";
	}
	
	/**
	 * 重定向转到发件箱(存放所有发送消息)（从左侧菜单栏跳转）
	 * @return
	 */
	public String toRedirectOutbox(){
		ims = new MessageServiceImpl();
		//得到帐号
		//ActionContext context = ActionContext.getContext();
		//Map<String, Object> session = context.getSession();
		/************>>>>>>>>>>>>>>>未确定******************/
		Employee nowStaff = (Employee)mySession.get("NowStaff");
		String account = (String)mySession.get(nowStaff.getEmpAccount());
		//获得总记录数
		long count = ims.countSendMessage(account);
		page = new Page();
		page.setCount((int)count);
		page.setCurrentPage(1);
		
		//获得返回消息集合
		List<Message> list = ims.listSendMseeage(account, page);
		page.setData(list);
		
		//将数据存入session
		mySession.put("messageOutBox", page);
		return "toreout";
	}
	
	/**
	 * 获得发送消息的指定页数的信息，刷新页面(上一页、下一页、首页、尾页)
	 * @return
	 */
	public String toOutBoxPage(){
		ims = new MessageServiceImpl();
		//得到帐号
		//ActionContext context = ActionContext.getContext();
		//Map<String, Object> session = context.getSession();
		/************>>>>>>>>>>>>>>>未确定******************/
		Employee nowStaff = (Employee)mySession.get("NowStaff");
		String account = (String)mySession.get(nowStaff.getEmpAccount());
		//获得总记录数
		long count = ims.countSendMessage(account);
		page = new Page();
		page.setCount((int)count);
		//从session中获得当前页
		page.setCurrentPage(messageCurrent);	
		
		//获得返回消息集合
		List<Message> list = ims.listSendMseeage(account, page);
		page.setData(list);
		
		//将数据存入session
		mySession.put("messageOutBox", page);
		return "tosend";
	}
	/*******************************************************************************************/


	/********************************************html中message***********************************************/
	
	/**
	 * 获得拥有关键字所有消息的指定页数的信息，刷新页面(上一页、下一页、首页、尾页)
	 * @return
	 */
	public String toInBoxAllPageInSa(){
		//获得总记录数
		page = new Page();
		if(null == keyword){
			keyword="";
		}
		long count = ims.countMessageByKeyword(keyword);
		page.setCount((int)count);
		page.setCurrentPage(messageCurrent);
		
		//获得返回消息集合
		List<Message> list = ims.listMessageByKeyword(keyword, page);
		page.setData(list);
		
		//将数据存入session
		mySession.put("messageInBox", page);
		
		return "toallSa";
	}

	/**
	 * 转到查看信息页面(自己查看)
	 * @return
	 */
	public String toShowMyselfInSa(){
		message = ims.getMessageById(messageId);
		return "toshowSa";
	}
	
	/**
	 * 删除消息
	 * @return
	 */
	public String doRemoveMessage(){
		idList = new ArrayList<Integer>();
		idList.add(messageId);
		ims.removeMessage(idList);
		return "toallreturn";
	}
	public Message getModel() {
		return getMessage();
	}
	
	/********************************************************************************************************/
}