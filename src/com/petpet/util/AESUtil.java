package com.petpet.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class AESUtil {
	public static final String KEY = "KittySnoopyMicky";

	public static String encryptString(String message) {

		String encryptedString = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			encryptedString = DatatypeConverter.printBase64Binary(cipher.doFinal(message.getBytes()));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	public static String decryptString(String key, String stringToDecrypt) {
		String decryptedString = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] b = DatatypeConverter.parseBase64Binary(stringToDecrypt);
			decryptedString = new String(cipher.doFinal(b));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return decryptedString;
	}

}
