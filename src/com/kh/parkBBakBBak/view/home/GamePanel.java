package com.kh.parkBBakBBak.view.home;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.parkBBakBBak.controller.EndNumber;
import com.kh.parkBBakBBak.controller.LeejhMGManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.JungSo;

public class GamePanel extends JPanel {
	
	private JFrame mf;
	private JPanel gp;
	private Player p;
	private int num;
	private int ranNum = (int) (Math.random() * 90001) + 10000;
	private boolean result;
	private int checkPoint;
	
	public GamePanel(JFrame mf, Player p) {
		this.mf = mf;
		gp = this;
		this.p = p;
		
		this.setLayout(null);
		this.setSize(1194, 834);
		this.setLocation(0, 0);
		
		this.setBackground(Color.BLACK);
		
		Thread t = new EndNumber(mf, gp, this.ranNum);
		t.start();
		
		JLabel checkNum = new JLabel(new ImageIcon(new ImageIcon("images/p1-1.png").getImage().getScaledInstance(300, 100, 0)));
		checkNum.setSize(300,100);
		checkNum.setLocation(50,617);
		this.add(checkNum);
		
		JTextField answer = new JTextField();
		answer.setSize(300,100);
		answer.setLocation(350,617);
		answer.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		answer.setForeground(Color.BLACK);
		answer.setBorder(null);
		this.add(answer);
		
		answer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				num = Integer.parseInt(answer.getText());
				System.out.println("num : " + num);
				LeejhMGManager lee = new LeejhMGManager();
				result = lee.checkAnswer(num, ranNum);
//				System.out.println("result : " + result);
				if(result == true) {
					System.out.println("ÄíÆù ¼ýÀÚ : " + p.getCouponQTY());
					JButton checkAnswer = new JButton("Á¤´ä");
					checkAnswer.setSize(200,100);
					checkAnswer.setLocation(834,617);
					checkAnswer.setBackground(Color.WHITE);
					checkAnswer.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
					checkAnswer.setForeground(Color.BLACK);
					gp.add(checkAnswer);
					
					checkAnswer.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(mf, "ÄíÆùÀ» ÇÏ³ª µå¸³´Ï´Ù.", "Á¤´ä", JOptionPane.PLAIN_MESSAGE);
							ChangePanel.replacePanel(mf, gp, new HomePanel(mf, p)); 
						}
					});
					
					p.setCouponQTY(p.getCouponQTY() + 1);
					System.out.println(p.getCouponQTY());
				} else {
					System.out.println("ÄíÆù ¼ýÀÚ : " + p.getCouponQTY());
					JButton checkAnswer = new JButton("¿À´ä");
					checkAnswer.setSize(200,100);
					checkAnswer.setLocation(834,617);
					checkAnswer.setBackground(Color.WHITE);
					checkAnswer.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
					checkAnswer.setForeground(Color.BLACK);
					gp.add(checkAnswer);
					
					checkAnswer.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(mf, "ÄíÆù ÇÏ³ª°¡ »ç¶óÁý´Ï´Ù.", "¿À´ä", JOptionPane.PLAIN_MESSAGE);
							ChangePanel.replacePanel(mf, gp, new HomePanel(mf, p)); 
						}
					});
					
					p.setCouponQTY(p.getCouponQTY() - 1);
					System.out.println(p.getCouponQTY());
				}
				
			}
		});
		
		JLabel guide1 = new JLabel(new ImageIcon(new ImageIcon("images/p1-2.png").getImage().getScaledInstance(300, 50, 0)));
		guide1.setSize(300,50);
		guide1.setLocation(330,567);
		this.add(guide1);
		
		JLabel guide2 = new JLabel(new ImageIcon(new ImageIcon("images/p1-3.png").getImage().getScaledInstance(50, 150, 0)));
		guide2.setSize(50,150);
		guide2.setLocation(1034,600);
		this.add(guide2);
		
	}

}
