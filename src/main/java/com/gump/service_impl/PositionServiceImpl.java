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
	public List<Position> selectAllPosition(Page page){
		return new PositionDaoImpl().selectAllPosition(page);
	}
	
	
	/**
	 * 根据职位ID查询职位信息
	 * @param posId
	 * @return PositionVo
	 */
	public Position selectPositionById(int posId){
		return new PositionDaoImpl().selectPosById(posId);
	}

	
	/**
	 * 根据职位名查询职位信息
	 * @param posName
	 * @return
	 */
	public Position selectPositionByName(String posName){
		return new PositionDaoImpl().selectPosByName(posName);
		
	}
	
	/**
	 * 新增职位
	 * @param pos
	 */
	public void insertPosition(Position pos){
		new PositionDaoImpl().addPos(pos);
		
	}
	
	/**
	 * 根据职位ID删除一个职位
	 * @param posId
	 */
	public void deletePostion(int posId){
		new PositionDaoImpl().deletePos(posId);
	}
	
	/**
	 * 根据职位ID修改职位信息
	 * @param posId
	 */
	public void updatePosition(Position pos){
		new PositionDaoImpl().updatePos(pos);
	}
}
