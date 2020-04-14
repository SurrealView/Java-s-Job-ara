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

import com.kh.parkBBakBBak.controller.interview.DokiDoki;
import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;

public class WaitResult extends JPanel {

	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String[] question = new String[] { "면접을 보느라 고생이 많았네", "잠시 후에 결과를 알려줄께야", };
	private String[] bigQuestion = new String[] { "면접에 응시해 주셔서 감사드립니다", "잠시후 결과를 안내해 드리겠습니다", };
	private String[] foreignQuestion = new String[] { "Thank you for your Interview.\\n;",
			"I'll let you know the result in a momnet.\\n;" };

	public WaitResult(JFrame mf, Player p) {
		System.out.println("waitResult 입장");
		System.out.println(InterviewManager.correctAnswer + "개 맞춤");
		this.mf = mf;
		this.panel = this;
		this.p = p;
		this.setLayout(null);
		this.setSize(1194, 834);
		InterviewManager.pageNum = 6;

		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);

		JLabel person;

		if (InterviewManager.WhatInterview == 1) {
			person = SelectInterview.addJLabelImage(new JLabel(), "gwakTheIronDragon.png", 314, 200);
			person.setLocation(222, 310);
			buttonArr = InterviewManager.showQuest(buttonArr, question, 26);
		} else if (InterviewManager.WhatInterview == 2) {
			person = SelectInterview.addJLabelImage(new JLabel(), "leeTheDragon.png", 202, 293);
			person.setLocation(222, 310);
			buttonArr = InterviewManager.showQuest(buttonArr, bigQuestion, 26);

		} else {
			person = SelectInterview.addJLabelImage(new JLabel(), "mark.png", 233, 208);
			person.setLocation(222, 310);
			buttonArr = InterviewManager.showQuest(buttonArr, foreignQuestion, 26);
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
		couponQty.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		couponQty.setForeground(Color.WHITE);
		couponQty.setSize(50, 40);
		couponQty.setLocation(220, 40);
		this.add(couponQty);

		JLabel dayWeekDay = new JLabel(p.getDay() + "일차" + " / " + p.getWeekDay() + "요일");
		dayWeekDay.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
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

		JLabel backGround = SelectInterview.addJLabelImage(new JLabel(), "interview.png", 1194, 834);
		backGround.setLocation(0, 0);

		for (int i = 0; i < buttonArr.size(); i++) {

			this.add(buttonArr.get(i));
		}

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("다음화면");
				DelayTime dt = new DelayTime(mf, p);
				DokiDoki doki = new DokiDoki(mf, dt);

				Thread runDoki = doki;
				runDoki.start();
				ChangePanel.replacePanel(mf, panel, dt);

			}
		});

		this.add(txtArea);
		this.add(person);
		this.add(backGround);

	}

}
