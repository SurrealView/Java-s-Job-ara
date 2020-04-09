package com.kh.parkBBakBBak.view.area;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.view.ChangePanel;
//import com.kh.parkBBakBBak.view.MaybeAcademyPanel;
//import com.kh.parkBBakBBak.view.MaybeCafePanel;
//import com.kh.parkBBakBBak.view.MaybeStationPanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class AreaMove {
	public void areaMove(JFrame mf, JPanel panel, JLabel avatar) {
		
		// 각 패널 이동
					// KH학원
					if (avatar.getX() >= 280 && avatar.getX() <= 290)
						if (avatar.getY() >= 560 && avatar.getY() <= 580) {
							ChangePanel change = new ChangePanel(mf, panel);
//							MaybeAcademyPanel academy = new MaybeAcademyPanel(mf);
//							change.replacePanel(academy);
						}
					// 카페
					if (avatar.getX() >= 355 && avatar.getX() <= 370)
						if (avatar.getY()>= 100 && avatar.getY() <= 120) {
							ChangePanel change = new ChangePanel(mf, panel);
//							MaybeCafePanel cafe = new MaybeCafePanel(mf);
//							change.replacePanel(cafe);
						}
					// 역
					if (avatar.getX() >= 820 && avatar.getX() <= 830)
						if (avatar.getY() >= 550 && avatar.getY() <= 570) {
							ChangePanel change = new ChangePanel(mf, panel);
//							MaybeStationPanel station = new MaybeStationPanel(mf);
//							change.replacePanel(station);
						}
					// 인터뷰 장소
					if (avatar.getX() >= 850 && avatar.getX() <= 860)
						if (avatar.getY() >= 100 && avatar.getY() <= 120) {
							ChangePanel change = new ChangePanel(mf, panel);
							SelectInterview interview = new SelectInterview(mf);
							change.replacePanel(interview);
						}
					
	}

}
