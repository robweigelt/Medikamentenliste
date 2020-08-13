package r.w;

import java.io.IOException;
import java.util.Scanner;

public class AppointmentMenu {

    private Scanner input = new Scanner(System.in);
    private AppointmentManager aptm;

    public AppointmentMenu() {
        this.input = new Scanner(System.in);
        this.aptm = new AppointmentManager();
    }

    public void runProgram() throws IOException, CloneNotSupportedException {
        aptm.readAppointmentCSV();
        while (true) {
            mainMenu();
        }
    }

    private void mainMenu() throws IOException, CloneNotSupportedException {
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Appointments Menu");
        System.out.println("");
        System.out.println("[1] Show all appointments");
        System.out.println("[2] Show appointment with ID");
        System.out.println("[3] Add, edit or delete");
        System.out.println("[-] ");
        System.out.println("[9] Return (discard changes)");
        System.out.println("[0] Return (save to CSV)");
        System.out.println("");
        System.out.print("Enter choice here: ");
        int choice = input.nextInt();
        switch (choice) {
            case 0:
                aptm.writeAppointmentToCSV();
                Controller.Menu();
                break;
            case 1:
                aptm.printAppointments();
                System.out.println();
                break;
            case 2:
                int id2;
                System.out.print("Enter appointment ID to Search: ");
                id2 = input.nextInt();
                Appointment foundAppointment = aptm.searchAppointmentByID(id2);
                System.out.println("__________________________________________\n");
                aptm.showAppointmentById(foundAppointment);
                break;
            case 3:
                addEditDeleteMenu();
                break;
            case 9:
                Controller.Menu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void addEditDeleteMenu() throws IOException, CloneNotSupportedException {
        int a_choice;
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Appointments Menu");
        System.out.println("  ⌞ Add, edit and delete");
        System.out.println("");
        System.out.println("[1] Add appointment");
        System.out.println("[2] Edit appointment with ID");
        System.out.println("[3] Delete appointment with ID");
        System.out.println("[-] ");
        System.out.println("[0] Return");
        System.out.println("");
        System.out.print("Enter choice here: ");
        a_choice = input.nextInt();
        if (a_choice == 1) {
            System.out.println("__________________________________________");
            System.out.println("Add appointment");
            aptm.addingAppointment();
        } else if (a_choice == 2) {
            System.out.print("Enter appointment ID to edit: ");
            int id = input.nextInt();
            System.out.println("__________________________________________");
            System.out.println("Edit appointment");
            aptm.editAppointment(id);
        } else if (a_choice == 3) {
            System.out.print("Enter appointment ID to delete: ");
            int id = input.nextInt();
            Appointment foundAppointment = aptm.searchAppointmentByID(id);
            aptm.deleteAppointment(foundAppointment);
            System.out.println("The appointment of id " + foundAppointment.getAppointmentID() + " was successfully removed!");
        } else {
            mainMenu();
        }
    }
}
