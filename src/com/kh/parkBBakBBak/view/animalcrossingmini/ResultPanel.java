package com.kh.parkBBakBBak.view.animalcrossingmini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.animalcrossingmini.BasePanel.MyMouseListener;
import com.kh.parkBBakBBak.view.home.HomePanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class ResultPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Player p;
	private int chatIndex = 0;
	private String[] chat = new String[] { "ºýºý´ÔÀÌ ÀÌ°å´Ù±¸¸®", "ºýºý´ÔÀÌ Á³´Ù±¸¸®. Á» ´õ ³ë·ÂÇØº¸´Â°Ô ÁÁÀ» °Í °°´Ù±¸¸®" };

	public ResultPanel(JFrame mf, Player p, int win) {
		this.mf = mf;
		panel = this;
		this.p = p;

		this.setLayout(null);
		this.setSize(1194, 834);

		this.setBackground(Color.black);
		JLabel realBackground = new JLabel(
				new ImageIcon(new ImageIcon("images/AnimalCrossingBg.png").getImage().getScaledInstance(500, 500, 0)));
		realBackground.setSize(500, 500);
		realBackground.setLocation(347, 167);

		// ÅØ½ºÆ® Ç³¼±
		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "Balloon Resize.png", 436, 135);
		txtArea.setSize(436, 135);
		txtArea.setLocation(385, 530);

		// ³Ê±¼
		JLabel nook = new JLabel(
				new ImageIcon(new ImageIcon("images/Tom Nook Resize.png").getImage().getScaledInstance(72, 119, 0)));
		nook.setSize(72, 119);
		nook.setLocation(420, 380);

		// ¸»Ç³¼±
		JTextArea ment;
		if (win == 1)
			ment = new JTextArea(chat[0]);
		else

			ment = new JTextArea(chat[1]);
		ment.setEditable(false);
		ment.setSize(370, 80);
		ment.setLocation(410, 570);
		ment.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		ment.setBackground(new Color(255, 250, 228));
		this.add(ment);
		ment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				BasePanel.bgm.stop();
				ChangePanel.replacePanel(mf, panel, new HomePanel(mf, p));
			}

		});

		this.add(txtArea);
		this.add(nook);
		this.add(realBackground);

	}
}
