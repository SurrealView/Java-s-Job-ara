package com.kh.parkBBakBBak.view.academy.testRoom;

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
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.AcademyMain;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class TestMainPage extends JPanel{

	private JFrame mf;
	private JPanel testMainPage;
	private Player p;
	private JButton goBack;

	public TestMainPage(JFrame mf,Player p) {
		this.p=p;
		this.mf = mf;
		this.testMainPage = this;

		this.setLayout(null);
		this.setBounds(0, 0, 1194, 834);

		goBack = new JButton(new ImageIcon(new ImageIcon("images/backButton.png").getImage().getScaledInstance(60, 60, 0)));
		goBack.setBounds(1100, 15, 60, 60);
		goBack.setOpaque(false);
		goBack.setBorderPainted(false);
		goBack.setContentAreaFilled(false);
		goBack.addMouseListener(new MyMouseAdapter());
		this.add(goBack);
		
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
		
		
		Image background = new ImageIcon("images/classroom.png").getImage().getScaledInstance(1194, 834, 0);
		JLabel backgroundLb = new JLabel(new ImageIcon(background));
		backgroundLb.setBounds(0, 0, 1194, 834);

		Image chat = new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(820, 270, 0);
		JLabel chatLb = new JLabel(new ImageIcon(chat));
		chatLb.setLayout(null);
		chatLb.setBounds(180, 520, 820, 270);

		JTextArea javaMasterName = new JTextArea(100, 300);
		javaMasterName.setOpaque(false);
		javaMasterName.append("자바마스터");
		javaMasterName.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		javaMasterName.setBounds(235, 570, 150, 30);

		JTextArea javaMasterChat = new JTextArea(950, 170);
		javaMasterChat.setOpaque(false);
		javaMasterChat.append("시험장을 선택하셨군요.\n4문제 이상 맞췄을 경우 합격, \n5문제 모두 맞추면 특별 선물이 있으니 최선을 다해 풀어보세요.");
		javaMasterChat.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		javaMasterChat.setBounds(235, 620, 660, 140);

		Image godJava = new ImageIcon("images/teacher.png").getImage().getScaledInstance(220, 210, 0);
		JLabel godJavaLb = new JLabel(new ImageIcon(godJava));
		godJavaLb.setLayout(null);
		godJavaLb.setBounds(230, 311, 220, 210);


		this.addMouseListener(new MyMouseAdapter());
		 
		
		this.add(javaMasterChat);
		this.add(javaMasterName);
		this.add(godJavaLb);
		this.add(chatLb);
		this.add(backgroundLb);
		mf.add(this);
		
	
		TestResult.answerCount = 0;
		ShowQuestPage sq = new ShowQuestPage();
		ShowQuestPage.index = 0;
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == goBack) {
				ChangePanel.replacePanel(mf, testMainPage,new AcademyMain(mf, p)); 
			} else {
				ChangePanel.replacePanel(mf, testMainPage, new TestChooseChapter(mf,p));
			}
		}
	}

}
