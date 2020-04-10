package com.kh.parkBBakBBak.view.interview;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.MainFrame;
import com.kh.parkBBakBBak.view.WorldPanel;

public class CreatedInterview extends JPanel implements MouseListener, ActionListener {
	protected ArrayList<JButton> talk = new ArrayList<JButton>();
	protected static final String ADDRESS = "images/";
	protected Font font;
	private JFrame mf;
	private JPanel panel;
	
	protected JButton menuButton, backButton;
	

	public void showQuest(ArrayList<JButton> buttonArr, String[] question) {

		for (int i = 0; i < question.length; i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("¸¼Àº °íµñ", font.PLAIN, 26));
			buttonArr.get(i).setSize(700, 40);
			buttonArr.get(i).setLocation(225, 550 + (60 * i));
			buttonArr.get(i).setBorderPainted(false);
			buttonArr.get(i).setContentAreaFilled(false);
			buttonArr.get(i).setFocusPainted(false);
			buttonArr.get(i).setHorizontalAlignment(SwingConstants.LEFT);
			this.add(buttonArr.get(i));
			 buttonArr.get(i).addActionListener(this);
		}
	}

	public JLabel addJLabelImage(JLabel label, String path, int x, int y) {

		Image image = new ImageIcon(ADDRESS + path).getImage().getScaledInstance(x, y, 0);
		label = new JLabel(new ImageIcon(image));
		label.setSize(x, y);

		return label;
	}

	public JButton addJButtonImage(JButton button, String path, int x, int y) {

		Image image = new ImageIcon(ADDRESS + path).getImage().getScaledInstance(x, y, 0);
		button = new JButton(new ImageIcon(image));
		button.setSize(x, y);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);

		return button;
	}

	public void creatTestPlace() {

		JLabel label = addJLabelImage(new JLabel(), "interview.png", 1194, 834);
		label.setLocation(0, 0);
		this.add(label);
	}

	public void creatEclipse() {

		JLabel label = addJLabelImage(new JLabel(), "javaConsole.png", 1194, 834);
		label.setLocation(0, 0);
		this.add(label);
	}

	public void creatSmallCoffee() {

		JLabel label = addJLabelImage(new JLabel(), "coffeeSmall.png", 17, 24);
		label.setLocation(140, 15);
		this.add(label);
	}

	public void createCountCoupons(int coffeeCoupon) {

		JLabel label = new JLabel(" X " + coffeeCoupon);
		label.setFont(font = new Font("¸¼Àº °íµñ", font.PLAIN, 24));
		label.setSize(50, 40);
		label.setLocation(160, 8);
		this.add(label);
	}

	public void createBackSpace() {

		backButton = addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1020, 15);
		backButton.addActionListener(this);
		this.add(backButton);

	}

	public void createMenuBar() {

		menuButton = addJButtonImage(new JButton(), "menuButton.png", 60, 60);
		menuButton.setLocation(1100, 15);
		menuButton.addActionListener(this);
		this.add(menuButton);
	}

	public void createTxtArea() {

		JLabel label = addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		label.setLocation(200, 510);
		this.add(label);

	}

	public void createJuckerburg() {
		JLabel label = addJLabelImage(new JLabel(), "mark.png", 233, 208);
		label.setLocation(222, 310);
		this.add(label);
	}

	public void createKwak() {
		JLabel label = addJLabelImage(new JLabel(), "gwakTheIronDragon.png", 314, 200);
		label.setLocation(222, 310);
		this.add(label);

	}

	public void createLee() {
		JLabel label = addJLabelImage(new JLabel(), "leeTheDragon.png", 200, 298);
		label.setLocation(222, 310);
		this.add(label);

	}

	public void createBattery(int hp) {

		JLabel label = addJLabelImage(new JLabel(), "batteryCase.png", 111, 44);
		label.setLocation(10, 5);
		String[] remainBattery = new String[] { "Battery1.png", "Battery2.png", "Battery3.png", "Battery4.png",
				"Battery5.png" };

		ArrayList<Image> images = new ArrayList<Image>();
		for (int i = 0; i < remainBattery.length; i++) {
			images.add(new ImageIcon(ADDRESS + remainBattery[i]).getImage().getScaledInstance(111, 44, 0));
		}

		ArrayList<JLabel> batteryLabels = new ArrayList<JLabel>();

		for (int i = 0; i < hp; i++) {
			batteryLabels.add(new JLabel(new ImageIcon(images.get(i))));
			batteryLabels.get(i).setSize(111, 44);
			batteryLabels.get(i).setLocation(10, 5);
			this.add(batteryLabels.get(i));
			this.add(label);
		}

	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		
//	ChangePanel change = new ChangePanel(mf,panel);
//	
//	SelectInterview select = new SelectInterview(mf);
//	change.replacePanel(select);

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.menuButton) {

			System.out.println("¸Þ´ºº¸±â");
		} else if (e.getSource() == this.backButton) {

			System.out.println("µÚ·Î °¥°Å´Ù");
			ChangePanel change = new ChangePanel(mf, panel);
			WorldPanel world = new WorldPanel(mf);
			change.replacePanel(world);
		}

	}

}
