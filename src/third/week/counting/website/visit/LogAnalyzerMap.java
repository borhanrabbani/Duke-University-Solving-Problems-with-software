package third.week.counting.website.visit;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import edu.duke.FileResource;

public class LogAnalyzerMap {
	
	private ArrayList<LogEntryMap> records;
	
	public LogAnalyzerMap() {
		records = new ArrayList<LogEntryMap>();
		
	}
	
	public void readFile(String fileName) {
		FileResource fr = new FileResource("data/" + fileName);
		for(String entry : fr.lines()) {
			WebLogParserMap wp = new WebLogParserMap();
			records.add(wp.parseEntry(entry));
		}
	}
	
	public HashMap<String,Integer> countVisitsPerIP(){
		HashMap<String,Integer> ipCount = new HashMap<String, Integer>();
		for(LogEntryMap le : records) {
			String ipAddr = le.getIpAddress();
			if(!ipCount.containsKey(ipAddr)) {
				ipCount.put(ipAddr, 1);
			}else {
				ipCount.put(ipAddr, ipCount.get(ipAddr)+1);
			}
		}
		
		return ipCount;
	}
	
	public int mostNumberVisitsByIP(HashMap<String, Integer> myMap){

		
		return Collections.max(myMap.values());
	}
	
	public ArrayList<String> iPsMostVisits(HashMap<String, Integer> myMap){
		ArrayList<String> maxIps = new ArrayList<String>();
		int max = Collections.max(myMap.values());
		for(String str : myMap.keySet()) {
			if(myMap.get(str)==max) {
				maxIps.add(str);
			}
		}
		
		return maxIps;
	}
	
	public HashMap<String,ArrayList<String>> iPsForDays() {
		HashMap<String,ArrayList<String>> dateMap = new HashMap<String, ArrayList<String>>();
		
		for(LogEntryMap le : records) {
			ArrayList<String> ip = new ArrayList<String>();
			String currDate = le.getAccessTime().toString().substring(4, 7)+ " "+ le.getAccessTime().toString().substring(8, 10);
			String currIp = le.getIpAddress();
//			System.out.println(currDate + "   " + currIp);
			
			if(!dateMap.containsKey(currDate)) {
				ip.clear();
				ip.add(currIp);
				dateMap.put(currDate, ip);
			}else{
				ip = dateMap.get(currDate);
				ip.add(currIp);
				dateMap.put(currDate, ip);
			}
			
		}
		
		return dateMap;
	}
	
	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> dateMap) {
		String maxDate = "";
		for(LogEntryMap le : records) {
			int maxNum =0;
			String str = le.getAccessTime().toString().substring(4, 7)+ " "+ le.getAccessTime().toString().substring(8, 10);
			if(dateMap.containsKey(str)) {
				int currNum = dateMap.get(str).size();
				if(currNum > maxNum) {
					maxNum = currNum;
					maxDate = str;
				}
			}
		}
		return maxDate;
	}
	
	public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> dateMap, String day){
		
		ArrayList<String> ipsOnGivenDay = dateMap.get(day);
		
		HashMap<String, Integer> ipCount = new HashMap<String, Integer>();
		for(String str : ipsOnGivenDay) {
			if(!ipCount.containsKey(str)) {
				ipCount.put(str, 1);
			}else {
				ipCount.put(str, ipCount.get(str)+1);
			}
		}
		
		return iPsMostVisits(ipCount);
		
	}
	
	
	public void printAll() {
		for(LogEntryMap le : records) {
			System.out.println(le);
		}
	}
	
}
