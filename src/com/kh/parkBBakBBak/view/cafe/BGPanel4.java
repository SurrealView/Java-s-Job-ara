package com.kh.parkBBakBBak.view.cafe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BGPanel4 extends BGPanel2{

	JFrame mf;
	JPanel panel;
	User u;
	public BGPanel4(JFrame mf, User u) {
		super(mf, u);
		this.mf = mf;
		this.u = u;
		panel = this;
		
		JButton button2 = new JButton();
		
		tf2.setText("������ �޴��� ü���� -2~4���� ");
		tf3.setText("�����ϰ� ȸ�����ݴϴ�.");
		this.remove(button);
		
	}
	class My4 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
		
//		public void mouseClicked(MouseEvent e) {
			ChangePanel change = new ChangePanel(mf, panel);
			BackgroundPanel world = new BackgroundPanel(mf, u);
			
			change.replacePanel(world);
		}
		
	}

}
