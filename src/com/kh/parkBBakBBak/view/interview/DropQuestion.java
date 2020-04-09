package com.kh.parkBBakBBak.view.interview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.model.dao.InputQuest;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.MainFrame;
import com.kh.parkBBakBBak.view.WorldPanel;

public class DropQuestion extends CreatedInterview {
	public static int count=0;
	private ArrayList<JButton> buttonArr= new ArrayList<JButton>();
	private InputQuest qa = new InputQuest();
	private String talks[] =new String[] {qa.getQuiz(),qa.getSample()[0],qa.getSample()[1],qa.getSample()[2]};
	private JFrame mf;
	
	private JPanel panel;
	
	public DropQuestion(JFrame mf) {
		this.mf=mf;
		this.panel=this;
		this.setLayout(null);
		this.setSize(1194,834);
				
		this.showQuest(buttonArr,talks);
		this.createBattery(3);
		this.createMenuBar();
		this.createBackSpace();
		this.createCountCoupons(3);
		this.creatSmallCoffee();
		this.creatEclipse();
	}
	
	@Override
	public void showQuest(ArrayList<JButton> buttonArr, String[] question) {
		
		for (int i = 0; i < question.length; i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("¸¼Àº °íµñ", font.PLAIN, 18));
			buttonArr.get(i).setForeground(Color.WHITE);
			buttonArr.get(i).setSize(1000, 40);
			buttonArr.get(i).setLocation(100, 200 + (60 * i));
			buttonArr.get(i).setBorderPainted(false);
			buttonArr.get(i).setContentAreaFilled(false);
			buttonArr.get(i).setFocusPainted(false);
			buttonArr.get(i).setHorizontalAlignment(SwingConstants.LEFT);
			this.add(buttonArr.get(i));
			 buttonArr.get(i).addActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == menuButton) {
			System.out.println("¸Þ´ºº¸±â");
			
		} else if (e.getSource() == backButton) {
			ChangePanel change = new ChangePanel(mf, panel);
			WorldPanel world = new WorldPanel(mf);
			change.replacePanel(world);


			
		}
	
	}

}
