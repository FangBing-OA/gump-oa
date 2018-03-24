package com.gump.service;

import java.util.List;

import com.gump.vo.Page;
import com.gump.vo.PositionVo;


public interface PositionService {
	
	
	/**
	 * 查询所有的职位信息
	 * @return List<PositionVo>
	 */
	public List<PositionVo> selectAllPosition(Page page);
	
	
	/**
	 * 根据职位ID查询职位信息
	 * @param posId
	 * @return List<PositionVo>
	 */
	public PositionVo selectPositionById(int posId);

	
	/**
	 * 根据职位名查询职位信息
	 * @param posName
	 * @return
	 */
	public PositionVo selectPositionByName(String posName);
	
	/**
	 * 新增职位
	 * @param pos
	 */
	public void insertPosition(PositionVo pos);
	
	/**
	 * 根据职位ID删除一个职位
	 * @param posId
	 */
	public void deletePostion(int posId);
	
	/**
	 * 根据职位ID修改职位信息
	 * @param posId
	 */
	public void updatePosition(PositionVo pos);
}
