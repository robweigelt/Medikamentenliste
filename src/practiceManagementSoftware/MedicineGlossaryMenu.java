package practiceManagementSoftware;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.IntStream;


class MedicineGlossaryMenu {
    static void Menu() throws CloneNotSupportedException, IOException {


        System.out.println("Please choose between the different options by pressing the number [] and [Enter]:\n" +
                "[1]Look for specific medicament  \n" +
                "[2]List all medicament's by type  \n" +
                "[0] Return "
        );
        InsideMenuMedicine(GetIntOrString.GetmyInt());
    }


    private static void InsideMenuMedicine(int Switcher) throws CloneNotSupportedException, IOException {
        switch (Switcher) {
            case 0:
                MainMenu.Menu();
                break;
            case 1:
                int a = MedicineGlossaryObject.SelectSearch();
                List <String> myList = MedicineGlossaryObject.switcherMedCategories(a);
                var listInCapitals = HelperFunctions.getList(myList);
                var upperItem = HelperFunctions.makeStringToCapital();
                if (listInCapitals.contains(upperItem)){
                    int[] indexes =
                            IntStream.range(0, listInCapitals.size())
                                    .filter(i -> listInCapitals.get(i).equals(upperItem))
                                    .toArray();

                    for (int b : indexes) {
                        MedicineGlossaryObject.SearchInsideListArray(b);
                    }
                }
                else System.out.println("No Results");
                Menu();
            case 2:
                int b = MedicineGlossaryObject.SelectSearch();

                myList = MedicineGlossaryObject.switcherMedCategories(b);
                var listInCapitalsSelect = HelperFunctions.getList(myList);
                Collections.sort(listInCapitalsSelect);
                LinkedHashSet<String> hashSet = new LinkedHashSet<>(listInCapitalsSelect);
                ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);
                listWithoutDuplicates.replaceAll(String::toUpperCase);
                for (Object element : listWithoutDuplicates) {
                    System.out.println(element);
                }
                Menu();
            default:
                System.out.println("You entered an invalid number");
                Menu();


        }

    }
}
