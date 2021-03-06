package com.kh.parkBBakBBak.view.area;

import javax.swing.JLabel;

public class AreaBlock {
	private JLabel avatar;

	public AreaBlock(JLabel avatar) {
		this.avatar = avatar;
	}

	// 학원 구역 지정
	public void areaKhAcademy(JLabel avatar) {
		// 학원 오른쪽 벽 막음
		if (avatar.getY() > 295 && avatar.getY() < 585) // 바뀌기 전 : 370~700
			if (avatar.getX() > 450 && avatar.getX() < 460) {
				avatar.setLocation(avatar.getX() + 10, avatar.getY());
			}
		// 학원 왼쪽 벽 막음
		if (avatar.getY() > 295 && avatar.getY() < 585) // 바뀌기 전 : 370~700
			if (avatar.getX() < 110 && avatar.getX() > 100) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}
		// 학원 정문쪽 막음
		if ((avatar.getX() >= 110 && avatar.getX() < 270) || (avatar.getX() > 300 && avatar.getX() <= 450)) // 문 뚫린 부분
			if (avatar.getY() > 575 && avatar.getY() < 585) { // 바뀌기 전 : 700/720
				avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			}
		// 학원 위쪽 막음
		if (avatar.getX() >= 120 && avatar.getX() <= 450)
			if (avatar.getY() < 280 && avatar.getY() > 270) { // 바뀌기 전 : 380 / 360
				avatar.setLocation(avatar.getX(), avatar.getY() - 10);
			}
	}

	// 카페 구역 지정
	public void areaCafe(JLabel avatar) {
		// 카페 오른쪽 벽 막음
		if (avatar.getY() >= 0 && avatar.getY() < 155)
			if (avatar.getX() > 500 && avatar.getX() < 510) {
				avatar.setLocation(avatar.getX() + 10, avatar.getY());
			}
		// 카페 왼쪽 벽 막음
		if (avatar.getY() >= 0 && avatar.getY() < 155)
			if (avatar.getX() < 75 && avatar.getX() > 65) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}
		// 카페 정문쪽 막음
		if ((avatar.getX() >= 70 && avatar.getX() < 355) || (avatar.getX() >= 370 && avatar.getX() < 510)) // 문 뚫린 부분 :
																											// 335~370
			if (avatar.getY() > 145 && avatar.getY() < 155) {
				avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			}
		// 카페는 위쪽이 맵에 막혔으므로 필요없다

	}

	// 인터뷰 지역 지정
	public void areaInterview(JLabel avatar) {
		// 인터뷰 왼쪽 벽 막음
		if (avatar.getY() < 155)
			if (avatar.getX() < 715 && avatar.getX() > 705) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}
		// 인터뷰 정문쪽 막음
		if ((avatar.getX() < 850 && avatar.getX() > 700) || (avatar.getX() > 860)) // 문 뚫린 부분 : 850~860
			if (avatar.getY() > 145 && avatar.getY() < 155) {
				avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			}

	}

	// 역 구역 지정
	public void areaStation(JLabel avatar) {
		// 학원 왼쪽 벽 막음
		if (avatar.getY() > 230 && avatar.getY() <= 610)
			if (avatar.getX() < 715 && avatar.getX() > 705) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}
		// 학원 정문쪽 막음
		if ((avatar.getX() > 700 && avatar.getX() < 820) || (avatar.getX() > 830))// 문 뚫린 부분 : 820~830
			if (avatar.getY() > 605 && avatar.getY() < 615) {
				avatar.setLocation(avatar.getX(), avatar.getY() + 10);
			}
		// 학원 위쪽 막음
		if (avatar.getX() > 700 && avatar.getX() < 950)
			if (avatar.getY() < 245 && avatar.getY() >= 235) {
				avatar.setLocation(avatar.getX(), avatar.getY() - 10);
			}
	}

	// 타워 구역 지정
	public void areaTower(JLabel avatar) {
		// 역 오른쪽 타워 구멱
		if (avatar.getY() < 300)
			if (avatar.getX() > 900) {
				avatar.setLocation(avatar.getX() - 10, avatar.getY());
			}

	}

	public void ghostExile(JLabel avatar) {
		if (avatar.getY() > 1194)
			if (avatar.getX() > 834) {
				avatar.setLocation(1500, 1500);
			}

	}

	public void areaBlock() {

		ghostExile(avatar);
		areaKhAcademy(avatar);
		areaCafe(avatar);
		areaStation(avatar);
		areaInterview(avatar);
		areaTower(avatar);
	}
}
