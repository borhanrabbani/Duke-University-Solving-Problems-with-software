package collection.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestList {
	
	

	public static void main(String args[]) {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Steve");
		alist.add("Tim");
		alist.add("Lucy");
		alist.add("Pat");
		alist.add("Angela");
		alist.add("Tom");

		// displaying elements
		System.out.println(alist);

		// Adding "Steve" at the fourth position
		alist.add(3, "Steve");

		// displaying elements
		System.out.println(alist);

		ArrayList<String> blist = new ArrayList<String>();
		blist.add("Steve");
		System.out.println(blist);
	}

}
