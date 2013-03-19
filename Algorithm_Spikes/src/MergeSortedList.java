public class MergeSortedList {

	public static void main(String[] args) {
		
		Integer[] arrayOne = {2,4,6,6,8,9};
		Integer[] arrayTwo = {1,3,5,7,8,9,10};
		
		int arraySize = arrayOne.length+arrayTwo.length;
		Integer[] sortedList = new Integer[arraySize];
		int k = 0;
		int i = 0;
		int j = 0;
		for(i=0; i<=arrayOne.length-1;) {
			for( j=0; j<=arrayTwo.length-1;){
				if(arrayOne[i]<arrayTwo[j]){
					sortedList[k]=arrayOne[i];
					i++;
				} else {
					sortedList[k]=arrayTwo[j];
					j++;
				}
				k++;
				if(j<arrayTwo.length && (i==arrayOne.length)){
					 sortedList[k]=arrayTwo[j];
					 j++;
				}
			}
			if(i<arrayOne.length && (j==arrayTwo.length)){
				 sortedList[k]=arrayOne[i];
				 i++;
			} 
		}
		for(int f =0; f<sortedList.length;f++){
			System.out.println("This is the sorted list"+sortedList[f]);
		}
	}
}
