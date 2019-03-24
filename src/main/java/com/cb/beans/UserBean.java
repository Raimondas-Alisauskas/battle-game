package com.cb.beans;

public class UserBean {
	private int id;
	private String userName;
	private String password;
	private byte isAdmin;
	private int rank;
	private int money;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getAdmin() {
		return isAdmin;
	}

	public void setAdmin(byte admin) {
		isAdmin = admin;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
