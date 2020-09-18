package com.revature.services;
//Methods adapted from
	//https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
	import java.security.MessageDigest;
	import java.security.NoSuchAlgorithmException;
	import java.security.SecureRandom;

public class PasswordHashingService {

		public PasswordHashingService() {
			super();
		}

		public static String passwordHash(String password) {
			String generatedPassword = null;
			try {
				// Create MessageDigest instance for MD5
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.getBytes());
				byte[] bytes = md.digest();
				// This bytes[] has bytes in decimal format
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < bytes.length; i++) {
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}
				// Get complete hashed password in hex format
				generatedPassword = sb.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return generatedPassword;
		}
	}