package com.kh.parkBBakBBak.view.animalcrossingmini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

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
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.MenuPanel;
import com.kh.parkBBakBBak.view.home.HomePanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class BasePanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Player p;
	private int chatIndex = 0;
	public static Clip bgm;
	private String[] chat = new String[] { "미안하다구리 이거 보여주려고 패널 추가로 넣었다구리", "무 값 변동 실화냐구리", "진짜 동물의 숲은 전설이다구리....",
			"게임을 하고 싶다면 말을 다시 한번 말을 걸어줘 구리" };
	private String[] gameChat = new String[] { "간단한 게임이야구리", "5초 안에 나를 12번 터치하면 빡빡님의 승리야구리",
			"불이익 같은 건 없으니까 안심하고 즐기면 돼구리", "이제 게임 시작한다구리" };
	private JLabel nook;
	public static int count = 0;
	public static int first = 0;

	public BasePanel(JFrame mf, Player p) {
		this.mf = mf;
		panel = this;
		this.p = p;

		// 브금
		MenuPanel.mainBgm.stop();
		AudioInputStream audioInputStream;
		File file;
		try {
			file = new File("sounds/K.K.Idol.wav");
			audioInputStream = AudioSystem.getAudioInputStream(file);
			bgm = AudioSystem.getClip();
			bgm.open(audioInputStream);
			bgm.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

		this.setLayout(null);
		this.setSize(1194, 834);

		// 배경화면
		this.setBackground(Color.black);
		JLabel realBackground = new JLabel(
				new ImageIcon(new ImageIcon("images/AnimalCrossingBg.png").getImage().getScaledInstance(500, 500, 0)));
		realBackground.setSize(500, 500);
		realBackground.setLocation(347, 167);

		// 뒤로가기 버튼
		JButton backButton = SelectInterview.addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1100, 15);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bgm.stop();
				ChangePanel.replacePanel(mf, panel, new HomePanel(mf, p));
			}
		});

		// 텍스트 풍선
		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "Balloon Resize.png", 436, 135);
		txtArea.setSize(436, 135);
		txtArea.setLocation(385, 530);

		// 너굴
		nook = new JLabel(
				new ImageIcon(new ImageIcon("images/Tom Nook Resize.png").getImage().getScaledInstance(72, 119, 0)));
		nook.setSize(72, 119);
		nook.setLocation(420, 380);

		// 무 가격
		JLabel beforeMoo = new JLabel();
		beforeMoo.setSize(237, 223);
		beforeMoo.setLocation(100, 300);
		Icon moo = new ImageIcon(new ImageIcon("images/moo.png").getImage().getScaledInstance(237, 233, 0));
		Icon allBlack = new ImageIcon(new ImageIcon("images/allBlack.png").getImage().getScaledInstance(237, 233, 0));

		// 말풍선
		JTextArea ment;
		if (first == 0)
			ment = new JTextArea(chat[0]);
		else
			ment = new JTextArea(gameChat[0]);
		ment.setEditable(false);
		ment.setSize(370, 80);
		ment.setLocation(410, 570);
		ment.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		ment.setBackground(new Color(255, 250, 228));
		this.add(ment);

		// 말풍선이나 배경 클릭시 말 출력
		ment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 처음에 입장시 보여줌
				if (first == 0) {
					if (chatIndex < chat.length) {
						ment.setText(chat[chatIndex]);
						if (chatIndex == 1)
							beforeMoo.setIcon(moo);
						else if (chatIndex > 1)
							beforeMoo.setIcon(allBlack);
					} else if (chatIndex == chat.length) {
						bgm.stop();
						first++;
						ChangePanel.replacePanel(mf, panel, new HomePanel(mf, p));
					}
					chatIndex++;
					// 두번째 입장부터 게임 설명
				} else {
					if (chatIndex < chat.length) {
						ment.setText(gameChat[chatIndex]);
					} else if (chatIndex == chat.length) {
//						bgm.stop();
//						ChangePanel.replacePanel(mf, panel, new HomePanel(mf, p));
						txtArea.setSize(0, 0);
						ment.setSize(0, 0);
						ACTimer timer = new ACTimer(mf, panel, p);
						Thread time = timer;
						time.setDaemon(true);
						time.start();
						nook.addMouseListener(new MyMouseListener());
					}
					chatIndex++;
				}
			}
		});

		this.add(beforeMoo);
		this.add(txtArea);
		this.add(backButton);
		this.add(nook);
		this.add(realBackground);

	}

	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			int x = (int) (Math.random() * 428) + 347;
			int y = (int) (Math.random() * 381) + 167;
			count += 1;
			System.out.println("count : " + count);
			nook.setLocation(x, y);

		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}

}
