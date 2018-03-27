package com.gump.service;

import java.util.List;

import com.gump.vo.Page;
import com.gump.vo.Position;


public interface IPositionService {
	
	
	/**
	 * 查询所有的职位信息
	 * @return List<Position>
	 */
	public List<Position> listPosition(Page page);
	
	
	/**
	 * 根据职位ID查询职位信息
	 * @param posId
	 * @return List<Position>
	 */
	public List<Position> getPositionById(int posId);

	
	/**
	 * 根据职位名查询职位信息
	 * @param posName
	 * @return List<Position>
	 */
	public List<Position> getPositionByName(String posName);
	
	/**
	 * 新增职位
	 * @param pos
	 */
	public void savePosition(Position pos);
	
	/**
	 * 根据职位ID删除一个职位
	 * @param posId
	 */
	public void removePosition(int posId);
	
	/**
	 * 根据职位ID修改职位信息
	 * @param posId
	 */
	public void updatePosition(Position pos);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public long getPositionCount();
	
	/**
	 * 查询所有的职位，不分页
	 * @return List<Position>
	 */
	public List<Position> AllPosition();
	
}
