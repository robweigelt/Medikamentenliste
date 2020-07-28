package r.w;

public class ControllerMedicineGlossar {
    public static void Menu() {
        System.out.println("Please choose between the different options by pressing the number [] and [Enter]:\n" +
                "Look for specific medicament [1] \n" +
                "List all medicaments by type [2] \n" +
                "Reurn [0]"
        );
        InsideMenuMedicine(GetIntOrString.GetmyInt());
    }
    public static void InsideMenuMedicine ( int Switcher) {
        switch (Switcher) {
            case 0:
                Controller.Menu();
                break;
            case 1:
                MedicineGlossarFunctions.SelectSearch();
                break;
            case 2:
                System.out.println("i ist zwei");
                break;


            default:
                System.out.println("You entered an invalid number");


        }
    }
}
