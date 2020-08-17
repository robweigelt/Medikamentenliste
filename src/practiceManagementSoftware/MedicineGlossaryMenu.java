package practiceManagementSoftware;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;


//Code Robert Weigelt -- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt
class MedicineGlossaryMenu {
    //Submenu
    static void Menu() throws CloneNotSupportedException, IOException {
        System.out.print("__________________________________________\n"+
                "Main Menu\n"+
                "⌞ Medicine Glossar Menu \n\n"+
                "[1] Look for specific medicament  \n" +
                "[2] List all medicaments by type  \n" +
                "[-] \n" +
                "[0] Return\n\n"+
                "Enter choice here: ");
        InsideMenuMedicine(GetIntOrString.GetmyInt());
    }
//Contoller for Switching between the
    private static void InsideMenuMedicine(int Switcher) throws CloneNotSupportedException, IOException {
        switch (Switcher) {
            case 0:
                MainMenu.Menu();
            case 1:
                System.out.println("__________________________________________\n"+
                        "Main Menu\n"+
                        "⌞ Medicine Glossary Menu\n"+
                        "  ⌞ Look for specific medicament\n");
                int a = MedicineGlossaryObject.SelectSearch();
                List <String> myList = MedicineGlossaryObject.switcherMedCategories(a);
                var listInCapitals = HelperFunctions.getList(myList);
                var upperItem = HelperFunctions.makeStringToCapital();
                HelperFunctions.medicamentFinder(listInCapitals, upperItem);

                Menu();
                break;
            case 2:
                System.out.println("__________________________________________\n"+
                        "Main Menu\n"+
                        "⌞ Medicine Glossary Menu\n"+
                        "  ⌞ List all medicament's by type\n");
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
                break;
            default:
                System.out.println("You entered an invalid number");
                Menu();
                break;
        }

    }
}
