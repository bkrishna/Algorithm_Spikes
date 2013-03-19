public class CheckPalindrome {
	
	public static void main(String[] args) {
		
		String inputString = "appppa isi appppa b";
		int j = inputString.length()-1;
		for(int i=0; i<inputString.length()-1;) {
				if(i==j){
					System.out.println("It is a palindrome");
					break;
				} else if(i+1==j){
					if(inputString.charAt(i)==inputString.charAt(j)){
						System.out.println("It is a palindrome");
						break;
					} else {
						System.out.println("This is not a palindrome");
						break;
					}
				} else {
					if(inputString.charAt(i)==inputString.charAt(j)) {
						i++;
						j--;
						continue;
					} else {
						System.out.println("This is not a palindrome");
						break;
					}
				}
		}
	}
}
