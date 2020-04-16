package com.kh.parkBBakBBak.view.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;

public class HiddenGame extends JPanel {
	
	private JFrame mf;
	private JPanel hg;
	private Player p;
	
	public HiddenGame(JFrame mf, Player p) {
		
		this.mf = mf;
		hg = this;
		this.p = p;
		
		this.setLayout(null);
		this.setSize(1194, 834);
		this.setLocation(0, 0);	
		
		
		
		JButton backButton = new JButton(new ImageIcon(new ImageIcon("images/backButton.png").getImage().getScaledInstance(60, 60, 0)));
		backButton.setSize(60,60);
		backButton.setLocation(1082,30);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		this.add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, hg, new HomePanel(mf, p));
			}
		});
		
		JButton yes = new JButton(new ImageIcon(new ImageIcon("images/YesButton.png").getImage().getScaledInstance(120, 100, 0)));
		yes.setSize(120, 100);
		yes.setLocation(433, 623);
		yes.setContentAreaFilled(false);
		yes.setFocusPainted(false);
		this.add(yes);
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				GamePanel gp = new GamePanel(mf, p);
//				PlayLJH01 p01 = new PlayLJH01(mf, gp);
//				
//				Thread runP01 = p01;
//				runP01.start();
				ChangePanel.replacePanel(mf, hg, new GamePanel(mf, p));
			}
		});
		
		JButton no = new JButton(new ImageIcon(new ImageIcon("images/NoButton.png").getImage().getScaledInstance(120, 100, 0)));
		no.setSize(120, 100);
		no.setLocation(636, 623);
		no.setContentAreaFilled(false);
		no.setFocusPainted(false);
		this.add(no);
		
		no.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, hg, new HomePanel(mf, p));
			}
		});

		
		JLabel bg = new JLabel(new ImageIcon(new ImageIcon("images/LeejhMiniGame.png").getImage().getScaledInstance(1194, 834, 0)));
		bg.setSize(1194, 834);
		bg.setLocation(0, 0);
		this.add(bg);
		
		
		
	}

}
