package r.w;




import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;


class ControllerMedicineGlossary {
    static void Menu() throws CloneNotSupportedException, IOException {


        System.out.println("Please choose between the different options by pressing the number [] and [Enter]:\n" +
                "Look for specific medicament [1] \n" +
                "List all medicament's by type [2] \n" +
                "Return [0]"
        );
        InsideMenuMedicine(GetIntOrString.GetmyInt());
    }


    private static void InsideMenuMedicine(int Switcher) throws CloneNotSupportedException, IOException {
        switch (Switcher) {
            case 0:
                Controller.Menu();
                break;
            case 1:
                int a = MedListO.SelectSearch();
                List myList = MedListO.switcherMedCategories(a);
                var listInCapitals = ListFunctions.getList(myList);
                var upperItem = ListFunctions.makeStringToCapital();
                if (listInCapitals.contains(upperItem)){
                    int[] indexes =
                            IntStream.range(0, listInCapitals.size())
                                    .filter(i -> listInCapitals.get(i).equals(upperItem))
                                    .toArray();

                    for (int b : indexes) {
                        MedListO.SearchInsideListArray(b);
                    }
                }
                else System.out.println("No Results");
                Menu();
                break;
            case 2:
                int b = MedListO.SelectSearch();

                myList = MedListO.switcherMedCategories(b);
                var listInCapitalsSelect = ListFunctions.getList(myList);
                Collections.sort(listInCapitalsSelect);
                ArrayList<String> listWithoutDuplicates = new ArrayList<>(listInCapitalsSelect);
                listWithoutDuplicates.replaceAll(String::toUpperCase);
                for (Object element : listWithoutDuplicates) {
                    System.out.println(element);
                }
                Menu();


                break;






            default:
                System.out.println("You entered an invalid number");
                Menu();


        }

    }
}