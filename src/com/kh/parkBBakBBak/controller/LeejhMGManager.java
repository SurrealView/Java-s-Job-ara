package com.kh.parkBBakBBak.controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class LeejhMGManager {
	
	public Boolean checkAnswer(int num, int ranNum) {
		
		System.out.println("�Է� ���� num :" + num);
		System.out.println("�Է� ���� rannum :" + ranNum);
		
		Boolean answer;
		
		if(num == ranNum) {
			answer = true;
			System.out.println("num�� ranNum�� ����");
		} else {
			answer = false;
			System.out.println("num�� ranNum�� �ٸ���.");
		}
		
		return answer;
	}

}
