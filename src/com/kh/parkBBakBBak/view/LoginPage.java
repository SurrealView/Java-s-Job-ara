package com.kh.parkBBakBBak.view;

import java.awt.Color;
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

public class LoginPage extends JPanel {
	
	private JFrame mf;
	private JPanel panel;
	private String loginId = "";
	private String loginPw = "";
	private Player p;

	public LoginPage(JFrame mf,Player p) {
		this.p = p;
		this.mf = mf;
		panel = this;
		
		this.setLayout(null);
		this.setSize(1194,834);
		this.setLocation(0,0);
		
		JLabel id = new JLabel("�� �� ��");
		id.setSize(80,34);
		id.setLocation(458,520);
		id.setOpaque(true);
		id.setBackground(new Color (255,255,255,60));
		id.setFont(new Font("���� ���", Font.BOLD, 20));
		id.setForeground(Color.WHITE);
		id.setHorizontalAlignment(JLabel.CENTER);
		id.setVerticalAlignment(JLabel.CENTER);
		this.add(id);
		
		JTextField loginInputId = new JTextField();
		loginInputId.setSize(185,34);
		loginInputId.setLocation(553, 520);
		loginInputId.setFont(new Font("���� ���", Font.BOLD, 20));
		loginInputId.setBorder(null);
		loginInputId.setForeground(Color.BLACK);
		
//		// ���̵� ��ü ����
//		loginInputId.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				loginId = loginInputId.getText();
//				System.out.println("loginId : " + loginId);
//			}
//		});
		
		this.add(loginInputId);
		
		JLabel pw = new JLabel("��й�ȣ");
		pw.setSize(80,34);
		pw.setLocation(458,572);
		pw.setOpaque(true);
		pw.setBackground(new Color (255,255,255,60));
		pw.setFont(new Font("���� ���", Font.BOLD, 20));
		pw.setForeground(Color.WHITE);
		pw.setHorizontalAlignment(JLabel.CENTER);
		pw.setVerticalAlignment(JLabel.CENTER);
		this.add(pw);
		
		JPasswordField loginInputPw = new JPasswordField();
		loginInputPw.setSize(185,34);
		loginInputPw.setLocation(553, 572);
		loginInputPw.setFont(new Font("���� ���", Font.BOLD, 20));
		loginInputPw.setBorder(null);
		
//		// ��й�ȣ Ȯ��
//		loginInputPw.addActionListener(new ActionListener() {
//				
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String pw2 = loginInputPw.getText();
//				loginPw = pw2;
//				System.out.println("loginPw : " + loginPw);			// �÷��̾� ��й�ȣ Ȯ�ο�
//			}
//		});						
		
		this.add(loginInputPw);
		
		JButton clickLogin = new JButton("�α���");
		clickLogin.setSize(280,34);
		clickLogin.setLocation(458,624);
		clickLogin.setBackground(Color.WHITE);
		clickLogin.setFont(new Font("���� ���", Font.BOLD, 20));
		clickLogin.setBorder(null);
		this.add(clickLogin);
		
		// ���� �� ����
		clickLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				loginId = loginInputId.getText();
				System.out.println("loginId : " + loginId);
				
				String pw2 = loginInputPw.getText();
				loginPw = pw2;
				System.out.println("loginPw : " + loginPw);			// �÷��̾� ��й�ȣ Ȯ�ο�
				
				int gaja = 0; 
				
				LoginManager lm = new LoginManager();
				gaja = lm.checkLogin(loginId, loginPw, p);
				
				switch(gaja) {
				case 0 :
					JOptionPane.showMessageDialog(mf, "���̵� �������� �ʽ��ϴ�.", "Login fail", JOptionPane.WARNING_MESSAGE);
					break;
				case 1 : 
					JOptionPane.showMessageDialog(mf, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "Login fail", JOptionPane.WARNING_MESSAGE);
					break;
				case 2 :
					lm.getP();
					System.out.println("lmŻ����� �븻 �α��� : " + lm.getP().toString());
					WorldPanel world = new WorldPanel(mf,lm.getP());
					ChangePanel.replacePanel(mf, panel, world);
					break;
				case 3 :
					lm.getP();
					System.out.println("lmŻ����� �߼� �α��� : " + lm.getP().toString());
					ChangePanel.replacePanel(mf, panel, new JungSo(mf, lm.getP())); 
					break;
				case 4 : 
					lm.getP();
					System.out.println("lmŻ����� ���� �α��� : " + lm.getP().toString());
					ChangePanel.replacePanel(mf, panel, new SamSung(mf, lm.getP())); 
					break;
				}
				
			}
		});
		
		
		JButton clickJoin = new JButton("ȸ������");
		clickJoin.setSize(280,34);
		clickJoin.setLocation(458,676);
		clickJoin.setBackground(Color.WHITE);
		clickJoin.setFont(new Font("���� ���", Font.BOLD, 20));
		clickJoin.setBorder(null);
		this.add(clickJoin);
		
		// ȸ������ 
		clickJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Join join = new Join();
				join.createPlayer(mf,p);
				ChangePanel.replacePanel(mf, panel, join);
				
			}
		});
		
		// �� = �α��� �ڽ�
		JLabel loginBox = new JLabel();
		loginBox.setSize(330,240);
		loginBox.setLocation(433, 495);
		loginBox.setOpaque(true);
		loginBox.setBackground(new Color (0,0,0,150));
		this.add(loginBox);
		
		// �� = ��ŸƮ ��׶���
		JLabel bg = new JLabel(new ImageIcon(new ImageIcon("images/mainPic.png").getImage().getScaledInstance(1194, 834, 0)));
		bg.setSize(1194, 834);
		bg.setLocation(0, 0);
		this.add(bg);
		
	}
	
	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}
	

}
