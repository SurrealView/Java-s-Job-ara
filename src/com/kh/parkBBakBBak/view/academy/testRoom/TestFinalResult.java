package com.kh.parkBBakBBak.view.academy.testRoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.AcademyMain;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class TestFinalResult extends JPanel {

	private JFrame mf;
	private JPanel TestFinalResult;
	private Player p;
	private int answerCount;
	private JTextArea testResult;
	

	public TestFinalResult(JFrame mf, Player p, int answerCount, int buttonIndex) {

		this.mf = mf;
		this.p = p;
		this.TestFinalResult = this;
		this.answerCount = answerCount;

		String[] chapter = {"변수", "연산자", "제어문", "배열", "객체", "상속", "다형성", "API", "예외처리", "컬렉션"};

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
		
		Image background = new ImageIcon("Images/classRoom.png").getImage().getScaledInstance(1194, 834, 0);
		JLabel backgroundLb = new JLabel(new ImageIcon(background));
		backgroundLb.setLayout(null);
		backgroundLb.setBounds(0, 0, 1194, 834);

		Image chat = new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(820, 270, 0);
		JLabel chatLb = new JLabel(new ImageIcon(chat));
		chatLb.setLayout(null);
		chatLb.setBounds(180, 250, 820, 270);

		testResult = new JTextArea(100, 300);
		testResult.setOpaque(false);
		testResult.append("");
		testResult.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		testResult.setEditable(false);


		if(answerCount > 3) {
			//스킬획득
			boolean[] a = new boolean[10];
			a = p.getGetSkill();
			a[buttonIndex] = true;
			p.setGetSkill(a);
			p.setSkillQTY(p.getSkillQTY() + 1);
			
			testResult.setText("축하합니다!" + "\n" + chapter[buttonIndex] + "스킬을 획득하셨습니다.");
			testResult.setBounds(250, 355, 400, 400);
			if(answerCount == 5) {
				//만점 시 커피쿠폰 1 증가
				testResult.setText("축하합니다! "+ chapter[buttonIndex] + "스킬을 획득하셨습니다.\n모든 문제를 맞춘 당신! 자바마스터의 선물이 도착했습니다.\n커피쿠폰 + 1");
				testResult.setBounds(250, 335, 700, 400);
				p.setCouponQTY(p.getCouponQTY() + 1);
				
			}
		} else if (answerCount < 4) {
			testResult.setBounds(250, 335, 400, 400);
			testResult.setText("시험에서 탈락했습니다.\n복습만이 살 길!\n해당 챕터 복습 후 재도전하세요.");
		}
		
		testResult.addMouseListener(new MyMouseAdapter());
		
		ShowQuestPage sp = new ShowQuestPage(mf, p, buttonIndex);
		ShowQuestPage.index=0;
		
		this.add(testResult);
		this.add(chatLb);
		this.add(backgroundLb);
	}
	
	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == testResult) {
				ChangePanel.replacePanel(mf, TestFinalResult, new AcademyMain(mf,p));
			}
		}
	}

}
