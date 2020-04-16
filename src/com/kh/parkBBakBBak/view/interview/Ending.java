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
	private String[] endingMent = new String[] { "성공적으로  기업 취업을 마친 빡빡", "KH를 빠져나와 새로운 삶을 펼치게 된 그에게",
			"황금 빛 미래가 펼쳐지길 바라며" };
	private String[] speacialEndingMent = new String[] { "성공적으로  해외 취업을 마친 빡빡", "대한민국을 떠나 세계적인 개발자가 되어버린 빡빡이",
			"지금 동안 게임을 플레이 해주셔서 감사합니다!" };
	private String[] moreStudy = new String[] { "박빡빡 :", "내가 많이 부족했어....", "좀더 스킬을 연마해서 다시 준비하자!" };

	public Ending(JFrame mf,Player p) {
		System.out.println("Ending 입장");
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
				p.setCareer("중소맨");

			} else if (InterviewManager.WhatInterview == 2) {
				JOptionPane.showMessageDialog(mf, "해외 취업 플레이가 가능합니다", "히든 스테이지 개방!", JOptionPane.WARNING_MESSAGE);
				buttonArr = InterviewManager.showQuest(buttonArr, endingMent,26);
				p.setHidden(0);
				p.setCareer("삼성맨");

			} else if (InterviewManager.WhatInterview == 3) {
				buttonArr = InterviewManager.showQuest(buttonArr, speacialEndingMent,26);
				p.setHiddenEnd(true); 
				p.setCareer("해외인싸");
			}

			for (int i = 0; i < buttonArr.size(); i++) {

				this.add(buttonArr.get(i));
			}

		}

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (InterviewManager.correctAnswer < 8) {
					System.out.println("울며 집에간 재형이");
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
				            System.out.println("save화면으로 꺼내는게 성공된 빡빡" + sm.savePlayer().toString());
				            
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
//			buttonArr.get(i).setFont(new Font("맑은 고딕", font.PLAIN, 26));
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
