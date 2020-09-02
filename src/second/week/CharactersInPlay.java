package second.week;

import java.util.ArrayList;

import edu.duke.FileResource;

public class CharactersInPlay {
	
	private ArrayList<String> names;
	private ArrayList<Integer> counts;
	
	public CharactersInPlay() {
		names = new ArrayList<String>();
		counts = new ArrayList<Integer>();
	}
	
	public void update(String person) {
		int index = names.indexOf(person);
		if(index == -1) {
			names.add(person);
			counts.add(1);
		}else {
			int value = counts.get(index);
			counts.set(index, value+1);
		}
		
	}
	
	public void findAllCharacters() {
		names.clear();
		counts.clear();
		
		FileResource fr = new FileResource("data/" + "errors.txt");
		for(String line: fr.lines()) {
			line = line.toLowerCase();
//			System.out.println(line);
			int index = line.indexOf(".");
			if(index != -1) {
				String str = line.substring(0, index);
				update(str);
			}
		}
		
	}
	
	public void tester() {
		findAllCharacters();
		for(int i=0; i<names.size(); i++) {
			if(counts.get(i)>=10 && counts.get(i)<=15) {
				System.out.println(names.get(i) + " : " + counts.get(i));
			}
			
		}
	}
	
	public void charactersWithNumParts(int num1, int num2) {
		if(num1<=num2) {
			
		}
	}

	public static void main(String[] args) {
		CharactersInPlay cp = new CharactersInPlay();
		cp.tester();
	}

}
