public class Permutations {

	public static void main(String[] args) {
		int n = 3;
		System.out.println("Permutation of a number: "+ permutationOfNumber(n));
	}
	
	private static int permutationOfNumber(int n) {
		
		if(n==1){
			return 1;
		}
		else {
			return n*permutationOfNumber(n-1);
		}		
	}
}
