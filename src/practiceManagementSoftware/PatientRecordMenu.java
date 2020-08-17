package practiceManagementSoftware;

import java.io.IOException;
import java.util.List;


//Code Robert Weigelt-- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt
class PatientRecordMenu {
    //Submenu
    static void Menu() throws CloneNotSupportedException, IOException {
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Patient Medical Record Menu");
        System.out.println();
        System.out.print("[1] Look for a specific person  \n" +
                "[2] Create new entry  \n" +
                "[3] List all entry's \n" +
                "[-] \n" +
                "[0] Return \n\nEnter choice here: ");
        InsideMenuMedicine(GetIntOrString.GetmyInt());

    }
    //Controller for switch-Statements
    private static void InsideMenuMedicine(int switcher) throws CloneNotSupportedException, IOException {
        switch (switcher){
            case 0:
                MainMenu.Menu();
            case 1:
                int a = PatientRecordObject.SelectSearch();
                List <String> myList  = PatientRecordObject.switcherMedicineCategory(a);
                var listInCapitals = HelperFunctions.getList(myList);
                var upperItem = HelperFunctions.makeStringToCapital();
                HelperFunctions.patientFinder(listInCapitals, upperItem);
                Menu();
            case 2:
                new PatientRecordObject().newEntry();
                Menu();
            case 3:
                PatientRecordObject.ListAllItems();
                Menu();
            default:
                System.out.println("You entered an invalid number");
                Menu();
        }

    }
}
