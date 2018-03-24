<%@page import="com.gump.utils.PoolFactory"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.util.List"%>
<%@page import="com.gump.service_impl.PositionServiceImpl"%>
<%@page import="com.gump.dao_impl.PositionDaoImpl"%>
<%@page import="com.gump.vo.Page"%>
<%@page import="com.gump.vo.PositionVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
      

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <% 
      //查询所有职位
        /* Page pa = new Page();
        PositionDaoImpl pdi =  new PositionDaoImpl();
        pa.setCount((int)pdi.allPositionCount());
        pa.setCurrentPage(1);
        System.out.println("euifdbuuireudjrfhdjk");
      	 List<PositionVo> listAllPosition = new PositionServiceImpl().selectAllPosition(pa);
		for(PositionVo pos : listAllPosition){
			System.out.println(pos.getPosId());
			System.out.println(pos.getPosName());
			System.out.println(pos.getPosDescribe());
		} */
		
		//新增职位
		System.out.println("新增test");
		PositionDaoImpl pdi =  new PositionDaoImpl();
		PositionVo pos = new PositionVo();
		pos.setPosDescribe("11111");
		pos.setPosName("22222");
		pdi.addPos(pos);
		%>

