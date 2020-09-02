package practice;

public class Rough {
	
	public boolean isAorE(char ch) {
		if(ch != 'a') {
			return false;
		}
		return true;
	}
	
	void matchCharacter(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		for(int i=0; i<sb.length();  i++) {
			System.out.println(sb.charAt(i));
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char ch = 'B';
//		ch = Character.toLowerCase(ch);
//		System.out.println(ch);
		
		Rough r = new Rough();
//		System.out.println(r.isAorE('a'));
		
		r.matchCharacter("hello", 'e');
		
		String word = "apprentice";
		if(Character.isLetter(word.charAt(word.length()-1)))
			System.out.println("last character is letter");

	}

}
