package r.w;

import java.util.concurrent.TimeUnit;

public class ControllerMedicineGlossar {
    public static void Menu() {

        System.out.println("             ___       __   __         ___    ___  __  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("       |  | |__  |    /  ` /  \\  |\\/| |__      |  /  \\ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("       |/\\| |___ |___ \\__, \\__/  |  | |___     |  \\__/ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("              ____                 _   _                                   ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("             |  _ \\ _ __ __ _  ___| |_(_) ___ ___                          ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("             | |_) | '__/ _` |/ __| __| |/ __/ _ \\                         ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("             |  __/| | | (_| | (__| |_| | (_|  __/                         ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("             |_|   |_|  \\__,_|\\___|\\__|_|\\___\\___|                         ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("  __  __                                                   _   ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" |  \\/  | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __|");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__|");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("          ____         __ _ |___/                               ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("         / ___|  ___  / _| |___      ____ _ _ __ ___                   ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("         \\___ \\ / _ \\| |_| __\\ \\ /\\ / / _` | '__/ _ \\                  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("          ___) | (_) |  _| |_ \\ V  V / (_| | | |  __/                  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("         |____/ \\___/|_|  \\__| \\_/\\_/ \\__,_|_|  \\___|                  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("by Tabea Böger");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.print(", Lisa Eberl");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.print(", Hannes Kukulenz");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.print(", Tobias Vogt");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" & Robert Weigelt");
        System.out.println("");




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
