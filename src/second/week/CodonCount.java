package second.week;

import java.util.Collections;
import java.util.HashMap;

import edu.duke.FileResource;

public class CodonCount {

	private HashMap<String, Integer> dnaCount;

	public CodonCount() {
		dnaCount = new HashMap<String, Integer>();
	}

	public void buildCodonMap(int start, String dna) {
		dnaCount.clear();
		for (int i = start; i < dna.length();) {
			if ((i + 2) < dna.length()) {
				String str = dna.substring(i, i + 3);
				if (!dnaCount.containsKey(str)) {
					dnaCount.put(str, 1);
				} else {
					dnaCount.put(str, dnaCount.get(str) + 1);
				}
			}
			i = i + 3;
			System.out.println(dnaCount.keySet());
		}
	}

	public String getMostCommonCodon() {
		int max = Collections.max(dnaCount.values());
		for (String s : dnaCount.keySet()) {
			if (dnaCount.get(s) == max)
				return s;
		}

		return null;
	}

	public void printCodonCounts(int start, int end) {
		for (String w : dnaCount.keySet()) {
			if (dnaCount.get(w) >= start && dnaCount.get(w) <= end) {
				System.out.println(w + "     " + dnaCount.get(w));
			}
		}
	}
	
	public void tester() {
		FileResource fr = new FileResource("data/gladlib/" + "dnaMystery2.txt");
		String dna = fr.asString();
		dna = dna.toUpperCase();
		buildCodonMap(0,dna);
		System.out.println("Total number of unique CODONS: " + dnaCount.size());
		System.out.println("Most Common Codon: "+ getMostCommonCodon() + " and it's count: " + dnaCount.get(getMostCommonCodon()));
		printCodonCounts(6,8);
	}

	public static void main(String[] args) {
		CodonCount cc = new CodonCount();
		cc.tester();

	}

}
