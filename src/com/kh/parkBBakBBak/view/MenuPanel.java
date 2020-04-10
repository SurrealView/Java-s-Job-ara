package com.kh.parkBBakBBak.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public MenuPanel(JFrame mf) {
		this.mf = mf;
		panel = this;

		this.setLayout(null);
		this.setSize(1194, 834);
		this.setLocation(0,0);
//		mf.add(panel);
		JLabel Background = new JLabel(
				new ImageIcon(new ImageIcon("images/mainPic.png").getImage().getScaledInstance(1194, 834, 0)));
		Background.setBounds(0, 0, 1194, 834);

		JLabel startButton = new JLabel(
				new ImageIcon(new ImageIcon("images/StartButton.png").getImage().getScaledInstance(200, 100, 0)));
		
		int buttonX = 1194/2 - 200/2;
		int buttonY = 834/2 + 100;

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
//			WorldPanel world = new WorldPanel(mf);
			LoginPage login = new LoginPage(mf);

			change.replacePanel(login);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
}
