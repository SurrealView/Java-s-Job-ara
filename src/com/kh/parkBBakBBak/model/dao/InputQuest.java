package com.kh.parkBBakBBak.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputQuest {

	private String quiz;
	private String[][] samples = new String[50][3];
	private int answers;
	private String[] sample = new String[3];
	private ArrayList<String> lectureArr = new ArrayList<String>();

	public InputQuest(String name1, String name2, String name3) {

		ArrayList<String> questArr = new ArrayList<String>();
		ArrayList<String> bogiArr = new ArrayList<String>();
		ArrayList<String> answerArr = new ArrayList<String>();

		int rand = (int) (Math.random() * 50);

		FileReader quest = null;
		FileReader bogi = null;
		FileReader answer = null;

		try {
//			quest = new FileReader("text/�����幮��.txt");
//			bogi = new FileReader("text/������ ���� �� ��.txt");
//			answer = new FileReader("text/������ ��.txt");
			quest = new FileReader("text/" + name1 + ".txt");
			bogi = new FileReader("text/" + name2 + ".txt");
			answer = new FileReader("text/" + name3 + ".txt");

			String str = "";
			int value;

			while ((value = quest.read()) != -1) {

				char spell = (char) value;

				str += spell;

			}

			StringTokenizer token = new StringTokenizer(str, "$");

			int count = token.countTokens();

			for (int i = 0; i < count; i++) {

				questArr.add(token.nextToken());

			}

			quiz = questArr.get(rand);

			// ���� ���

			str = "";
			int value2;
			while ((value2 = bogi.read()) != -1) {

				char spell = (char) value2;

				str += spell;

			}

			token = new StringTokenizer(str, "$");

			count = token.countTokens();

			System.out.println("���� ������");

			for (int i = 0; i < count; i++) {

				bogiArr.add(token.nextToken());

			}

			for (int i = 0; i < bogiArr.size(); i++) {
				token = new StringTokenizer(bogiArr.get(i), "^");

				for (int j = 0; j < samples[i].length; j++) {

					samples[i][j] = token.nextToken();

				}
			}
			for (int i = 0; i < sample.length; i++) {
				sample[i] = samples[rand][i];

			}
			// ���� ���

			str = "";

			int value3;
			while ((value3 = answer.read()) != -1) {

				char spell = (char) value3;

				str += spell;

			}

			token = new StringTokenizer(str, "$");

			count = token.countTokens();

			for (int i = 0; i < count; i++) {

				answerArr.add(token.nextToken());

			}
			answers = Integer.parseInt(answerArr.get(rand));

		} catch (FileNotFoundException e) {
			System.out.println("������ �����");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (quest != null) {
					quest.close();
				}
				if (bogi != null) {
					bogi.close();
				}
				if (answer != null) {
					answer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// ������ �뵵
	public InputQuest(String name) {

		FileReader lecture = null;

		try {
			lecture = new FileReader("text/" + name + ".txt");

			String str = "";
			int value;

			while ((value = lecture.read()) != -1) {

				char spell = (char) value;

				str += spell;

			}

			StringTokenizer token = new StringTokenizer(str, "^");

			int count = token.countTokens();

			System.out.println(count);

			for (int i = 0; i < count; i++) {

				lectureArr.add(token.nextToken());

			}
		} catch (FileNotFoundException e) {
			System.out.println("������ �����");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (lecture != null) {
					lecture.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public String getQuiz() {
		return quiz;
	}

	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}

	public String[][] getSamples() {
		return samples;
	}

	public void setSamples(String[][] samples) {
		this.samples = samples;
	}

	public int getAnswers() {
		return answers;
	}

	public void setAnswers(int answers) {
		this.answers = answers;
	}

	public String[] getSample() {
		return sample;
	}

	public void setSample(String[] sample) {
		this.sample = sample;
	}

	public ArrayList<String> getLectureArr() {
		return lectureArr;
	}

	public void setLectureArr(ArrayList<String> lectureArr) {
		this.lectureArr = lectureArr;
	}

}
