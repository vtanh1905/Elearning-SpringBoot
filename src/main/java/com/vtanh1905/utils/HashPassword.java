package com.vtanh1905.utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassword {
	private final static int SALT = 10;
	
	public static String execute(String str) {
		return BCrypt.hashpw(str, BCrypt.gensalt(SALT));
	}
	
	public static boolean compare(String str, String hashed) {
		return BCrypt.checkpw(str, hashed);
	}
}
