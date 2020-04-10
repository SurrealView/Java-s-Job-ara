package com.kh.parkBBakBBak.view.interview;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;

public class SmallIntroduce2 extends CreatedInterview {
	private ArrayList<JButton> buttonArr= new ArrayList<JButton>();
	private String talks[] =new String[] {"지금부터 면접을 시작하겠네","준비가 되면 말을 걸어주시게"};
	protected  JFrame mf;
	private JPanel panel;
	
	public SmallIntroduce2(JFrame mf) {
		this.mf=mf;
		this.panel=this;
		this.setLayout(null);
		this.setSize(1194,834);
				
		this.showQuest(buttonArr,talks);
		this.createBattery(5);
		this.createKwak();
		this.createTxtArea();
		this.createMenuBar();
		this.createBackSpace();
		this.createCountCoupons(5);
		this.creatSmallCoffee();
		this.creatTestPlace();
		this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
//		ChangePanel change = new ChangePanel(mf, panel);
		DropQuestion dq = new DropQuestion(mf);
		ChangePanel.replacePanel(mf,panel,dq);
//		change.replacePanel(dq);
		//this.bbakbbak.setHp(this.bbakbbak.getHp()-2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuButton) {
			System.out.println("메뉴보기");
			
		} else if (e.getSource() == backButton) {

			
//			ChangePanel change = new ChangePanel(mf, panel);
			SmallIntroduce1 intro1 = new SmallIntroduce1(mf);
			ChangePanel.replacePanel(mf,panel,intro1);
//			change.replacePanel(intro1);
		}
	}
	
	

}
