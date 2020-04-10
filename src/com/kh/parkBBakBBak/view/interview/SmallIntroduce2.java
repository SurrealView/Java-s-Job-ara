package com.kh.parkBBakBBak.view.interview;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.WorldPanel;

public class SmallIntroduce2 extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Font font;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String[] question= new String[]{"지금부터 면접을 시작할 걸세","배터리가 2 감소할거야","준비가 되면 말을 걸어주시게"};
	private int index;
	
	
	public SmallIntroduce2(JFrame mf) {
		System.out.println("smallIntroduce2 입장");
		this.mf=mf;
		this.panel=this;
		this.setLayout(null);
		this.setSize(1194,834);
		
		JLabel smallCoffee = addJLabelImage(new JLabel(), "coffeeSmall.png", 17, 24);
		smallCoffee.setLocation(140, 15);
		
		
		JLabel couponQty = new JLabel(" X " + 3);
		couponQty.setFont(font = new Font("맑은 고딕", font.PLAIN, 24));
		couponQty.setSize(50, 40);
		couponQty.setLocation(160, 8);
		
	
		
		JLabel txtArea = addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);
		
	
		
		JLabel gwak = addJLabelImage(new JLabel(), "gwakTheIronDragon.png", 314, 200);
		gwak.setLocation(222, 310);
		
		JLabel batteryCase = addJLabelImage(new JLabel(), "batteryCase.png", 111, 44);
		batteryCase.setLocation(10, 5);
		String[] remainBattery = new String[] { "Battery1.png", "Battery2.png", "Battery3.png", "Battery4.png",
				"Battery5.png" };

		ArrayList<Image> batteryImage = new ArrayList<Image>();
		for (int i = 0; i < remainBattery.length; i++) {
			batteryImage.add(new ImageIcon(SelectInterview.ADDRESS + remainBattery[i]).getImage().getScaledInstance(111, 44, 0));
		}

		ArrayList<JLabel> batteryLabels = new ArrayList<JLabel>();

		for (int i = 0; i < 5; i++) {
			batteryLabels.add(new JLabel(new ImageIcon(batteryImage.get(i))));
			batteryLabels.get(i).setSize(111, 44);
			batteryLabels.get(i).setLocation(10, 5);
			
		}
		for(int i=0; i<5; i++) {
			this.add(batteryLabels.get(i));
		}
		this.add(batteryCase);

		
		
		
		
		
	
		JButton backButton = addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1020, 15);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("돌아갈래");
				
				ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf));
				//ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf));
				
			}
		});
		
		JButton menuButton = addJButtonImage(new JButton(), "menuButton.png", 60, 60);
		menuButton.setLocation(1100, 15);
		menuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				System.out.println("메뉴보기");
				
			}
		});
	
		JLabel backGround = addJLabelImage(new JLabel(), "interview.png", 1194, 834);
		backGround.setLocation(0, 0);
	
	
		buttonArr=showQuest(buttonArr,question);
		for(int i=0; i<buttonArr.size(); i++) {
			index=i;
		this.add(buttonArr.get(i));
		}
		
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("다음화면");
				ChangePanel.replacePanel(mf, panel, new DropQuestion(mf));
				
			}
		});
	
		
		
	
	
	
		this.add(smallCoffee);
		this.add(couponQty);
		this.add(txtArea);
		this.add(gwak);
		this.add(backButton);
		this.add(menuButton);
		this.add(backGround);
	
	
	}
	

	public JLabel addJLabelImage(JLabel label, String path, int x, int y) {

		Image image = new ImageIcon(SelectInterview.ADDRESS + path).getImage().getScaledInstance(x, y, 0);
		label = new JLabel(new ImageIcon(image));
		label.setSize(x, y);

		return label;
	}

	public JButton addJButtonImage(JButton button, String path, int x, int y) {

		Image image = new ImageIcon(SelectInterview.ADDRESS + path).getImage().getScaledInstance(x, y, 0);
		button = new JButton(new ImageIcon(image));
		button.setSize(x, y);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);

		return button;
	}
	
	public  ArrayList<JButton> showQuest(ArrayList<JButton> buttonArr, String[] question) {

		for (int i = 0; i < question.length; i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("맑은 고딕", font.PLAIN, 26));
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
