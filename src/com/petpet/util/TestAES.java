package com.petpet.util;

public class TestAES {

	public static void main(String[] args) {
		String pwd = "passw0rd";
		String cipherText = AESUtil.encryptString(pwd);
		System.out.println(cipherText);
		String plainText = AESUtil.decryptString("KittySnoopyMicky", cipherText);
		System.out.println(plainText);

	}

}
