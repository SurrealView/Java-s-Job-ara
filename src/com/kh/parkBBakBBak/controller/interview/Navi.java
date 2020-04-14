package com.kh.parkBBakBBak.controller.interview;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Navi extends Thread {

	private JFrame mf;
	private JPanel panel;
	private String a = "";

	public Navi(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}

	@Override
	public void run() {
		String ment = "\n\n\t\t\t\tInterview Developer : Ko Jong Hyun\n\n\t\t\t\tLobby Developer : Jeong Sang Hyun \n\n\t\t\t\tCafe Developer : In Hyo Geun\n\n\t\t\t\t"
				+ "Lecture Developer : Kim Jung Soo\n\n\t\t\t\tTest Developer : Lee Hae Lim\n\n\t\t\t\tLogin&Save Developer : Lee Jae Hyung";
		JTextArea label = new JTextArea("");
		label.setSize(1184, 700);
		label.setLocation(0,0);
		label.setFont(new Font("Aharoni", Font.PLAIN, 26));
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(255,0,0,0));
		label.setEditable(false);
		
		panel.add(label);
		for (int i = 0; i < ment.length(); i++) {
			try {
				String s = ment.charAt(i) + "";

				this.sleep(100L);
				//label.append(s);

				a += s;

				label.setText(a);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
