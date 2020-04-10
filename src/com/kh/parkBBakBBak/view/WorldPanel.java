package com.kh.parkBBakBBak.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.area.AreaBlock;
import com.kh.parkBBakBBak.view.area.AreaMove;

public class WorldPanel extends JPanel {

	private JFrame mf;
	private JPanel panel;
	private JLabel avatar = new JLabel(
			new ImageIcon(new ImageIcon("images/standFront.png").getImage().getScaledInstance(52, 152, 0)));

	private Icon moveFront;
	private Icon moveBack;
	private Icon moveLeft;
	private Icon moveRight;
	private Icon standFront;
	private Icon standBack;
	private Icon standLeft;
	private Icon standRight;
	private int charCnt = 0;

	public WorldPanel(JFrame mf) {


		this.mf = mf;
		panel = this;
		this.setLayout(null);

		mf.setTitle("��Ÿ�");
		
		avatar.setLocation(500, 380);
		avatar.setSize(52, 152);

		JLabel Background = new JLabel(
				new ImageIcon(new ImageIcon("images/streetMap.png").getImage().getScaledInstance(1194, 834, 0)));
		Background.setLocation(0, 0);
		Background.setSize(1194, 834);

		moveFront = new ImageIcon(new ImageIcon("images/moveFront.gif").getImage().getScaledInstance(52, 152, 0));
		moveBack = new ImageIcon(new ImageIcon("images/moveBack.gif").getImage().getScaledInstance(52, 152, 0));
		moveLeft = new ImageIcon(new ImageIcon("images/moveLeft.gif").getImage().getScaledInstance(52, 152, 0));
		moveRight = new ImageIcon(new ImageIcon("images/moveRight.gif").getImage().getScaledInstance(52, 152, 0));
		standFront = new ImageIcon(new ImageIcon("images/standFront.png").getImage().getScaledInstance(52, 152, 0));
		standBack = new ImageIcon(new ImageIcon("images/standBack.png").getImage().getScaledInstance(52, 152, 0));
		standLeft = new ImageIcon(new ImageIcon("images/standLeft.png").getImage().getScaledInstance(52, 152, 0));
		standRight = new ImageIcon(new ImageIcon("images/standRight.png").getImage().getScaledInstance(52, 152, 0));

		mf.setFocusable(true); // Ű���帮���ʰ� �۵��ϵ��� focus�� �������� on
		mf.addKeyListener(new MyKeyListener());
		
		this.add(Background);
		this.add(avatar);
		this.setComponentZOrder(Background, 1);
	}

	class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

			System.out.println("���2");
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
//			System.out.println("x : " + avatar.getX() + " | y : " + avatar.getY());

			switch (key) {
			case KeyEvent.VK_UP:
				avatar.setIcon(moveBack);// �̵�������� ����
				if (avatar.getY() <= 0)
					return;
				else
					avatar.setLocation(avatar.getX(), avatar.getY() - 5);
				break;
			case KeyEvent.VK_DOWN:
				avatar.setIcon(moveFront);
				// �̵�������� ����
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
