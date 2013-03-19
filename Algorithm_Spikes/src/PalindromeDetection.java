import java.util.Scanner;
/**
 * 2) Palindrome Detection
	Write a function that determines if a given string is a palindrome. A palindrome is a word or phrase that is spelled exactly the same forwards or backwards, 
	like "pop" or "Ah, Satan sees Natasha". For this question, ignore all non-alphanumeric characters and assume that upper-and lower-case characters are identical. 
	The function should output whether or not the string is a palindrome and return a boolean.
	
	Instructions:
	1) Please enter the input string in the command line.
 
	Note:
	There is many ways to detect a palindrome, another easier approach is to reverse a string and compare.
	But its not cost efficient as it visits all the char in the string and then compares them.
	
 * @author bkrishna
 */
public class PalindromeDetection {

	public static void main(String[] args) {	
		
		Scanner userInput =  new Scanner(System.in);
		System.out.print("Enter the string:");
		String inputString = userInput.nextLine();
		String filteredString = filterNonAlphaNumericCharacters(inputString.toUpperCase());
		System.out.println("Is the given string "+inputString+" a palindrome?"+checkIfPalindrome(filteredString));
	}

	private static boolean checkIfPalindrome(String inputString) {
		int begin = 0;
		int end = inputString.length() - 1;
		boolean isPalindrome = false;
		if(end>=0) {
			while (begin <= end) {
				if (inputString.charAt(begin) == inputString.charAt(end)) {
					begin++;
					end--;
					continue;
				} else {
					isPalindrome = false;
					break;
				}
			}
			if (begin >= end) {
				isPalindrome = true;
			}
		}	
		return isPalindrome;
	}
	
	private static String filterNonAlphaNumericCharacters(String inputString) {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<=inputString.length()-1;i++) {
			if(Character.isLetterOrDigit(inputString.charAt(i))) {
				sb.append(inputString.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
}
