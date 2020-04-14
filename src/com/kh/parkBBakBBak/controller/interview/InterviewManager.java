package com.kh.parkBBakBBak.controller.interview;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.model.vo.Player;

public class InterviewManager {
	public final static String ADDRESS="images/";//�̹��� ���� �ּ�
	public static int pageNum;//�� ���������� �˷��ִ� ����
	public static int correctAnswer;//������ � ���߾����� �˷��ִ� ����
	public static int countQuestion=1;//��� ������ Ǯ���ִ��� �˷��ִ� ����
	//public static int hidden= -1; //�ؿ���� ����� ���
	public static boolean isCorrect;//������ ������� ��������� ����
	public static int WhatInterview;
	//public static boolean hiddenEnd=false; //���翣�� �����ϴ� Ű����
	
	
	public static ArrayList<JButton> showQuest(ArrayList<JButton> buttonArr, String[] question,int fontsize) {

		for (int i = 0; i < question.length; i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("���� ���", Font.PLAIN, fontsize));
			buttonArr.get(i).setSize(700, 40);
			buttonArr.get(i).setLocation(225, 550 + (60 * i));
			buttonArr.get(i).setBorderPainted(false);
			buttonArr.get(i).setContentAreaFilled(false);
			buttonArr.get(i).setFocusPainted(false);
			buttonArr.get(i).setHorizontalAlignment(SwingConstants.LEFT);

		}
		return buttonArr;
	}
}
