package com.kh.parkBBakBBak.view.interview;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;

public class SmallIntroduce1 extends CreatedInterview implements MouseListener {

	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String talks[] = new String[] { "오 자네가 이재형인가", "자네에 대해 많이 들었네", "지금부터 면접을 시작할걸세" };
	protected JFrame mf;
	private JPanel panel;

	public SmallIntroduce1(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		this.setLayout(null);
		this.setSize(1194, 834);
		this.showQuest(buttonArr, talks);
		this.createBattery(3);
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
	public void showQuest(ArrayList<JButton> buttonArr, String[] question) {
		buttonArr = this.buttonArr;
		question = talks;

		for (int i = 0; i < question.length; i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("맑은 고딕", font.PLAIN, 26));
			buttonArr.get(i).setSize(700, 40);
			buttonArr.get(i).setLocation(225, 550 + (60 * i));
			buttonArr.get(i).setBorderPainted(false);
			buttonArr.get(i).setContentAreaFilled(false);
			 buttonArr.get(i).setFocusPainted(false);
			buttonArr.get(i).setHorizontalAlignment(SwingConstants.LEFT);
			this.add(buttonArr.get(i));
			 buttonArr.get(i).addActionListener(this);

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		ChangePanel change = new ChangePanel(mf, panel);
		SmallIntroduce2 intro2 = new SmallIntroduce2(mf);
		change.replacePanel(intro2);


	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuButton) {
			System.out.println("메뉴보기");
			
		} else if (e.getSource() == backButton) {
			ChangePanel change = new ChangePanel(mf, panel);
			SelectInterview st = new SelectInterview(mf);
			change.replacePanel(st);

			
		}

	}

}
