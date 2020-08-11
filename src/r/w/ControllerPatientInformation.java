package r.w;

import java.util.Scanner;

public class ControllerPatientInformation {

    public static void Starter () {
        Scanner input = new Scanner(System.in);
        Patient p = new Patient();
        Appointment a = new Appointment();
        int choice;
        do {
            //Menu method
            menu();
            System.out.println("Enter choice here: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    int p_choice;
                    System.out.println("1. Add Patient");
                    System.out.println("2. Edit");
                    System.out.println("3. Delete");
                    System.out.println("4. Go back to Menu");
                    System.out.println("Enter choice here: ");
                    p_choice = input.nextInt();
                    if (p_choice == 1) {
                        System.out.println("Add Patient");
                        p.addPatient();
                        System.out.println("Patient Added\n");
                    } else if (p_choice == 2) {
                        Long id;
                        System.out.println("Enter Patient ID to Edit: ");
                        id = input.nextLong();
                        p.editPatient(id);
                    } else if (p_choice == 3) {
                        Long id;
                        System.out.println("Enter Patient ID to Delete: ");
                        id = input.nextLong();
                        p.deletePatient(id);
                        System.out.println("Patient Deleted!");
                    } else {
                        menu();
                    }
                    break;
                case 2:
                    int a_choice;
                    System.out.println("1. Add Appointment");
                    System.out.println("2. Edit");
                    System.out.println("3. Delete");
                    System.out.println("4. Go back to Menu");
                    a_choice = input.nextInt();
                    if (a_choice == 1) {
                        System.out.println("Add Appointment");
                        a.addAppointment();
                        System.out.println("Appointment Added\n");
                    } else if (a_choice == 2) {
                        Long id;
                        System.out.println("Enter Appointment ID to Edit: ");
                        id = input.nextLong();
                        a.editAppointment(id);
                    } else if (a_choice == 3) {
                        Long id;
                        System.out.println("Enter Appointment ID to Delete: ");
                        id = input.nextLong();
                        a.deleteAppointment(id);
                        System.out.println("Appointment Deleted!");
                    } else {
                        menu();
                    }
                    break;
                case 3:
                    p.showPatients();
                    System.out.println();
                    break;
                case 4:
                    a.showAppointments();
                    System.out.println();
                    break;
                case 5:
                    int id;
                    System.out.println("Enter Patient ID to Search: ");
                    id = input.nextInt();
                    p.searchPatient(Integer.toString(id));
                    break;
                case 6:
                    int id2;
                    System.out.println("Enter Appointment ID to Search: ");
                    id2 = input.nextInt();
                    a.searchAppointment(Integer.toString(id2));
                    break;
                case 7:
                    System.out.println("Have a nice day!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input!");
            }
        } while (choice != 7);
    }

    private static void menu() {
        System.out.println("Patients and Appointments Menu");
        System.out.println("1. Patients");
        System.out.println("2. Appointments");
        System.out.println("3. Show Patients");
        System.out.println("4. Show Appointments");
        System.out.println("5. Show Patient with ID");
        System.out.println("6. Show Appointment with ID");
        System.out.println("7. Exit");
    }

}
