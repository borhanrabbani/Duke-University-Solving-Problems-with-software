package second.week;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class WordsInFiles {
	private HashMap<String,ArrayList> wordMap;
	
	public WordsInFiles() {
		wordMap = new HashMap<String, ArrayList>();
	}
	
	private void addWordsFromFile(File f) {
		String fileName = f.getName();
		FileResource fr = new FileResource(f);
		for(String word : fr.words()) {
			ArrayList<String> files = new ArrayList<String>();
			if(!wordMap.containsKey(word)) {
				files.add(fileName);
				wordMap.put(word, files);
			}else {
//				files.addAll(wordMap.get(fileName));
//				files = wordMap.get(fileName);
				if(files.contains(fileName)) {
					files.add(fileName);
				}
				wordMap.put(fileName, files);
			}
		}
	}
	
	public void buildWordFileMap() {
		wordMap.clear();
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles()) {
			addWordsFromFile(f);
		}
	}
	
	public int maxNumber() {
		int max =0;
		for(String word : wordMap.keySet()) {
			ArrayList<String> files = new ArrayList<String>(wordMap.get(word));
			int numOfFiles = files.size();
			if(numOfFiles>max) {
				max = numOfFiles;
			}
		}
		return max;
	}
	
	 public ArrayList<String> wordsInNumFiles(int n){
		 ArrayList<String> words = new ArrayList<String>();
		 for(String word : wordMap.keySet()) {
			 ArrayList<String> files = new ArrayList<String>(wordMap.get(word));
			 int numOfFiles = files.size();
			 if(numOfFiles == n) {
				 words.add(word);
			 }
		 }
		 return words;
	 }
	 
	 public void printFilesIn(String word) {
		 ArrayList<String> files = new ArrayList<String>(wordMap.get(word));
		 for(String file : files) {
			 System.out.println(file);
		 }
	 }
	 
	 public void tester() {
		 buildWordFileMap();
//		 int maxNumOfFiles = maxNumber();
		 System.out.println("Maximum files any word is in:"+ maxNumber());
		 ArrayList<String> wordsWithMaxFile = wordsInNumFiles(maxNumber());
		 System.out.println("words with this number of files");
		 for(String word : wordsWithMaxFile) {
			 System.out.println(word);
		 }
		 
		 System.out.println(wordMap);
	 }

	public static void main(String[] args) {
		WordsInFiles wf = new WordsInFiles();
		wf.tester();

	}

}
