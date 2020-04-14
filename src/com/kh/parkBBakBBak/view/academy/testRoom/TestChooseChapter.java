package com.kh.parkBBakBBak.view.academy.testRoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import com.kh.parkBBakBBak.view.academy.AcademyMain;
import com.kh.parkBBakBBak.view.academy.testRoom.ShowQuestPage.MyMouseAdapter;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class TestChooseChapter extends JPanel {
	private JFrame mf;
	private JPanel TestChooseChapter;
	private int buttonIndex;
	private Player p;
	private JButton goBack;
	private JTextArea noticeBattery;
	private boolean[] a = new boolean[10];

	public TestChooseChapter(JFrame mf,Player p) {
		this.p =p;
		this.mf = mf;
		this.TestChooseChapter = this;

		this.setLayout(null);
		this.setBounds(0, 0, 1194, 834);
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

		goBack = new JButton(new ImageIcon(new ImageIcon("images/backButton.png").getImage().getScaledInstance(60, 60, 0)));
		goBack.setBounds(1100, 15, 60, 60);
		goBack.setOpaque(false);
		goBack.setBorderPainted(false);
		goBack.setContentAreaFilled(false);
		goBack.addMouseListener(new MyMouseAdapter());
		this.add(goBack);

		Image background = new ImageIcon("images/classroom.png").getImage().getScaledInstance(1194, 834, 0);
		JLabel backgroundLb = new JLabel(new ImageIcon(background));
		backgroundLb.setBounds(0, 0, 1194, 834);

		Image blackBoard = new ImageIcon("images/blackBoardClean.png").getImage().getScaledInstance(1080, 625, 0);
		JLabel blackBoardLb = new JLabel(new ImageIcon(blackBoard));
		blackBoardLb.setLayout(null);
		blackBoardLb.setBounds(53, 115, 1080, 625);

		JTextArea chooseChapter = new JTextArea("시험 볼 챕터를 선택하세요.");
		chooseChapter.setOpaque(false);
		chooseChapter.setFont(new Font("맑은고딕", Font.BOLD, 25));
		chooseChapter.setForeground(Color.WHITE);
		chooseChapter.setBounds(400, 70, 300, 50);
		blackBoardLb.add(chooseChapter);

		Image smallChat = new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(954, 302, 0);
		JLabel smallChatLb = new JLabel(new ImageIcon(smallChat));
		smallChatLb.setLayout(null);
		smallChatLb.setBounds(110, 266, 954, 302);

		//이미 습득한 챕터인지 확인(플레이어 객체가 습득한 스킬 확인)
		a = p.getGetSkill();
		
		noticeBattery = new JTextArea();
		if(p.getHp() > 0) {
			noticeBattery.setText("시험을 시작합니다.\n배터리가 1 감소합니다.");
		} else if(p.getHp() <= 0) {
			noticeBattery.setText("배터리가 부족합니다.\n메인화면으로 돌아갑니다.");
		}

		
		noticeBattery.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		noticeBattery.setBounds(130, 100, 400, 200);
		noticeBattery.setOpaque(false);
		smallChatLb.add(noticeBattery);

		String[] chapter = {"0. 변수", "1. 연산자", "2. 제어문", "3. 배열", "4. 객체", "5. 상속", "6. 다형성", "7. API", "8. 예외처리", "9. 컬렉션"};

		ArrayList<JButton> chapterButton = new ArrayList<JButton>();

		for(int i = 0; i < chapter.length; i++) {
			//GUI
			chapterButton.add(new JButton(chapter[i]));
			chapterButton.get(i).setName(chapter[i]);
			chapterButton.get(i).setOpaque(false);
			chapterButton.get(i).setBorderPainted(false);
			chapterButton.get(i).setContentAreaFilled(false);
			chapterButton.get(i).setFocusPainted(true);
			chapterButton.get(i).setFont(new Font("맑은 고딕", Font.PLAIN, 25));
			chapterButton.get(i).setForeground(Color.WHITE);
			if(i < 5) {
				chapterButton.get(i).setBounds(200, 150 + (70 * i), 170, 50);
			} else if (i > 4) {
				chapterButton.get(i).setBounds(690, 140 + (70 * (i - 5)), 170, 50);
			}
			blackBoardLb.add(chapterButton.get(i));
		}

		this.add(blackBoardLb);
		this.add(smallChatLb);
		this.add(backgroundLb);
		mf.add(this);

		for(int i = 0; i < chapterButton.size(); i++) {
			chapterButton.get(i).addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					for(int i = 0; i <chapterButton.size(); i++) {
						if(e.getSource() == chapterButton.get(i)) {
							//buttonIndex 값 설정
							String temp = chapterButton.get(i).getName().charAt(0) + "";
							buttonIndex = Integer.parseInt(temp);
							
							if(a[buttonIndex] == true) {
								noticeBattery.setText("이미 습득한 챕터입니다.\n메인화면으로 돌아갑니다.");
							}

							TestChooseChapter.remove(blackBoardLb);
							TestChooseChapter.repaint();
							TestChooseChapter.addMouseListener(new MyMouseAdapter());
						}
						
					}

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == goBack || a[buttonIndex] == true) {
				ChangePanel.replacePanel(mf, TestChooseChapter,new AcademyMain(mf, p)); 
			} else {
				if(p.getHp() > 0) {
					p.setHp(p.getHp() - 1);
					ChangePanel.replacePanel(mf, TestChooseChapter,new ShowQuestPage(mf, p, buttonIndex)); 
				} else if(p.getHp() <= 0) {
					ChangePanel.replacePanel(mf, TestChooseChapter,new WorldPanel(mf, p)); 
				}
			}
		}
	}
}