package com.kh.parkBBakBBak.view.academy.lecture;

import java.awt.Button;
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
import javax.swing.JPanel;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.AcademyMain;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class LectureMain extends JPanel {                
	private JFrame mf;
	private JPanel panel;
	private ImageIcon ic;
	private Player p;
	private ArrayList<JButton> list = new ArrayList<>();
	public  static int buttonIndex;
	public static String[] name = {"1. 변수", "2.연산자", "3.제어문", "4.배열", "5.객체", "6.상속", "7.다형성", "8.API", "9.예외", "10.컬렉션"};
	public LectureMain(JFrame mf,Player p) {
		this.mf = mf;
		panel = this;
		this.p = p;
		this.setLayout(null);
		this.setSize(1194,834);
		this.setLocation(0, 0);
		
		//과목 버튼
		
		for(int i = 0; i < 10; i++) {
			list.add(new JButton(name[i]));
			list.get(i).setOpaque(true);
			list.get(i).setFont(new Font("맑은고딕", Font.BOLD, 30));
			list.get(i).setBackground(new Color(45,86,26,255));
			list.get(i).setForeground(Color.WHITE);
			list.get(i).setBorderPainted(false);
			list.get(i).setFocusPainted(false);
			if( i < 5) {
				list.get(i).setBounds(150, 257 + (68 * i), 355, 68);
			} else if(i >= 5) {
				list.get(i).setBounds(650, 257 + (68 *(i-5)), 355, 68);
			}
			list.get(i).addMouseListener(new MyMouseAdapter());
			this.add(list.get(i));
		}
		
		JButton buttonmn = new JButton("들을 과목을 선택해 주세요");
		buttonmn.setBounds(143, 157, 908, 56);
		(buttonmn).setOpaque(false);
		buttonmn.setFont(new Font("맑은고딕", Font.BOLD, 30));
		buttonmn.setBackground(new Color(45,86,26,255));
		buttonmn.setForeground(Color.WHITE);
		buttonmn.setBorderPainted(false);
		buttonmn.setFocusPainted(false);
		this.add(buttonmn);
				
		
		
		
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
	       
	       for(int i = 0; i < p.getHp(); i++) {
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
	      
	      
		//뒤로가기 이미지
		Image iconBack = new ImageIcon("images/backButton.PNG").getImage().getScaledInstance(60, 60, 0);
		JButton buttonBack = new JButton(new ImageIcon(iconBack));
		buttonBack.setSize(60, 60);
		buttonBack.setLocation(1100,15);
		this.add(buttonBack);
		buttonBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, panel, new AcademyMain(mf,p));
			
		}});
		
		
		//칠판 
		Image icon2 = new ImageIcon("images/blackBoardClean.PNG").getImage().getScaledInstance(1080, 625, 0);
		JLabel label2 = new JLabel(new ImageIcon(icon2));
		label2.setSize(1080, 625);
		label2.setLocation(57, 110);	
		this.add(label2);
		
		
		//배경화면
		Image icon = new ImageIcon("images/classRoom.PNG").getImage().getScaledInstance(1194, 834, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setSize(1194, 834);
		label.setLocation(0, 0);
		this.add(label);
		
		list.get(0).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=0;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
				
			}
		});
		
		list.get(1).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=1;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
			}
		});

		list.get(2).addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=2;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
		
			}
		});
		
		list.get(3).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=3;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
				
			}
		});
		
		list.get(4).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=4;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
				
			}
		});
		
		list.get(5).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=5;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
				
			}
		});
		
		list.get(6).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=6;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
				
			}
		});
		
		list.get(7).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=7;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
				
			}
		});
		
		list.get(8).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=8;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
				
			}
		});
		
		list.get(9).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonIndex=9;
				ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
				
			}
		});
		
		mf.add(this);
	}
	

	
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.replacePanel(mf, panel, new LectureSub(mf,p));
	}
 }
}
