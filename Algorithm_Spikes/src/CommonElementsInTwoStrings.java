import java.util.List;
import java.util.ArrayList;
public class CommonElementsInTwoStrings {

    public static void main(String[] args){
    
    List<String> list1 = new ArrayList();
    list1.add("apple");
    list1.add("mango");
    list1.add("grapes");
    
    List<String> list2 = new ArrayList();
    list2.add("apple");
    list2.add("cherry");
    list2.add("pine");

    
    System.out.println(list1.removeAll(list2));

    List<String> commonElements =  new ArrayList();
    list2.removeAll(list1);
    for(String valueList1 : list1) {
        for(String valueList2 : list2) {
            if(valueList1.equalsIgnoreCase(valueList2)) {
                commonElements.add(valueList2);
            }
        }
    }
    
    for(String commonWords : list2) {
        System.out.println(commonWords);
    }
    }  
}