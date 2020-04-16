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
		System.out.println("Ÿ�̸� �޼ҵ�");
		JTextField label = new JTextField("�����ð� : ");
		label.setLayout(null);
		label.setBounds(270, 300, 150, 30);
		label.setFont(new Font("���� ���", Font.BOLD, 14));
		findButtonGame.add(label);

		try {
			for(i = 25; i >= 0; i--){
				if(i == 9) {
					label.setForeground(Color.RED);
				}
				System.out.println(i);
				this.sleep(1000);
				label.setText("�����ð� : " + i);

				if(i > 0 && FindButtonGame.index == 20) { 
					ChangePanel.replacePanel(mf, findButtonGame, new MiniGameResult(mf, p)); 
					break;
				}

				System.out.println("i �� : " + i);
				System.out.println("Ÿ�̸� �ε����� : " + FindButtonGame.index);
				if (i == 0 && FindButtonGame.index < 20) {
					System.out.println("�ð��ʰ�������...");
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