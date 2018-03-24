package com.gump.service_impl;

import java.util.List;

import com.gump.dao_impl.PositionDaoImpl;
import com.gump.service.PositionService;
import com.gump.vo.Page;
import com.gump.vo.PositionVo;

public class PositionServiceImpl implements PositionService {

	/**
	 * 查询所有的职位信息
	 * @return List<PositionVo>
	 */
	public List<PositionVo> selectAllPosition(Page page){
		return new PositionDaoImpl().selectAllPosition(page);
	}
	
	
	/**
	 * 根据职位ID查询职位信息
	 * @param posId
	 * @return PositionVo
	 */
	public PositionVo selectPositionById(int posId){
		return new PositionDaoImpl().selectPosById(posId);
	}

	
	/**
	 * 根据职位名查询职位信息
	 * @param posName
	 * @return
	 */
	public PositionVo selectPositionByName(String posName){
		return new PositionDaoImpl().selectPosByName(posName);
		
	}
	
	/**
	 * 新增职位
	 * @param pos
	 */
	public void insertPosition(PositionVo pos){
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
	public void updatePosition(PositionVo pos){
		new PositionDaoImpl().updatePos(pos);
	}
}
