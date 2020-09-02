package second.week;

import java.util.ArrayList;

import edu.duke.FileResource;

public class WordFrequencies {
	
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;
	
	public WordFrequencies() {
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
	}
	
	public void findUnique() {
		myWords.clear();
		myFreqs.clear();
		
		FileResource fr = new FileResource("data/" + "errors.txt");
		
		for(String word: fr.words()) {
			word = word.toLowerCase();
			int idx = myWords.indexOf(word);
			if(idx == -1) {
				myWords.add(word);
				myFreqs.add(1);
			}else {
				int value = myFreqs.get(idx);
				myFreqs.set(idx, value+1);
			}
		}
		
	}
	
	public int findMaxIndex() {
		int maxIndex = 0;
		for(int i=0; i<myFreqs.size(); i++) {
			if(maxIndex< myFreqs.indexOf(i)) {
				maxIndex = myFreqs.indexOf(i);
			}
		}
		
		return maxIndex;
	}
	
	
	public void tester() {
		findUnique();
		System.out.println("Total Words are: " + myFreqs.size());
		System.out.println(findMaxIndex());
		System.out.println(myWords.get(findMaxIndex()));
		int counter = 0;
		for(int i=0; i<myWords.size(); i++) {
			if(myFreqs.get(i)>=0) {
				counter = counter + myFreqs.get(i);
			System.out.println(myWords.get(i) + " : " + myFreqs.get(i));
		}
		}
		System.out.println(counter);
		
//		System.out.println(myWords.get(3616));
	}
	
	public static void main(String[] args) {
		WordFrequencies wf = new WordFrequencies();
		wf.tester();
	}

}
