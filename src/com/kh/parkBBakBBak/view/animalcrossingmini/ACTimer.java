package com.kh.parkBBakBBak.view.animalcrossingmini;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.TestRoomMiniGame.FindButtonGame;
import com.kh.parkBBakBBak.view.TestRoomMiniGame.MiniGameResult;
import com.kh.parkBBakBBak.view.home.HomePanel;

public class ACTimer extends Thread {

	private JFrame mf;
	private JPanel base;
	private Player p;
	private int i;

	public ACTimer(JFrame mf, JPanel base, Player p) {
		this.mf = mf;
		this.base = base;
		this.p = p;
	}

	public void run() {
		JTextField label = new JTextField("남은시간 : ");
		label.setLayout(null);
		label.setBackground(Color.black);
		label.setBounds(347, 137, 150, 30);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		base.add(label);

		try {
			for (i = 5; i >= 0; i--) {
				label.setForeground(Color.white);
				System.out.println(i);
				this.sleep(1000);
				label.setText("남은시간 : " + i);

				if (i == 0) {
					BasePanel.bgm.stop();
					BasePanel.count = 0;
					ChangePanel.replacePanel(mf, base, new ResultPanel(mf, p, 0));
					break;
				} else if (i > 0)
					if (BasePanel.count >= 12) {
						BasePanel.bgm.stop();
						BasePanel.count = 0;
						ChangePanel.replacePanel(mf, base, new ResultPanel(mf, p, 1));
						break;
					}

//					ChangePanel.replacePanel(mf, findButtonGame, new MiniGameResult(mf, p)); 

			}
		} catch (

		InterruptedException e) {
			e.printStackTrace();
		}
	}
}