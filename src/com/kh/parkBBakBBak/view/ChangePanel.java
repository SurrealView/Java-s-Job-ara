package com.kh.parkBBakBBak.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangePanel {

	private JFrame mf;
	private JPanel panel;

	public ChangePanel(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}

	public void replacePanel(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		changePanel.setSize(1194,834);
		changePanel.setLocation(0,0);
		mf.repaint();
	}
}
