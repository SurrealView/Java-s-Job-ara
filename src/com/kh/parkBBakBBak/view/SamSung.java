package com.kh.parkBBakBBak.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;

public class SamSung extends JPanel {
	
	private JFrame mf;
	private JPanel js;
	private Player p;
	
	public SamSung(JFrame mf, Player p) {
		
		this.mf = mf;
		js = this;
		this.p = p;
		
		System.out.println("»ù¼þÀ¸·Î µé¾î¿Â ºýºý : " + p.toString());
		
		this.setLayout(null);
		this.setSize(1194,834);
		this.setLocation(0,0);
		this.setBackground(Color.BLACK);
		
		JButton yes = new JButton();
		yes.setSize(120,120);
		yes.setLocation(401,567);
		yes.setContentAreaFilled(false);
		yes.setFocusPainted(false);
		this.add(yes);
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				down();
				ChangePanel.replacePanel(mf, js, new WorldPanel(mf, p));
			}
		});
		
		JButton no = new JButton();
		no.setSize(120,120);
		no.setLocation(677,567);
		no.setContentAreaFilled(false);
		no.setFocusPainted(false);
		this.add(no);
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, js, new LoginPage(mf, p));
			}
		});
		
		JLabel text1 = new JLabel("´ç½ÅÀº ÀÌ¹Ì ´ë±â¾÷¿¡ Ãë¾÷Çß½À´Ï´Ù.");
		text1.setSize(1000,120);
		text1.setLocation(97,87);
		text1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 50));
		text1.setHorizontalAlignment(JLabel.CENTER);
		text1.setForeground(new Color(240,247,247));
		this.add(text1);
		
		JLabel text2 = new JLabel("Á» ´õ ³ÐÀº ¹°¿¡¼­ ³î±âÀ§ÇØ");
		text2.setSize(1000,120);
		text2.setLocation(97,247);
		text2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 50));
		text2.setHorizontalAlignment(JLabel.CENTER);
		text2.setForeground(new Color(240,247,247));
		this.add(text2);
		
		JLabel text3 = new JLabel("Åð»çÇÏ°í ´Ù½Ã KH¿¡ ÀÔ¼Ò ÇÏ½Ã°Ú½À´Ï±î?");
		text3.setSize(1000,120);
		text3.setLocation(97,407);
		text3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 50));
		text3.setHorizontalAlignment(JLabel.CENTER);
		text3.setForeground(new Color(240,247,247));
		this.add(text3);
		
		JLabel text4 = new JLabel("YES    or    NO");
		text4.setSize(1000,120);
		text4.setLocation(97,567);
		text4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 50));
		text4.setHorizontalAlignment(JLabel.CENTER);
		text4.setForeground(new Color(240,247,247));
		this.add(text4);
		
	}
	
	public void down() {
		this.p.setCareer("¹«Á÷");
	}

}
