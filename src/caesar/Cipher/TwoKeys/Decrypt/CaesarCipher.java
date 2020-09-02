package caesar.Cipher.TwoKeys.Decrypt;

public class CaesarCipher {
	public String encryptTwoKeys(String input, int key1, int key2) {
		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);

		for (int i = 0; i < encrypted.length(); i++) {
			alphabet = alphabet.toUpperCase();
			shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
			shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
			char currChar = encrypted.charAt(i);
			int idx1 = i;
			if (idx1 % 2 == 0) {
				if (Character.isUpperCase(currChar)) {
					int idx = alphabet.indexOf(currChar);
					if (idx != -1) {
						char newChar = shiftedAlphabet1.charAt(idx);
						encrypted.setCharAt(i, newChar);
					}
				} else if (Character.isLowerCase(currChar)) {
					alphabet = alphabet.toLowerCase();
					shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
					shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
					int idx = alphabet.indexOf(currChar);
					if (idx != -1) {
						char newChar = shiftedAlphabet1.charAt(idx);
						encrypted.setCharAt(i, newChar);
					}
				}
			}

			if (idx1 % 2 != 0) {
				if (Character.isUpperCase(currChar)) {
					int idx = alphabet.indexOf(currChar);
					if (idx != -1) {
						char newChar = shiftedAlphabet2.charAt(idx);
						encrypted.setCharAt(i, newChar);
					}
				} else if (Character.isLowerCase(currChar)) {
					alphabet = alphabet.toLowerCase();
					shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
					shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
					int idx = alphabet.indexOf(currChar);
					if (idx != -1) {
						char newChar = shiftedAlphabet2.charAt(idx);
						encrypted.setCharAt(i, newChar);
					}
				}
			}
		}
		
		return encrypted.toString();
	}
	

}
