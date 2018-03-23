package com.gump.dao_impl;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gump.dao.PositionDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.PositionVo;

public class PositionDaoImpl implements PositionDao {

	//获取数据源
	DataSource ds = PoolFactory.getDS();
	
	
	
	/**
	 * 查询所有的部门
	 * @return List<PositionVo>
	 */
	public List<PositionVo> selectAllPosition() {
			try {
				
				String sql = "select * from position";
				List<PositionVo> ls = new QueryRunner(ds).query(sql, new BeanListHandler<PositionVo>(PositionVo.class));
			    return ls;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return null;
	}

	
	/**
	 * 根据Id查询部门
	 * @return PositionVo
	 * @param  positionId
	 */
	public PositionVo selectPositionById(int positionId) {
		
		try {
			String sql = "select * from position where positionId = "+positionId;
			PositionVo pv = (PositionVo) new QueryRunner(ds).query(sql, new BeanListHandler<PositionVo>(PositionVo.class));
		    return pv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 根据部门名称查询部门
	 * @return PositionVo
	 * @param  positionName
	 */
	public PositionVo selectPositionByName(String positionName) {
		
		try {
			String sql = "select * from position where positionName = '"+positionName+"'";
			PositionVo pv = (PositionVo) new QueryRunner(ds).query(sql, new BeanListHandler<PositionVo>(PositionVo.class));
		    return pv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加一个新的职位
	 * @param posId,posName,posDescribe
	 */
	public void addPos(int posId,String posName,String posDescribe){
		
		try {
			
			String sql = "insert into position(posName,posDescribe) values('"+posName+"','"+posDescribe+"')";
			new QueryRunner(ds).update(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
