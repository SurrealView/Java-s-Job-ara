package com.kh.parkBBakBBak.view.home;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;

public class BlackHome extends JPanel {
	
	private JFrame mf;
	private JPanel bh;
	private Player p;
	
	public BlackHome(JFrame mf, Player p) {
		
		this.mf = mf;
		bh = this;
		this.p = p;
		
		this.setLayout(null);
		this.setSize(1194,834);
		this.setLocation(0,0);
		
		System.out.println("bh¿¡ µé¾î¿Â ºýºý : " + p.toString());
		
		JLabel txtArea = new JLabel("Day " + p.getDay());
		txtArea.setSize(1194,834);
		txtArea.setLocation(0,0);
		txtArea.setFont(new Font("¸¼Àº °íµñ", Font.ITALIC, 60));
		txtArea.setForeground(Color.WHITE);
		txtArea.setHorizontalAlignment(JLabel.CENTER);
		this.add(txtArea);
		
		txtArea.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.replacePanel(mf, bh, new HomeEnd1(mf, p));		
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		JLabel bg = new JLabel(new ImageIcon(new ImageIcon("images/homeBlack.png").getImage().getScaledInstance(1194, 834, 0)));
		bg.setSize(1194, 834);
		bg.setLocation(0, 0);
		this.add(bg);
		
	}

}
