package r.w;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

class ControllerMedicineGlossar {
    private static void Menu() {
        System.out.println("Please choose between the different options by pressing the number [] and [Enter]:\n" +
                "Look for specific medicament [1] \n" +
                "List all medicaments by type [2] \n" +
                "Return [0]"
        );
        InsideMenuMedicine(GetIntOrString.GetmyInt());
    }
    private static void InsideMenuMedicine ( int Switcher) {
        switch (Switcher) {
            case 0:
                Controller.Menu();
                break;
            case 1:
                int a = MedicineGlossarFunctions.SelectSearch();
                List myLista = MedListO.switcherMedCategorie(a);
                System.out.println("");

                break;
            case 2:
                int b = MedicineGlossarFunctions.SelectSearch();
                List myListb = MedListO.switcherMedCategorie(b);

                Collections.sort(myListb);
                List<String> ListSingle = (List<String>) myListb.stream()
                        .distinct()
                        .collect(Collectors.toList());

                for (Object element : ListSingle) {
                    System.out.println(element);
                }

                Menu();
                break;


            default:
                System.out.println("You entered an invalid number");


        }
        }
    }
