package com.kh.parkBBakBBak.view.cafe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BGPanel3 extends BGPanel2{


	JFrame mf;
	JPanel panel;
	User u;
	public BGPanel3(JFrame mf, User u) {
		super(mf, u);
		this.mf = mf;
		this.u = u;
		panel = this;
		
		//JButton button2 = new JButton();
		button.addMouseListener(new My4());
		tf2.setText("아이스 아메리카노는");
		tf3.setText("체력을 1 회복시켜주며,");
		//this.remove(button);
		
	}
	class My4 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
		
//		public void mouseClicked(MouseEvent e) {
			ChangePanel change = new ChangePanel(mf, panel);
			BGPanel4 world = new BGPanel4(mf, u);
			
			change.replacePanel(world);
		}
		
	}

}
