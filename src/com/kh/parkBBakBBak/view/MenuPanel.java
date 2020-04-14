package com.kh.parkBBakBBak.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;

public class MenuPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Player p;

	public static Clip mainBgm; // bgm

	public MenuPanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;

		Player p = new Player();
//		mf.add(panel);
		this.p = p;
		JLabel Background = new JLabel(
				new ImageIcon(new ImageIcon("images/mainPic.png").getImage().getScaledInstance(1194, 834, 0)));
		Background.setBounds(0, 0, 1194, 834);

		JLabel startButton = new JLabel(
				new ImageIcon(new ImageIcon("images/StartButton.png").getImage().getScaledInstance(200, 100, 0)));
		
		//Backgound Music Play
		AudioInputStream audioInputStream;
		File file;
		try {
			file = new File("sounds/kkHouse.wav");
			audioInputStream = AudioSystem.getAudioInputStream(file);
			mainBgm = AudioSystem.getClip();
			mainBgm.open(audioInputStream);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
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

			
//			WorldPanel world = new WorldPanel(mf);
			LoginPage login = new LoginPage(mf,p);
			ChangePanel.replacePanel(mf, panel, login);

			
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
}
