package com.gump.commons;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gump.dao.IPositionDao;
import com.gump.dao_impl.PositionDaoImpl;
import com.gump.vo.Employee;
import com.gump.vo.Position;

public class JudgeRole {
	private static IPositionDao ips = new PositionDaoImpl();
	public static boolean isAdmin(){
		Employee emp = (Employee)ServletActionContext.getContext().getSession().get("account");
		List<Position> selectPosById = ips.getPositionById(emp.getEmpPosId());
		Position position = selectPosById.get(0);
		System.out.println(position.getPosId());
		if (position.getPosId() == 4) {
			return false;
		} else{
			return true;
		}
	}
}
