package com.kh.parkBBakBBak.view.settings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class StatusPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public StatusPanel(JFrame mf, Player p) {

		this.mf = mf;
		panel = this;
		this.setLayout(null);

		int x = mf.getWidth();
		int y = mf.getHeight();

		JTextArea status = new JTextArea();
		status.setBackground(new Color(255, 0, 0, 0));
		status.setBounds(x / 2 - 250, y / 2 - 250, 500, 500);
		
		status.setFont(new Font("���� ���", Font.PLAIN, 24));
		status.setForeground(Color.WHITE);
		
		status.append("\n\n\n�̸� : �ں���\n\n");
		status.append("��� : "+p.getCareer()+"\n\n");
		status.append("���� ��ų ���� : "+ p.getSkillQTY()+"\n\n");
		status.append("���� ���� ���� : "+ p.getCouponQTY()+"\n\n");
		status.append("���� ü�� : "+p.getHp()+"\n\n");

		JLabel background = new JLabel(
				new ImageIcon(new ImageIcon("images/settingBgd.png").getImage().getScaledInstance(1194, 834, 0)));
		background.setBounds(0, 0, 1194, 834);

		JButton backButton = SelectInterview.addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1100, 15);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, panel, new SettingPanel(mf, p));
				// ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf));
			}
		});
		
		this.add(status);
		this.add(backButton);
		this.add(background);
	}

}
