package second.week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import edu.duke.FileResource;
import edu.duke.URLResource;

public class GladLibMap {

	private HashMap<String, ArrayList<String>> myMap;
	private ArrayList<String> checkDuplicate;
	private ArrayList<String> totalCount;
	private Random myRandom;

	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "data";

	public GladLibMap() {
		myMap = new HashMap<String, ArrayList<String>>();
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
		checkDuplicate = new ArrayList<String>();

		totalCount = new ArrayList<String>();

	}

	public GladLibMap(String source) {
		initializeFromSource(source);
		myRandom = new Random();
	}

	private void initializeFromSource(String source) {
		String[] label = { "adjective", "noun", "color", "fruit", "verb", "country", "animal", "name", "timeframe" };

		for (String s : label) {
			ArrayList<String> list = readIt(source + "/" + s + ".txt");
			myMap.put(s, list);
		}
	}

	private String randomFrom(ArrayList<String> source) {
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}

	public String getSubstitute(String label) {

		for(String str : myMap.keySet()) {
			if(str.equals(label)) {
				int idx = totalCount.indexOf(str);
				if(idx == -1) {
					totalCount.add(str);
				}
				
			}
			
		}

		if (label.equals("number")) {
			return "" + myRandom.nextInt(50) + 5;
		}
		return randomFrom(myMap.get(label));
	}

	private String processWord(String str) {
		int first = str.indexOf("<");
		int last = str.indexOf(">", first);
		if (first == -1 || last == -1) {
			return str;
		}
		String prefix = str.substring(0, first);
		String suffix = str.substring(last + 1);
		String sub = getSubstitute(str.substring(first + 1, last));
		int idx = checkDuplicate.indexOf(sub);
		if (idx == -1) {
			checkDuplicate.add(sub);
			return prefix + sub + suffix;
		}
		System.out.println("actually the choosen word was " + sub + " which we couldn't take");
		return processWord(str);
	}

	private void printOut(String s, int lineWidth) {
		int charsWritten = 0;
		for (String w : s.split("\\s+")) {
			if (charsWritten + w.length() > lineWidth) {
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w + " ");
			charsWritten += w.length() + 1;
		}
	}

	private String fromTemplate(String source) {
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for (String word : resource.words()) {
				story = story + processWord(word) + " ";
			}
		} else {
			FileResource resource = new FileResource(source);
			for (String word : resource.words()) {
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}

	private ArrayList<String> readIt(String source) {
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for (String line : resource.lines()) {
				list.add(line);
			}
		} else {
			FileResource resource = new FileResource(source);
			for (String line : resource.lines()) {
				list.add(line);
			}
		}
		return list;
	}

	public void makeStory() {
		checkDuplicate.clear();
		String story = fromTemplate("data/madtemplate.txt");
		printOut(story, 60);
	}

	public void totalWordsInMap() {
//		ArrayList<String> str = new ArrayList<String>();
//		
//		for(String s : myMap.keySet()) {
//			str.addAll(myMap.get(s));
//
//		}
//		
////		for(int i=0; i<str.size(); i++) {
////			System.out.println(str.get(i));;
////		}
//		
////		return str.size();
//		int count =0;
//
//		for (String category : myMap.keySet()) {
//			System.out.println(category);
////			ArrayList<String> str = myMap.get(category);
////			for(String word : str) {
////				System.out.println(word);
////				count++;
////			}
//
//		}
//		System.out.println(count);
		
		System.out.println("\n");
		for(String str : totalCount) {
			System.out.println(str);
		}
		int count = 0;
		System.out.println();
		for(String str : myMap.keySet()) {
			for(String tempStr : myMap.get(str)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public int totalWordsConsidered() {
		int count = 0;
//		ArrayList<String> wordCount = new ArrayList<String>();
		
		for(String str : totalCount) {
			FileResource fr = new FileResource("data/" + str +".txt");
			for(String tempStr : fr.lines()) {
				count++;
			}
			
		}
		
		return count;
	}

	public static void main(String[] args) {
		GladLibMap gm = new GladLibMap();
		gm.makeStory();
		gm.totalWordsInMap();
		System.out.println(gm.totalWordsConsidered());

	}

}
