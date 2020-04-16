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

public class SaveComplete extends JPanel{
	
	private JFrame mf;
	private JPanel sc;
	private Player p;
	
	public SaveComplete(JFrame mf, Player p) {
		
		this.mf = mf;
		sc = this;
		this.p = p;
		
		this.setLayout(null);
		this.setSize(1194,834);
		this.setLocation(0,0);
		
		System.out.println("savecomplete¿¡ µé¾î¿Â ºýºý : " + p.toString());
		
		JLabel txtArea = new JLabel();
		txtArea.setSize(820,270);
		txtArea.setLocation(187,500);
		this.add(txtArea);
		
		txtArea.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.replacePanel(mf, sc, new BlackHome(mf, p));		
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
		
		JLabel text1 = new JLabel("ÇÏ¾Ï~~ ºýºýÀÌ Á¹·Á~~");
		text1.setSize(715,45);
		text1.setLocation(240,551);
		text1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		text1.setBackground(new Color(240,247,247));
		text1.setBorder(null);
		this.add(text1);
		
		JLabel text2 = new JLabel("¾ó¸¥ º¹½ÀÇÏ°í ÀÚ¾ßÁö~~");
		text2.setSize(715,45);
		text2.setLocation(240,611);
		text2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		text2.setBackground(new Color(240,247,247));
		text2.setBorder(null);
		this.add(text2);
		
		JLabel text3 = new JLabel("(ÇöÀç±îÁö ÁøÇà»óÈ²ÀÌ ÀúÀåµË´Ï´Ù.)");
		text3.setSize(715,45);
		text3.setLocation(240,671);
		text3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		text3.setBackground(new Color(240,247,247));
		text3.setBorder(null);
		this.add(text3);
		
		JLabel txtBoxImg = new JLabel(new ImageIcon(new ImageIcon("images/txtarea2.png").getImage().getScaledInstance(820, 270, 0)));
		txtBoxImg.setSize(820,270);
		txtBoxImg.setLocation(187, 500);
		this.add(txtBoxImg);
		
		JLabel bg = new JLabel(new ImageIcon(new ImageIcon("images/homeReSize.png").getImage().getScaledInstance(1194, 834, 0)));
		bg.setSize(1194, 834);
		bg.setLocation(0, 0);
		this.add(bg);
		
	}
	
	

}
