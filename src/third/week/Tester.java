package third.week;

import java.util.ArrayList;

public class Tester {
	
	public void testLogAnalyzer() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog1_log.txt");
//		la.printAll();
//		la.printAllHigherThanNum(400);
		System.out.println(la.countUniqueIPsInRange(200, 299));
	}
	
	public void testUniqueIP() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog2_log.txt");
		System.out.println(la.countUniqueIPs());
	}
	
	public void onDayTest() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog2_log.txt");
		ArrayList<String> dayTest = la.uniqueIPVisitsOnDay("Sep 24");
		for(String str : dayTest) {
			System.out.println(str);
		}
		
		System.out.println(dayTest.size());
	}
	
	public static void main(String[] args) {
		Tester t = new Tester();
//		t.testLogAnalyzer();
//		t.testUniqueIP();
////		t.onDayTest();
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog2_log.txt");
		System.out.println(la.countUniqueIPsInRange(400, 499));
//		t.testLogAnalyzer();
//		t.onDayTest();
	}

}
