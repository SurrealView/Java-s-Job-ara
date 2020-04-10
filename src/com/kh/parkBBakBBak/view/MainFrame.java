package com.kh.parkBBakBBak.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame {

	public MainFrame() {
		JFrame mainFrame = new JFrame();
		imageBackground(1194, 834);
		mainFrame.setSize(1194, 834);
//		mainFrame.setLocation(0, 0);
		mainFrame.setLocationRelativeTo(null);// 창이 가운데 나오게
		mainFrame.setTitle("메인 화면");
	
//		mainFrame.setResizable(false);// 창의 크기를 변경하지 못하게

		mainFrame.add(new MenuPanel(mainFrame));

		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void imageBackground(int x, int y) {
		
		ImageIcon bgIcon = new ImageIcon("images/mainPic.png");
		x = bgIcon.getIconWidth();
		y = bgIcon.getIconHeight();

		Image bgImg = bgIcon.getImage();
		Image changedBgImg = bgImg.getScaledInstance(x, y, Image.SCALE_SMOOTH);
	}

}
