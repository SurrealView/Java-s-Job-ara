package com.kh.parkBBakBBak.view.interview;

import java.awt.Color;
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
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;

public class ShowResult extends JPanel {

	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String[] failed = new String[] { "�ڳ��� ����� �˷��ְڳ�", "�ڳ״� 10������ " + InterviewManager.correctAnswer + "���� ���豺",
			"�ڳ״� ���հ��̾�  �������༭ ����" };
	private String[] attach = new String[] { "�ڳ���  ����� �˷��ְڳ�", "�ڳ״� 10������ " + InterviewManager.correctAnswer + "���� ���豺",
			"���� �츮ȸ��� ���� �� �繫�ǿ��� ����ͱ���!" };
	private String[] failed2 = new String[] { "������ ���� ����� �����Ǿ����ϴ�",
			"���ϴ�  10���� �� " + InterviewManager.correctAnswer + "���� ���߼̽��ϴ�", "���ϴ� ���� ȸ�翡 ���� ���հ� ó���Ǿ����ϴ� �����մϴ�." };
	private String[] attach2 = new String[] { "������ ���� ����� �����Ǿ����ϴ�",
			"���ϴ� 10������ " + InterviewManager.correctAnswer + "���� ���߼̽��ϴ�", "���ϴ� ���� ȸ�翡 �հ� �Ǿ����ϴ� ������ �˰ڽ��ϴ�." };
	private String[] failed3 = new String[] { "Let me show your result\\n;",
			"you got a" + InterviewManager.correctAnswer + "out of 10 Question Correct\\n;",
			"you failed the Interview thank you for Applying\\n;" };
	private String[] attach3 = new String[] { "Let me show your result\\\\n;",
			"you got a" + InterviewManager.correctAnswer + "out of 10 Question Correct\\\\n;",
			"I'm glad you passed our Company!\\n; See you Soon!\\n;" };

	public ShowResult(JFrame mf, Player p) {
		System.out.println("final Result");
		this.mf = mf;
		this.panel = this;
		this.p = p;
		this.setLayout(null);
		this.setSize(1194, 834);
		InterviewManager.pageNum = 8;

		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);

		JLabel person;

		if (InterviewManager.WhatInterview == 1) {
			person = SelectInterview.addJLabelImage(new JLabel(), "gwakTheIronDragon.png", 314, 200);
			person.setLocation(222, 310);

		} else if (InterviewManager.WhatInterview == 2) {
			person = SelectInterview.addJLabelImage(new JLabel(), "leeTheDragon.png", 202, 293);
			person.setLocation(222, 310);

		} else {
			person = SelectInterview.addJLabelImage(new JLabel(), "mark.png", 233, 208);
			person.setLocation(222, 310);

		}

		JLabel batteryCase = new JLabel(
				new ImageIcon(new ImageIcon("images/batteryCase.png").getImage().getScaledInstance(140, 45, 0)));
		batteryCase.setSize(140, 45);
		batteryCase.setLocation(40, 40);
		this.add(batteryCase);

		String[] remainBattery = new String[] { "Battery1.png", "Battery2.png", "Battery3.png", "Battery4.png",
				"Battery5.png" };

		ArrayList<Image> batteryImage = new ArrayList<Image>();
		for (int i = 0; i < remainBattery.length; i++) {
			batteryImage.add(new ImageIcon(InterviewManager.ADDRESS + remainBattery[i]).getImage()
					.getScaledInstance(140, 45, 0));
		}

		ArrayList<JLabel> batteryLabels = new ArrayList<JLabel>();

		if (p.getHp() != 0) {
			for (int i = 0; i < p.getHp(); i++) {
				batteryLabels.add(new JLabel(new ImageIcon(batteryImage.get(i))));
				batteryLabels.get(i).setSize(140, 45);
				batteryLabels.get(i).setLocation(40, 40);
			}

			for (int i = 0; i < this.p.getHp(); i++) {
				this.add(batteryLabels.get(i));
			}

		}
		this.add(batteryCase);

