package com.gump.action;

import java.util.List;

import com.gump.service_impl.PositionServiceImpl;
import com.gump.vo.Page;
import com.gump.vo.Position;

public class PositionAction{
	
	private List<Position> positionList;//职位集合
	private Page page;//当前页面
	private Position position;//职位vo对象
	
	
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
	

	/**
	 * 查询所有的职位信息
	 * @return
	 */
	public String listPosition(){
		int count = (int)new PositionServiceImpl().getPositionCount();
		System.out.println("count:"+count);
		//如果不是点击查看某一页，则默认是第一页
		if(page.getCurrentPage() < 0){
			//设置当前页面
			page.setCurrentPage(1);
		}
		positionList  = new PositionServiceImpl().listPosition(page);
		return "toPositionList";
	}
	
	
	/**
	 * 根据职位ID查询职位信息
	 * @return
	 */
	public String getPositionById(){
		
		position = new PositionServiceImpl().getPositionById(position.getPosId());
		return "toPositionList";
	}

	
	/**
	 * 根据职位名称查询职位信息
	 * @return
	 */
	public String getPositionByName(){
		
		position = new PositionServiceImpl().getPositionByName(position.getPosName());
		return "toPositionList";
	}
	
	/**
	 * 跳转到新增jsp页面
	 * @return
	 */
    public String goAddPositionPage(){
		return "goAddPage";
	}
	
	/**
	 * 新增职位操作，跳转到listPosition方法，并显示
	 * @return
	 */
	public void addPosition(){
		new PositionServiceImpl().savePosition(position);
		this.listPosition();
	}
	
	/**
	 * 根据ID删除职位，跳转到listPosition方法，并显示
	 * @return
	 */
	public void removePosition(){
		new PositionServiceImpl().removePosition(position.getPosId());
		this.listPosition();
	}
	
	/**
	 * 去修改职位界面
	 * @return
	 */
	public String goUpdatePositionPage(){
		return "goUpdatePage";
	}
	
	/**
	 * 修改职位信息操作
	 */
	public void updatePosition(){
		new PositionServiceImpl().updatePosition(position);
		this.listPosition();
	}

}
