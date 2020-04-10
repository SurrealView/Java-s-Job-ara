package com.kh.parkBBakBBak.view.area;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.parkBBakBBak.model.vo.Player;
import com.kh.parkBBakBBak.view.ChangePanel;
import com.kh.parkBBakBBak.view.MaybeCafePanel;
import com.kh.parkBBakBBak.view.cafe.BackgroundPanel;
//import com.kh.parkBBakBBak.view.MaybeAcademyPanel;
//import com.kh.parkBBakBBak.view.MaybeCafePanel;
//import com.kh.parkBBakBBak.view.MaybeStationPanel;
import com.kh.parkBBakBBak.view.interview.SelectInterview;

public class AreaMove {
	public void areaMove(JFrame mf, JPanel panel, JLabel avatar) {
		
		// 각 패널 이동
					// KH학원
					if (avatar.getX() >= 280 && avatar.getX() <= 290)
						if (avatar.getY() >= 560 && avatar.getY() <= 560) {
//							ChangePanel change = new ChangePanel(mf, panel);
							
//							MaybeAcademyPanel academy = new MaybeAcademyPanel(mf);
//							change.replacePanel(academy);
						}
					// 카페
					if (avatar.getX() >= 355 && avatar.getX() <= 370)
						if (avatar.getY()>= 100 && avatar.getY() <= 100) {
							System.out.println("출력");
//							ChangePanel change = new ChangePanel(mf, panel);
							Player p = new Player();
							BackgroundPanel cafe = new BackgroundPanel(mf, p);
							ChangePanel.replacePanel(mf,panel,cafe);
//							change.replacePanel(cafe);
						}
					// 역
					if (avatar.getX() >= 820 && avatar.getX() <= 830)
						if (avatar.getY() >= 550 && avatar.getY() <= 550) {
							
							System.out.println("출력");
							MaybeCafePanel cafe2 = new MaybeCafePanel(mf);
							ChangePanel.replacePanel(mf,panel,cafe2);
//							ChangePanel change = new ChangePanel(mf, panel);
//							MaybeStationPanel station = new MaybeStationPanel(mf);
//							change.replacePanel(station);
						}
					// 인터뷰 장소
					if (avatar.getX() >= 850 && avatar.getX() <= 860)
						if (avatar.getY() >= 100 && avatar.getY() <= 100) {
							System.out.println("출력");
							panel.remove(avatar);
							mf.remove(panel);
//							ChangePanel change = new ChangePanel(mf, panel);
							SelectInterview interview = new SelectInterview(mf);
							ChangePanel.replacePanel(mf,panel,interview);
//							change.replacePanel(interview);
						}
					
	}

}
