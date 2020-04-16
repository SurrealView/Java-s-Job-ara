package com.kh.parkBBakBBak.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.parkBBakBBak.controller.LoginManager;
import com.kh.parkBBakBBak.model.vo.Player;

public class Join extends JPanel{
	
	private JFrame mf;
	private JPanel panel;
	private Player p;
	private int count = 0;
	private boolean check;
	
	public Join() {}
	
	public void createPlayer(JFrame mf,Player p) {
		this.p = p;
		this.mf = mf;
		panel = this;
		
		this.setLayout(null);
		this.setSize(1194,834);
		this.setLocation(0,0);
		
		JLabel id = new JLabel("아 이 디");
		id.setSize(100,34);
		id.setLocation(448,499);
		id.setOpaque(true);
		id.setBackground(new Color (255,255,255,150));
		id.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		id.setForeground(Color.WHITE);
		id.setHorizontalAlignment(JLabel.CENTER);
		id.setVerticalAlignment(JLabel.CENTER);
		this.add(id);
		
		JTextField inputId = new JTextField();
		inputId.setSize(185,34);
		inputId.setLocation(563, 499);
		inputId.setBorder(null);
		inputId.setForeground(Color.BLACK);
		
		this.add(inputId);
		
		JLabel pw = new JLabel("비밀번호");
		pw.setSize(100,34);
		pw.setLocation(448,547);
		pw.setOpaque(true);
		pw.setBackground(new Color (255,255,255,150));
		pw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pw.setForeground(Color.WHITE);
		pw.setHorizontalAlignment(JLabel.CENTER);
		pw.setVerticalAlignment(JLabel.CENTER);
		this.add(pw);
		
		JPasswordField inputPw = new JPasswordField();
		inputPw.setSize(185,34);
		inputPw.setLocation(563, 547);
		inputPw.setBorder(null);
		
		this.add(inputPw);
		
		JLabel pw2 = new JLabel("비밀번호 확인");
		pw2.setSize(100,34);
		pw2.setLocation(448,595);
		pw2.setOpaque(true);
		pw2.setBackground(new Color (255,255,255,150));
		pw2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pw2.setForeground(Color.WHITE);
		pw2.setHorizontalAlignment(JLabel.CENTER);
		pw2.setVerticalAlignment(JLabel.CENTER);
		this.add(pw2);
		
		JPasswordField inputPw2 = new JPasswordField();
		inputPw2.setSize(185,34);
		inputPw2.setLocation(563, 595);
		inputPw2.setBorder(null);
		
		this.add(inputPw2);
		
		JButton checkId = new JButton("ID 중복 확인");
		checkId.setSize(130,20);
		checkId.setLocation(458,643);
		checkId.setFont(new Font("맑은 고딕", Font.ITALIC, 15));
		checkId.setBorder(null);
		
		checkId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = inputId.getText();
				boolean du = new LoginManager().duplicate(id);
				if(du) {
					JOptionPane.showMessageDialog(mf, "중복되는 ID입니다.", "Id Check", JOptionPane.WARNING_MESSAGE);
					check = false;
					count = 4;
				} else {
					JOptionPane.showMessageDialog(mf, "사용가능한 ID입니다.", "Id Check", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		this.add(checkId);
		
		JButton clickLogin = new JButton("비밀번호 확인");
		clickLogin.setSize(130,20);
		clickLogin.setLocation(608,643);
		clickLogin.setFont(new Font("맑은 고딕", Font.ITALIC, 15));
		clickLogin.setBorder(null);
		
		clickLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = inputId.getText();
				p.setUserId(id);
				System.out.println("회원가입 아이디 : " + p.getUserId());		// player 아이디 확인 용
				
				String pwd1 = inputPw.getText();
				p.setUserPwd(pwd1);
				System.out.println("회원가입 비번1 : " + p.getUserPwd());
				
				String pwd2 = inputPw2.getText();
				p.setCheckPwd(pwd2);
				System.out.println("회원가입 비번2 : " + p.getCheckPwd());
				
				
				count++;
				if(p.getUserPwd().equals(p.getCheckPwd())) {
					System.out.println("비밀번호 동일");
					check = true;
					JOptionPane.showMessageDialog(mf, "Password가 동일합니다!", "Password Check", JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println("비밀번호 다름");
//					check++;
					check = false;
					JOptionPane.showMessageDialog(mf, "Password가 일치하지 않습니다!", "Password Check", JOptionPane.WARNING_MESSAGE);
				}
				
				System.out.println("count : " + count);
				System.out.println("check : " + check);
				
			}
		});
		
		this.add(clickLogin);
		
		JButton clickJoin = new JButton("회원생성");
		clickJoin.setSize(280,34);
		clickJoin.setLocation(458,676);
		clickJoin.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		clickJoin.setBorder(null);
		this.add(clickJoin);
		
		// 회원생성 
		clickJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(count == 0) {
					// 패스워드 체크를 해주세요! dialog
					JOptionPane.showMessageDialog(mf, "Password Check를 해주세요!", "경고", JOptionPane.WARNING_MESSAGE);
					
				} else if(count == 4) { 
					JOptionPane.showMessageDialog(mf, "중복되는 ID입니다!", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(check == true) {
						// 플레이어 정보를 저장한 dat파일 저장
						
						LoginManager lm = new LoginManager();
						lm.createPlayer(p);
						
						
						ChangePanel.replacePanel(mf, panel, new LoginPage(mf,p)); 
						
						
					} else {
						// 비밀번호 확인을 다시 해주세요 dialog
						JOptionPane.showMessageDialog(mf, "Password Check가 일치하지 않습니다!", "경고", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
			}
		});
		
		JLabel loginBox = new JLabel();
		loginBox.setSize(330,270);
		loginBox.setLocation(433, 465);
		loginBox.setOpaque(true);
		loginBox.setBackground(new Color (0,0,0,150));
		this.add(loginBox);
		
		JLabel bg = new JLabel(new ImageIcon (new ImageIcon("images/mainPic.png").getImage().getScaledInstance(1194, 834, 0)));
		bg.setSize(1194, 834);
		bg.setLocation(0, 0);
		this.add(bg);
		
		
		
		
	}

}
