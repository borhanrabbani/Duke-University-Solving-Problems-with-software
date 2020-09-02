package practice;

public class CaesarBreaker {

	public String halfOfString(String message, int start) {

//		StringBuilder sb = new StringBuilder(message);
		String tempMessage = "";

		for (int i = start; i < message.length(); i=i+2) {
			tempMessage = tempMessage + message.charAt(i);
		}
		
		return tempMessage;
	}
	
	
	
	
	

	public static void main(String[] args) {
//		CaesarBreaker cb = new CaesarBreaker();
//		String evenText = cb.halfOfString("Just a test string with lots of eeeeeeeeeeeeeeeees", 23);
//		String oddText = cb.halfOfString("Just a test string with lots of eeeeeeeeeeeeeeeees", 2);
//		System.out.println(evenText);
//		System.out.println(evenText.length());
//		int len = evenText.length() + oddText.length();
//		System.out.println(len);
//		String strArr[]	= new String[len];
//		strArr[0] = "abc";
//		for(int i=0; i<strArr.length; i++) {
//			strArr[i] = "a";
//			System.out.println(strArr[i]);
//		}
//		System.out.println(strArr);
	}

}


//if(i%2==0) {
//	String tempStr = ""; 
//	tempStr = tempStr + evenText.charAt(i);
//	strArr[i] = tempStr;
//}else if(i%2 !=0) {
//	String tempStr = ""; 
//	tempStr = tempStr + oddText.charAt(i);
//	strArr[i] = tempStr;
//}