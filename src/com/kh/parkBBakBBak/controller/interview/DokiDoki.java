package com.kh.parkBBakBBak.controller.interview;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DokiDoki extends Thread {

	private JFrame mf;
	private JPanel panel;
	private String a = "";

	public DokiDoki(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}

	@Override
	public void run() {
		String ment = "\n\n\n\n\t�δ��ϴ�...\n\n\n\t������ ����� ���ƿ� ������....\n\n\n\t�� �հ� �� �� ������?";
		JTextArea label = new JTextArea("");
		label.setSize(900, 700);
		label.setLocation(0,0);
		label.setFont(new Font("���� ����", Font.BOLD, 36));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.black);
		label.setEditable(false);
		
		panel.add(label);
		for (int i = 0; i < ment.length(); i++) {
			try {
				String s = ment.charAt(i) + "";

				this.sleep(100L);
				label.append(s);

				a += s;

				label.setText(a);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
