package com.kh.parkBBakBBak.controller.interview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.interview.ShowResult;

public class DokiDoki extends Thread {

	private JFrame mf;
	private JPanel panel;
	private String a = "";
	private Player p;

	public DokiDoki(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
		this.p = p;
	}

	@Override
	public void run() {
		String ment = "\n\n\n\n\t½Î´ÃÇÏ´Ù...\n\n\n\t°¡½¿¿¡ ºñ¼ö°¡ ³¯¾Æ¿Í ²ÈÈù´Ù....\n\n\n\t³­ ÇÕ°Ý ÇÒ ¼ö ÀÖÀ»±î?";
		JTextArea label = new JTextArea("");
		label.setSize(900, 700);
		label.setLocation(0,0);
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 36));
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
