package com.gump.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PoolFactory {
	// 私有化构造方法，禁止创建对象
	private PoolFactory(){}
	
	public static DataSource ds = null;
	
	static{
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/db");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDS(){
		return ds;
	}
}
