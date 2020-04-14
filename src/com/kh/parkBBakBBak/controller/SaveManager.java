package com.kh.parkBBakBBak.controller;

import java.util.ArrayList;

import com.kh.parkBBakBBak.model.dao.LoginDao;
import com.kh.parkBBakBBak.model.vo.Player;

public class SaveManager {
	
	private LoginDao ld = new LoginDao();
	private Player p;
	
	public void deleteData(Player p) {
		
		this.p = p;
		
		this.p.setDay(this.p.getDay() + 1);
		this.p.changeWeekDay();
		this.p.setHp(this.p.getHp() + 2);
		if(this.p.getHp() >= 5) {
			this.p.setHp(5);
		}
//		this.p.setCareer("Áß¼Ò¸Ç");
		
		ArrayList<Player> list = ld.readPlayerList();
		
		Player save = null;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getUserId().equals(p.getUserId())) {
				list.set(i, this.p);
				save = list.get(i);
				this.p = save;
				System.out.println("saveµ¤¾î¾º¿öÁø ºýºý" + save.toString());
				System.out.println("ÇÊµå¿¡ µ¤¾î¾º¿öÁø ºýºý" + this.p.toString());
				
				ld.writePlayerList(list);
				
			}
		}
		
	}
	
	public Player savePlayer() {
		return this.p;
	}

}
