package com.kh.parkBBakBBak.controller;

import java.util.ArrayList;

import com.kh.parkBBakBBak.model.dao.LoginDao;
import com.kh.parkBBakBBak.model.vo.Player;

public class LoginManager {
	
	private LoginDao ld = new LoginDao();
	private Player p;
	
	public LoginManager() {}
	
	// ȸ�� ���� �޼ҵ�
	public void createPlayer(Player p) {
		
		// ȸ�� ��ȣ 0���� �ʱ�ȭ
		int playerNumber = 0;
		
		// ���Ͽ� � ȸ���� �ִ��� ��ȸ
		ArrayList<Player> list = ld.readPlayerList();
		
		if(list == null) {
			// 1��° ȸ�� �߰�
			list = new ArrayList<Player>();
			playerNumber++;
		} else {
			// 2��° ȸ������ ���� ��ȣ �ΰ�
			playerNumber = list.get(list.size() - 1).getPlayerNumber() + 1;
		}
		
		// �÷��̾� ��ü�� �÷��̾� �ѹ� ����
		p.setPlayerNumber(playerNumber);
		
		// ����Ʈ�� �÷��̾� ��ü �߰�
		list.add(p);
		
		// ����Ʈ�� ������ ���
		ld.writePlayerList(list);
		
		
	}
	
	// �α��� �޼ҵ�
	public int checkLogin(String id, String pw, Player p) {
		
		System.out.println("�޾ƿ� �� : " + id);
		String idCheck = id + "\n";
//		String pwCheck = pw + "\n";
		
		ArrayList<Player> list = ld.readPlayerList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("�÷��̾�" + (i + 1) + "��° ���� : " + list.get(i).toString());
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
				case "����" : 
					System.out.println("���� �α��� ���� : " + this.p.toString());
					check = 3;
					break;
				case "�߼Ҹ�" :
					System.out.println("�߼Ҹ� �α��� ���� : " + this.p.toString());
					check = 5;
					break;
				case "�Ｚ��" : 
					System.out.println("������ �α��� ���� : " + this.p.toString());
					check = 6;
					break;
				case "�ؿ��ν�" :	
					System.out.println("�ؿ��ν� �α��� ���� : " + this.p.toString());
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
