package third.week.counting.website.visit;

import java.util.ArrayList;
import java.util.HashMap;import java.util.Map;

public class TesterMap {
	
	public void testCounter() {
		LogAnalyzerMap la = new LogAnalyzerMap();
		la.readFile("weblog2_log.txt");
		HashMap<String,Integer> counts = la.countVisitsPerIP();
		System.out.println(counts);
		System.out.println(la.mostNumberVisitsByIP(counts));
		ArrayList<String> holdIp = la.iPsMostVisits(counts);
//		for(String ip : holdIp) {
//			System.out.println(ip);
//		}
		HashMap<String,ArrayList<String>> dateIp = la.iPsForDays();
//		for(String str : dateIp.keySet()) {
//			System.out.println(str+ " = ");
//			for(String str1 : dateIp.get(str)) {
//				System.out.println(str1);
//			}
//		}
		
		System.out.println(la.dayWithMostIPVisits(dateIp));
		
		ArrayList<String> specificIpOnAday = la.iPsWithMostVisitsOnDay(dateIp, "Sep 30");
		for(String ip : specificIpOnAday) {
			System.out.println(ip);
		}
		
	}
	
	public static void main(String[] args) {
		TesterMap tm = new TesterMap();
		tm.testCounter();
	}

}
