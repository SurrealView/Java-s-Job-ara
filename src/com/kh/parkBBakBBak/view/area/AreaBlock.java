package com.kh.parkBBakBBak.view.area;

import javax.swing.JLabel;

public class AreaBlock {
	private JLabel avatar;

	public AreaBlock(JLabel avatar) {
		this.avatar = avatar;
	}

	public void areaBlock() {
		areaKhAcademy(avatar);
		areaCafe(avatar);
		areaStation(avatar);
		areaInterview(avatar);
		areaTower(avatar);
	}

	// �п� ���� ����
	public void areaKhAcademy(JLabel avatar) {
		// �п� ������ �� ����
		if (avatar.getY() > 280 && avatar.getY() < 600) // �ٲ�� �� : 370~700
			if (avatar.getX() > 450 && avatar.getX() < 460) {
				avatar.setLocation(avatar.getX() + 10, avatar.getY());
			}
		// �п� ���� �� ����
		if (avatar.getY() > 280 && avatar.getY() < 600) // �ٲ�� �� : 370~700
			if (avatar.getX() < 110 && avatar.getX() > 100) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}
		// �п� ������ ����
		if ((avatar.getX() >= 110 && avatar.getX() < 280) || (avatar.getX() > 290 && avatar.getX() <= 450)) //�� �ո� �κ�
			if (avatar.getY() > 595 && avatar.getY() < 605) { // �ٲ�� �� : 700/720
				avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			}
		// �п� ���� ����
		if (avatar.getX() >= 120 && avatar.getX() <= 450)
			if (avatar.getY() < 280 && avatar.getY() > 270) { // �ٲ�� �� : 380 / 360
				avatar.setLocation(avatar.getX(), avatar.getY() - 10);
			}
	}

	// ī�� ���� ����
	public void areaCafe(JLabel avatar) {
		// ī�� ������ �� ����
		if (avatar.getY() >= 0 && avatar.getY() < 160)
			if (avatar.getX() > 500 && avatar.getX() < 510) {
				avatar.setLocation(avatar.getX() + 10, avatar.getY());
			}
		// ī�� ���� �� ����
		if (avatar.getY() >= 0 && avatar.getY() < 160)
			if (avatar.getX() < 75 && avatar.getX() > 65) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}
		// ī�� ������ ����
		if ((avatar.getX() >= 70 && avatar.getX() < 355)||(avatar.getX() >= 370 && avatar.getX() < 510)) //�� �ո� �κ� : 335~370
			if (avatar.getY() > 155 && avatar.getY() < 165) {
				avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			}
		// ī��� ������ �ʿ� �������Ƿ� �ʿ����

	}

	// ���ͺ� ���� ����
	public void areaInterview(JLabel avatar) {
		// ���ͺ� ���� �� ����
		if (avatar.getY() <= 160)
			if (avatar.getX() < 715 && avatar.getX() > 705) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}
		// ���ͺ� ������ ����
		if ((avatar.getX()<850 && avatar.getX() > 700) || (avatar.getX() > 860)) //�� �ո� �κ� : 850~860
			if (avatar.getY() > 155 && avatar.getY() < 165) {
				avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			}

	}

	// �� ���� ����
	public void areaStation(JLabel avatar) {
		// �п� ���� �� ����
		if (avatar.getY() > 230 && avatar.getY() <= 610)
			if (avatar.getX() < 715 && avatar.getX() > 705) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}
		// �п� ������ ����
		if ((avatar.getX() > 700 && avatar.getX()<820) || (avatar.getX()>830))//�� �ո� �κ� : 820~830
			if (avatar.getY() > 605 && avatar.getY() < 615) {
				avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			}
		// �п� ���� ����
		if (avatar.getX() > 700 && avatar.getX() < 950)
			if (avatar.getY() < 245 && avatar.getY() >= 235) {
				avatar.setLocation(avatar.getX(), avatar.getY() - 10);
			}
	}

	// Ÿ�� ���� ����
	public void areaTower(JLabel avatar) {
		// �� ������ Ÿ�� ����
		if (avatar.getY() < 300)
			if (avatar.getX() > 900) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}

	}
}
