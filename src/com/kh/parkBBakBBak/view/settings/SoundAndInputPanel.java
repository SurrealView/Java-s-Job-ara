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
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class SoundAndInputPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public SoundAndInputPanel(JFrame mf, Player p) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);

		int x = mf.getWidth();
		int y = mf.getHeight();

		JLabel background = new JLabel(
				new ImageIcon(new ImageIcon("images/settingBgd.png").getImage().getScaledInstance(1194, 834, 0)));
		background.setBounds(0, 0, 1194, 834);

		// 뒤로가기 버튼
		JButton backButton = SelectInterview.addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1100, 15);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, panel, new SettingPanel(mf, p));
				// ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf));
			}
		});

		JButton settingButton = SelectInterview.addJButtonImage(new JButton(), "soundButton.png", 100, 100);
		settingButton.setLocation(x / 2 - 100 / 2, (y / 2 - (100 / 2 + 100)));
		settingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VolumeDialog dial = new VolumeDialog(mf);
			}
		});

		JButton infoButton = SelectInterview.addJButtonImage(new JButton(), "chipButton.png", 72, 72);
		infoButton.setLocation(x / 2 - 72 / 2, y / 2);
		infoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String cheat = "자라나라 머리머리";
				try {
					InputDialog input = new InputDialog();
					String result = input.Dialog();
					if (result.equals(cheat)) {
						boolean skills[] = { true, true, true, true, true, true, true, true, true, true };
						JOptionPane.showMessageDialog(mf, "플레이어 습득 스킬이 10이됩니다!", "치트 성공!", JOptionPane.WARNING_MESSAGE);

						p.setGetSkill(skills);
						p.setSkillQTY(10);
					}

				} catch (NullPointerException except) {
					System.out.println("취소");
				}
			}
		});

		this.add(backButton);
		this.add(settingButton);
		this.add(infoButton);
		this.add(background);
	}

}
