package com.kh.parkBBakBBak.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.view.MenuPanel.MyMouseAdapter;

public class MaybeCafePanel extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public MaybeCafePanel(JFrame mf) {
		System.out.println("Ä«Æä\n---------------------");
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		this.setBackground(Color.CYAN);
		JLabel startButton = new JLabel(
				new ImageIcon(new ImageIcon("images/StartButton.png").getImage().getScaledInstance(200, 100, 0)));

		int buttonX = 1194 / 2 - 200 / 2;
		int buttonY = 834 / 2 + 100;

		startButton.setBounds(buttonX, buttonY, 200, 100);
		startButton.addMouseListener(new MyMouseAdapter());
		this.add(startButton);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {

//			ChangePanel change = new ChangePanel(mf, panel);
			WorldPanel world = new WorldPanel(mf);
			ChangePanel.replacePanel(mf, panel, world);

//			change.replacePanel(world);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
}
