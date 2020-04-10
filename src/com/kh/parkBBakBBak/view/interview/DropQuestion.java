package com.kh.parkBBakBBak.view.interview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.kh.parkBBakBBak.model.dao.InputQuest;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.MainFrame;
import com.kh.parkBBakBBak.view.WorldPanel;
//private String talks[] =new String[] {qa.getQuiz(),qa.getSample()[0],qa.getSample()[1],qa.getSample()[2]};

public class DropQuestion extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Font font;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private InputQuest qa = new InputQuest();
	private String[] question = new String[] { qa.getQuiz(), qa.getSample()[0], qa.getSample()[1], qa.getSample()[2] };
	private int correct;

	public DropQuestion(JFrame mf) {
		System.out.println("DropQuestion 입장");
		this.mf = mf;
		this.panel = this;
		this.setLayout(null);
		this.setSize(1194, 834);

		JLabel smallCoffee = addJLabelImage(new JLabel(), "coffeeSmall.png", 17, 24);
		smallCoffee.setLocation(140, 15);

		JLabel couponQty = new JLabel(" X " + 3);
		couponQty.setFont(font = new Font("맑은 고딕", font.PLAIN, 24));
		couponQty.setSize(50, 40);
		couponQty.setLocation(160, 8);

		JLabel txtArea = addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);

		JLabel gwak = addJLabelImage(new JLabel(), "gwakTheIronDragon.png", 314, 200);
		gwak.setLocation(222, 310);

		JLabel batteryCase = addJLabelImage(new JLabel(), "batteryCase.png", 111, 44);
		batteryCase.setLocation(10, 5);
		String[] remainBattery = new String[] { "Battery1.png", "Battery2.png", "Battery3.png", "Battery4.png",
				"Battery5.png" };

		ArrayList<Image> batteryImage = new ArrayList<Image>();
		for (int i = 0; i < remainBattery.length; i++) {
			batteryImage.add(
					new ImageIcon(SelectInterview.ADDRESS + remainBattery[i]).getImage().getScaledInstance(111, 44, 0));
		}

		ArrayList<JLabel> batteryLabels = new ArrayList<JLabel>();

		for (int i = 0; i < 5; i++) {
			batteryLabels.add(new JLabel(new ImageIcon(batteryImage.get(i))));
			batteryLabels.get(i).setSize(111, 44);
			batteryLabels.get(i).setLocation(10, 5);

		}
		for (int i = 0; i < 5; i++) {
			this.add(batteryLabels.get(i));
		}
		this.add(batteryCase);

		JButton backButton = addJButtonImage(new JButton(), "backButton.png", 60, 60);
		backButton.setLocation(1020, 15);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("돌아갈래");

				ChangePanel.replacePanel(mf, panel, new SmallIntroduce2(mf));
				// ChangePanel.replacePanel(mf, panel, new SmallIntroduce1(mf));

			}
		});

		JButton menuButton = addJButtonImage(new JButton(), "menuButton.png", 60, 60);
		menuButton.setLocation(1100, 15);
		menuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("메뉴보기");
				ChangePanel.replacePanel(mf, panel, new WorldPanel(mf));

			}
		});

		JLabel backGround = addJLabelImage(new JLabel(), "javaConsole.png", 1194, 834);
		backGround.setLocation(0, 0);

		buttonArr = showQuest(buttonArr, question);
		for (int i = 0; i < buttonArr.size(); i++) {

			this.add(buttonArr.get(i));
		}
		buttonArr.get(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				correct = 1;
				System.out.println("정답은:"+qa.getAnswers());
				if (correct == qa.getAnswers()) {
					System.out.println("너 정답");
				} else {
					System.out.println("너 틀림");
				}
			}
		});

		buttonArr.get(2).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				correct = 2;
				System.out.println("정답은:"+qa.getAnswers());
				if (correct == qa.getAnswers()) {
					System.out.println("너 정답");
				} else {
					System.out.println("너 틀림");
				}
			}
		});

		buttonArr.get(3).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				correct = 3;
				System.out.println("정답은:"+qa.getAnswers());
				if (correct == qa.getAnswers()) {
					System.out.println("너 정답");
				} else {
					System.out.println("너 틀림");
				}
			}
		});
		this.add(backButton);
		this.add(menuButton);
		this.add(backGround);

	}

	public JLabel addJLabelImage(JLabel label, String path, int x, int y) {

		Image image = new ImageIcon(SelectInterview.ADDRESS + path).getImage().getScaledInstance(x, y, 0);
		label = new JLabel(new ImageIcon(image));
		label.setSize(x, y);

		return label;
	}

	public JButton addJButtonImage(JButton button, String path, int x, int y) {

		Image image = new ImageIcon(SelectInterview.ADDRESS + path).getImage().getScaledInstance(x, y, 0);
		button = new JButton(new ImageIcon(image));
		button.setSize(x, y);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);

		return button;
	}

	public ArrayList<JButton> showQuest(ArrayList<JButton> buttonArr, String[] question) {

		for (int i = 0; i < question.length; i++) {
			buttonArr.add(new JButton(question[i]));
			buttonArr.get(i).setFont(new Font("맑은 고딕", font.PLAIN, 18));
			buttonArr.get(i).setForeground(Color.WHITE);
			buttonArr.get(i).setSize(1000, 40);
			buttonArr.get(i).setLocation(100, 200 + (60 * i));
			buttonArr.get(i).setBorderPainted(false);
			buttonArr.get(i).setContentAreaFilled(false);
			buttonArr.get(i).setFocusPainted(false);
			buttonArr.get(i).setHorizontalAlignment(SwingConstants.LEFT);

		}
		return buttonArr;
	}

}
