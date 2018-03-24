package com.gump.dao_impl;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gump.dao.IPositionDao;
import com.gump.utils.PoolFactory;
import com.gump.vo.Page;
import com.gump.vo.Position;

public class PositionDaoImpl implements IPositionDao {

	//获取数据源
	DataSource ds = PoolFactory.getDS();
	
	
	
	/**
	 * 查询所有的职位
	 * @return List<PositionVo>
	 * @param  page
	 */
	public List<Position> listPosition(Page page) {
			try {
				
				List<Position> ls = null;
				
				//获取每页显示职位数
				int pageSize = page.getPageSize();
				//从第pageLimit条数据拿值
				int pageLimit = (page.getCurrentPage()-1)*pageSize;
				
				String sql = "select * from position limit "+pageLimit+","+pageSize;
				ls = new QueryRunner(ds).query(sql, new BeanListHandler<Position>(Position.class));
			    return ls;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	
	/**
	 * 根据Id查询职位
	 * @return PositionVo
	 * @param  positionId
	 */
	public Position getPositionById(int posId) {
		
		try {
			
			String sql ="select * from position where 1 = 1 ";
			
			if(posId > 0){
				sql += "and positionId = "+posId;
			}
			Position pv = (Position) new QueryRunner(ds).query(sql, new BeanListHandler<Position>(Position.class));
		    return pv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 根据部门名称查询职位
	 * @return PositionVo
	 * @param  positionName
	 */
	public Position getPositionByName(String posName) {
		
		try {
			String sql ="select * from position where 1 = 1 ";
			
			if(posName != null){
				sql += "and posName = "+posName;
			}
			Position pv = (Position) new QueryRunner(ds).query(sql, new BeanListHandler<Position>(Position.class));
		    return pv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加一个新的职位
	 * @param pos
	 */
	public void savePosition(Position pos){ 
		String sql = null;
		System.out.println("职位名称："+pos.getPosName());
		System.out.println("职位描述："+pos.getPosDescribe());
		try {
			if(pos.getPosName() != null && pos.getPosDescribe() != null){
				sql = "insert into position(posName,posDescribe) values('"+pos.getPosName()+"','"+pos.getPosDescribe()+"')";
			}
       			System.out.println("职位新增sql"+sql);
			new QueryRunner(ds).update(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据职位Id删除职位
	 * @param posId
	 */
	public void removePosition(int posId){
		try {
			
			String sql = "delete position where 1 = 1 ";
			if(posId > 0){
				sql += " and posId = "+posId;
			}
			new QueryRunner(ds).update(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 根据职位Id修改职位信息
	 * @param pos
	 */
	public void updatePosition(Position pos){
		try {
			String sql = null;
			if(pos.getPosName() != null){
				sql = "update position set posName = '"+pos.getPosName()+"'";
			}else if(pos.getPosDescribe() != null){
				sql += ",posDescribe = '"+pos.getPosDescribe()+"'  where posId = "+pos.getPosId();
			}
			new QueryRunner(ds).update(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 查询所有记录数
	 * @return
	 */
	public long getPositionCount(){
		long l = 0;
		try {
			String sql = "select count(*) from position";
			QueryRunner qr=new QueryRunner(ds);
		    l=qr.query(sql, new ScalarHandler<Long>(1));
			//l = new QueryRunner(ds).query(sql,new ScalarHandler<Long>(1));
			//System.out.println("总记录数："+l);
		    System.out.println("总记录数为："+l);
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
}
