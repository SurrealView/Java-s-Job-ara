package com.kh.parkBBakBBak.controller.interview;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.model.vo.Player;

public class InterviewManager {
	public final static String ADDRESS="images/";//이미지 파일 주소
	public static int pageNum;//몇 페이지인지 알려주는 변수
	public static int correctAnswer;//정답을 몇개 맞추었는지 알려주는 변수
	public static int countQuestion=1;//몇번 문제를 풀고있는지 알려주는 변수
	//public static int hidden= -1; //해외취업 개방시 사용
	public static boolean isCorrect;//정답을 맞췄는지 못맞췄는지 구분
	public static int WhatInterview;
	//public static boolean hiddenEnd=false; //히든엔딩 개방하는 키워드
	
	
	public static ArrayList<JButton> showQuest(ArrayList<JButton> buttonArr, String[] question,int fontsize) {

		for (int i = 0; i < question.length; i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("맑은 고딕", Font.PLAIN, fontsize));
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
