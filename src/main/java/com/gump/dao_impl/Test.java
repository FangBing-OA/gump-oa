package com.gump.dao_impl;

import javax.sql.DataSource;

import com.gump.utils.PoolFactory;

public class Test {
  public static void main(String[] args) {
	//DataSource ds=PoolFactory.getDS();
	PositionDaoImpl po=new PositionDaoImpl();
	po.allPositionCount();
}
}
