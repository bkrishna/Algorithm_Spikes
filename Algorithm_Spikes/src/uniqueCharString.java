public class uniqueCharString {

	public static void main(String[] args){
		String value = "ABVHJK*&()";
		int[] occurence = new int[256];
		if(value !=null && value!=""){
			boolean uniquechar = true;
			for(int i=0;i<value.length();i++){
				int location = value.charAt(i);
				System.out.println(location);
				int j =occurence[location];
				occurence[location] = j+1;
				if(j+1>1){
					System.out.println("There is no unique characters");
					uniquechar = false;
					break;
				}	
			}
			if(uniquechar){
				System.out.println("There is unique characters");
			}
		} else {
			System.out.println("The input is empty or not valid");
		}
	}	
}
