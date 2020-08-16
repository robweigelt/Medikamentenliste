package practiceManagementSoftware;

import java.io.IOException;
import java.util.Scanner;

//Code Hannes Kukulenz -- Design Hannes Kukulenz-- Exception Handling Robert Weigelt
public class AppointmentMenu {


    private Scanner input;
    private final AppointmentManager aptm;

    public AppointmentMenu() {
        this.input = new Scanner(System.in);
        this.aptm = new AppointmentManager();
    }

    public void runProgram() throws IOException, CloneNotSupportedException {
        aptm.readAppointmentCSV();
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                mainMenu();
            }
            catch (RuntimeException ignored){}
        }


    }

    private void mainMenu() throws IOException, CloneNotSupportedException {
        System.out.print("__________________________________________\n"
        +"Main Menu\n"
        +"⌞ Appointments Menu \n\n"
        +"[1] Show all appointments\n"
        +"[2] Show appointment with ID\n"
        +"[3] Add, edit or delete\n"
        +"[-] \n"
        +"[9] Return (discard changes)\n"
        +"[0] Return (save to CSV)\n\n"
        +"Enter choice here: ");
        int choice = GetIntOrString.GetmyInt();
        switch (choice) {
            case 0:
                aptm.writeAppointmentToCSV();
                MainMenu.Menu();
                break;
            case 1:
                aptm.printAppointments();
                System.out.println();
                break;
            case 2:

                System.out.print("Enter appointment ID to Search: ");
                int id2 = GetIntOrString.GetmyInt();
                AppointmentObject foundAppointmentObject = aptm.searchAppointmentByID(id2);
                System.out.println("__________________________________________\n");
                aptm.showAppointmentById(foundAppointmentObject);
                break;
            case 3:
                addEditDeleteMenu();
                break;
            case 9:
                MainMenu.Menu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void addEditDeleteMenu() throws IOException, CloneNotSupportedException {
        int a_choice;
        System.out.print("__________________________________________\n"
        +"Main Menu \n"
        +"⌞ Appointments Menu\n"
        +"  ⌞ Add, edit and delete\n\n"
        +"[1] Add appointment\n"
        +"[2] Edit appointment with ID\n"
        +"[3] Delete appointment with ID\n"
        +"[-] \n"
        +"[0] Return\n\n"
        +"Enter choice here: ");
        a_choice = GetIntOrString.GetmyInt();
        if (a_choice == 1) {
            System.out.println("__________________________________________\n"
            +"Add appointment");
            aptm.addingAppointment();
        } else if (a_choice == 2) {
            System.out.print("Enter appointment ID to edit: ");
            int id = GetIntOrString.GetmyInt();
            System.out.println("__________________________________________\n" +"Edit appointment");
            aptm.editAppointment(id);
        } else if (a_choice == 3) {
            System.out.print("Enter appointment ID to delete: ");
            int id = GetIntOrString.GetmyInt();
            AppointmentObject foundAppointmentObject = aptm.searchAppointmentByID(id);
            aptm.deleteAppointment(foundAppointmentObject);
            System.out.println("The appointment of ID " + foundAppointmentObject.getAppointmentID() + " was successfully removed!");
        } else {
            mainMenu();
        }
    }
}
