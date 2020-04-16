package com.kh.parkBBakBBak.controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class LeejhMGManager {
	
	public Boolean checkAnswer(int num, int ranNum) {
		
		System.out.println("입력 받은 num :" + num);
		System.out.println("입력 받은 rannum :" + ranNum);
		
		Boolean answer;
		
		if(num == ranNum) {
			answer = true;
			System.out.println("num과 ranNum은 같다");
		} else {
			answer = false;
			System.out.println("num과 ranNum은 다르다.");
		}
		
		return answer;
	}

}
