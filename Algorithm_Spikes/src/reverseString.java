
public class reverseString {

    public static void main(String[] args) {
    
        String testString = "bhagavathy";
        StringBuffer sb = new StringBuffer();
         
        for(int i=testString.length()-1;i>=0; i--) {  
            sb.append(testString.charAt(i));   
        }
        System.out.println(sb.toString());
    }

}