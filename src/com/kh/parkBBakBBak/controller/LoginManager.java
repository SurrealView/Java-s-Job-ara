package com.kh.parkBBakBBak.controller;

import java.util.ArrayList;

import com.kh.parkBBakBBak.model.dao.LoginDao;
import com.kh.parkBBakBBak.model.vo.Player;

public class LoginManager {
	
	private LoginDao ld = new LoginDao();
	private Player p;
	
	public LoginManager() {}
	
	// 회원 생성 메소드
	public void createPlayer(Player p) {
		
		// 회원 번호 0으로 초기화
		int playerNumber = 0;
		
		// 파일에 어떤 회원이 있는지 조회
		ArrayList<Player> list = ld.readPlayerList();
		
		if(list == null) {
			// 1번째 회원 추가
			list = new ArrayList<Player>();
			playerNumber++;
		} else {
			// 2번째 회원부터 각각 번호 부가
			playerNumber = list.get(list.size() - 1).getPlayerNumber() + 1;
		}
		
		// 플레이어 객체의 플레이어 넘버 변경
		p.setPlayerNumber(playerNumber);
		
		// 리스트에 플레이어 객체 추가
		list.add(p);
		
		// 리스트에 파일을 기록
		ld.writePlayerList(list);
		
		
	}
	
	// 로그인 메소드
	public int checkLogin(String id, String pw, Player p) {
		
		System.out.println("받아온 값 : " + id);
		String idCheck = id + "\n";
//		String pwCheck = pw + "\n";
		
		ArrayList<Player> list = ld.readPlayerList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("플레이어" + (i + 1) + "번째 빡빡 : " + list.get(i).toString());
		}
		
		Player BBakBBak = null;
		
		int check = 0;
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getUserId().equals(idCheck)) {
					BBakBBak = list.get(i);
					System.out.println(idCheck.compareTo(BBakBBak.getUserId()));
					check = 1;
					break;
				} else {
					System.out.println("id X");
					check = 0;
				}
			}
		}
		
		if(check == 1) {
			if(BBakBBak.getUserPwd().equals(pw)) {
//				System.out.println(BBakBBak.toString());
//				System.out.println(pw.compareTo(BBakBBak.getUserPwd()));
				this.p = BBakBBak;
				
				switch(this.p.getCareer()) {
				case "무직" : 
					System.out.println("무직 로그인 성공 : " + this.p.toString());
					check = 3;
					break;
				case "중소맨" :
					System.out.println("중소맨 로그인 성공 : " + this.p.toString());
					check = 5;
					break;
				case "삼성맨" : 
					System.out.println("샘숭맨 로그인 성공 : " + this.p.toString());
					check = 6;
					break;
				case "해외인싸" :	
					System.out.println("해외인싸 로그인 성공 : " + this.p.toString());
					check = 3;
					break;
				}
				
				
			} else {
				System.out.println("pw X");
				check = 4;
			}
		}
		
		int start = 0;
		
		switch(check) {
		case 0 : start = 0; break;
		case 3 : start = 2; break;
		case 4 : start = 1; break;
		case 5 : start = 3; break;
		case 6 : start = 4; break;
		}
		
		return start;
		
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}
	
	

}
