package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import edu.duke.FileResource;

public class CountWords {
	
	static String[] getCommon() throws IOException {
		FileResource fr = new FileResource("data/common.txt");
		String[] common = new String[20];
		int index = 0;
		for(String s : fr.words()) {
			common[index] = s;
			index +=1;
		}
		return common;
	}
	
	public int indexOf(String[] list, String word) {
		
		for(int k=0; k<list.length; k++) {
			if(list[k].equals(word)) {
				return k;
			}
		}
		
		return -1;
	}
	
	public void countWords(FileResource fr, String[] common, int[] counts) {
		for(String word : fr.words()) {
			word = word.toLowerCase();
			int index = indexOf(common, word);
			if(index != -1) {
				counts[index] += 1;
			}
		}
	}
	
	void countShakespeare() throws IOException {
		String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", 
						"macbeth.txt", "romeo.txt"};
		
//		String[] plays = {"likeit.txt"};
		
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for(int k=0; k<plays.length; k++) {
			FileResource fr = new FileResource("data/" + plays[k]);
			countWords(fr, common, counts);
			System.out.println("done with " + plays[k]);
		}
		
		for(int k=0; k<common.length; k++) {
			System.out.println(common[k] + "\t" + counts[k]);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CountWords cw = new CountWords();
		cw.countShakespeare();

	}

}
