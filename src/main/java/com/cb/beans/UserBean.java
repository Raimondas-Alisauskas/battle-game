package com.cb.beans;

public class UserBean {
	private int id;
	private String userName;
	private String password;
	private int isAdmin;
	private String email;
	private int rating;
	private int money;
	private int characterId;
	private int partyId;

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

	public int getAdmin() {
		return isAdmin;
	}

	public void setAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
}
