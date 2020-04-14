package com.kh.parkBBakBBak.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.parkBBakBBak.model.vo.Player;

public class LoginDao {
	
	// ���Ͽ� �÷��̾� ���� �о����� �޼ҵ�
	@SuppressWarnings("unchecked")
	public ArrayList<Player> readPlayerList(){
		ObjectInputStream ois = null;
		ArrayList<Player> list = null;
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream("PlayerList.dat"));
			
			list = (ArrayList<Player>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �����ϴ�.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// ���Ͽ� �÷��̾� ���� ����ϱ�� �޼ҵ�
	public void writePlayerList(ArrayList<Player> list) {
		
		ObjectOutputStream oos = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream("PlayerList.dat"));
			
			oos.writeObject(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
			
		
		
		
	}

}
