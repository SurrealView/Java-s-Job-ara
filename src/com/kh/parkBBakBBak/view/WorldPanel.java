package com.kh.parkBBakBBak.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.academy.AcademyMain;
import com.kh.parkBBakBBak.view.animalcrossingmini.BasePanel;
import com.kh.parkBBakBBak.view.area.AreaBlock;
import com.kh.parkBBakBBak.view.cafe.BackgroundPanel;
import com.kh.parkBBakBBak.view.home.HomePanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;
import com.kh.parkBBakBBak.view.settings.SettingPanel;

public class WorldPanel extends JPanel {

	private JFrame mf;
	private JPanel panel;
	private JLabel avatar;
	private Icon moveFront;
	private Icon moveBack;
	private Icon moveLeft;
	private Icon moveRight;
	private Icon standFront;
	private Icon standBack;
	private Icon standLeft;
	private Icon standRight;
	private int charCnt = 0;
	private Player p;
	
	public static Clip cafeBgm;

	public WorldPanel(JFrame mf, Player p) {

		this.p = p;
		this.mf = mf;
		panel = this;
		this.setLayout(null);

		MenuPanel.mainBgm.start(); // 게임 시작 후 재생
		MenuPanel.mainBgm.loop(Clip.LOOP_CONTINUOUSLY);
		
		

		avatar = new JLabel(
				new ImageIcon(new ImageIcon("images/standFront.png").getImage().getScaledInstance(52, 152, 0)));
		avatar.setLocation(500, 380);
		avatar.setSize(52, 152);

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
	       couponQty.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
	       couponQty.setForeground(Color.WHITE);
	       couponQty.setSize(50, 40);
	       couponQty.setLocation(220, 40);
	      this.add(couponQty);
	      
	      JLabel dayWeekDay = new JLabel(p.getDay() + "일차" + " / " + p.getWeekDay() + "요일");
	      dayWeekDay.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
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

		JLabel Background = new JLabel(
				new ImageIcon(new ImageIcon("images/streetMap.png").getImage().getScaledInstance(1194, 834, 0)));
		Background.setLocation(0, 0);
		Background.setSize(1194, 834);

		moveFront = new ImageIcon(new ImageIcon("images/moveFront.gif").getImage().getScaledInstance(52, 152, 0));
		moveBack = new ImageIcon(new ImageIcon("images/moveBack.gif").getImage().getScaledInstance(52, 152, 0));
		moveLeft = new ImageIcon(new ImageIcon("images/moveLeft.gif").getImage().getScaledInstance(52, 152, 0));
		moveRight = new ImageIcon(new ImageIcon("images/moveRight.gif").getImage().getScaledInstance(52, 152, 0));
		standFront = new ImageIcon(new ImageIcon("images/standFront.png").getImage().getScaledInstance(52, 152, 0));
		standBack = new ImageIcon(new ImageIcon("images/standBack.png").getImage().getScaledInstance(52, 152, 0));
		standLeft = new ImageIcon(new ImageIcon("images/standLeft.png").getImage().getScaledInstance(52, 152, 0));
		standRight = new ImageIcon(new ImageIcon("images/standRight.png").getImage().getScaledInstance(52, 152, 0));

		mf.setFocusable(true); // 키보드리스너가 작동하도록 focus를 이쪽으로 on

		JButton menuButton = SelectInterview.addJButtonImage(new JButton(), "menuButton.png", 60, 60);
		menuButton.setLocation(1100, 15);
		menuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				avatar.setLocation(1500, 1500);
				SettingPanel setting = new SettingPanel(mf, p);
				ChangePanel.replacePanel(mf, panel, setting);
			}
		});

	     
	   //카페 bgm   
	   AudioInputStream audioInputStream;
	   File file;
	   try {
	      file = new File("sounds/Lounge Lizard.wav");
	      audioInputStream = AudioSystem.getAudioInputStream(file);
	      cafeBgm = AudioSystem.getClip();
	      cafeBgm.open(audioInputStream);
	   } catch (UnsupportedAudioFileException | IOException e) {
	      e.printStackTrace();
	   } catch (LineUnavailableException e) {
	      e.printStackTrace();
	   }
	   
		
		
		mf.addKeyListener(new MyKeyListener());
		p.setAvatar(avatar);
		this.add(avatar);
		this.add(menuButton);
		this.add(Background);
