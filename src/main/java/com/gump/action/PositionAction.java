package com.gump.action;

import java.util.List;

import com.gump.commons.JudgeRole;
import com.gump.service_impl.PositionServiceImpl;
import com.gump.vo.Page;
import com.gump.vo.Position;

public class PositionAction{
	
	private List<Position> positionList;//职位集合
	private Page page;//当前页面
	private int g;
	private Position position ;//职位vo对象
	private List<Position> listName;//下拉框集合
	private int posId;
	
	
	
	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public List<Position> getListName() {
		return listName;
	}

	public void setListName(List<Position> listName) {
		this.listName = listName;
	}

	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
		position.setPosId(posId);
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String excute(){
		return null;
	}
	

	
	public String PositionBy(){
		//获取所有的职位名称集合(实际为所有职位信息集合)
		listName = new PositionServiceImpl().AllPosition();
		
		//通过Id查询Position
		 if(position.getPosId() > 0){
			positionList = new PositionServiceImpl().getPositionById(position.getPosId());
			//通过Name查询Position
		}else{
			positionList = new PositionServiceImpl().getPositionByName(position.getPosName());
		} 
		return "toadminlist";
	}
	/**
	 * 查询所有的职位信息
	 * @return
	 */
	public String listPosition(){
		
		   page = new Page();
		   
		   //获取所有的职位名称集合(实际为所有职位信息集合)
		   listName = new PositionServiceImpl().AllPosition();
		   
		   //获取总记录数并设置
		   int count = (int)new PositionServiceImpl().getPositionCount();
		   page.setCount(count);
			
		   page.setCurrentPage(g); 
		   
			//设置当前页面
			page.setCurrentPage(page.getCurrentPage());
			//开始查询所有记录数
			positionList  = new PositionServiceImpl().listPosition(page);
			if(JudgeRole.isAdmin()){
				return "toadminlist";
			}else{
				return "tostafflist";
			}
	}
	
	
	/**
	 * 根据职位ID查询职位信息
	 * @return
	 */
	public String getPositionById(){
		
		page = new Page();
		//获取总记录数并设置
		int count = (int)new PositionServiceImpl().getPositionCount();
		page.setCount(count);
		
		//设置当前页面
		page.setCurrentPage(1);
		
		//开始查询记录
		positionList = new PositionServiceImpl().getPositionById(position.getPosId());
		
		//获取所有的职位名称集合(实际为所有职位信息集合)
		listName  = new PositionServiceImpl().AllPosition();
		return "toadminlist";
	}

	
	/**
	 * 根据职位名称查询职位信息
	 * @return
	 */
	public String getPositionByName(){
		//获取所有的职位名称集合(实际为所有职位信息集合)
		listName = new PositionServiceImpl().AllPosition();
		
		//开始查询记录
		positionList = new PositionServiceImpl().getPositionByName(position.getPosName());
		return "toadminlist";
	}
	
	/**
	 * 跳转到新增jsp页面
	 * @return
	 */
    public String goAddPositionPage(){
    	//获取所有的职位名称集合(实际为所有职位信息集合)
    	listName = new PositionServiceImpl().AllPosition();
		return "goAddPage";
	}
	
	/**
	 * 新增职位操作，跳转到listPosition方法，并显示
	 * @return
	 */
	public String addPosition(){
		//获取所有的职位名称集合(实际为所有职位信息集合)
		listName = new PositionServiceImpl().AllPosition();
		
		//开始新增职位信息
		new PositionServiceImpl().savePosition(position);
		return this.listPosition();
	}
	
	/**
	 * 根据ID删除职位，跳转到listPosition方法，并显示
	 * @return
	 */
	public String removePosition(){
		//获取所有的职位名称集合(实际为所有职位信息集合)
		listName = new PositionServiceImpl().AllPosition();
		
		//开始删除职位
		new PositionServiceImpl().removePosition(position.getPosId());
		return this.listPosition();
	}
	
	/**
	 * 去修改职位界面
	 * @return
	 */
	public String goUpdatePositionPage(){
		//获取所有的职位名称集合(实际为所有职位信息集合)
		listName = new PositionServiceImpl().AllPosition();
		return "goUpdatePage";
	}
	
	/**
	 * 修改职位信息操作
	 */
	public String  updatePosition(){
		page = new Page();
		//获取所有的职位名称集合(实际为所有职位信息集合)
		listName = new PositionServiceImpl().AllPosition();
		
		//设置当前页面为1
		page.setCurrentPage(1);
		
		//开始修改职位信息
		new PositionServiceImpl().updatePosition(position);
		 return this.listPosition();
	}
	

}
