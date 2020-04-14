package com.kh.parkBBakBBak.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.cafe.BackgroundPanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class ChangePanel {

//	private JFrame mf;
//	private JPanel panel;

	public ChangePanel() {
	}

	public static void replacePanel(JFrame mf, JPanel oldPanel, JPanel changePanel) {

		mf.remove(oldPanel);
		mf.add(changePanel);
		changePanel.setSize(1194, 834);
		changePanel.setLocation(0, 0);
//			mf.revalidate();
		mf.repaint();
	}
}
