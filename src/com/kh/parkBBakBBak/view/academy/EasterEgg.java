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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.AcademyMain;
import com.kh.parkBBakBBak.view.interview.DropQuestion;
import com.kh.parkBBakBBak.view.interview.SelectInterview;
import com.kh.parkBBakBBak.view.interview.SmallIntroduce1;

public class EasterEgg extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	private int chatIndex=0;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String[] chat = new String[] {"빡빡  : 너무 바빠서 주말인지도 몰랐네....카페나 가야겠다\n\n"
			+"빡빡 : 흑당마라민트초코를 주문하면 카페에 오래있을수 있겠지?",
			
			"자바마스터 : 빡빡씨!! 주말인데도 강남에 나오셨군요!!\n\n" + 
			"빡빡 : 앗 마스터님 안녕하세요!\n\n" +	"자바마스터 : 미니프로젝트 준비가 다 끝났다면서요?",
			
			"빡빡 : 아 넵! 그렇습니다!\n\n" +"자바마스터 : 끝날때 까지 끝난게 아니죠 히든패널을 추가해 보세요\n\n" + 
			"빡빡 : 아 넵... 알겠습니다...",
			
			"자바마스터 : 프로젝트를 하면서 고통 받는게 진정한 재미입니다.\n\n" + 
			"자바마스터 : 빡빡씨는 지금까지 재미라는 것을 잘못 알고있었어요\n\n" + 
			"빡빡 : 아 그렇군요! 카페가서 당장 해보겠습니다!\n\n",
			
			"자바마스터 : 좋습니다 재형씨 시연날을 기대해볼께요\n\n자바마스터 : 가는 길에 커피 한잔 해요\n\n"+
			"재형 : 넵 최선을 다하겠습니다...",
			
			"주말에 학원을 방문한 재형은 배터리가 1감소했다\n\n"
			+"자바마스터가 독려의 의미로 쿠폰을 한장 주었다\n\n"+
			"Episode 병주고 약주고 종료"
			};
			
			

	public EasterEgg(JFrame mf, Player p) {
		System.out.println("이스터에그 입장");
		this.mf = mf;
		this.panel = this;
		this.p = p;
		this.setLayout(null);
		this.setSize(1194, 834);
		InterviewManager.pageNum = 3;

		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);

		Image godJava = new ImageIcon("images/teacher.png").getImage().getScaledInstance(220, 210, 0);
		JLabel godJavaLb = new JLabel(new ImageIcon(godJava));
		godJavaLb.setLayout(null);
		godJavaLb.setBounds(230, 311, 220, 210);

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

		

		JLabel backGround = SelectInterview.addJLabelImage(new JLabel(), "smoke.png", 1194, 834);
		backGround.setLocation(0, 0);

		JTextArea ment = new JTextArea(chat[0]);
		ment.setSize(720,200);
		ment.setLocation(250,540);
		ment.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		ment.setBackground(new Color(240,247,247));
		this.add(ment);
		
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				chatIndex++;
				
				switch (chatIndex) {

				case 1: case 2: case 3: case 4:	ment.setText(chat[chatIndex]); break;
				case 5:
					ment.setText(chat[chatIndex]);
					p.setHp(p.getHp() - 1);
					p.setCouponQTY(p.getCouponQTY() + 1);
					break;

				case 6:
					ment.setText("빡빡의 현재 체력 :" + p.getHp() + "칸\n\n빡빡의 현재 쿠폰갯수 : " + p.getCouponQTY() + "장");
					break;
				case 7:
					ChangePanel.replacePanel(mf, panel, new AcademyMain(mf, p));

				}

			}
		});
		
		this.add(txtArea);
		this.add(godJavaLb);
		this.add(backGround);

	}

}
