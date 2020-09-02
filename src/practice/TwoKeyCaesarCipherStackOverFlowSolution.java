package practice;

import edu.duke.FileResource;

public class TwoKeyCaesarCipherStackOverFlowSolution {

	// this method to encrypt a messgae using a key
	String encrypt(String input, int key) {

		// convert the original message to temp upper case letters
		String input2 = input.toUpperCase();
		// using string builder rather than normal string
		StringBuilder sb = new StringBuilder(input2);
		// default alphabet
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// shiftted alphabet
		String shifttedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

		// itterating around the original message to get each char and then getting its
		// index
		// then getting the equilvent char in the shiftted alphabet
		for (int i = 0; i < sb.length(); i++) {

			char currentChar = sb.charAt(i);
			int currentIndex = alphabet.indexOf(currentChar);

			if (currentIndex != -1) {
				char shifttedChar = shifttedAlphabet.charAt(currentIndex);
				sb.setCharAt(i, shifttedChar);
			}
		}
		// converting the builder string to a normal string
		String encrypted = sb.toString();
		// getting every char to its normal case even lower or upper
		for (int i = 0; i < input.length(); i++) {
			boolean upper = Character.isUpperCase(input.charAt(i));
			if (upper) {
				sb.setCharAt(i, Character.toUpperCase(encrypted.charAt(i)));
			} else {
				sb.setCharAt(i, Character.toLowerCase(encrypted.charAt(i)));
			}

		}
		// restting the encrypted message after editting to the lower nad upper case
		// state
		encrypted = sb.toString();
		// returning the encrypted string
		return encrypted;
	}

	// this method to encrypt using two keys
	String encryptTwoKeys(String input, int key1, int key2) {
		String encryptedKey1 = encrypt(input, key1);
		String encryptedKey2 = encrypt(input, key2);

		StringBuilder finalEncrypted = new StringBuilder(input);

		for (int i = 0; i < encryptedKey1.length(); i += 2) {
			char currentChar = encryptedKey1.charAt(i);
			finalEncrypted.replace(i, i + 1, String.valueOf(currentChar));

		}

		for (int i = 1; i < encryptedKey2.length(); i += 2) {
			char currentChar = encryptedKey2.charAt(i);
			finalEncrypted.replace(i, i + 1, String.valueOf(currentChar));

		}

		return finalEncrypted.toString();
	}

	void testEncryptTwoKeys() {
		String encrypted = encryptTwoKeys(
				"Top ncmy qkff vi vguv vbg ycpx", 2, 20);
		System.out.println(encrypted);
		String decrypted = encryptTwoKeys(encrypted, 26 - 2, 26 - 20);
		System.out.println(decrypted);

	}

	void testEncrypt() {
		FileResource fr = new FileResource();
		String message = fr.asString();
		String encrypted = encrypt(message, 15);
		System.out.println("key is " + 15 + "\n" + encrypted);
	}
	
	public static void main(String[] args) {
		TwoKeyCaesarCipherStackOverFlowSolution twoKey = new TwoKeyCaesarCipherStackOverFlowSolution();
		twoKey.testEncryptTwoKeys();
	}
}