//		this.setComponentZOrder(Background, 1);

	}

	class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			// com.kh.controller.keyboard 패키지의 갈수 없는 영역 관련 메소드
			AreaBlock block = new AreaBlock(avatar);
			block.areaBlock();

			// 각 패널 이동
			// KH학원
			if (avatar.getX() >= 280 && avatar.getX() <= 290)
				if (avatar.getY() >= 560 && avatar.getY() <= 560) {
//					p.setAvatar(avatar);
					avatar.setLocation(1500, 1500);
					ChangePanel.replacePanel(mf, panel, new AcademyMain(mf, p));

				}
			// 카페
			if (avatar.getX() >= 355 && avatar.getX() <= 370)
				if (avatar.getY() >= 100 && avatar.getY() <= 100) {
					avatar.setLocation(1500, 1500);

				    cafeBgm.start();
				    cafeBgm.loop(cafeBgm.LOOP_CONTINUOUSLY);
				    
					BackgroundPanel cafe = new BackgroundPanel(mf, p);
					ChangePanel.replacePanel(mf, panel, cafe);
				}
			
			// 역
			if (avatar.getX() >= 820 && avatar.getX() <= 830)
				if (avatar.getY() >= 550 && avatar.getY() <= 550) {
					avatar.setLocation(1500, 1500);
					HomePanel home = new HomePanel(mf, p);
					ChangePanel.replacePanel(mf, panel, home);
				}
			
			// 인터뷰 장소
			if (avatar.getX() >= 850 && avatar.getX() <= 860)
				if (avatar.getY() >= 100 && avatar.getY() <= 100) {
					/*
					mf.remove(panel);
					mf.repaint();
					*/
//					p.setAvatar(avatar);
					avatar.setLocation(1500, 1500);
					SelectInterview interview = new SelectInterview(mf, p);
					ChangePanel.replacePanel(mf, panel, interview);
				}
			
//			// 동물의숲
//			if (avatar.getX() >= 0 && avatar.getX() <= 65)
//				if (avatar.getY() == 0) {
//					avatar.setLocation(1500, 1500);
//					ChangePanel.replacePanel(mf, panel, new BasePanel(mf, p));
//				}
		

			// 테스트용 : 캐릭터의 맨 왼쪽 위 기준 x/y좌표
//			System.out.println("x : " + avatar.getX() + " | y : " + avatar.getY());

			switch (key) {
			case KeyEvent.VK_UP:
				avatar.setIcon(moveBack);// 이동모션으로 변경
				if (avatar.getY() <= 0)
					return;
				else
					avatar.setLocation(avatar.getX(), avatar.getY() - 5);
				break;
			case KeyEvent.VK_DOWN:
				avatar.setIcon(moveFront);
				// 이동모션으로 변경
				if (avatar.getY() + avatar.getHeight() + 5 > panel.getHeight())
					return;
				else
					avatar.setLocation(avatar.getX(), avatar.getY() + 5);
				break;
			case KeyEvent.VK_LEFT:
				avatar.setIcon(moveLeft); // 이동모션으로 변경
				if (avatar.getX() <= 0)
					return;
				else
					avatar.setLocation(avatar.getX() - 5, avatar.getY());
				break;
			case KeyEvent.VK_RIGHT:
				avatar.setIcon(moveRight); // 이동모션으로 변경
				if (avatar.getX() + avatar.getWidth() + 5 > panel.getWidth())
					return;
				else
					avatar.setLocation(avatar.getX() + 5, avatar.getY());
				break;

			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

			// 방향 바라보는 상태로 움직임 멈춤
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_UP:
				avatar.setIcon(standBack);
				break;
			case KeyEvent.VK_DOWN:
				avatar.setIcon(standFront);
				break;
			case KeyEvent.VK_LEFT:
				avatar.setIcon(standLeft);
				break;
			case KeyEvent.VK_RIGHT:
				avatar.setIcon(standRight);
				break;
			}
		}
	}
}
