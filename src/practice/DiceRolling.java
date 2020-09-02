package practice;

import java.util.Random;

public class DiceRolling {
	
	static void simulate(int rolls) {
		Random rand = new Random();
		int [] counts = new int[13];
		
		for(int k=0; k < rolls; k++) {
			int d1 = rand.nextInt(6)+1;  
			int d2 = rand.nextInt(6) + 1;
			System.out.println("before incr::: "  +(d1+d2)+  " happened: " +counts[d1+d2]);
			counts[d1+d2]++;
			System.out.println(d1 + "   " + d2 +"  "+counts[d1+d2]);
		}
		
		for(int k=0; k<counts.length; k++) {
			System.out.println(k +"'s=\t" + counts[k] + "\t" + 100.0 * counts[k]/rolls);
		}
	}
	
	static void simpleSimulate(int rolls) {
		Random rand = new Random();
		int twos = 0;
		int twelves = 0;
		int sixes=0;
		
		for(int k=0; k < rolls; k++) {
			int d1 = rand.nextInt(7);  
			int d2 = rand.nextInt(6) + 1;
			if(d1+d2 == 2) {
				twos++;
			}else if(d1+d2 == 6) {
				sixes++;
			}
			else if(d1+d2 == 12) {
				twelves++;
			}
		}
		
		System.out.println("2's=\t" + twos + "\t" + 100.0 * twos/rolls);
		System.out.println("12's=\t" + twelves + "\t" + 100.0 * twelves/rolls);
		System.out.println("6's=\t" + sixes);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simpleSimulate(100);
		simulate(50);

	}

}
