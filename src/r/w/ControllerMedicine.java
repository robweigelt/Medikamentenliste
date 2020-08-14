package r.w;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;


//Deleter hinzufügen
class ControllerMedicine {
    static void Menu() throws CloneNotSupportedException, IOException {
        System.out.println("Please choose between the different options by pressing the number [] and [Enter]:\n" +
                "Look for a specific person [1] \n" +
                "Create new entry [2] \n" +
                "List all entry's [3] \n" +
                "Return [0]"
        );
        InsideMenuMedicine(GetIntOrString.GetmyInt());

    }
    private static void InsideMenuMedicine(int switcher) throws CloneNotSupportedException, IOException {
        switch (switcher){
            case 0:
                Controller.Menu();
            case 1:
                int a = MedicineO.SelectSearch();
                List <String> myList  = MedicineO.switcherMedicineCategory(a);
                var listInCapitals = ListFunctions.getList(myList);
                var upperItem = ListFunctions.makeStringToCapital();
                if (listInCapitals.contains(upperItem)){
                    int[] indexes =
                            IntStream.range(0, listInCapitals.size())
                                    .filter(i -> listInCapitals.get(i).equals(upperItem))
                                    .toArray();

                    for (int b : indexes) {
                       try{ MedicineO.SearchInsideListArray(b);}
                       catch (java.lang.IndexOutOfBoundsException ignored){
                       }

                    }

                }


                else System.out.println("No Results");
                Menu();



            case 2:
                MedicineO.newEntry();
                Menu();

            case 3:
                MedicineO.ListAllItems();
                Menu();
            default:
                System.out.println("You entered an invalid number");
                Menu();
        }

    }
}
