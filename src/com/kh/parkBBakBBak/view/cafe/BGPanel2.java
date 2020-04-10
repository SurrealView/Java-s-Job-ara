package com.kh.parkBBakBBak.view.cafe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BGPanel2 extends BackgroundPanel{

	JFrame mf;
	JPanel panel;
	User u;
	JTextField tf3;
	
	
	public BGPanel2(JFrame mf, User u) {
		
		
		super(mf, u);
		//BGPanel2 p2 = new BGPanel2(mf, u);
		this.mf = mf;
		this.u = u;
		panel = this;
		//this.setLayout(null);
		this.button.setText("gdgd");
		//this.add(button);
		//this.setComponentZOrder(button, 0);
		//button.addMouseListener(new My3());
		tf2.setText("저희 카페는 아이스 아메리카노와, ");
		tf2.setBounds(240,527,820,170);
		 tf3 = new JTextField();
		tf3.setBounds(240,567,820,170);
		tf3.setText("오늘의 메뉴를 판매하고 있습니다.");
		this.setComponentZOrder(tf3,1);
		tf3.setOpaque(false);
		tf3.setBorder(null);
		tf3.disable();
		tf3.setFont(font);
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				/*System.out.println(1);
				tf2.setText("아이스 아메리카노는");
				tf3.setText("체력을 1 회복시켜주며");*/
				/*tf2.repaint();
				tf3.repaint();*/
				
				
				
			}
		});
		/*JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/cafeBack.PNG").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0,0,1000,800);
		this.setComponentZOrder(label, 0);*/
		
		
		//this.add(label);
		
		
		
	}
	class My3 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
		
//		public void mouseClicked(MouseEvent e) {
			ChangePanel change = new ChangePanel(mf, panel);
			BGPanel3 world = new BGPanel3(mf, u);
			
			change.replacePanel(world);
		}
		
	}

}
