package com.kh.parkBBakBBak.view.animalcrossingmini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

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
import com.kh.parkBBakBBak.view.WorldPanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class BasePanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	private int chatIndex = 0;
	private Clip bgm;
//	private JLabel beforeMoo;
//	private Icon moo, allBlack;
	private String[] chat = new String[] { "�̾��ϴٱ��� �̰� �����ַ��� �г� �߰��� �־��ٱ���", "�� �� ���� ��ȭ�ı���", "��¥ ������ ���� �����̴ٱ���...." };

	public BasePanel(JFrame mf, Player p) {
		this.mf = mf;
		panel = this;
		this.p = p;

		// ���
		MenuPanel.mainBgm.stop();
		AudioInputStream audioInputStream;
		File file;
		try {
			file = new File("sounds/K.K.Idol.wav");
			audioInputStream = AudioSystem.getAudioInputStream(file);
			bgm = AudioSystem.getClip();
			bgm.open(audioInputStream);
			bgm.loop(bgm.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

		this.setLayout(null);
		this.setSize(1194, 834);

		// ���ȭ��
		this.setBackground(Color.black);
		JLabel realBackground = new JLabel(
				new ImageIcon(new ImageIcon("images/AnimalCrossingBg.png").getImage().getScaledInstance(500, 500, 0)));
		realBackground.setSize(500, 500);
		realBackground.setLocation(347, 167);

		// �ڷΰ��� ��ư
		JButton backButton = SelectInterview.addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1100, 15);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, panel, new WorldPanel(mf, p));
			}
		});

		// �ؽ�Ʈ ǳ��
		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "Balloon Resize.png", 436, 135);
		txtArea.setSize(436, 135);
		txtArea.setLocation(385, 530);

		// �ʱ�
		JLabel nook = new JLabel(
				new ImageIcon(new ImageIcon("images/Tom Nook Resize.png").getImage().getScaledInstance(72, 119, 0)));
		nook.setSize(72, 119);
		nook.setLocation(420, 380);

		// ��ǳ��
		JTextArea ment = new JTextArea(chat[0]);
		ment.setSize(370, 80);
		ment.setLocation(410, 570);
		ment.setFont(new Font("���� ����", Font.PLAIN, 12));
		ment.setBackground(new Color(255, 250, 228));
		this.add(ment);

		// �� ����
		JLabel beforeMoo = new JLabel();
//				new ImageIcon(new ImageIcon("images/allBlack.png").getImage().getScaledInstance(237, 223, 0)));
		beforeMoo.setSize(237, 223);
		beforeMoo.setLocation(100, 300);
		Icon moo = new ImageIcon(new ImageIcon("images/moo.png").getImage().getScaledInstance(237, 233, 0));
		Icon allBlack = new ImageIcon(new ImageIcon("images/allBlack.png").getImage().getScaledInstance(237, 233, 0));

		// ��ǳ���̳� ��� Ŭ���� �� ���
		ment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ��ǳ���� ���� ��� ó��
				if (chatIndex < chat.length) {
					ment.setText(chat[chatIndex]);
				} else if (chatIndex == chat.length) {
					ChangePanel.replacePanel(mf, panel, new WorldPanel(mf, p));
					bgm.stop();
				}
				chatIndex++;
			}
		});

		realBackground.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chatIndex < chat.length) {
					ment.setText(chat[chatIndex]);
					if(chatIndex == 1)
						beforeMoo.setIcon(moo);
					else if(chatIndex > 1)
						beforeMoo.setIcon(allBlack);
				} else if (chatIndex == chat.length) {
					ChangePanel.replacePanel(mf, panel, new WorldPanel(mf, p));
					bgm.stop();
				}
				chatIndex++;
			}
		});
		
		this.add(beforeMoo);
		this.add(txtArea);
		this.add(backButton);
		this.add(nook);
		this.add(realBackground);

	}

}