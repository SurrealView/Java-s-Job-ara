package com.kh.parkBBakBBak.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.view.area.AreaBlock;
import com.kh.parkBBakBBak.view.area.AreaMove;

public class WorldPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel avatar;
	private Icon moveFront = new ImageIcon(
			new ImageIcon("images/moveFront.gif").getImage().getScaledInstance(52, 152, 0));
	private Icon moveBack = new ImageIcon(new ImageIcon("images/moveBack.gif").getImage().getScaledInstance(52, 152, 0));
	private Icon moveLeft = new ImageIcon(new ImageIcon("images/moveLeft.gif").getImage().getScaledInstance(52, 152, 0));
	private Icon moveRight = new ImageIcon(
			new ImageIcon("images/moveRight.gif").getImage().getScaledInstance(52, 152, 0));

	public WorldPanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
//		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // �г� �ܰ� �׵θ� : ����, ũ��
		panel = this;

		mf.setTitle("��Ÿ�");

		avatar = new JLabel(
				new ImageIcon(new ImageIcon("images/standFront.png").getImage().getScaledInstance(52, 152, 0)));
		avatar.setLocation(500, 380);
		avatar.setSize(52, 152);

		JLabel Background = new JLabel(new ImageIcon(
				new ImageIcon("images/streetMap.png").getImage().getScaledInstance(MainFrame.x, MainFrame.y, 0)));
		Background.setBounds(0, 0, MainFrame.x, MainFrame.y);

		mf.addKeyListener(new MyKeyListener());

		this.add(Background);
		this.add(avatar);
		this.setComponentZOrder(Background, 1);
//		mf.add(this);
//		this.setVisible(true);

	}

	class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			// com.kh.controller.keyboard ��Ű���� ���� ���� ���� ���� �޼ҵ�
			AreaBlock block = new AreaBlock(avatar);
			block.areaBlock();
			
			AreaMove move = new AreaMove();
			move.areaMove(mf, panel, avatar);
			

			// �׽�Ʈ�� : ĳ������ �� ���� �� ���� x/y��ǥ
			System.out.println("x : " + avatar.getX() + " | y : " + avatar.getY());

			switch (key) {
			case KeyEvent.VK_UP:
				avatar.setIcon(moveBack);// �̵�������� ����
				if (avatar.getY() <= 0)
					return;
				else
					avatar.setLocation(avatar.getX(), avatar.getY() - 5);
				break;
			case KeyEvent.VK_DOWN:
				avatar.setIcon(moveFront); // �̵�������� ����
				if (avatar.getY() + avatar.getHeight() + 5 > panel.getHeight())
					return;
				else
					avatar.setLocation(avatar.getX(), avatar.getY() + 5);
				break;
			case KeyEvent.VK_LEFT:
				avatar.setIcon(moveLeft); // �̵�������� ����
				if (avatar.getX() <= 0)
					return;
				else
					avatar.setLocation(avatar.getX() - 5, avatar.getY());
				break;
			case KeyEvent.VK_RIGHT:
				avatar.setIcon(moveRight); // �̵�������� ����
				if (avatar.getX() + avatar.getWidth() + 5 > panel.getWidth())
					return;
				else
					avatar.setLocation(avatar.getX() + 5, avatar.getY());
				break;

			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			Icon standFront = new ImageIcon(
					new ImageIcon("images/standFront.png").getImage().getScaledInstance(52, 152, 0));
			Icon standBack = new ImageIcon(
					new ImageIcon("images/standBack.png").getImage().getScaledInstance(52, 152, 0));
			Icon standLeft = new ImageIcon(
					new ImageIcon("images/standLeft.png").getImage().getScaledInstance(52, 152, 0));
			Icon standRight = new ImageIcon(
					new ImageIcon("images/standRight.png").getImage().getScaledInstance(52, 152, 0));

			// ���� �ٶ󺸴� ���·� ������ ����
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_UP:
				avatar.setIcon(standBack);
				break;
			case KeyEvent.VK_DOWN:
				avatar.setIcon(standFront);
				break;
			case KeyEvent.VK_LEFT:
				avatar.setIcon(standLeft);
				break;
			case KeyEvent.VK_RIGHT:
				avatar.setIcon(standRight);
				break;
			}
		}
	}

}
