package com.kh.parkBBakBBak.view.interview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.dao.InputQuest;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;

public class DropQuestion extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	//private ArrayList<JButton> buttonArr2 = new ArrayList<JButton>();
	private InputQuest qa = new InputQuest("시험장문제", "시험장 보기 및 답", "시험장 답");
	private InputQuest fqa = new InputQuest("영어시험장 문제", "영어시험장 보기&답", "시험장 답");
	private String[] question = new String[] { qa.getQuiz(), qa.getSample()[0], qa.getSample()[1], qa.getSample()[2] };
	private String[] fquestion = new String[] { fqa.getQuiz(), fqa.getSample()[0], fqa.getSample()[1],fqa.getSample()[2] };
	private int correct;
//	public static int countQuestion = 0;
//	public static int correctAnswer = 0;

	public DropQuestion(JFrame mf,Player p) {
		System.out.println(
				"DropQuestion" + InterviewManager.countQuestion + "입장" + "정답수 :" + InterviewManager.correctAnswer);
		this.mf = mf;
		this.panel = this;
		this.p=p;
		this.setLayout(null);
		this.setSize(1194, 834);
		InterviewManager.pageNum = 4;

		JLabel backGround = SelectInterview.addJLabelImage(new JLabel(), "javaConsole.png", 1194, 834);
		backGround.setLocation(0, 0);
		
		
		if (InterviewManager.WhatInterview == 3) {
			buttonArr = showQuest(buttonArr, fquestion);
			for (int i = 0; i < buttonArr.size(); i++) {

				this.add(buttonArr.get(i));
			}
		}
		else  {
			buttonArr = showQuest(buttonArr, question);
			for (int i = 0; i < buttonArr.size(); i++) {

				this.add(buttonArr.get(i));
			}
		}
		
		if (InterviewManager.WhatInterview == 3) {
			buttonArr.get(1).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					correct = 1;
					System.out.println("정답은:" + fqa.getAnswers());
					if (correct == fqa.getAnswers()) {
						System.out.println("너 정답");
						InterviewManager.correctAnswer++;
						InterviewManager.isCorrect = true;
					} else {
						InterviewManager.isCorrect = false;
					}
					ChangePanel.replacePanel(mf, panel, new CheckAnswer(mf,p));
				}
			});

			buttonArr.get(2).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					correct = 2;
					System.out.println("정답은:" + fqa.getAnswers());
					if (correct == fqa.getAnswers()) {
						System.out.println("너 정답");
						InterviewManager.correctAnswer++;
						InterviewManager.isCorrect = true;
					} else {
						InterviewManager.isCorrect = false;
					}
					ChangePanel.replacePanel(mf, panel, new CheckAnswer(mf,p));
				}
			});

			buttonArr.get(3).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					correct = 3;
					System.out.println("정답은:" + fqa.getAnswers());
					if (correct == fqa.getAnswers()) {
						System.out.println("너 정답");
						InterviewManager.correctAnswer++;
						InterviewManager.isCorrect = true;
					} else {
						InterviewManager.isCorrect = false;
					}
					ChangePanel.replacePanel(mf, panel, new CheckAnswer(mf,p));
				}
			});
		}
		else {

			buttonArr.get(1).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					correct = 1;
					System.out.println("정답은:" + qa.getAnswers());
					if (correct == qa.getAnswers()) {
						System.out.println("너 정답");
						InterviewManager.correctAnswer++;
						InterviewManager.isCorrect = true;
					} else {
						InterviewManager.isCorrect = false;
					}
					ChangePanel.replacePanel(mf, panel, new CheckAnswer(mf,p));
				}
			});

			buttonArr.get(2).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					correct = 2;
					System.out.println("정답은:" + qa.getAnswers());
					if (correct == qa.getAnswers()) {
						System.out.println("너 정답");
						InterviewManager.correctAnswer++;
						InterviewManager.isCorrect = true;
					} else {
						InterviewManager.isCorrect = false;
					}
					ChangePanel.replacePanel(mf, panel, new CheckAnswer(mf,p));
				}
			});

			buttonArr.get(3).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					correct = 3;
					System.out.println("정답은:" + qa.getAnswers());
					if (correct == qa.getAnswers()) {
						System.out.println("너 정답");
						InterviewManager.correctAnswer++;
						InterviewManager.isCorrect = true;
					} else {
						InterviewManager.isCorrect = false;
					}
					ChangePanel.replacePanel(mf, panel, new CheckAnswer(mf,p));
				}
			});
		}

		this.add(backGround);

	}



	public ArrayList<JButton> showQuest(ArrayList<JButton> buttonArr, String[] question) {

		for (int i = 0; i < question.length; i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("맑은 고딕", font.PLAIN, 18));
			buttonArr.get(i).setForeground(Color.WHITE);
			buttonArr.get(i).setSize(1000, 40);
			buttonArr.get(i).setLocation(100, 200 + (60 * i));
			buttonArr.get(i).setBorderPainted(false);
			buttonArr.get(i).setContentAreaFilled(false);
			buttonArr.get(i).setFocusPainted(false);
			buttonArr.get(i).setHorizontalAlignment(SwingConstants.LEFT);

		}
		return buttonArr;
	}

}
