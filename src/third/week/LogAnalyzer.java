package third.week;

import java.util.ArrayList;
import java.util.Date;

import edu.duke.FileResource;

public class LogAnalyzer {
	
	private ArrayList<LogEntry> records;
	
	public LogAnalyzer() {
		records = new ArrayList<LogEntry>();
	}
	
	public void readFile(String fileName) {
		FileResource fr = new FileResource("data/" + fileName);
		for(String entry : fr.lines()) {
			WebLogParser wp = new WebLogParser();
			records.add(wp.parseEntry(entry));
		}
	}
	
	public int countUniqueIPs() {
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for(LogEntry le : records) {
			String ipAddr = le.getIpAddress();
			if(!uniqueIPs.contains(ipAddr)) {
				uniqueIPs.add(ipAddr);
			}
		}
		
		return uniqueIPs.size();
	}
	
	public void printAllHigherThanNum(int num) {
		
		for(LogEntry le : records) {
			int stat = le.getStatusCode();
			if(stat>num) {
				System.out.println(le);
			}
		}
	}
	
	public ArrayList<String> uniqueIPVisitsOnDay(String someday){
		ArrayList<String> specificDay = new ArrayList<String>();
		
		for(LogEntry le : records) {
			String currDate = le.getAccessTime().toString().substring(4, 7)+ " "+ le.getAccessTime().toString().substring(8, 10);
			if(someday.equals(currDate)) {
				String ipAddr = le.getIpAddress();
				if(!specificDay.contains(ipAddr)) {
					specificDay.add(ipAddr);
				}
			}
		}
		
		return specificDay;
		
	}
	
	public int countUniqueIPsInRange(int low, int high) {
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for(LogEntry le : records) {
			String ipAddr = le.getIpAddress();
			if(!uniqueIPs.contains(ipAddr)) {
				if((le.getStatusCode()>=low && le.getStatusCode()<=high))
				uniqueIPs.add(ipAddr);
			}
		}
		return uniqueIPs.size();
	}
	
	public void printAll() {
		for(LogEntry le : records) {
			System.out.println(le);
		}
	}
	
}
