package com.kh.parkBBakBBak.model.vo;

public class Player implements java.io.Serializable{
	
	private String userId;
	private char[] userPwd;			// 비밀번호는 char[]로 저장 char[] pwd = {'u','s','e','r','0','1'};
//	private String userNick;
	
	private int day = 1;
	private String[] weekDay = {"월","화","수","목","금","토","일"};
	private int hp = 5;
	private int couponQTY = 0;
	private int skillQTY = 0;
	private boolean[] getSkill = {false, false, false, false, false, false, false, false, false, false};
	private String career;
	
	public Player() {}
	
//	public Player(String userId, String userPwd, String userNick) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char[] getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(char[] userPwd) {
		this.userPwd = userPwd;
	}

//	public String getUserNick() {
//		return userNick;
//	}
//
//	public void setUserNick(String userNick) {
//		this.userNick = userNick;
//	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String[] getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String[] weekDay) {
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
	
	
	
	

}
