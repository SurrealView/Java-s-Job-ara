package com.kh.parkBBakBBak.view.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class SettingPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public SettingPanel(JFrame mf, Player p) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		int x = mf.getWidth();
		int y = mf.getHeight();
//		System.out.println(x + " | " + y);
		JLabel background = new JLabel(
				new ImageIcon(new ImageIcon("images/settingBgd.png").getImage().getScaledInstance(1194, 834, 0)));
		background.setBounds(0, 0, 1194, 834);

		JButton backButton = SelectInterview.addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1100, 15);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, panel, new WorldPanel(mf, p));
				// ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf));
			}
		});

		JButton settingButton = SelectInterview.addJButtonImage(new JButton(), "settingsButton.png", 100, 100);
		settingButton.setLocation((x / 2 - 100 / 2), (y / 2 - (100 / 2 + 100)));
		settingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SoundAndInputPanel sip = new SoundAndInputPanel(mf, p);
				ChangePanel.replacePanel(mf, panel, sip);
				/*
				 * VolumePanel vol = new VolumePanel(mf, p); ChangePanel.replacePanel(mf, panel,
				 * vol);
				 */
			}
		});

		JButton infoButton = SelectInterview.addJButtonImage(new JButton(), "chipButton.png", 72, 72);
		infoButton.setLocation((x / 2 - 72 / 2), y / 2);
		infoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, panel, new StatusPanel(mf, p));
			}
		});

		JButton exitButton = SelectInterview.addJButtonImage(new JButton(), "exitButton.png", 72, 72);
		exitButton.setLocation((x / 2 - 72 / 2), (y / 2 - (72 / 2) + 150));
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Á¾·á");
				System.exit(0);

			}
		});
//		setLocation(x - (panel.getWidth() / 2), y - (panel.getHeight() / 2));

		this.add(settingButton);
		this.add(infoButton);
		this.add(exitButton);
		this.add(backButton);
		this.add(background);
//		panel.setComponentZOrder(settingButton, 0);

	}

}
