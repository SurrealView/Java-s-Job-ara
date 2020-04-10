package com.kh.parkBBakBBak.view.cafe;

import javax.swing.JFrame;




public class MainFrame extends JFrame{
	private User user;
	
	public MainFrame(User u){
		
		user = u ;
		user = new User(5, 5);
		this.setBounds(0, 0, 1194,834);
		//this.setLayout(null);
		
		this.add(new BackgroundPanel(this,user));
		//this.add(new TestPanel(this));
		//this.add(new GraphicTest(this));
		
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
