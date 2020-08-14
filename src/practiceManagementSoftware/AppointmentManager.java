package practiceManagementSoftware;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AppointmentManager {

    private final List<AppointmentObject> appointmentObjects = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);


    public void readAppointmentCSV() {
        appointmentObjects.clear();
        List<String> Helper = new ArrayList<>();
        String filepath = "Appointments.csv";
        File f = new File(filepath);
        try (Scanner scCSV = new Scanner(f)) {
            while (scCSV.hasNextLine()) {
                Helper.add(scCSV.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String s : Helper) {
            AppointmentObject apot = new AppointmentObject(0, 0, null, null, null, null);

            String[] parts = s.split(";");

            apot.setAppointmentID(Integer.parseInt(parts[0]));
            apot.setPatientID(Integer.parseInt(parts[1]));
            apot.setTitle(parts[2]);
            apot.setDate(parts[3]);
            apot.setStartTime(parts[4]);
            apot.setEndTime(parts[5]);
            appointmentObjects.add(apot);
        }
    }

    public void printAppointments() {
        String[] aCol = {"ID", "PatID", "Title", "Date", "Start Time", "End Time"};
        System.out.println("__________________________________________\n List of Appointments\n");
        for (String aCol1 : aCol) {
            System.out.print(aCol1 + "\t");
        }
        System.out.println();
        for (AppointmentObject appointmentObject : appointmentObjects) {
            System.out.println(appointmentObject.getAppointmentID() + "\t\t" + appointmentObject.getPatientID() + "\t\t" + appointmentObject.getTitle()
                    + "\t" + appointmentObject.getDate() + "\t" + appointmentObject.getStartTime() + "\t" + appointmentObject.getEndTime());
        }
    }

    public void addAppointment(int appointmentID, int patientID, String title, String date, String startTime, String endTime) {
        try {
            AppointmentObject apt = new AppointmentObject(appointmentID, patientID, title, date, startTime, endTime);
            appointmentObjects.add(apt);
            System.out.println("AppointmentObject saved!");
        } catch (Exception e) {
            System.out.println("AppointmentObject could not be saved!");
        }
    }

    public void deleteAppointment(AppointmentObject foundappointment) {
        try {
            appointmentObjects.remove(foundappointment);
        } catch (Exception e) {
            System.out.println("AppointmentObject could not be removed!");
        }
    }

    public void showAppointmentById(AppointmentObject foundappointment) {
        try {
            System.out.println(foundappointment);
        } catch (Exception e) {
            System.out.println("AppointmentObject could not be found!");
        }
    }

    public AppointmentObject searchAppointmentByID(int apatId) {
        for (AppointmentObject foundAppointmentObject : appointmentObjects) {
            if (foundAppointmentObject.getAppointmentID() == apatId) {
                return foundAppointmentObject;
            }
        }
        return null;
    }

    public void writeAppointmentToCSV() {
        ListIterator<AppointmentObject> lItr = appointmentObjects.listIterator();

        String tempFile = "temp.csv";

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            AppointmentObject apatIt1 = lItr.next();

            pw.print(apatIt1.getAppointmentID() + ";" + apatIt1.getPatientID() + ";" + apatIt1.getTitle() + ";" + apatIt1.getDate() + ";" + apatIt1.getStartTime() + ";" + apatIt1.getEndTime() + ";");
            while (lItr.hasNext()) {
                AppointmentObject apatIt = lItr.next();
                pw.print("\n" + apatIt.getAppointmentID() + ";" + apatIt.getPatientID() + ";" + apatIt.getTitle() + ";" + apatIt.getDate() + ";" + apatIt.getStartTime() + ";" + apatIt.getEndTime() + ";");
            }
            pw.flush();
            pw.close();
            System.out.println("Appointments were successfully written to CSV!");

        } catch (Exception e) {
            System.out.println("Appointments could not be written to CSV!");
        }
    }

    public boolean checkIfIDExists(int id) {
        for (AppointmentObject apat : appointmentObjects) {
            if (apat.getAppointmentID() == id) {
                return true;
            }
        }
        return false;
    }

    public void editAppointment(int id) {
        System.out.println();
        System.out.println("Existing details: ");

        AppointmentObject foundAppointmentObject = searchAppointmentByID(id);
        showAppointmentById(foundAppointmentObject);
        deleteAppointment(foundAppointmentObject);
        addingAppointment();
    }

    public void addingAppointment() {
        System.out.println();
        System.out.println("Enter AppointmentObject ID: ");
        int appointmentID = input.nextInt();
        while (checkIfIDExists(appointmentID)) {
            System.out.println("ID already taken, try a new one:");
            appointmentID = input.nextInt();
        }

        System.out.println("Enter Patient Id: ");
        int patientID = input.nextInt();
        System.out.println("Enter Title: ");
        input.nextLine();
        String title = input.nextLine();
        System.out.println("Enter Date: ");
        String date = input.nextLine();
        System.out.println("Enter Start Time: ");
        String startTime = input.nextLine();
        System.out.println("Enter End Time: ");
        String endTime = input.nextLine();
        addAppointment(appointmentID, patientID, title, date, startTime, endTime);


    }
}
