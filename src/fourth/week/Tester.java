package fourth.week;

import java.util.HashSet;

import edu.duke.FileResource;

public class Tester {

	public static void main(String[] args) {
//		FileResource fr = new FileResource("data/" + "Spanish");
		
		
//		CaesarCipher cc = new CaesarCipher(1);
//		System.out.println(cc.encrypt(tempStr));
//		System.out.println(cc.decrypt(tempStr));
		
//		CaesarCracker cc = new CaesarCracker('a');
//		String result = cc.decrypt(tempStr);
//		System.out.println(result);
		
//		int[] key = {17,14,12,4};
		
//		VigenereCipher vc = new VigenereCipher(key);
//		System.out.println(vc.encrypt(tempStr));
//		System.out.println(vc.decrypt(tempStr));
		
		VigenereBreaker vb = new VigenereBreaker();
		vb.breakVigenere();
//		System.out.println(vb.mostCommonCharIn(temp));;
//		System.out.println(vb.sliceString("abcdefghijklm", 4, 5));
		
//		int[] tempArr = vb.tryKeyLength(tempStr, 5, 'e');
//		for(int i=0; i<tempArr.length; i++) {
//			System.out.println(tempArr[i]);
//		}

	}

}
