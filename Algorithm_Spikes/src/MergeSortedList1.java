
public class MergeSortedList1 {

	public static void main(String[] args) {
		
		Integer[] arrayOne = {2,4,6,6,8,9};
		Integer[] arrayTwo = {1,3,5,7,8,9,10};
		
		int arrayOneLength = arrayOne.length;
		int arrayTwoLength = arrayTwo.length;
		
		int countOne = 0;
		int countTwo = 0;
		Integer[] finalArray = new Integer[arrayOneLength+arrayTwoLength];
		int finalCount = 0;
		
		while(countOne<=arrayOneLength-1 && countTwo<=arrayTwoLength-1) {
			if(arrayOne[countOne]<arrayTwo[countTwo]) {
				finalArray[finalCount] = arrayOne[countOne];
				countOne++;
			} else {
				finalArray[finalCount] = arrayTwo[countTwo];
				countTwo++;
			}
			finalCount++;
		}
		
		if(countOne<=arrayOneLength-1) {
			for(int i=countOne; i<arrayOneLength; i++){
				finalArray[finalCount]= arrayOne[i];
				finalCount++;
				countOne++;
			}	
		} else if(countTwo<=arrayTwoLength-1) {
			for(int i=countTwo; i<arrayTwoLength;i++) {
				finalArray[finalCount]= arrayTwo[i];
				countTwo++;
				finalCount++;
			}
		}
		
		for(int i=0;i<=finalArray.length-1;i++) {
			System.out.print(finalArray[i]);
		}
			
	}
}
