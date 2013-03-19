import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

	public static void main(String[] args) {
		
		String initialString = "abc";
		ArrayList<String> values = findPermutedString(initialString);
		for(String value : values) {
			System.out.println(value);
		}	
	}
	
	public static ArrayList<String> findPermutedString(String initialString) {
		ArrayList<String> permutedStrings = new ArrayList();
		if(initialString == null){
			return null;
		} else if(initialString.length()==0){
			 permutedStrings.add("");
			 return permutedStrings;
		}
		char initialChar = initialString.charAt(0);
		String remainingString = initialString.substring(1);
		ArrayList<String> words = findPermutedString(remainingString);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutedStrings.add(insertCharAt(word, initialChar, j)); 
				//return permutedStrings;
			}
		}
		return permutedStrings;
	}
	
	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
}
