package collection.framework;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<String, String> words = new HashMap<>();
		words.put("Perseverance", "persistence in doing something difficulty or delay in achieving success");
		words.put("Tenacity", "The quality or fact of being able to grip something firmly");
		words.put("Steep", "(of a slope, flight of stairs, or angle) rising or falling sharply; almost perpendicular");
		words.put("giggle", "Laugh lightly and repeatedly in a silly way, from amusement, nervousness or embarrasment");
		words.put("Guffaw", "A loud and hearty lough");
		
		for(Map.Entry<String, String> entry : words.entrySet()) {
			System.out.println(entry.getKey() + " == " + entry.getValue());
		}
		
		for(String key: words.keySet()) {
			System.out.println(key + " == " + words.get(key));
		}

	}

}
