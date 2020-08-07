package r.w;




import java.util.*;
import java.util.stream.IntStream;


class ControllerMedicineGlossar {
    static void Menu() throws CloneNotSupportedException {


        System.out.println("Please choose between the different options by pressing the number [] and [Enter]:\n" +
                "Look for specific medicament [1] \n" +
                "List all medicaments by type [2] \n" +
                "Reurn [0]"
        );
        InsideMenuMedicine(GetIntOrString.GetmyInt());
    }

    private static void InsideMenuMedicine(int Switcher) throws CloneNotSupportedException {
        switch (Switcher) {
            case 0:
                Controller.Menu();
                break;
            case 1:
                int a = MedicineGlossarFunctions.SelectSearch();
                List myList = MedListO.switcherMedCategorie(a);
                ArrayList<String> listinCapitals = new ArrayList<>(myList);
                listinCapitals.replaceAll(String::toUpperCase);
                System.out.println("Please type the item you are looking for");
                String item = GetIntOrString.GetmyString();
                String upperItem = item.toUpperCase();
                if (listinCapitals.contains(upperItem)){
                    int[] indexes =
                            IntStream.range(0, listinCapitals.size())
                                    .filter(i -> listinCapitals.get(i).equals(upperItem))
                                    .toArray();

                    for (int b : indexes) {
                        MedListO.CreateMatrix(b);

                    }
                }
                else System.out.println("No Results");
                Menu();
                break;
            case 2:
                int b = MedicineGlossarFunctions.SelectSearch();

                myList = MedListO.switcherMedCategorie(b);


                Collections.sort(myList);
                LinkedHashSet hashSet = new LinkedHashSet<>(myList);
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


        }

    }
}
