package practiceManagementSoftware;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//Code Tabea Boeger -- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt
public class MainMenu {


    //Starter
    static int WelcomeText() throws InterruptedException {
        Funtext();
        System.out.print("Please press [1] and [Enter] to continue: ");
        return GetIntOrString.GetmyInt();
    }

    //@Hannes Kukulenz Starter
    public static void Funtext()  throws InterruptedException {
        System.out.println("             ___       __   __         ___    ___  __  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("       |  | |__  |    /  ` /  \\  |\\/| |__      |  /  \\ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("       |/\\| |___ |___ \\__, \\__/  |  | |___     |  \\__/ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println();
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
        System.out.println();
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
        System.out.println();
    }
    //Main Menu
    static void Menu() throws CloneNotSupportedException, IOException {

        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("\n" +
               "[1] Patient Record\n" +
               "[2] Medicine Glossar\n" +
               "[3] Inventory \n" +
               "[4] Appointments \n[-]\n" +
               "[0] Close\n"
        );
        System.out.print("Enter choice here: ");
        InsideMenu(GetIntOrString.GetmyInt());
    }
    //Controller: Switch to Submenus
    private static void InsideMenu(int Switcher) throws CloneNotSupportedException, IOException {
        switch (Switcher) {
            case 1:
                System.out.println("__________________________________________\n");
                System.out.println("[1] Patient Information");
                System.out.println("[2] Patient Medical Record\n");
                System.out.print("Enter choice here: ");
                int a = GetIntOrString.GetmyInt();
                if (1 == a) {
                    PatientMenu pm = new PatientMenu();
                    pm.runProgram();
                } else if (a == 2) {
                    PatientRecordMenu.Menu();
                } else {
                    System.out.println("You entered an invalid number");
                    InsideMenu(1);
                }
                break;
            case 2:
                MedicineGlossaryMenu.Menu();
                break;
            case 3:                
                InventoryMenu ic = new InventoryMenu();
                ic.start();
                break;
            case 4:
                AppointmentMenu am = new AppointmentMenu();
                am.runProgram();
                break;
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
            default: System.out.println("You entered an invalid number");
                Menu();
        }
    }
}
