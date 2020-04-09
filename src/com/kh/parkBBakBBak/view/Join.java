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

public class Join extends JPanel{
	
	private JFrame mf;
	private JPanel panel;
	
	public Join(JFrame mf) {
		
		this.mf = mf;
		panel = this;
		
		this.setLayout(null);
		this.setSize(1194,834);
		this.setLocation(0,0);
		
		// �÷��̾� ��ü ����
		Player p = new Player();
		
		JLabel id = new JLabel("�� �� ��");
		id.setSize(100,34);
		id.setLocation(448,499);
		id.setOpaque(true);
		id.setBackground(new Color (255,255,255,150));
		id.setFont(new Font("���� ���", Font.PLAIN, 15));
		id.setForeground(Color.WHITE);
		id.setHorizontalAlignment(JLabel.CENTER);
		id.setVerticalAlignment(JLabel.CENTER);
		this.add(id);
		
		JTextField inputId = new JTextField();
		inputId.setSize(185,34);
		inputId.setLocation(563, 499);
		inputId.setBorder(null);
//		inputId.setOpaque(true);
//		inputId.setBackground(new Color (0,0,0,125));
		inputId.setForeground(Color.BLACK);
		
		// ���̵� ��ü ����
		inputId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = inputId.getText();
				p.setUserId(id);
//				System.out.println(p.getUserId());		// player ���̵� Ȯ�� ��
			}
		});
		
		this.add(inputId);
		
		
		JLabel pw = new JLabel("��й�ȣ");
		pw.setSize(100,34);
		pw.setLocation(448,547);
		pw.setOpaque(true);
		pw.setBackground(new Color (255,255,255,150));
		pw.setFont(new Font("���� ���", Font.PLAIN, 15));
		pw.setForeground(Color.WHITE);
		pw.setHorizontalAlignment(JLabel.CENTER);
		pw.setVerticalAlignment(JLabel.CENTER);
		this.add(pw);
		
		JPasswordField inputPw = new JPasswordField();
		inputPw.setSize(185,34);
		inputPw.setLocation(563, 547);
		inputPw.setBorder(null);
		
		// ��й�ȣ ��ü ����
			inputPw.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					char[] pw = inputPw.getPassword();
					
					for(char ch : pw) {
//						(char).toString(ch)
					}
					
					System.out.println(p.getUserPwd());
				}
			});		
		
		this.add(inputPw);
		
		
		JLabel pw2 = new JLabel("��й�ȣ Ȯ��");
		pw2.setSize(100,34);
		pw2.setLocation(448,595);
		pw2.setOpaque(true);
		pw2.setBackground(new Color (255,255,255,150));
		pw2.setFont(new Font("���� ���", Font.PLAIN, 15));
		pw2.setForeground(Color.WHITE);
		pw2.setHorizontalAlignment(JLabel.CENTER);
		pw2.setVerticalAlignment(JLabel.CENTER);
		this.add(pw2);
		
		JPasswordField inputPw2 = new JPasswordField();
		inputPw2.setSize(185,34);
		inputPw2.setLocation(563, 595);
		inputPw2.setBorder(null);
		this.add(inputPw2);
		
		JButton clickLogin = new JButton("��й�ȣ Ȯ��");
		clickLogin.setSize(200,20);
		clickLogin.setLocation(497,643);
		clickLogin.setFont(new Font("���� ���", Font.ITALIC, 15));
		clickLogin.setBorder(null);
		this.add(clickLogin);
		
		JButton clickJoin = new JButton("ȸ������");
		clickJoin.setSize(280,34);
		clickJoin.setLocation(458,676);
		clickJoin.setFont(new Font("���� ���", Font.BOLD, 20));
		clickJoin.setBorder(null);
		this.add(clickJoin);
		
		// ȸ������ 
		clickJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel change = new ChangePanel(mf, panel);
//				WorldPanel world = new WorldPanel(mf);
				LoginPage login = new LoginPage(mf);

				change.replacePanel(login);
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
