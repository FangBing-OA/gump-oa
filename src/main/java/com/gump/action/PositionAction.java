package com.gump.action;

import java.util.List;

import com.gump.service_impl.PositionServiceImpl;
import com.gump.vo.Page;
import com.gump.vo.Position;

public class PositionAction{
	
	private List<Position> listAllPosition;
	
	public String excute(){
		System.out.println("euifdbuuireudjrfhdjk");
		Page page = new Page();
		listAllPosition = new PositionServiceImpl().selectAllPosition(page);
		return "test";
	}

}
