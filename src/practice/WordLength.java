package practice;

import edu.duke.FileResource;

public class WordLength {
	
	public void countWordLengths(FileResource resource, int[] counts) {
		for(String word: resource.words()) {
			int len=0;
			StringBuilder sb = new StringBuilder(word);
			for(int i=0; i<sb.length(); i++) {
				char currChar = sb.charAt(i);
				if(Character.isLetter(currChar)) {
					len++;
				}
			}
			System.out.println(word);
			for(int i=0; i<counts.length; i++) {
				if(len == i) {
					counts[i]++;
					break;
				}
			}
		}
		
		for(int k=0; k<counts.length; k++) {
			if(counts[k]!=0) {
				System.out.println(k + " length words are:" + counts[k]);

			}
		}
	}
	
	public void testCountWordLengths() {
		String[] plays = {"small.txt"};
		int[] counts = new int[31];
		for(int k=0; k<plays.length; k++) {
			FileResource fr = new FileResource("data/" + plays[k]);
			countWordLengths(fr, counts);
		}
		
	}
	
	public static void main(String[] args) {
		WordLength wl = new WordLength();
		wl.testCountWordLengths();
	}

}
