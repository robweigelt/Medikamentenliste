package practiceManagementSoftware;

import java.util.List;

import static java.util.stream.IntStream.range;


//Code Robert Weigelt -- Design Hannes Kukulenz--Exception Handling and Code Review Robert Weigelt

//Make Strings to Capital
class HelperFunctions {
    static String makeStringToCapital(){
        System.out.println("Please type in the item you are looking for");
        String item = GetIntOrString.GetmyString();
        return item.toUpperCase();
    }
//Makes every Item in List to Upper-Case
    static List<String> getList(List <String> mylist) {

        mylist.replaceAll(String::toUpperCase);
        return mylist;
    }

    //Finding all the Items
    public static void patientFinder (List <String> listInCapitals, String upperItem) {

        if (listInCapitals.contains(upperItem)) {
            int[] indexes =
                    range(0, listInCapitals.size())
                            .filter(i -> listInCapitals.get(i).equals(upperItem))
                            .toArray();

            for (int b : indexes) {
                try {
                    PatientRecordObject.SearchInsideListArray(b);
                } catch (java.lang.IndexOutOfBoundsException ignored) {
                }

            }
        }
        else System.out.println("No Results");
    }
    //Finding all the Items
    public static void medicamentFinder (List <String> listInCapitals, String upperItem)
    {
        if (listInCapitals.contains(upperItem)){
            int[] indexes =
                    range(0, listInCapitals.size())
                            .filter(i -> listInCapitals.get(i).equals(upperItem))
                            .toArray();

            for (int b : indexes) {
                try {
                    MedicineGlossaryObject.SearchInsideListArray(b);
                } catch (java.lang.IndexOutOfBoundsException ignored) {
                }

            }
        }
        else System.out.println("No Results");
    }
    //Design: Helper for Results
    public static String cut(String s, int len){
        return s.substring(0, Math.min(len, s.length()));
    }
}
