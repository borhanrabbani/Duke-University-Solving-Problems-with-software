package practice;


// This is the first assignment task given in the Coursera: Java Programming: Arrays, Lists, 
// Structured data. Implementing Caesar Cipher algorithm module.

public class WordPlay {
	
	boolean isVowel(char ch){
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch =='U') {
			return true;
		}
		return false;
	}
	
	String replaceVowels(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		for(int i=0; i<sb.length(); i++) {
			char currChar = sb.charAt(i);
			boolean res = isVowel(currChar);
			if(res) {
				sb.setCharAt(i, ch);
			}
			
 		}		
		String msg = new String(sb);
		return msg;
	}
	
	String emphasize(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		for(int i=0; i<sb.length(); i++) {
			char currChar = sb.charAt(i);
			boolean res = isVowel(currChar);
			if(res) {
				if(i%2==0) {
					sb.setCharAt(i, '*');
				}else {
					sb.setCharAt(i, '+');
				}
			}
 		}	
		
		String msg = new String(sb);
		return msg;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPlay w = new WordPlay();
		System.out.println(w.isVowel('a'));
		String newMsg = w.replaceVowels("DeAl with mE", '_');
		System.out.println(newMsg);
		System.out.println(w.emphasize("dna ctgaaactga", 'a'));
		System.out.println(w.emphasize("Mary Bella Abracadabra", 'a'));
		
	}

}
