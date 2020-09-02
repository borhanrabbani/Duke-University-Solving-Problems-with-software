package second.week;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class WordsInFilesMap {
	private HashMap<String, ArrayList<String>> wordMap;
	ArrayList<String> myArray;

	public WordsInFilesMap() {
		wordMap = new HashMap<String, ArrayList<String>>();
	}

//	private void addWordsFromFile(File f) {
//		String fname = f.getName();
//		FileResource fr = new FileResource(f);
//		for (String str : fr.words()) {
//			ArrayList<String> files = new ArrayList<String>();
//			if (!wordMap.containsKey(str)) {
//				files.add(fname);
//				wordMap.put(str, files);
//			} else {
//				ArrayList<String> newfiles = wordMap.get(str);
//				for (String fileStr : newfiles) {
//					if (fileStr != fname) {
//						files.add(fname);
//					}
//				}
//			}
//		}
//	}
//
//	public void buildWordFileMap() {
//		wordMap.clear();
//		DirectoryResource dr = new DirectoryResource();
//		for (File f : dr.selectedFiles()) {
//			addWordsFromFile(f);
//		}
//	}

	private void addWordsFromFile(File f) {
		FileResource fr = new FileResource(f);
		for (String word : fr.words()) {
//			word = word.toLowerCase();
			if (!wordMap.keySet().contains(word)) {
				myArray = new ArrayList<String>();
				myArray.add(f.getName());
				wordMap.put(word, myArray);
			} else {
				myArray = wordMap.get(word);
				if (!myArray.contains(f.getName())) {
					myArray.add(f.getName());
				}
				wordMap.put(word, myArray);
			}
		}
	}

	public void buildWordFileMap() {
		wordMap.clear();
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			addWordsFromFile(f);
		}
	}

	public int maxNumber() {
		int max = 0;
		int curr = 0;
		for (ArrayList<String> temp : wordMap.values()) {
			curr = temp.size();
			if (curr > max) {
				max = curr;
			}
		}
		return max;
	}

	public ArrayList<String> wordsInNumFiles(int number) {
		int myArraySize = 0;// number of times words appear in the array
		ArrayList<String> collection = new ArrayList<String>();
		for (String word : wordMap.keySet()) {
			myArray = wordMap.get(word);
			myArraySize = myArray.size();
			if (myArraySize == number) {
				collection.add(word);
			}
		}
		return collection;
	}

//	public ArrayList<String> wordsInNumFiles(int number) {
//		ArrayList<String> words = new ArrayList<String>();
//		int counter = 0;
//		for (String str : wordMap.keySet()) {
//			counter = wordMap.get(str).size();
//			if (counter == number) {
//				words.add(str);
//			}
//		}
//
//		return words;
//	}

	public void printFilesIn(String word) {

		ArrayList<String> tempList = wordMap.get(word);
		for (String str : tempList) {
			System.out.println(str);
		}
	}

	public void tester() {
		buildWordFileMap();
//		System.out.println("Maximum files any word is in:" + maxNumber());
//		ArrayList<String> wordsWithMaxFile = wordsInNumFiles(4);
//		System.out.println("words with this number of files" + wordsWithMaxFile.size());
//		for (String word : wordsWithMaxFile) {
//			System.out.println(word);
//		}
//
//		System.out.println(wordMap);
		ArrayList<String> temp = wordMap.get("tree");
		for(String str : temp) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		WordsInFilesMap wm = new WordsInFilesMap();
		wm.tester();
	}

}
