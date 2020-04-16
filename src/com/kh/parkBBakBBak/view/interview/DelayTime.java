package com.kh.parkBBakBBak.view.interview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;

public class DelayTime extends JPanel{

	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	

	public DelayTime(JFrame mf,Player p) {
		this.p =p;
		this.mf = mf;
		this.panel = this;
		this.setLayout(null);
		this.setSize(1194, 834);
		this.setLocation(0,0);
		InterviewManager.pageNum=7;
		this.setBackground(Color.BLACK);
		
		JButton nextButton=SelectInterview.addJButtonImage(new JButton(),"nextButton.png", 60, 60);
		nextButton.setLocation(1000,50);
		this.add(nextButton);

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ChangePanel.replacePanel(mf, panel, new ShowResult(mf,p));
			}
		});
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("다음화면");
				ChangePanel.replacePanel(mf, panel, new ShowResult(mf,p));

			}
		});
	
	}

	

	
	
}
