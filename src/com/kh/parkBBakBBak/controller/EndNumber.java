package com.kh.parkBBakBBak.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.view.home.GamePanel;

public class EndNumber extends Thread {
	
	private JFrame mf;
	private JPanel panel;
	private int num;
	
	public EndNumber(JFrame mf, JPanel gp, int num) {
		this.mf = mf;
		this.panel = gp;
		this.num = num;
	}

	

	@Override
	public void run() {
		
		int xPoint = (int) (Math.random() * 990);
		int yPoint = (int) (Math.random() * 600);
		JLabel label = new JLabel("" + num + "");
		label.setSize(200, 50);
		label.setLocation(xPoint, yPoint);
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		try {
			panel.add(label);
			Thread.sleep(300L);
			label.setText("");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
