package com.kh.parkBBakBBak.view.home;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.animalcrossingmini.BasePanel;

public class GameMain extends JPanel {
	
	private JFrame mf;
	private JPanel gm;
	private Player p;
	
	public GameMain(JFrame mf, Player p ) {
		
		this.mf = mf;
		gm = this;
		this.p = p;
		
		this.setLayout(null);
		this.setSize(1194, 834);
		this.setLocation(0, 0);	
//		this.setBackground(new Color(240,247,247));
//		this.setBackground(Color.BLACK);

		
		
		
		JButton game1 = new JButton();
		game1.setSize(360, 60);
		game1.setLocation(389, 173);
		game1.setBorderPainted(false);
		game1.setContentAreaFilled(false);
		game1.setFocusPainted(false);
		this.add(game1);
		
		game1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, gm, new HiddenGame(mf, p));
			}
		});
		
		JButton game2 = new JButton();
		game2.setSize(360, 60);
		game2.setLocation(389, 250);
		game2.setBorderPainted(false);
		game2.setContentAreaFilled(false);
		game2.setFocusPainted(false);
		this.add(game2);
		
		game2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, gm, new BasePanel(mf, p));
			}
		});
		
		
		JButton backButton = new JButton(new ImageIcon(new ImageIcon("images/backButton.png").getImage().getScaledInstance(60, 60, 0)));
		backButton.setSize(60,60);
		backButton.setLocation(654,589);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		this.add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.replacePanel(mf, gm, new HomePanel(mf, p));
			}
		});
		
		JLabel backLabel = new JLabel();
		backLabel.setSize(357, 186);
		backLabel.setLocation(389, 150);
		backLabel.setBackground(new Color(221, 254, 238));
//		backLabel.setBackground(Color.BLACK);
		this.add(backLabel);
		
		JLabel bmo = new JLabel(new ImageIcon(new ImageIcon("images/BMO1.png").getImage().getScaledInstance(719, 834, 0)));
		bmo.setSize(719, 834);
		bmo.setLocation(237, 0);
		this.add(bmo);
		
		JLabel bg = new JLabel(new ImageIcon(new ImageIcon("images/homeReSize.png").getImage().getScaledInstance(1194, 834, 0)));
		bg.setSize(1194, 834);
		bg.setLocation(0, 0);
		this.add(bg);
		
	}

}
