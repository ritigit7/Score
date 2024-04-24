package com.goalscorer.Util;

public class DBQuery {
	private static String login="SELECT * from users WHERE username=? AND password=?";
	private static String register= "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
	public static String getLogin() {
		return login;
	}
	public static String getRegister() {
		return register;
	}	
}
