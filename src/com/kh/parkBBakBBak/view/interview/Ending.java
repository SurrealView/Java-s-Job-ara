package com.kh.parkBBakBBak.view.interview;

import java.awt.Font;
import java.awt.Menu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.controller.SaveManager;
import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.controller.interview.Navi;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.LoginPage;
import com.kh.parkBBakBBak.view.MenuPanel;
import com.kh.parkBBakBBak.view.home.HomePanel;

public class Ending extends JPanel {

	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String[] endingMent = new String[] { "����������  ��� ����� ��ģ ����", "KH�� �������� ���ο� ���� ��ġ�� �� �׿���",
			"Ȳ�� �� �̷��� �������� �ٶ��" };
	private String[] speacialEndingMent = new String[] { "����������  �ؿ� ����� ��ģ ����", "���ѹα��� ���� �������� �����ڰ� �Ǿ���� ������",
			"���� ���� ������ �÷��� ���ּż� �����մϴ�!" };
	private String[] moreStudy = new String[] { "�ں��� :", "���� ���� �����߾�....", "���� ��ų�� �����ؼ� �ٽ� �غ�����!" };

	public Ending(JFrame mf,Player p) {
		System.out.println("Ending ����");
		MenuPanel.mainBgm.stop();
		this.mf = mf;
		this.p=p;
		this.panel = this;
		this.setLayout(null);
		this.setSize(1194, 834);
		InterviewManager.pageNum = 10;
		
		

		JLabel backGround;
		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);

		if (InterviewManager.correctAnswer < 8) {
			backGround = SelectInterview.addJLabelImage(new JLabel(), "homeReSize.png", 1194, 834);
			backGround.setLocation(0, 0);

			buttonArr = InterviewManager.showQuest(buttonArr, moreStudy,26);
			for (int i = 0; i < buttonArr.size(); i++) {

				this.add(buttonArr.get(i));
			}
		} else {
			backGround = SelectInterview.addJLabelImage(new JLabel(), "gameOver.png", 1194, 834);
			backGround.setLocation(0, 0);
			if (InterviewManager.WhatInterview == 1) {
				buttonArr = InterviewManager.showQuest(buttonArr, endingMent,26);
				p.setCareer("�߼Ҹ�");

			} else if (InterviewManager.WhatInterview == 2) {
				JOptionPane.showMessageDialog(mf, "�ؿ� ��� �÷��̰� �����մϴ�", "���� �������� ����!", JOptionPane.WARNING_MESSAGE);
				buttonArr = InterviewManager.showQuest(buttonArr, endingMent,26);
				p.setHidden(0);
				p.setCareer("�Ｚ��");

			} else if (InterviewManager.WhatInterview == 3) {
				buttonArr = InterviewManager.showQuest(buttonArr, speacialEndingMent,26);
				p.setHiddenEnd(true); 
				p.setCareer("�ؿ��ν�");
			}

			for (int i = 0; i < buttonArr.size(); i++) {

				this.add(buttonArr.get(i));
			}

		}

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (InterviewManager.correctAnswer < 8) {
					System.out.println("��� ������ ������");
					 ChangePanel.replacePanel(mf, panel, new HomePanel(mf,p));
				} else {
					if (p.isHiddenEnd() == true) {
						NaviBobetDDau nb =new NaviBobetDDau(mf,p);
						Navi navi = new Navi(mf, nb);
						
						Thread runNavi = navi;
						
						runNavi.start();
						ChangePanel.replacePanel(mf, panel, nb);
					

					} else {
						   SaveManager sm = new SaveManager();
				            sm.deleteData(p);
				            sm.savePlayer();
				            System.out.println("saveȭ������ �����°� ������ ����" + sm.savePlayer().toString());
				            
				            ChangePanel.replacePanel(mf, panel, new LoginPage(mf,p));
					
					}
				}InterviewManager.correctAnswer = 0;
				
			}
		});

		this.add(txtArea);
		this.add(backGround);

	}


//
//	public ArrayList<JButton> showQuest(ArrayList<JButton> buttonArr, String[] question) {
//
//		for (int i = 0; i < question.length; i++) {
//			buttonArr.add(new JButton(question[i]));
//			buttonArr.get(i).setFont(new Font("���� ���", font.PLAIN, 26));
//			buttonArr.get(i).setSize(700, 40);
//			buttonArr.get(i).setLocation(225, 550 + (60 * i));
//			buttonArr.get(i).setBorderPainted(false);
//			buttonArr.get(i).setContentAreaFilled(false);
//			buttonArr.get(i).setFocusPainted(false);
//			buttonArr.get(i).setHorizontalAlignment(SwingConstants.LEFT);
//
//		}
//		return buttonArr;
//	}

}
