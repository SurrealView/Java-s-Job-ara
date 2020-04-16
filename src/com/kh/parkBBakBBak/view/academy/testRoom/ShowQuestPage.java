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
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.dao.TestRoomInputQuest;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.testRoom.TestMainPage.MyMouseAdapter;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class ShowQuestPage extends JPanel{

	private JFrame mf;
	private JPanel ShowQuestPage;
	private Player p;
	private int buttonIndex;

	private String userSelectAnswer;

	public static int index;
	private JButton example1;
	private JButton example2;
	private JButton example3;
	private JButton goBack;

	private TestRoomInputQuest tq = new TestRoomInputQuest();
	private ArrayList<String> quest;
	private ArrayList<String> example;

	public ShowQuestPage() {}

	public ShowQuestPage(JFrame mf, Player p, int buttonIndex) {
		this.p=p;
		this.mf = mf;
		this.ShowQuestPage = this;
		this.buttonIndex = buttonIndex;

		this.quest = tq.getQuest();
		this.example = tq.getExample();

		this.setLayout(null);
		this.setBounds(0, 0, 1194, 834);

		System.out.println("TestPage buttonIndex : " + buttonIndex);

		goBack = new JButton(new ImageIcon(new ImageIcon("images/backButton.png").getImage().getScaledInstance(60, 60, 0)));
		goBack.setBounds(1100, 15, 60, 60);
		goBack.setOpaque(false);
		goBack.setBorderPainted(false);
		goBack.setContentAreaFilled(false);
		goBack.addMouseListener(new MyMouseAdapter());
		this.add(goBack);

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
		
		Image background = new ImageIcon("images/classroom.png").getImage().getScaledInstance(1194, 834, 0);
		JLabel backgroundLb = new JLabel(new ImageIcon(background));
		backgroundLb.setLayout(null);
		backgroundLb.setBounds(0, 0, 1194, 834);

		Image blurBlackBoard = new ImageIcon("images/blackBoardDim.png").getImage().getScaledInstance(1194, 691, 0);
		JLabel blurBlackBoardLb = new JLabel(new ImageIcon(blurBlackBoard));
		blurBlackBoardLb.setLayout(null);
		blurBlackBoardLb.setBounds(0, 80, 1194, 691);

		String[] chapter = {"0. º¯¼ö", "1. ¿¬»êÀÚ", "2. Á¦¾î¹®", "3. ¹è¿­", "4. °´Ã¼", "5. »ó¼Ó", "6. ´ÙÇü¼º", "7. API", "8. ¿¹¿ÜÃ³¸®", "9. ÄÃ·º¼Ç"};

		//Ã©ÅÍ¸í Ãâ·Â
		JTextArea chapterName = new JTextArea();
		chapterName.setEditable(false);
		//buttonIndex¿¡ µû¶ó Ã©ÅÍ ÀÌ¸§ Ç¥½Ã
		for(int i = 0; i < chapter.length; i++) {
			if(buttonIndex == i) {
				chapterName.setText(chapter[i]);
			}
		}
		chapterName.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
		chapterName.setForeground(Color.WHITE);
		chapterName.setBounds(130, 100, 400, 50);
		chapterName.setOpaque(false);
		blurBlackBoardLb.add(chapterName);

		//¹®Á¦Ãâ·Â
		JTextArea questArea = new JTextArea();
		questArea.setEditable(false);
		questArea.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		questArea.setForeground(Color.WHITE);
		questArea.setBounds(130, 170, 1000, 50);
		questArea.setOpaque(false);
		if(buttonIndex * 5 == 45 && index > 4) {
			questArea.setText((index + 1)+ ". " + quest.get(49));
		} else {
			questArea.setText((index + 1)+ ". " + quest.get(buttonIndex * 5 + index));
		}

		blurBlackBoardLb.add(questArea);

		//º¸±âÃâ·Â
		example1 = new JButton();
		example1.setBounds(130, 250, 1000, 50);
		example1.setOpaque(false);
		example1.setBorderPainted(false);
		example1.setContentAreaFilled(false);
		example1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		example1.setForeground(Color.WHITE);
		if(buttonIndex * 15 == 135 && index > 4) {
			example1.setText(example.get(147));
		} else {
			example1.setText(example.get((buttonIndex * 15) + (index * 3)));
		}
		example1.setHorizontalAlignment(SwingConstants.LEFT);
		blurBlackBoardLb.add(example1);
		example1.addMouseListener(new MyMouseAdapter());

		example2 = new JButton();
		example2.setBounds(130, 320, 1000, 50);
		example2.setOpaque(false);
		example2.setBorderPainted(false);
		example2.setContentAreaFilled(false);
		example2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		example2.setForeground(Color.WHITE);
		
		if(buttonIndex * 15 == 135 && index > 4) {
			example2.setText(example.get(148));
		} else {
			example2.setText(example.get((buttonIndex * 15) + (index * 3) + 1));
		}
		example2.setHorizontalAlignment(SwingConstants.LEFT);
		blurBlackBoardLb.add(example2);
		example2.addMouseListener(new MyMouseAdapter());

		example3 = new JButton();
		example3.setBounds(130, 390, 1000, 50);
		example3.setOpaque(false);
		example3.setBorderPainted(false);
		example3.setContentAreaFilled(false);
		example3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		example3.setForeground(Color.WHITE);
		if(buttonIndex * 15 == 135 && index > 4) {
			example3.setText(example.get(149));
		} else {
			example3.setText(example.get((buttonIndex * 15) + (index * 3) + 2));
		}
		
		example3.setHorizontalAlignment(SwingConstants.LEFT);
		blurBlackBoardLb.add(example3);
		example3.addMouseListener(new MyMouseAdapter());




		this.add(blurBlackBoardLb);
		this.add(backgroundLb);
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == example1) {
				userSelectAnswer = "1";
				ChangePanel.replacePanel(mf, ShowQuestPage, new TestResult(mf,p, buttonIndex, userSelectAnswer, index));
			} else if (e.getSource() == example2) {
				userSelectAnswer = "2";
				ChangePanel.replacePanel(mf, ShowQuestPage, new TestResult(mf,p, buttonIndex, userSelectAnswer, index));
			} else if(e.getSource() == example3) {
				userSelectAnswer = "3";
				ChangePanel.replacePanel(mf, ShowQuestPage, new TestResult(mf,p, buttonIndex, userSelectAnswer, index));
			}

			if(e.getSource() == goBack) {
				ChangePanel.replacePanel(mf, ShowQuestPage, new BackButtonView(mf,p, buttonIndex, index));
			}
		}
	}

	

}

