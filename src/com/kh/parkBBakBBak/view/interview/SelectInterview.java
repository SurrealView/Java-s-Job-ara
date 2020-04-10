package com.kh.parkBBakBBak.view.interview;



import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;

public class SelectInterview extends CreatedInterview {

	private ArrayList<JButton> talk = new ArrayList<JButton>();
	
	private JPanel panel;
	private JFrame mf;

	
	String[] talks = new String[] { "1.중소기업(스킬 5개이상)", "2.대기업(스킬 8개이상)"  };

	public SelectInterview(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		this.setLayout(null);
		this.setSize(1194, 834);

		this.showQuest(talk, talks);
		this.createBattery(5);
		this.createTxtArea();
		this.createMenuBar();
		this.createBackSpace();
		this.createCountCoupons(3);
		this.creatSmallCoffee();
		this.creatTestPlace();

		this.setVisible(true);

		mf.add(panel);

	}

	@Override
	public void showQuest(ArrayList<JButton> buttonArr, String[] question) {
		// TODO Auto-generated method stub
		super.showQuest(buttonArr, question);
		for (int i = 0; i < question.length; i++) {
			buttonArr.get(i).addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == talk.get(0)) {
			
//			ChangePanel change = new ChangePanel(mf, panel);
			SmallIntroduce1 intro1 = new SmallIntroduce1(mf);
			ChangePanel.replacePanel(mf,panel,intro1);
//			change.replacePanel(intro1);


		}else if(e.getSource()==talk.get(1)) {
			System.out.println("머같네");
			
		}else if(e.getSource()==menuButton) {
			
			System.out.println("메뉴보기");
		}else if(e.getSource()==backButton) {
			
			System.out.println("뒤로 갈거다");
		}
	}

}
