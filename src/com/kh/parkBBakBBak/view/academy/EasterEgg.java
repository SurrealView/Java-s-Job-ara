package com.kh.parkBBakBBak.view.academy;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.parkBBakBBak.controller.interview.InterviewManager;
import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.academy.AcademyMain;
import com.kh.parkBBakBBak.view.interview.DropQuestion;
import com.kh.parkBBakBBak.view.interview.SelectInterview;
import com.kh.parkBBakBBak.view.interview.SmallIntroduce1;

public class EasterEgg extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private Font font;
	private Player p;
	private int chatIndex=0;
	private ArrayList<JButton> buttonArr = new ArrayList<JButton>();
	private String[] chat = new String[] {"����  : �ʹ� �ٺ��� �ָ������� ������....ī�䳪 ���߰ڴ�\n\n"
			+"���� : ��縶���Ʈ���ڸ� �ֹ��ϸ� ī�信 ���������� �ְ���?",
			
			"�ڹٸ����� : ������!! �ָ��ε��� ������ �����̱���!!\n\n" + 
			"���� : �� �����ʹ� �ȳ��ϼ���!\n\n" +	"�ڹٸ����� : �̴�������Ʈ �غ� �� �����ٸ鼭��?",
			
			"���� : �� ��! �׷����ϴ�!\n\n" +"�ڹٸ����� : ������ ���� ������ �ƴ��� �����г��� �߰��� ������\n\n" + 
			"���� : �� ��... �˰ڽ��ϴ�...",
			
			"�ڹٸ����� : ������Ʈ�� �ϸ鼭 ���� �޴°� ������ ����Դϴ�.\n\n" + 
			"�ڹٸ����� : �������� ���ݱ��� ��̶�� ���� �߸� �˰��־����\n\n" + 
			"���� : �� �׷�����! ī�䰡�� ���� �غ��ڽ��ϴ�!\n\n",
			
			"�ڹٸ����� : �����ϴ� ������ �ÿ����� ����غ�����\n\n�ڹٸ����� : ���� �濡 Ŀ�� ���� �ؿ�\n\n"+
			"���� : �� �ּ��� ���ϰڽ��ϴ�...",
			
			"�ָ��� �п��� �湮�� ������ ���͸��� 1�����ߴ�\n\n"
			+"�ڹٸ����Ͱ� ������ �ǹ̷� ������ ���� �־���\n\n"+
			"Episode ���ְ� ���ְ� ����"
			};
			
			

	public EasterEgg(JFrame mf, Player p) {
		System.out.println("�̽��Ϳ��� ����");
		this.mf = mf;
		this.panel = this;
		this.p = p;
		this.setLayout(null);
		this.setSize(1194, 834);
		InterviewManager.pageNum = 3;

		JLabel txtArea = SelectInterview.addJLabelImage(new JLabel(), "txtarea2.png", 820, 270);
		txtArea.setLocation(200, 510);

		Image godJava = new ImageIcon("images/teacher.png").getImage().getScaledInstance(220, 210, 0);
		JLabel godJavaLb = new JLabel(new ImageIcon(godJava));
		godJavaLb.setLayout(null);
		godJavaLb.setBounds(230, 311, 220, 210);

		JLabel batteryCase = new JLabel(
				new ImageIcon(new ImageIcon("images/batteryCase.png").getImage().getScaledInstance(140, 45, 0)));
		batteryCase.setSize(140, 45);
		batteryCase.setLocation(40, 40);
		this.add(batteryCase);

		String[] remainBattery = new String[] { "Battery1.png", "Battery2.png", "Battery3.png", "Battery4.png",
				"Battery5.png" };

		ArrayList<Image> batteryImage = new ArrayList<Image>();
		for (int i = 0; i < remainBattery.length; i++) {
			batteryImage.add(new ImageIcon(InterviewManager.ADDRESS + remainBattery[i]).getImage()
					.getScaledInstance(140, 45, 0));
		}

		ArrayList<JLabel> batteryLabels = new ArrayList<JLabel>();

		if (p.getHp() != 0) {
			for (int i = 0; i < p.getHp(); i++) {
				batteryLabels.add(new JLabel(new ImageIcon(batteryImage.get(i))));
				batteryLabels.get(i).setSize(140, 45);
				batteryLabels.get(i).setLocation(40, 40);
			}

			for (int i = 0; i < this.p.getHp(); i++) {
				this.add(batteryLabels.get(i));
			}

		}
		this.add(batteryCase);

		JLabel smallCoffee = SelectInterview.addJLabelImage(new JLabel(), "coffeeSmall.png", 21, 40);
		smallCoffee.setSize(21, 40);
		smallCoffee.setLocation(200, 42);
		this.add(smallCoffee);

		JLabel couponQty = new JLabel(" X " + p.getCouponQTY());
		couponQty.setFont(new Font("���� ���", Font.PLAIN, 24));
		couponQty.setForeground(Color.WHITE);
		couponQty.setSize(50, 40);
		couponQty.setLocation(220, 40);
		this.add(couponQty);

		JLabel dayWeekDay = new JLabel(p.getDay() + "����" + " / " + p.getWeekDay() + "����");
		dayWeekDay.setFont(new Font("���� ���", Font.PLAIN, 20));
		dayWeekDay.setForeground(Color.WHITE);
		dayWeekDay.setSize(150, 40);
		dayWeekDay.setLocation(280, 41);
		this.add(dayWeekDay);

		JLabel infoBox = new JLabel();
		infoBox.setSize(403, 65);
		infoBox.setLocation(30, 30);
		infoBox.setOpaque(true);
		infoBox.setBackground(new Color(0, 0, 0, 150));
		this.add(infoBox);

		

		JLabel backGround = SelectInterview.addJLabelImage(new JLabel(), "smoke.png", 1194, 834);
		backGround.setLocation(0, 0);

		JTextArea ment = new JTextArea(chat[0]);
		ment.setSize(720,200);
		ment.setLocation(250,540);
		ment.setFont(new Font("���� ���", Font.PLAIN, 24));
		ment.setBackground(new Color(240,247,247));
		this.add(ment);
		
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				chatIndex++;
				
				switch (chatIndex) {

				case 1: case 2: case 3: case 4:	ment.setText(chat[chatIndex]); break;
				case 5:
					ment.setText(chat[chatIndex]);
					p.setHp(p.getHp() - 1);
					p.setCouponQTY(p.getCouponQTY() + 1);
					break;

				case 6:
					ment.setText("������ ���� ü�� :" + p.getHp() + "ĭ\n\n������ ���� �������� : " + p.getCouponQTY() + "��");
					break;
				case 7:
					ChangePanel.replacePanel(mf, panel, new AcademyMain(mf, p));

				}

			}
		});
		
		this.add(txtArea);
		this.add(godJavaLb);
		this.add(backGround);

	}

}
