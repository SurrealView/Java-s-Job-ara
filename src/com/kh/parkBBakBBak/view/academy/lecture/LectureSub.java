package com.kh.parkBBakBBak.view.academy.lecture;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class LectureSub extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Player p;
	private ArrayList<JButton> list = new ArrayList<>();


	public LectureSub(JFrame mf,Player p) {
		this.mf =mf;
		panel = this;
		this.p=p;
		this.setLayout(null);
		this.setSize(1194, 834);
		this.setLocation(0, 0);



		JTextArea ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta);
	//	ta.setCaretPosition(ta.getDocument().getLength());
	//	mf.setLocationRelativeTo(null);
		sp.setBounds(182, 257, 824, 340);
	//	sp.setPreferredSize(new Dimension(1000, 1000));
		sp.setVerticalScrollBarPolicy(sp.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(sp.HORIZONTAL_SCROLLBAR_ALWAYS);
		mf.add(sp);
		mf.getContentPane().add(sp);
		this.add(sp);
		this.add(ta);
		sp.setViewportView(ta);
		ta.setCaretPosition(ta.getDocument().getLength());
		ta.setSize(824, 340);
		ta.setLocation(182, 257);
		ta.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		ta.setForeground(Color.WHITE);
		ta.setBackground(new Color(45,86,26,255));
		ta.setWrapStyleWord(true);
		ta.setLineWrap(true);
		ta.setCaretPosition(ta.getDocument().getLength());
		



		try(BufferedReader br = new BufferedReader(new FileReader("text/ÀÚ¹Ù³»¿ë Á¤¸®.txt"));) {

			String lecture;
			StringBuilder sb = new StringBuilder("");
			ArrayList<Character> as = new ArrayList<Character>();
			//³»¿ë ³ª´©±â
			
			while((lecture = br.readLine()) != null) {
				sb.append(lecture);

			}
			
			lecture = sb.substring(0);
			

			StringTokenizer st = new StringTokenizer(lecture, "^");
			System.out.println("st ¼ýÀÚ : " + st.countTokens());
			String[] first = new String[st.countTokens()];
			System.out.println("Á¦´ë·Î ²÷°å´Ï? : " + first.length);
			for(int i=0; i<first.length; i++) {
				first[i]=st.nextToken();
			}
//			first[LectureMain.buttonIndex] = new String(st.nextToken());
			System.out.println(first[0]);
			
			StringTokenizer line = new StringTokenizer(first[LectureMain.buttonIndex], "#");
			System.out.println("line ¼ýÀÚ : " + line.countTokens());
			String[] variable = new String[line.countTokens()];
			System.out.println("º¯¼ö ²÷°å´Ï? : " + variable.length);
			for(int i = 0; i < variable.length; i++) {
				variable[i] = new String(line.nextToken());
				System.out.println("Â¥ÀÜ!" + variable[i]);
				ta.append(variable[i] + "\n");
			}
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

		setVisible(true);

		//Ã©ÅÍ¸í
		JButton chapter1 = new JButton(LectureMain.name[LectureMain.buttonIndex]);
		chapter1.setSize(908, 56);
		chapter1.setLocation(143, 157);
		chapter1.setBackground(new Color(45,86,26,255));
		chapter1.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 24));
		chapter1.setForeground(Color.WHITE);
		chapter1.setBorderPainted(false);
		chapter1.setFocusPainted(false);
		this.add(chapter1);

		
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
	       
	       for(int i = 0; i < p.getHp(); i++) {
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
		//µÚ·Î°¡±â ÀÌ¹ÌÁö
		Image iconBack = new ImageIcon("images/backButton.PNG").getImage().getScaledInstance(60, 60, 0);
		JButton buttonBack = new JButton(new ImageIcon(iconBack));
		buttonBack.setSize(60, 60);
		buttonBack.setLocation(1100,15);
		this.add(buttonBack);
		buttonBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, panel, new LectureMain(mf,p));

			}});

		//Ä¥ÆÇ
		Image icon2 = new ImageIcon("images/blackBoardClean.PNG").getImage().getScaledInstance(1080, 625, 0);
		JLabel label2 = new JLabel(new ImageIcon(icon2));
		label2.setSize(1080,625);
		label2.setLocation(57,110);
		this.add(label2);


		//¹è°æÈ­¸é
		Image icon = new ImageIcon("images/classRoom.PNG").getImage().getScaledInstance(1194, 834, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setSize(1194,834);
		label.setLocation(0, 0);
		this.add(label);


		this.setVisible(true);



	}
}
