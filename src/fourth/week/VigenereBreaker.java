package fourth.week;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import edu.duke.FileResource;

//public class VigenereBreaker {
//	public String sliceString(String message, int whichSlice, int totalSlice) {
//		StringBuilder answer = new StringBuilder();
//		for(int i=whichSlice; i<message.length(); i = i+totalSlice) {
//			char c = message.charAt(i);
//			answer.append(c);
//		}
//		return answer.toString();
//	}
//	
//	public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
//		
//		int[] key = new int[klength];
//		for(int i=0; i<klength; i++) {
//			CaesarCracker cc = new CaesarCracker(mostCommon);
//			String slice = sliceString(encrypted, i, klength);
//			int sliceKey = cc.getKey(slice);
//			key[i] = sliceKey;
//		}
//		// complete this method
//		return key;
//	}
//	
//	public void breakVigenere() {
//		FileResource fr = new FileResource();
//		String message = fr.asString();
//		message = message.toLowerCase();
//		
//		FileResource f = new FileResource("data/" + "English.txt");
//		
//		int[] key = tryKeyLength(message,4,'e');
//		HashSet<String> word = readDictionary(f);
//		
//		for(int i=0; i<key.length; i++) {
//			System.out.println(key[i]);
//		}
//		VigenereCipher vc = new VigenereCipher(key);
//		String tempString = breakForLanguage(message, word);
//		System.out.println(tempString);
//		System.out.println(vc.decrypt(message));
//		
//	}
//	
//	public HashSet<String> readDictionary(FileResource Fr){
//		HashSet<String> myDictionary = new HashSet<String>();
//		for(String str : Fr.words()) {
//			String input = str.toLowerCase();
//			myDictionary.add(input);
//		}
//		return myDictionary;
//	}
//	
//	private int countWords(String message, HashSet<String> yourDictionay) {
//		int count =0;
//		for(String str : message.split("\\w+")) {
//			if(yourDictionay.contains(str)) {
//				count++;
//			}
//		}
//		return count;
//	}
//	
//	public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
//		
//		int max=0, idxKey =0;
//		String sb = "";
//		
//		
//		for(int i=1; i<=100; i++) {
//			int[] key = new int[i];
//			key = tryKeyLength(encrypted, i, 'e');
//			VigenereCipher vc = new VigenereCipher(key);
//			String decrypted = vc.decrypt(encrypted);
//			int wordCount = countWords(decrypted, dictionary);
//			
//			if(wordCount > max) {
//				max = wordCount;
//				idxKey = i;
//				sb = decrypted;
//			}
//		}
//		
//		System.out.println("key Length: " + idxKey);
//		return sb;
//	}
//
//}

public class VigenereBreaker {
	
	public String sliceString(String message, int whichSlice, int totalSlice) {
		StringBuilder answer = new StringBuilder();
		for(int i=whichSlice; i<message.length(); i = i+totalSlice) {
			char c = message.charAt(i);
			answer.append(c);
		}
		return answer.toString();
	}

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker ob = new CaesarCracker(mostCommon);
        for(int i=0;i<klength;i++)
        {
            String s = sliceString(encrypted,i,klength);
            key[i] = ob.getKey(s);
        }
        
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        String[] allDictionary = new String[] {"Danish", "Dutch", "English", "French", "German", "Italian", "Portuguese", "Spanish"};
        
        HashMap<String, HashSet<String>> myMap = new HashMap<String, HashSet<String>>();
        
        
        for(int i=0; i<allDictionary.length; i++) {
        	String tempStr = allDictionary[i];
        	FileResource tempFile = new FileResource("data/" + tempStr);
        	HashSet<String> mySet = readDictionary(tempFile);
        	myMap.put(tempStr, mySet);
        }
        
        String decrypted = breakForAllLanguage(encrypted,myMap);
        System.out.print(decrypted);
    }
    
    private String breakForAllLanguage(String encrypted, HashMap<String, HashSet<String>> languages) {
		int countMaxWord = 0;
		int maxWords = 0;
		String decrypted = "";
		String language = "";
		
		for(String langName : languages.keySet()) {
			HashSet<String> langDict = languages.get(langName);
			String decrypto = breakForLanguage(encrypted, langDict);
			maxWords = countWords(decrypto, langDict);
			if(maxWords>countMaxWord) {
				countMaxWord = maxWords;
				decrypted = decrypto;
				language = langName;
			}
		}
		System.out.println("Language Name: " + language);
    	return decrypted;
	}

	public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String> words = new HashSet<String>();
        for(String l : fr.words())
        {
            words.add(l.toLowerCase());
        }
        return words;
    }
    private int countWords(String message, HashSet<String>words)
    {
        int sum = 0;
        for(String w : message.split("\\W+"))
        {
            if(words.contains(w))
            {
                sum++;
            }
        }
        return sum;
    }
    public String breakForLanguage(String encrypted, HashSet<String>words)
    {
        int i,max = 0,j = 0;
        int[] temparr = {};
        String p = "";
        char mostChar = mostCommonCharIn(words);
        
        for(i=1;i<=100;i++)
        {
            int [] key = new int [i];
            key = tryKeyLength(encrypted,i, mostChar);
            VigenereCipher object = new VigenereCipher(key);
            String decrypted = object.decrypt(encrypted);
            int sum = countWords(decrypted,words);
            if(sum > max)
            {
                max = sum;
                j = i;
                p = decrypted;
                temparr = key;
            }
        }
        System.out.println("Length : " + j + " valid words: " +max);
        for(int k=0; k<temparr.length; k++) {
        	System.out.println(temparr[k]);
        }
        return p;
    }
    
    public char mostCommonCharIn(HashSet<String> wordList) {
    	HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
    	char resChar = ' ';
    	for(String word : wordList) {
    		for(char ch : word.toCharArray()) {
    			if(!letterCount.containsKey(ch)) {
    				letterCount.put(ch, 1);
    			}else {
    				letterCount.put(ch, letterCount.get(ch)+1);
    			}
    		}
    	}
    	
    	int max = Collections.max(letterCount.values());
    	
    	for(Character ch : letterCount.keySet()) {
    		if(letterCount.get(ch).equals(max)) {
    			resChar = ch;
    		}
    	}
    	
    	return resChar;
    	
    }
    
}
