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

public class JaeHyung extends JPanel{
	public JFrame mf;
	public JPanel panel;
	public Player u;
	JTextArea ta;
	
	int tok = 0;

	public JaeHyung(JFrame mf, Player p) {
		this.mf = mf;
		panel = this;
		u = p;
		 this.setLayout(null);
		
		Font font = new Font("���� ���", Font.BOLD, 20);
		JLabel cafeManager = new JLabel(new ImageIcon(new ImageIcon("images/PPackPPack.PNG").getImage().getScaledInstance(360, 384, 0)));
	      cafeManager.setBounds(640,137,360,384);
	      JLabel cafeManager2 = new JLabel(new ImageIcon(new ImageIcon("images/PPackPPack.PNG").getImage().getScaledInstance(360, 384, 0)));
	      cafeManager2.setBounds(200,137,360,384);
		

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
		ta.append("�ں����� ��ȣ");
		//ta.setVisible(true);
		
		ta.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(tok + "�� Ŭ��");
				if(tok==0) {
					ta.setText("��! �����̴�!");
					tok++;
				}else if(tok==1) {
					ta.setText("�� �� �̷��� ����̴�..");
					tok++;
				}else if(tok==2) {
					ta.setText("Ŀ�� ���� ���ð� ���� ������ �Ϸ�...");
					tok++;
				}else if(tok==3) {
					ta.setText("������ �̷��� �����Լ�\n���� �� ���� �����!!!");
					tok++;
				}else {
					tok=0;
					
					u.setCouponQTY(u.getCouponQTY()+11111);
					//u.setHp(u.getHp()+100);
					System.out.println("QkrQKr�г� ����");
					u.setPppppakk(u.getPppppakk()+1);
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
		this.add(cafeManager);
		this.add(cafeManager2);
		this.add(textArea);
		this.add(ta);
		this.add(label);
		
		this.setComponentZOrder(cafeManager, 0);
		this.setComponentZOrder(ta, 0);
		this.setComponentZOrder(textArea, 1);
		//this.setComponentZOrder(label, 2);

	}

}
