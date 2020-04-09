package com.kh.parkBBakBBak.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
//	private JPanel panel = new JPanel() {
//		Image background = new ImageIcon("image/MainPic.png").getImage();
//		public void paint(Graphics g) {
//			// 그리는 함수
//			g.drawImage(background, 0, 0, null);
//			// background를 그려줌
//		}
//	};

	public MenuPanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;

		
//		mf.add(panel);
		JLabel Background = new JLabel(
				new ImageIcon(new ImageIcon("images/mainPic.png").getImage().getScaledInstance(MainFrame.x, MainFrame.y, 0)));
		Background.setBounds(0, 0, 1194, 834);

		JLabel startButton = new JLabel(
				new ImageIcon(new ImageIcon("images/StartButton.png").getImage().getScaledInstance(200, 100, 0)));
		
		int buttonX = MainFrame.x/2 - 200/2;
		int buttonY = MainFrame.y/2 + 100;

		startButton.setBounds(buttonX, buttonY, 200, 100);
		startButton.addMouseListener(new MyMouseAdapter());
		
		this.add(Background);
		this.add(startButton);
		this.setComponentZOrder(Background, 1);

	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {

			ChangePanel change = new ChangePanel(mf, panel);
			WorldPanel world = new WorldPanel(mf);

			change.replacePanel(world);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
}
