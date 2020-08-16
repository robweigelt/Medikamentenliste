package practiceManagementSoftware;

import java.util.List;

import static java.util.stream.IntStream.range;


//Tabea
class HelperFunctions {
    static String makeStringToCapital(){
        System.out.println("Please type in the item you are looking for");
        String item = GetIntOrString.GetmyString();
        return item.toUpperCase();
    }

    static List<String> getList(List <String> mylist) {

        mylist.replaceAll(String::toUpperCase);
        return mylist;
    }
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

    public static String cut(String s, int len){
        return s.substring(0, Math.min(len, s.length()));
    }
}
