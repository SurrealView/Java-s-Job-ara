package com.kh.parkBBakBBak.view.home;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class HomeEnd3 extends JPanel {
	
	private JFrame mf;
	private JPanel he1;
	private Player p;
	
	public HomeEnd3(JFrame mf, Player p) {
		
		this.mf = mf;
		he1 = this;
		this.p = p;
		
		this.setLayout(null);
		this.setSize(1194,834);
		this.setLocation(0,0);
		
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
	    couponQty.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
	    couponQty.setForeground(Color.WHITE);
	    couponQty.setSize(50, 40);
	    couponQty.setLocation(220, 40);
		this.add(couponQty);
		
		JLabel dayWeekDay = new JLabel(p.getDay() + "ÀÏÂ÷" + " / " + p.getWeekDay() + "¿äÀÏ");
		dayWeekDay.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
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
		
		JLabel txtArea = new JLabel();
		txtArea.setSize(820,270);
		txtArea.setLocation(187,500);
		this.add(txtArea);
		
		txtArea.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.replacePanel(mf, he1, new WorldPanel(mf, p));		
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		JLabel text1 = new JLabel("À¸¾Ç! Áö°¢ÀÌ´Ù!!! ¾ó¸¥ °¡ÀÚ!!!!");
		text1.setSize(715,45);
		text1.setLocation(240,551);
		text1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		text1.setBackground(new Color(240,247,247));
		text1.setBorder(null);
		this.add(text1);
		
		JLabel txtBoxImg = new JLabel(new ImageIcon(new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(820, 270, 0)));
		txtBoxImg.setSize(820,270);
		txtBoxImg.setLocation(187, 500);
		this.add(txtBoxImg);
		
		JLabel bg = new JLabel(new ImageIcon(new ImageIcon("images/homeReSize.png").getImage().getScaledInstance(1194, 834, 0)));
		bg.setSize(1194, 834);
		bg.setLocation(0, 0);
		this.add(bg);
		
	}
	
}
