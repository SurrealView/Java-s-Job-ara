package com.kh.parkBBakBBak.view.interview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;

public class SelectInterview extends JPanel {

	private JFrame mf;
	private JPanel panel;
	private Player p;
	private Font font;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String[] question = new String[] { "면접장에 입장하셨습니다", "중소 기업  : (스킬 5개이상 보유)", "대기업 (스킬 8개이상 보유) :",
			"해외 취업(Hidden)" };

	public SelectInterview(JFrame mf, Player p) {
		System.out.println("selectInterview 입장");
		this.p = p;
		this.mf = mf;
		this.panel = this;
		this.setLayout(null);
		this.setSize(1194, 834);
		InterviewManager.pageNum = 1;

		JLabel txtArea = addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);

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

		JButton backButton = addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1100, 15);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("돌아갈래");

				ChangePanel.replacePanel(mf, panel, new WorldPanel(mf, p));
				// ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf));

			}
		});

		JLabel backGround = addJLabelImage(new JLabel(), "interview.png", 1194, 834);
		backGround.setLocation(0, 0);

		buttonArr = showQuest(buttonArr, question);
		for (int i = 0; i < buttonArr.size(); i++) {

			this.add(buttonArr.get(i));
		}

		buttonArr.get(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (5 <= p.getSkillQTY()) {
					InterviewManager.WhatInterview = 1;
					System.out.println("중소중소");

					ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf, p));
				}

				else {
					JOptionPane.showMessageDialog(mf, "스킬이 부족합니다!", "더 배워오세요", JOptionPane.WARNING_MESSAGE);

				}

			}

		});

		buttonArr.get(2).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (8 <= p.getSkillQTY()) {
					InterviewManager.WhatInterview = 2;
					System.out.println("샘송샘송");

					ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf, p));
				}

				else {
					JOptionPane.showMessageDialog(mf, "스킬이 부족합니다!", "더 배워오세요", JOptionPane.WARNING_MESSAGE);

				}
			}
		});

		if (p.getHidden() == 0) {

			buttonArr.get(3).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					InterviewManager.WhatInterview = 3;
					System.out.println("페북페북");

					ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf, p));
				}
			});
		}

		this.add(txtArea);
		this.add(backButton);
		this.add(backGround);

	}

	public static JLabel addJLabelImage(JLabel label, String path, int x, int y) {

		Image image = new ImageIcon(InterviewManager.ADDRESS + path).getImage().getScaledInstance(x, y, 0);
		label = new JLabel(new ImageIcon(image));
		label.setSize(x, y);

		return label;
	}

	public static JButton addJButtonImage(JButton button, String path, int x, int y) {

		Image image = new ImageIcon(InterviewManager.ADDRESS + path).getImage().getScaledInstance(x, y, 0);
		button = new JButton(new ImageIcon(image));
		button.setSize(x, y);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);

		return button;
	}

	public ArrayList<JButton> showQuest(ArrayList<JButton> buttonArr, String[] question) {

		for (int i = 0; i < (question.length +p.getHidden()); i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("맑은 고딕", font.PLAIN, 26));
			buttonArr.get(i).setSize(700, 40);
			buttonArr.get(i).setLocation(225, 550 + (60 * i));
			buttonArr.get(i).setBorderPainted(false);
			buttonArr.get(i).setContentAreaFilled(false);
			buttonArr.get(i).setFocusPainted(false);
			buttonArr.get(i).setHorizontalAlignment(SwingConstants.LEFT);

		}
		return buttonArr;
	}

}
