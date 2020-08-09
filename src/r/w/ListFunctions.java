package r.w;

import java.util.ArrayList;
import java.util.List;

public class ListFunctions {
    static String makeStringToCapital(){
        System.out.println("Please type in the item you are looking for");
        String item = GetIntOrString.GetmyString();
        return item.toUpperCase();
    }

    public static List<String> getList(List mylist) {
        List<String> list = new ArrayList<String>(mylist);
        list.replaceAll(String::toUpperCase);
        return list;
    }
}
