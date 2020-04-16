package com.kh.parkBBakBBak.view.TestRoomMiniGame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.testRoom.TestMainPage;

public class FindButtonGame extends JPanel {

	private JFrame mf;
	private JPanel FindButtonGame;
	private Player p;
	private JButton goBack;
	private ArrayList<JButton> numberButton;
	private JButton start;
	private JButton restart;
	public static int index = 0;

	public FindButtonGame(JFrame mf, Player p) {

		System.out.println("미니게임 페이지");

		this.p = p;
		this.mf = mf;
		this.FindButtonGame = this;

		this.setLayout(null);
		this.setBounds(0, 0, 1194, 834);

		//뒤로가기 버튼
		goBack = new JButton(new ImageIcon(new ImageIcon("images/backButton.png").getImage().getScaledInstance(60, 60, 0)));
		goBack.setBounds(1100, 15, 60, 60);
		goBack.setOpaque(false);
		goBack.setBorderPainted(false);
		goBack.setContentAreaFilled(false);
		goBack.addMouseListener(new MyMouseAdapter());
		this.add(goBack);

		Image nobonoboChat = new ImageIcon("images/nobonoboChat.png").getImage().getScaledInstance(450, 250, 0);
		JLabel nobonoboChatLb = new JLabel(new ImageIcon(nobonoboChat));
		nobonoboChatLb.setBounds(30, 30, 450, 250);
		this.add(nobonoboChatLb);

		Image background = new ImageIcon("images/bonobono.jpg").getImage().getScaledInstance(1194, 834, 0);
		JLabel backgroundLb = new JLabel(new ImageIcon(background));
		backgroundLb.setBounds(0, 0, 1194, 834);

		start = new JButton("시작");
		start.setBounds(30, 300, 100, 30);
		start.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		this.add(start);
		start.addMouseListener(new MyMouseAdapter());

		restart = new JButton("다시 섞기");
		restart.setBounds(150, 300, 100, 30);
		restart.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		this.add(restart);
		restart.addMouseListener(new MyMouseAdapter());

		//범위 내의 랜덤한 위치에 1~20까지의 JButton 생성
		numberButton = new ArrayList<JButton>();

		for(int i = 0; i < 20; i++) {
			int x = (int)(Math.random() * 285) + 100;
			int y = (int)(Math.random() * 280) + 400;
			numberButton.add(new JButton());
			numberButton.get(i).setFont(new Font("맑은 고딕", Font.BOLD, 14));
			numberButton.get(i).setOpaque(false);
			numberButton.get(i).setBorderPainted(false);
			numberButton.get(i).setContentAreaFilled(false);
			numberButton.get(i).setText(i + 1 + "");
			numberButton.get(i).setBounds(x, y, 50, 50);
			numberButton.get(i).setVisible(false);
			FindButtonGame.add(numberButton.get(i));
			numberButton.get(i).addMouseListener(new MyMouseAdapter());
		}

		System.out.println("FindButtonGame index : " + index);

		this.add(backgroundLb);
		mf.add(this);
	}

	public int getIndex() {
		return index;
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == goBack) {
				ChangePanel.replacePanel(mf, FindButtonGame,new TestMainPage(mf, p)); 
			}
			for(int i = 0; i < 20; i++) {
				if(index == i && e.getSource() == numberButton.get(i)) {
					FindButtonGame.remove(numberButton.get(i));
					FindButtonGame.repaint();
					index++;
					System.out.println("게임화면 index : " + index);
					if(index == 20) {
						ChangePanel.replacePanel(mf, FindButtonGame,new MiniGameResult(mf, p)); 
					}
				}

				if(e.getSource() == start) {
					numberButton.get(i).setVisible(true);
					
					if(i == 0) {
						Timer timer = new Timer(mf, FindButtonGame, p);
						Thread t1 = timer;
						t1.setDaemon(true);
						t1.start();
					}
				}
				
				if(e.getSource() == restart) {
					for(int j = index; j < 20; j++) {
						int x = (int)(Math.random() * 285) + 100;
						int y = (int)(Math.random() * 280) + 400;
						numberButton.get(j).setBounds(x, y, 50, 50);
					}
				}
			}
			
		}
	}
}

