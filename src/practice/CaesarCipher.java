package practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaesarCipher {
	
	public String encrypt(String input, int key) {
		StringBuilder encrypt = new StringBuilder(input);
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		
		for(int i=0; i<encrypt.length(); i++) {
			char currChar = encrypt.charAt(i);
			
			int idx = alphabet.indexOf(currChar);
			
			if(idx != -1) {
				char newChar = shiftedAlphabet.charAt(idx);
				
				encrypt.setCharAt(i, newChar);
			}
			char ch='.';
			if(ch == '#') {
				
			}
		}
		return encrypt.toString();
	}
	
	public void testCaesarCipher() throws IOException {
		int key = 15;
		
		File file = new File("C:\\Users\\User\\Desktop\\out.txt");
		
		String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\Desktop\\in.txt")));
		String message = content.toUpperCase();
		String encrypted = encrypt(message, key);
		System.out.println(encrypted);
		String decrypted = encrypt(encrypted, 26-key);
		System.out.println(decrypted);
	}
	
	public static void main(String[] args) throws IOException {
		CaesarCipher cp = new CaesarCipher();
		cp.testCaesarCipher();
	}
	

}
