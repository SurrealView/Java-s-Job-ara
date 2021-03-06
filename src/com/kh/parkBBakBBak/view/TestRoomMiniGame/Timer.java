package com.kh.parkBBakBBak.view.TestRoomMiniGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;

public class Timer extends Thread {

	private JFrame mf;
	private JPanel findButtonGame;
	private Player p;
	private int i;

	public Timer(JFrame mf, JPanel findButtonGame, Player p){
		this.mf = mf;
		this.findButtonGame = findButtonGame;
		this.p = p;
	}

	@Override
	public void run() {
		System.out.println("타이머 메소드");
		JTextField label = new JTextField("남은시간 : ");
		label.setLayout(null);
		label.setBounds(270, 300, 150, 30);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		findButtonGame.add(label);

		try {
			for(i = 25; i >= 0; i--){
				if(i == 9) {
					label.setForeground(Color.RED);
				}
				System.out.println(i);
				this.sleep(1000);
				label.setText("남은시간 : " + i);

				if((i > 0 && FindButtonGame.index == 20)) { 
					ChangePanel.replacePanel(mf, findButtonGame, new MiniGameResult(mf, p)); 
					break;
				}
				
				if(FindButtonGame.checkBack == true) {
					break;
				}

				System.out.println("i 값 : " + i);
				System.out.println("타이머 인덱스값 : " + FindButtonGame.index);
				if (i == 0 && FindButtonGame.index < 20) {
					System.out.println("시간초과했을때...");
					ChangePanel.replacePanel(mf, findButtonGame, new MiniGameResult(mf, p));
					break;
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(i);


	}
}