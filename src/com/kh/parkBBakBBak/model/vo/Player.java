package com.kh.parkBBakBBak.model.vo;

import java.util.Arrays;

import javax.swing.JLabel;

public class Player implements java.io.Serializable{
	
//	/**
//	 * 
//	 */
	private static final long serialVersionUID = -9172491562312961541L;
	
	private int playerNumber;
	private String userId;
	private String userPwd;			
	private String checkPwd;			
	
	private int day = 1;
	private String weekDay = "월";
	private int hp = 5;
	private int couponQTY = 0;
	private int skillQTY = 10;
	private boolean[] getSkill = {false, false, false, false, false, false, false, false, false, false};
	private String career = "무직";
	private JLabel avatar;
	private  int hidden= -1;
	private  boolean hiddenEnd=false;
	private int couponCount = 0 ;
	private int pppppakk=0;
	
	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}

	public int getPppppakk() {
		return pppppakk;
	}

	public void setPppppakk(int pppppakk) {
		this.pppppakk = pppppakk;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	public boolean isHiddenEnd() {
		return hiddenEnd;
	}

	public void setHiddenEnd(boolean hiddenEnd) {
		this.hiddenEnd = hiddenEnd;
	}

	public Player() {}

	public Player(int playerNumber, String userId, String userPwd, String checkPwd, int day, String weekDay, int hp,
			int couponQTY, int skillQTY, boolean[] getSkill, String career) {
		this.playerNumber = playerNumber;
		this.userId = userId;
		this.userPwd = userPwd;
		this.checkPwd = checkPwd;
		this.day = day;
		this.weekDay = weekDay;
		this.hp = hp;
		this.couponQTY = couponQTY;
		this.skillQTY = skillQTY;
		this.getSkill = getSkill;
		this.career = career;
	}

	@Override
	public String toString() {
		return "Player [playerNumber=" + playerNumber + ", userId=" + userId + ", userPwd=" + userPwd + ", checkPwd="
				+ checkPwd + ", day=" + day + ", weekDay=" + weekDay + ", hp=" + hp + ", couponQTY="
				+ couponQTY + ", skillQTY=" + skillQTY + ", getSkill=" + Arrays.toString(getSkill) + ", career="
				+ career + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getCouponQTY() {
		return couponQTY;
	}

	public void setCouponQTY(int couponQTY) {
		this.couponQTY = couponQTY;
	}

	public int getSkillQTY() {
		return skillQTY;
	}

	public void setSkillQTY(int skillQTY) {
		this.skillQTY = skillQTY;
	}

	public boolean[] getGetSkill() {
		return getSkill;
	}

	public void setGetSkill(boolean[] getSkill) {
		this.getSkill = getSkill;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getCheckPwd() {
		return checkPwd;
	}

	public void setCheckPwd(String checkPwd) {
		this.checkPwd = checkPwd;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public JLabel getAvatar() {
		return avatar;
	}

	public void setAvatar(JLabel avatar) {
		this.avatar = avatar;
	}

//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
	
	public void changeWeekDay() {
		
		String[] weekDay = {"월","화","수","목","금","토","일"};
		
		if(getDay() < 8) {
			setWeekDay(weekDay[getDay() - 1]); 
		} else {
			int a = getDay() % 7;
			
			switch(a) {
			case 1 : setWeekDay(weekDay[0]); break;
			case 2 : setWeekDay(weekDay[1]); break;
			case 3 : setWeekDay(weekDay[2]); break;
			case 4 : setWeekDay(weekDay[3]); break;
			case 5 : setWeekDay(weekDay[4]); break;
			case 6 : setWeekDay(weekDay[5]); break;
			case 0 : setWeekDay(weekDay[6]); break;
			}
		}
		

		
	}

}
