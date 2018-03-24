package com.gump.dao;

import java.util.List;

import com.gump.vo.Page;
import com.gump.vo.PositionVo;


public interface PositionDao {
	
	/**
	 * 查询所有的职位
	 * @return List<PositionVo>
	 * @param  page
	 */
	public List<PositionVo> selectAllPosition(Page page);
	

	/**
	 * 根据Id查询职位
	 * @return PositionVo
	 * @param  positionId
	 */
	public PositionVo selectPosById(int posId);
	
	/**
	 * 根据部门名称查询职位
	 * @return PositionVo
	 * @param  positionName
	 */
	public PositionVo selectPosByName(String posName);
	
	
	/**
	 * 添加一个新的职位
	 * @param pos
	 */
	public void addPos(PositionVo pos);
	
	
	/**
	 * 根据职位Id删除职位
	 * @param posId
	 */
	public void deletePos(int posId);
	
	
	
	/**
	 * 根据职位Id修改职位信息
	 * @param posId
	 */
	public void updatePos(PositionVo pos);
	
	/**
	 * 查询所有记录数
	 * @return
	 */
	public long allPositionCount();

}
