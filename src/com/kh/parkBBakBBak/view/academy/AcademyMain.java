package com.kh.parkBBakBBak.view.academy;

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
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;
import com.kh.parkBBakBBak.view.academy.lecture.LectureMain;
import com.kh.parkBBakBBak.view.academy.testRoom.TestMainPage;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class AcademyMain extends JPanel{

	private JFrame mf;
	private JPanel academyMain;
	private JButton testRoom;
	private Player p;
	private JButton goBack;

	public AcademyMain(JFrame mf,Player p) {
		this.mf = mf;
		this.academyMain = this;
		this.p=p;

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

		JTextArea userChat = new JTextArea("늦지 않게 학원에 도착했군! 이제 뭐할까?");
		userChat.setBounds(235, 570, 500, 57);
		userChat.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		userChat.setOpaque(false);
		this.add(userChat);
	
		JButton lecture = new JButton("1. 강의실에서 수업을 듣는다.");
		lecture.setBounds(215, 620, 500, 57);
		lecture.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lecture.setBorderPainted(false);
		lecture.setContentAreaFilled(false);
		lecture.setOpaque(false);
		lecture.setHorizontalAlignment(lecture.LEFT);
		this.add(lecture);

		testRoom = new JButton("2. 시험장에서 시험을 본다.(배터리 1 감소)");
		testRoom.setBounds(215, 675, 500, 57);
		testRoom.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		testRoom.setBorderPainted(false);
		testRoom.setContentAreaFilled(false);
		testRoom.setOpaque(false);
		testRoom.setHorizontalAlignment(lecture.LEFT);

		if(p.getWeekDay().equals("토") || p.getWeekDay().equals("일")) {
			this.remove(lecture);
			testRoom.setVisible(false);
			JButton hidden = new JButton();
			hidden.setBounds(525, 160, 60, 60);
			
			hidden.setBorderPainted(false);
			hidden.setContentAreaFilled(false);
			hidden.setOpaque(false);
			//hidden.setHorizontalAlignment(hidden.LEFT);
			this.add(hidden);
			hidden.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ChangePanel.replacePanel(mf, academyMain,new EasterEgg(mf, p));
					
					
				}
			});
			hidden.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					Image godJava = new ImageIcon("images/teacher.png").getImage().getScaledInstance(170, 90, 0);
					hidden .setIcon(new ImageIcon(godJava));
					hidden.setSize(170,90);
					
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					hidden.setIcon(new ImageIcon(""));
					hidden.setSize(60,60);
					hidden.setBorderPainted(false);
					hidden.setContentAreaFilled(false);
					hidden.setOpaque(false);
				}
			});
			this.repaint();
			chatLb.setBounds(190, 250, 820, 270);
			userChat.setText("주말에는 운영하지 않습니다.\n주말 이용 가능 컨텐츠 : 면접장, 카페");
			userChat.setFont(new Font("맑은 고딕", Font.BOLD, 22));
			userChat.setBounds(245, 360, 1000, 1000);
		}

		this.add(testRoom);
		this.add(chatLb);
		this.add(backgroundLb);

		mf.add(this);

		System.out.println(p.toString());

		testRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TestMainPage tm = new TestMainPage(mf,p);
				ChangePanel.replacePanel(mf, academyMain, tm); 
			}
		});
		lecture.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, academyMain, new LectureMain(mf,p));

			}
		});
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == goBack) {
				ChangePanel.replacePanel(mf, academyMain, new WorldPanel(mf, p)); 
			}

		}
	}
}



