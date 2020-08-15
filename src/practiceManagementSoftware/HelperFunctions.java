package practiceManagementSoftware;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.IntStream;

import static com.sun.jmx.mbeanserver.Util.cast;
import static java.util.stream.IntStream.*;


//Tabea
class HelperFunctions {
    static @NotNull String makeStringToCapital(){
        System.out.println("Please type in the item you are looking for");
        String item = GetIntOrString.GetmyString();
        return item.toUpperCase();
    }

    static @NotNull List<String> getList(List <String> mylist) {

        List<String> list;
        mylist.replaceAll(String::toUpperCase);
        return mylist;
    }
    public static void patientFinder (@NotNull List <String> listInCapitals, String upperItem) {

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

    public static void medicamentFinder (@NotNull List <String> listInCapitals, String upperItem)
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
}
