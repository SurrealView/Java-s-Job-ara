package com.kh.parkBBakBBak.view.cafe;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;

public class HiddenPanel2 extends JPanel{
	public JFrame mf;
	public JPanel panel;
	public Player u;
	JTextArea ta;
	
	int tok = 0;

	public HiddenPanel2(JFrame mf, Player p) {
		this.mf = mf;
		panel = this;
		u = p;
		 this.setLayout(null);
		
		Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 20);

		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/cafeBack.PNG").getImage().getScaledInstance(1194, 834, 0)));
		label.setBounds(0, 0, 1194, 834);
		JLabel textArea = new JLabel(
				new ImageIcon(new ImageIcon("images/txtarea2.PNG").getImage().getScaledInstance(820, 270, 0)));
		textArea.setSize(820,270);
		textArea.setLocation(180,498);
		//textArea.setBounds(180, 498, 820, 270);
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setSize(820,170);
		ta.setLocation(240,557);
		//ta.setBounds(240, 557, 820, 170);
		ta.setOpaque(false);
		ta.setFont(font);
		ta.append("µ¹ ¹ß ÀÌ º¥ Æ® ! !");
		//ta.setVisible(true);
		
		ta.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(tok + "¹ø Å¬¸¯");
				if(tok==0) {
					ta.setText("ºýºý¾¾, ÄíÆù ½ºÅÆÇÁ ´Ù¼¸ Ä­À» ´Ù Ã¤¿ì¼Ì±º¿ä");
					tok++;
				}else if(tok==1) {
					ta.setText("°¨»çÀÇ ÀÇ¹Ì·Î ÄíÆùÀ» µÎ Àå µå¸®°Ú½À´Ï´Ù ^^");
					tok++;
				}else if(tok==2) {
					ta.setText("ºýºýÀº ÄíÆù µÎ °³¸¦ ¾ò¾ú´Ù!!!");
					tok++;
				}else {
					tok=0;
					
					u.setCouponQTY(u.getCouponQTY()+2);
					//u.setHp(u.getHp()+100);
					System.out.println("È÷µçÆÐ³Î2 ÅðÀå");
					 //BackgroundPanel world = new BackgroundPanel(mf,u);
		             ChangePanel.replacePanel(mf,panel,new BackgroundPanel(mf, u));
				}
				
			}
			
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
			
		});

		this.add(textArea);
		this.add(ta);
		this.add(label);
		
		this.setComponentZOrder(ta, 0);
		this.setComponentZOrder(textArea, 1);
		this.setComponentZOrder(label, 2);

	}

}
