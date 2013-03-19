import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class removeDuplicatesInString {

	public static void main(String[] args){
		
		String testString = "aabbbgghhh";
		removeDuplicates(testString.toCharArray());
	}
	
	public static void removeDuplicates(char[] str) {
	    if (str == null)
	        return;
	    int len = str.length;
	    if (len < 2)
	        return;
	    int tail = 1;
	    for (int i = 1; i < len; ++i) {
	        int j;
	        for (j = 0; j < tail; ++j) {
            if (str[i] == str[j])
	                break;
	            }
	            if (j == tail) {
	                str[tail] = str[i];
	                ++tail;
	            }
	    }
	    str[tail] = 0;
	    
	    System.out.println(str);
	
}
	
}



/*public static void main(String[] args) {
	String duplicateString = "zzzyyyaabbcc";
	int count = 0;
	for(int i=0; i<=duplicateString.length()-1;i++){
		int charvalue = duplicateString.charAt(i);
		for(int j=0; j<=duplicateString.length()-1;j++) {
			if(charvalue==duplicateString.charAt(j) && count==0){
				count++;
			} else if(charvalue==duplicateString.charAt(j) && count>0){
				
			}
		}
		
	}
	
}*/

/*public static void main(String[] args) {
	String duplicateString = "zzzyyyaabbcc";
	Set<Character> characters =  new TreeSet<Character>();
	for(int i=0; i<=duplicateString.length()-1;i++){
		characters.add(duplicateString.charAt(i));
	}
	StringBuilder sb = new StringBuilder();
	for(Character c : characters){
		sb.append(c);
	}
	System.out.println(sb.toString());
}*/