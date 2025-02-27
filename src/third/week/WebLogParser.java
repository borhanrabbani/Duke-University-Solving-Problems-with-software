package third.week;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WebLogParser {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:kk:mm:ss Z", Locale.getDefault());
	private static String munchTo(StringBuilder sb, String delim) {
		int x = sb.indexOf(delim);
		if( x==-1) {
			x = sb.length();
		}
		String ans = sb.substring(0,x);
		sb.delete(0, x+delim.length());
		return ans;
	}
	
	public static LogEntry parseEntry(String line) {
		StringBuilder sb = new StringBuilder(line);
		String ip = munchTo(sb, " ");
		munchTo(sb, " ");
		munchTo(sb, " [");
		String dateStr = munchTo(sb, "] \"");
		Date date = parseDate(dateStr);
		String request = munchTo(sb, "\" ");
		String statusStr = munchTo(sb, " ");
		int status = Integer.parseInt(statusStr);
		String byteStr = munchTo(sb, " ");
		int bytes = Integer.parseInt(byteStr);
		return new LogEntry(ip, date, request, status, bytes);
		
	}

	private static Date parseDate(String dateStr) {
		ParsePosition pp = new ParsePosition(0);
		return dateFormat.parse(dateStr,pp);
	}

}
