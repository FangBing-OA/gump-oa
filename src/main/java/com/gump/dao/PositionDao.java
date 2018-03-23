package com.gump.dao;

import java.util.List;

import com.gump.vo.PositionVo;


public interface PositionDao {
	
	/**
	 * 查询所有的部门
	 * @return List<PositionVo>
	 */
	public List<PositionVo> selectAllPosition();
	

	/**
	 * 根据Id查询部门
	 * @return PositionVo
	 * @param  positionId
	 */
	public PositionVo selectPositionById(int positionId);
	
	/**
	 * 根据部门名称查询部门
	 * @return PositionVo
	 * @param  positionName
	 */
	public PositionVo selectPositionByName(String positionName);
	
	
	/**
	 * 添加一个新的职位
	 * @param posId,posName,posDescribe
	 */
	public void addPos(int posId,String posName,String posDescribe);

}
