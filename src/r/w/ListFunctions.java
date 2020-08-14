package r.w;

import java.util.List;

import static com.sun.jmx.mbeanserver.Util.cast;

class ListFunctions {
    static String makeStringToCapital(){
        System.out.println("Please type in the item you are looking for");
        String item = GetIntOrString.GetmyString();
        return item.toUpperCase();
    }

    static List<String> getList(List <String> mylist) {

        List<String> list;
        list = cast(mylist);
        list.replaceAll(String::toUpperCase);
        return list;
    }

}