		JLabel smallCoffee = SelectInterview.addJLabelImage(new JLabel(), "coffeeSmall.png", 21, 40);
		smallCoffee.setSize(21, 40);
		smallCoffee.setLocation(200, 42);
		this.add(smallCoffee);

		JLabel couponQty = new JLabel(" X " + p.getCouponQTY());
		couponQty.setFont(new Font("���� ���", Font.PLAIN, 24));
		couponQty.setForeground(Color.WHITE);
		couponQty.setSize(50, 40);
		couponQty.setLocation(220, 40);
		this.add(couponQty);

		JLabel dayWeekDay = new JLabel(p.getDay() + "����" + " / " + p.getWeekDay() + "����");
		dayWeekDay.setFont(new Font("���� ���", Font.PLAIN, 20));
		dayWeekDay.setForeground(Color.WHITE);
		dayWeekDay.setSize(150, 40);
		dayWeekDay.setLocation(280, 41);
		this.add(dayWeekDay);

		JLabel infoBox = new JLabel();
		infoBox.setSize(403, 65);
		infoBox.setLocation(30, 30);
		infoBox.setOpaque(true);
		infoBox.setBackground(new Color(0, 0, 0, 150));
		this.add(infoBox);

		if (InterviewManager.WhatInterview == 1) {
			if (InterviewManager.correctAnswer < 8) {// ���� ���᰹���� 8������ ������ failed ���ڿ��� add

				buttonArr = InterviewManager.showQuest(buttonArr, failed, 20);
				for (int i = 0; i < buttonArr.size(); i++) {

					this.add(buttonArr.get(i));
				}
			} else {// ���� ���᰹���� 8������ ũ�ų� ������ attach ���ڿ��� add

				buttonArr = InterviewManager.showQuest(buttonArr, attach, 20);
				for (int i = 0; i < buttonArr.size(); i++) {

					this.add(buttonArr.get(i));
				}
			}
		} else if (InterviewManager.WhatInterview == 2) {
			if (InterviewManager.correctAnswer < 8) {// ���� ���᰹���� 8������ ������ failed ���ڿ��� add

				buttonArr = InterviewManager.showQuest(buttonArr, failed2, 20);
				for (int i = 0; i < buttonArr.size(); i++) {

					this.add(buttonArr.get(i));
				}
			} else {// ���� ���᰹���� 8������ ũ�ų� ������ attach ���ڿ��� add

				buttonArr = InterviewManager.showQuest(buttonArr, attach2, 20);
				for (int i = 0; i < buttonArr.size(); i++) {

					this.add(buttonArr.get(i));
				}
			}

		} else if (InterviewManager.WhatInterview == 3) {

			if (InterviewManager.correctAnswer < 8) {// ���� ���᰹���� 8������ ������ failed ���ڿ��� add

				buttonArr = InterviewManager.showQuest(buttonArr, failed3, 20);
				for (int i = 0; i < buttonArr.size(); i++) {

					this.add(buttonArr.get(i));
				}
			} else {// ���� ���᰹���� 8������ ũ�ų� ������ attach ���ڿ��� add

				buttonArr = InterviewManager.showQuest(buttonArr, attach3, 20);
				for (int i = 0; i < buttonArr.size(); i++) {

					this.add(buttonArr.get(i));
				}
			}

		}

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (InterviewManager.correctAnswer < 8) {
					System.out.println("������ ������");

				} else {
					System.out.println("�հ��� ������");

				}
				ChangePanel.replacePanel(mf, panel, new Ending(mf, p));

			}
		});
		JLabel backGround = SelectInterview.addJLabelImage(new JLabel(), "interview.png", 1194, 834);
		backGround.setLocation(0, 0);

		this.add(txtArea);
		this.add(person);
		this.add(backGround);

	}



}
