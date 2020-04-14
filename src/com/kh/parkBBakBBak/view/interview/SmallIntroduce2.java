package com.kh.parkBBakBBak.view.interview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class SmallIntroduce2 extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String[] question = new String[] { "지금부터 면접을 시작할 걸세", "배터리가 2 감소할거야", "준비가 되면 말을 걸어주시게" };
	private String[] bigQuestion = new String[] { "지금 부터 면접이 실시 될 것 입니다.", "입장시 배터리가 2 감소됩니다.", "준비가 완료 되시면 시작하겠습니다" };
	private String[] foreignQuestion = new String[] { "Let's Start the interview now.\\n; ",
			"if you enter, the battery will be reduced by 2.\\n; ", "if you're ready, let's get it start.\\n;" };

	public SmallIntroduce2(JFrame mf,Player p) {
		System.out.println("smallIntroduce2 입장");
		this.mf = mf;
		this.panel = this;
		this.p= p;
		this.setLayout(null);
		this.setSize(1194, 834);
		InterviewManager.pageNum = 3;

	

		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);

		JLabel person;
		
		if(InterviewManager.WhatInterview==1) {
		person= SelectInterview.addJLabelImage(new JLabel(), "gwakTheIronDragon.png", 314, 200);
		person.setLocation(222, 310);
		buttonArr = InterviewManager.showQuest(buttonArr, question,26);
		}
		else if(InterviewManager.WhatInterview==2) {
			person= SelectInterview.addJLabelImage(new JLabel(), "leeTheDragon.png", 202, 293);
			person.setLocation(222, 310);
			buttonArr = InterviewManager.showQuest(buttonArr, bigQuestion,26);
			
		}else {
			person= SelectInterview.addJLabelImage(new JLabel(), "mark.png", 233, 208);
			person.setLocation(222, 310);
			buttonArr =InterviewManager.showQuest(buttonArr, foreignQuestion,26);
		}

		

		 JLabel batteryCase = new JLabel(new ImageIcon(new ImageIcon("images/batteryCase.png").getImage().getScaledInstance(140, 45, 0)));
	       batteryCase.setSize(140,45);
	      batteryCase.setLocation(40, 40);
	       this.add(batteryCase);
	       
	       String[] remainBattery = new String[] { "Battery1.png", "Battery2.png", "Battery3.png", "Battery4.png", "Battery5.png" };

	       ArrayList<Image> batteryImage = new ArrayList<Image>();
	       for (int i = 0; i < remainBattery.length; i++) {
	          batteryImage.add(new ImageIcon(InterviewManager.ADDRESS + remainBattery[i]).getImage().getScaledInstance(140, 45, 0));
	       }

	       ArrayList<JLabel> batteryLabels = new ArrayList<JLabel>();

	       if(p.getHp() != 0) {
	       for (int i = 0; i < p.getHp(); i++) {
	          batteryLabels.add(new JLabel(new ImageIcon(batteryImage.get(i))));
	          batteryLabels.get(i).setSize(140, 45);
	          batteryLabels.get(i).setLocation(40, 40);
	          }
	       
	       for(int i = 0; i < this.p.getHp(); i++) {
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
	      infoBox.setSize(403,65);
	      infoBox.setLocation(30,30);
	      infoBox.setOpaque(true);
	      infoBox.setBackground(new Color (0,0,0,150));
	      this.add(infoBox);

		JButton backButton = SelectInterview.addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1100, 15);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("돌아갈래");

				ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf,p));
				// ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf));

			}
		});

	

		JLabel backGround = SelectInterview.addJLabelImage(new JLabel(), "interview.png", 1194, 834);
		backGround.setLocation(0, 0);

		buttonArr = InterviewManager.showQuest(buttonArr, question,26);
		for (int i = 0; i < buttonArr.size(); i++) {

			this.add(buttonArr.get(i));
		}

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("다음화면");
				if(p.getHp()>2) {
					
					p.setHp(p.getHp()-2);
					ChangePanel.replacePanel(mf, panel, new DropQuestion(mf,p));
				}else {
					JOptionPane.showMessageDialog(mf, "체력이 부족합니다!", "체력을 충전하고 오세요", JOptionPane.WARNING_MESSAGE);
					
				}

			}
		});

		
		this.add(txtArea);
		this.add(person);
		this.add(backButton);
		this.add(backGround);

	}





}
