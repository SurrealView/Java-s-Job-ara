package com.kh.parkBBakBBak.model.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TestRoomInputQuest {
	
	private ArrayList<String> quest;
	private ArrayList<String> example;
	private ArrayList<String> answer;
	
	public TestRoomInputQuest() {
		
		BufferedReader brQuest = null;
		BufferedReader brexample = null;
		BufferedReader brAnswer = null;
		
		String temp1 = null;
		StringBuilder temp2 = new StringBuilder("");
		
		quest = new ArrayList<String>();
		example = new ArrayList<String>();
		answer = new ArrayList<String>();
		
		
		try {
			brQuest = new BufferedReader(new FileReader("text/시험장문제.txt"));
			brexample = new BufferedReader(new FileReader("text/시험장 보기 및 답.txt"));
			brAnswer = new BufferedReader(new FileReader("text/시험장 답.txt"));
			
			//읽어온 텍스트 파일을 StringBuilder로 저장
			while((temp1 = brQuest.readLine()) != null) {
				temp2.append(temp1);
			}
			
			//StringBuilder temp2를 String 타입으로 변환
			temp1 = temp2.substring(0);
			
			StringTokenizer questToken = new StringTokenizer(temp1, "$");
			
			//문제 ArrayList에 문자열 분리해서 저장
			for(int i = 0; questToken.hasMoreElements() != false; i++) {
				quest.add(questToken.nextToken());
			}
			
			//보기 ArrayList에 담기
			
			//StringBuilder 임시변수 초기화
			temp1 = null;
			temp2.setLength(0);
			
			while((temp1 = brexample.readLine()) != null) {
				temp2.append(temp1);
			}
			
			temp1 = temp2.substring(0);
			
			StringTokenizer exampleToken = new StringTokenizer(temp1, "$^");
			
			for(int i = 0; exampleToken.hasMoreElements() != false; i++) {
				example.add(exampleToken.nextToken());
			}
			
			//답 ArrayList에 담기
			temp1 = null;
			temp2.setLength(0);
			
			while((temp1 = brAnswer.readLine()) != null) {
				temp2.append(temp1);
			}
			
			temp1 = temp2.substring(0);
			
			StringTokenizer answerToken = new StringTokenizer(temp1, "$");
			
			for(int i = 0; answerToken.hasMoreElements() != false; i++) {
				answer.add(answerToken.nextToken());
			}
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getQuest() {
		return quest;
	}

	public ArrayList<String> getExample() {
		return example;
	}

	public ArrayList<String> getAnswer() {
		return answer;
	}



	

}
