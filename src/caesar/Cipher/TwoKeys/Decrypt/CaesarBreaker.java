package caesar.Cipher.TwoKeys.Decrypt;

import edu.duke.FileResource;

public class CaesarBreaker {
	
	public int[] countLetters(String input) {
		StringBuilder encrypted = new StringBuilder(input);
		String alph = "abcdefghijklmnopqrstuvwxyz";
		int [] counts = new int[26];
		for(int i=0; i<encrypted.length(); i++) {
			char ch = Character.toLowerCase(encrypted.charAt(i));
			int idx = alph.indexOf(ch);
			if(idx != -1) {
				counts[idx] += 1;
			}
		}
		
		return counts;
	}
	
	public int maxIndex(int[] vals) {
		int maxIdx = 0;
		for(int i=0; i<vals.length; i++) {
			if(vals[i]>vals[maxIdx]) {
				maxIdx = i;
			}
		}
		
		return maxIdx;
	}
	
	public String halfOfString(String message, int start) {
		StringBuilder halfOfString = new StringBuilder(message);
		for(int i=0; i<message.length(); i++) {
			char c = message.charAt(i);
			if((start%2 == 0) && (i%2 == 0)) {
				halfOfString.append(c);
			}else if(((start %2)!=0) && (i%2!=0)) {
				halfOfString.append(c);
			}
		}
		String half = halfOfString.toString();
		return half;
	}
	
	public int getKey(String s) {
		int[] counts = countLetters(s);
		int maxIdx = maxIndex(counts);
		int dkey = maxIdx - 4;
		if(maxIdx < 4) {
			dkey = 26 - (4-maxIdx);
		}
		
		return dkey;
	}
	
	public void decryptTwoKeys(String encrypted) {
		String firstHalf = halfOfString(encrypted, 0);
		String secondHalf = halfOfString(encrypted, 1);
		
		int dkey1 = getKey(firstHalf);
		int dkey2 = 3;//getKey(secondHalf);
		
		System.out.println("dkey1 = " + dkey1 );
		System.out.println("dkey2 = " + dkey2 );
		
		CaesarCipher cc = new CaesarCipher();
		for(int i=1; i<27; i++) {
			System.out.println(cc.encryptTwoKeys(encrypted, 26-dkey1, 26-i));
		}
		
	}
	
	public void testdecryptTwoKeys() {
		FileResource fr = new FileResource("data/" + "mysteryTwoKeyDecrypt.txt");
//		FileResource fr = new FileResource("data/" + plays[k]);
		String encrypted = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";//fr.asString();
//		String encrypted = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
		decryptTwoKeys(encrypted);
//		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		CaesarBreaker cb = new CaesarBreaker();
		cb.testdecryptTwoKeys();
	}

}
