package com.kh.parkBBakBBak.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.academy.AcademyMain;
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

		
		mf.addKeyListener(new MyKeyListener());
		p.setAvatar(avatar);
		this.add(avatar);
		this.add(menuButton);
		this.add(Background);
//		this.setComponentZOrder(Background, 1);

	}

	/*
	 * public void bgmPlay() {
	 * 
	 * File bgm = new File("sounds/kkHouse.wav"); AudioInputStream stream;
	 * AudioFormat format; DataLine.Info info;
	 * 
	 * try { // 파일을 가져와서 AudioSystem을 통해 InputStream에 넣음 stream =
	 * AudioSystem.getAudioInputStream(bgm);
	 * 
	 * // 파일이 저장된 스트림에서 오디오 형식을 가져와 해당 오디오의 정보 오브젝트를 구축 format = stream.getFormat();
	 * info = new DataLine.Info(Clip.class, format);
	 * 
	 * // 오디오 정보 오브젝트의 정보를 읽음 clip = (Clip) AudioSystem.getLine(info);
	 * 
	 * // clip을 통해 음악파일을 불러옴 clip.open(stream);
	 * 
	 * // 음량조절 FloatControl gainControl = (FloatControl)
	 * clip.getControl(FloatControl.Type.MASTER_GAIN); gainControl.setValue(-20.0f);
	 * 
	 * 
	 * // clip실행 clip.start(); } catch (Exception e) { } }
	 * 
	 * // 스레드 : 배경음악 반복재생, 이동음 처리 public void run() {// 이동 시 음악 재생용 스레드 while (true)
	 * { try { // 배경음악이 끝까지 재생되면, 배경음악실행 메소드를 다시실행 if (clip.getFrameLength() ==
	 * clip.getFramePosition()) bgmPlay();
	 * 
	 * // 이동음 처리 // chk는 방향키를 눌렀을때 증가. // 이동음이 끝날때 감소
	 * 
	 * if (chk > 0) { movingSnd(sel); // 이동음을 상세컨트롤(중복재생컨트롤) thread.notify(); //
	 * 재생횟수 0 이상일 시 재생 시작 if (chk > 10) chk = 10; // 이동음 재생횟수 많을 시 제한. } else {
	 * thread.wait(); // 재생 횟수 0 일때 재생 중지 }
	 * 
	 * } catch (Exception e) { } } }
	 * 
	 */
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
//								MaybeAcademyPanel academy = new MaybeAcademyPanel(mf);
//								ChangePanel.replacePanel(mf,panel,academy);

				}
			// 카페
			if (avatar.getX() >= 355 && avatar.getX() <= 370)
				if (avatar.getY() >= 100 && avatar.getY() <= 100) {
//								System.out.println("출력");
//					p.setAvatar(avatar);
					avatar.setLocation(1500, 1500);
					BackgroundPanel cafe = new BackgroundPanel(mf, p);
					ChangePanel.replacePanel(mf, panel, cafe);

//					panel.setSize(0, 0);
//					ChangePanel.replacePanel(mf, panel, 1, p);

				}
			// 역
			if (avatar.getX() >= 820 && avatar.getX() <= 830)
				if (avatar.getY() >= 550 && avatar.getY() <= 550) {
//								System.out.println("출력");
					avatar.setLocation(avatar.getX(), avatar.getY() + 100);
//					p.setAvatar(avatar);
					avatar.setLocation(1500, 1500);
					HomePanel home = new HomePanel(mf, p);
					ChangePanel.replacePanel(mf, panel, home);
//					ChangePanel.worldToPlace(panel, cafe2);
				}
			// 인터뷰 장소
			if (avatar.getX() >= 850 && avatar.getX() <= 860)
				if (avatar.getY() >= 100 && avatar.getY() <= 100) {
					mf.remove(panel);
					mf.repaint();
//								System.out.println("출력");
					avatar.setLocation(avatar.getX(), avatar.getY() + 100);
					p.setAvatar(avatar);
					avatar.setLocation(1500, 1500);
					SelectInterview interview = new SelectInterview(mf, p);
					ChangePanel.replacePanel(mf, panel, interview);
//					ChangePanel.replacePanel(mf, panel, 2, p);
				}

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
