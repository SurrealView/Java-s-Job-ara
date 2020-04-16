package com.kh.parkBBakBBak.view.TestRoomMiniGame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.testRoom.TestMainPage;

public class MiniGameResult extends JPanel {
	
	private JFrame mf;
	private JPanel MiniGameResult;
	private Player p;

	
	public MiniGameResult(JFrame mf, Player p) {
		
		
		this.mf = mf;
		this.p = p;
		this.MiniGameResult = this;
		
		int index = FindButtonGame.index;
		
		System.out.println("결과페이지 index : " + index);
		System.out.println("결과패널생성");
		
		JTextArea gameResult = new JTextArea();
		gameResult.setOpaque(false);
		gameResult.append("");
		gameResult.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		this.add(gameResult);
		
		Image chat = new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(820, 270, 0);
		JLabel chatLb = new JLabel(new ImageIcon(chat));
		chatLb.setLayout(null);
		chatLb.setBounds(180, 250, 820, 270);
		this.add(chatLb);
		
		Image background = new ImageIcon("images/minigameResultBack.png").getImage().getScaledInstance(1194, 834, 0);
		JLabel backgroundLb = new JLabel(new ImageIcon(background));
		backgroundLb.setBounds(0, 0, 1194, 834);
		this.add(backgroundLb);
		
		if(index == 20) {
			//버튼 다 찾았을때
			gameResult.setText("노보노보 : 임무를 완수했구나! 이걸로 힘내서 더 열심히 공부하라구!\n커피쿠폰 + 1");
			gameResult.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			gameResult.setBounds(250, 355, 700, 400);
			p.setCouponQTY(p.getCouponQTY() + 1);
			
		} else {
			//버튼 다 못찾았을 때
			gameResult.setBounds(250, 370, 600, 400);
			gameResult.setText("노보노보 : 아쉽네.. 내일 다시 도전 해보라구!");
		}
		
		this.addMouseListener(new MyMouseAdapter());
		

		
		FindButtonGame.index = 0;
	}
	
	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == MiniGameResult) {
				ChangePanel.replacePanel(mf, MiniGameResult, new TestMainPage(mf,p));
			}
		}
	}

}
