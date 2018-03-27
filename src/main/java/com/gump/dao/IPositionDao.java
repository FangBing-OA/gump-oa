package com.gump.dao;

import java.util.List;

import com.gump.vo.Page;
import com.gump.vo.Position;


public interface IPositionDao {
	
	/**
	 * 查询所有的职位
	 * @return List<PositionVo>
	 * @param  page
	 */
	public List<Position> listPosition(Page page);
	

	/**
	 * 根据Id查询职位
	 * @return PositionVo
	 * @param  List<Position>
	 */
	public List<Position> getPositionById(int posId);
	
	/**
	 * 根据部门名称查询职位
	 * @return List<Position>
	 * @param  positionName
	 */
	public List<Position> getPositionByName(String posName);
	
	
	/**
	 * 添加一个新的职位
	 * @param pos
	 */
	public void savePosition(Position pos);
	
	
	/**
	 * 根据职位Id删除职位
	 * @param posId
	 */
	public void removePosition(int posId);
	
	
	
	/**
	 * 根据职位Id修改职位信息
	 * @param posId
	 */
	public void updatePosition(Position pos);
	
	/**
	 * 查询所有记录数
	 * @return
	 */
	public long getPositionCount();
	
	/**
	 * 查询所有的职位，不分页
	 * @return
	 */
	public List<Position> AllPosition();

}
