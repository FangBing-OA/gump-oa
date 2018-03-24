package com.gump.service_impl;

import java.util.List;

import com.gump.dao_impl.PositionDaoImpl;
import com.gump.service.IPositionService;
import com.gump.vo.Page;
import com.gump.vo.Position;

public class PositionServiceImpl implements IPositionService {

	/**
	 * 查询所有的职位信息
	 * @return List<PositionVo>
	 */
	public List<Position> listPosition(Page page){
		return new PositionDaoImpl().listPosition(page);
	}
	
	
	/**
	 * 根据职位ID查询职位信息
	 * @param posId
	 * @return PositionVo
	 */
	public Position getPositionById(int posId){
		return new PositionDaoImpl().getPositionById(posId);
	}

	
	/**
	 * 根据职位名查询职位信息
	 * @param posName
	 * @return
	 */
	public Position getPositionByName(String posName){
		return new PositionDaoImpl().getPositionByName(posName);
		
	}
	
	/**
	 * 新增职位
	 * @param pos
	 */
	public void savePosition(Position pos){
		new PositionDaoImpl().savePosition(pos);
		
	}
	
	/**
	 * 根据职位ID删除一个职位
	 * @param posId
	 */
	public void removePosition(int posId){
		new PositionDaoImpl().removePosition(posId);
	}
	
	/**
	 * 根据职位ID修改职位信息
	 * @param posId
	 */
	public void updatePosition(Position pos){
		new PositionDaoImpl().updatePosition(pos);
	}
	
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public long getPositionCount(){
		return new PositionDaoImpl().getPositionCount();
	}
}
