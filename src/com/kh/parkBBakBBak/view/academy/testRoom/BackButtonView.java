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

public class BackButtonView extends JPanel{
	
	private JFrame mf;
	private JPanel BackButtonView;
	private Player p;
	private JButton yes;
	private JButton no;
	private int buttonIndex;
	private int index;
	
	public BackButtonView(JFrame mf, Player p, int buttonIndex, int index) {
		
		this.mf = mf;
		this.BackButtonView = this;
		this.p = p;
		this.buttonIndex = buttonIndex;
		this.index = index;
		
		Image background = new ImageIcon("images/classroom.png").getImage().getScaledInstance(1194, 834, 0);
		JLabel backgroundLb = new JLabel(new ImageIcon(background));
		backgroundLb.setLayout(null);
		backgroundLb.setBounds(0, 0, 1194, 834);
		
		Image chat = new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(820, 270, 0);
		JLabel chatLb = new JLabel(new ImageIcon(chat));
		chatLb.setLayout(null);
		chatLb.setBounds(180, 250, 820, 270);
		
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
		
		JTextArea notice = new JTextArea(100, 300);
		notice.setOpaque(false);
		notice.append("시험을 포기하고 돌아가시겠습니까?\n소모된 배터리는 복구되지 않습니다.");
		notice.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		notice.setBounds(390, 325, 600, 100);
		notice.setEditable(false);
		
		yes = new JButton("네");
		yes.setOpaque(false);
		yes.setBorderPainted(false);
		yes.setContentAreaFilled(false);
		yes.setFocusPainted(true);
		yes.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		yes.setBounds(380, 395, 100, 100);
		yes.addMouseListener(new MyMouseAdapter());
		this.add(yes);
		
		no = new JButton("아니오");
		no.setOpaque(false);
		no.setBorderPainted(false);
		no.setContentAreaFilled(false);
		no.setFocusPainted(true);
		no.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		no.setBounds(660, 395, 150, 100);
		no.addMouseListener(new MyMouseAdapter());
		this.add(no);
		
		this.add(notice);
		this.add(chatLb);
		this.add(backgroundLb);
		mf.add(this);
		
	}
	
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == yes) {
				ChangePanel.replacePanel(mf, BackButtonView, new AcademyMain(mf,p));
			} else if(e.getSource() == no) {
				new ShowQuestPage(mf, p, buttonIndex);
				ChangePanel.replacePanel(mf, BackButtonView, new ShowQuestPage(mf,p, buttonIndex));
			}
		}
	}

}
