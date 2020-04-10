package com.kh.parkBBakBBak.model.vo;

public class User {
	private int hp=1;
	private int coupon=1;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int hp, int coupon) {
		super();
		this.hp = hp;
		this.coupon = coupon;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	

}
