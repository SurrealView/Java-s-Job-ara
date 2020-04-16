package com.kh.parkBBakBBak.view.academy.testRoom;

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

import com.kh.parkBBakBBak.model.dao.TestRoomInputQuest;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.testRoom.TestChooseChapter.MyMouseAdapter;

public class TestResult extends JPanel {
	
	private JFrame mf;
	private JPanel TestResult;
	private Player p;
	private int buttonIndex;

	private TestRoomInputQuest tq = new TestRoomInputQuest();
	private ArrayList<String> answer;
	public static int answerCount;
	private String userSelectAnswer;
	private int index;
	private JButton goBack;
	
	public TestResult() {}
	
	public TestResult(JFrame mf, Player p, int buttonIndex, String userSelectAnswer, int index) {
		this.mf = mf;
		this.TestResult = this;
		this.p = p;
		this.userSelectAnswer = userSelectAnswer;
		this.buttonIndex = buttonIndex;
		this.index = index;
		
		this.answer = tq.getAnswer(); 
		
		System.out.println("시험결과페이지");
		System.out.println("buttonIndex : " + buttonIndex);
		System.out.println("userSelectAnswer : " + userSelectAnswer);
		System.out.println("index : " + index);
		System.out.println("answer : " + answer.get((buttonIndex * 5) + index));
		
		goBack = new JButton(new ImageIcon(new ImageIcon("images/backButton.png").getImage().getScaledInstance(60, 60, 0)));
		goBack.setBounds(1100, 15, 60, 60);
		goBack.setOpaque(false);
		goBack.setBorderPainted(false);
		goBack.setContentAreaFilled(false);
		goBack.addMouseListener(new MyMouseAdapter());
		this.add(goBack);
		
		Image background = new ImageIcon("Images/classRoom.png").getImage().getScaledInstance(1194, 834, 0);
		JLabel backgroundLb = new JLabel(new ImageIcon(background));
		backgroundLb.setLayout(null);
		backgroundLb.setBounds(0, 0, 1194, 834);
		
		Image chat = new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(820, 270, 0);
		JLabel chatLb = new JLabel(new ImageIcon(chat));
		chatLb.setLayout(null);
		chatLb.setBounds(180, 250, 820, 270);
		
		JTextArea resultArea = new JTextArea(100, 300);
		resultArea.setOpaque(false);
		resultArea.append("");
		resultArea.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		resultArea.setBounds(235, 370, 150, 30);
		resultArea.setEditable(false);
		
		if(userSelectAnswer.equals(answer.get((buttonIndex * 5) + index))) {
			resultArea.setText("정답입니다.");
			answerCount++;
			System.out.println("answerCount : " + answerCount);
		} else {
			resultArea.setText("오답입니다.");
		}
		
		this.add(resultArea);
		this.add(chatLb);
		this.add(backgroundLb);
		
		resultArea.addMouseListener(new MyMouseAdapter());
	}
	

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}


	class MyMouseAdapter extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ShowQuestPage.index +=1;
			if(ShowQuestPage.index < 5) {
				ChangePanel.replacePanel(mf, TestResult, new ShowQuestPage(mf, p, buttonIndex));
			} else if (ShowQuestPage.index == 5) {
				ChangePanel.replacePanel(mf, TestResult, new TestFinalResult(mf, p, answerCount, buttonIndex));
			} else if (e.getSource() == goBack) {
				ChangePanel.replacePanel(mf, TestResult,new BackButtonView(mf, p, buttonIndex, index)); 
			}
		}
	}
}
