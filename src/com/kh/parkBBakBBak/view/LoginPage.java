package com.kh.parkBBakBBak.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.parkBBakBBak.model.vo.Player;

public class LoginPage extends JPanel {
	
	private JFrame mf;
	private JPanel panel;
	
	public LoginPage(JFrame mf) {
		
		this.mf = mf;
		panel = this;
		
		this.setLayout(null);
//		this.setSize(1194,834); ChangePanel에서 실행됨
//		this.setLocation(0,0);
		
//		ArrayList<Image> img = new ArrayList<Image>();
//		img.add(new ImageIcon("images/mainPic.png").getImage().getScaledInstance(1194, 834, 0));
//		img.add(new ImageIcon("images/loginBox2.PNG").getImage().getScaledInstance(330, 240, 0));
		
		// 라벨 아이디 자리
		// x:458 / y:520 / w:80 / h:34
		JLabel id = new JLabel("아 이 디");
		id.setSize(80,34);
		id.setLocation(458,520);
		id.setOpaque(true);
		id.setBackground(new Color (255,255,255,125));
		id.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		id.setForeground(Color.WHITE);
		id.setHorizontalAlignment(JLabel.CENTER);
		id.setVerticalAlignment(JLabel.CENTER);
		this.add(id);
		
		JTextField inputId = new JTextField();
		inputId.setSize(185,34);
		inputId.setLocation(553, 520);
		inputId.setBorder(null);
//		inputId.setOpaque(true);
//		inputId.setBackground(new Color (0,0,0,125));
		inputId.setForeground(Color.WHITE);
		this.add(inputId);
		
		// 라벨 비밀번호 자리
		// x:458 / y:572 / w:80 / h:34
		JLabel pw = new JLabel("비밀번호");
		pw.setSize(80,34);
		pw.setLocation(458,572);
		pw.setOpaque(true);
		pw.setBackground(new Color (255,255,255,125));
		pw.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pw.setForeground(Color.WHITE);
		pw.setHorizontalAlignment(JLabel.CENTER);
		pw.setVerticalAlignment(JLabel.CENTER);
		this.add(pw);
		
		JPasswordField inputPw = new JPasswordField();
		inputPw.setSize(185,34);
		inputPw.setLocation(553, 572);
		inputPw.setBorder(null);
		this.add(inputPw);
		

		Player p = new Player();
		
		JButton clickLogin = new JButton("로그인");
		clickLogin.setSize(280,34);
		clickLogin.setLocation(458,624);
		clickLogin.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		clickLogin.setBorder(null);
		this.add(clickLogin);
		
		// 매인 맵 입장
			clickLogin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					ChangePanel change = new ChangePanel(mf, panel);
					WorldPanel world = new WorldPanel(mf);
					ChangePanel.replacePanel(mf,panel,world);
//					change.replacePanel(world);
				}
			});
		
		JButton clickJoin = new JButton("회원가입");
		clickJoin.setSize(280,34);
		clickJoin.setLocation(458,676);
		clickJoin.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		clickJoin.setBorder(null);
		this.add(clickJoin);
		
		// 회원가입 
		clickJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				ChangePanel change = new ChangePanel(mf, panel);
				Join join = new Join(mf);
				ChangePanel.replacePanel(mf,panel,join);
//				change.replacePanel(join);
			}
		});
		
		// 라벨 = 로그인 박스
		JLabel loginBox = new JLabel();
		loginBox.setSize(330,240);
		loginBox.setLocation(433, 495);
		loginBox.setOpaque(true);
		loginBox.setBackground(new Color (0,0,0,150));
		this.add(loginBox);
		
		// 라벨 = 스타트 백그라운드
		JLabel bg = new JLabel(new ImageIcon(new ImageIcon("images/mainPic.png").getImage().getScaledInstance(1194, 834, 0)));
		bg.setSize(1194, 834);
		bg.setLocation(0, 0);
		this.add(bg);
		
	}
	
	

}
