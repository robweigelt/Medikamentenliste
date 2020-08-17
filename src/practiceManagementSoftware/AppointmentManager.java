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

//Code Hannes Kukulenz -- Design Hannes Kukulenz-- EException Handling and Code Review Robert Weigelt
public class AppointmentManager {

    private final List<AppointmentObject> appointmentObjects = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public void readAppointmentCSV() {
        //Appointment Objekt Liste aus der CSV Appointments.csv erstellen
        appointmentObjects.clear();
        List<String> Helper = new ArrayList<>();
        String filepath = "Appointments.csv";
        File f = new File(filepath);
        //die CSV einlesen
        try (Scanner scCSV = new Scanner(f)) {
            while (scCSV.hasNextLine()) {
                Helper.add(scCSV.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //die Appointment Objekte aus den Zeilen erstellen
        for (String s : Helper) {
            AppointmentObject apot = new AppointmentObject(0, 0, null, null, null, null);
            String[] parts = s.split(";");
            apot.setAppointmentID(Integer.parseInt(parts[0]));
            apot.setPatientID(Integer.parseInt(parts[1]));
            apot.setTitle(parts[2]);
            apot.setDate(parts[3]);
            apot.setStartTime(parts[4]);
            apot.setEndTime(parts[5]);
            //und zur Liste hinzufügen
            appointmentObjects.add(apot);
        }
    }

    public void printAppointments() {
        //Ausgabe aller Appointments in Tabellenform
        String leftAlignFormat = "| %-5d | %-5d | %-10s | %-5s | %-5s | %-20s |%n";
        System.out.format("+-------+-------+------------+-------+-------+----------------------+%n");
        System.out.format("| A.ID  | P.ID  | Date       | Start | End   | Title                |%n");
        System.out.format("+-------+-------+------------+-------+-------+----------------------+%n");
        for (AppointmentObject appointmentObject : appointmentObjects) {
            System.out.format(leftAlignFormat,appointmentObject.getAppointmentID(),appointmentObject.getPatientID(),appointmentObject.getDate(),appointmentObject.getStartTime(),appointmentObject.getEndTime(),appointmentObject.getTitle());
        }
        System.out.format("+-------+-------+------------+-------+-------+----------------------+%n");
    }

    public void addAppointment(int appointmentID, int patientID, String title, String date, String startTime, String endTime) {
        //neues Appointment Objekt erstellen und zur Liste hinzufügen
        try {
            AppointmentObject apt = new AppointmentObject(appointmentID, patientID, title, date, startTime, endTime);
            appointmentObjects.add(apt);
            System.out.println("Appointment saved!");
        } catch (Exception e) {
            System.out.println("Appointment could not be saved!");
        }
    }

    public void deleteAppointment(AppointmentObject foundappointment) {
        //Appointment Objekt aus der Liste entfernen
        try {
            appointmentObjects.remove(foundappointment);
        } catch (Exception e) {
            System.out.println("Appointment could not be removed!");
        }
    }

    public void showAppointmentById(AppointmentObject foundappointment) {
        //einzelnes Appointment ausgeben
        try {
            System.out.println(foundappointment); //ruft toString Methode auf
        } catch (Exception e) {
            System.out.println("Appointment could not be found!");
        }
    }

    public AppointmentObject searchAppointmentByID(int apatId) {
        //Appointment Objekt mit bestimmter ID zurückgeben
        for (AppointmentObject foundAppointmentObject : appointmentObjects) {
            if (foundAppointmentObject.getAppointmentID() == apatId) {
                return foundAppointmentObject;
            }
        }
        return null;
    }

    public void writeAppointmentToCSV() {
        //die aktuelle Liste mit Appointment Objekten in die CSV schreiben
        ListIterator<AppointmentObject> lItr = appointmentObjects.listIterator();
        String tempFile = "temp.csv";
        File newFile = new File(tempFile);
        String filepath = "Appointments.csv";
        File oldFile = new File(filepath);

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            AppointmentObject apatIt1 = lItr.next();
            //eine Zeile formulieren
            pw.print(apatIt1.getAppointmentID() + ";" + apatIt1.getPatientID() + ";" + apatIt1.getTitle() + ";" + apatIt1.getDate() + ";" + apatIt1.getStartTime() + ";" + apatIt1.getEndTime() + ";");
            while (lItr.hasNext()) {
                AppointmentObject apatIt = lItr.next();
                pw.print("\n" + apatIt.getAppointmentID() + ";" + apatIt.getPatientID() + ";" + apatIt.getTitle() + ";" + apatIt.getDate() + ";" + apatIt.getStartTime() + ";" + apatIt.getEndTime() + ";");
            }
            pw.flush();
            pw.close();

            boolean wasSuccessufull =oldFile.delete();
            File dump = new File(filepath);
            boolean wasAlsoSuccessfull =newFile.renameTo(dump);
            if (wasAlsoSuccessfull&&wasSuccessufull){
                System.out.println("Appointments were successfully written to CSV!");
            }
        } catch (Exception e) {
            System.out.println("Appointments could not be written to CSV!");
        }
    }

    public boolean checkIfIDExists(int id) {
        //überprüfen, ob es bereits ein Appointment Objekt mit der übergebenen Appointment ID gibt
        for (AppointmentObject apat : appointmentObjects) { //über alle Appointment Objekte itererieren
            if (apat.getAppointmentID() == id) {
                return true;
            }
        }
        return false;
    }

    public void editAppointment(int id) {
        //das Appointment mit der übergebenen ID bearbeiten
        System.out.println();
        System.out.println("Existing details: ");
        //Appointment suchen
        AppointmentObject foundAppointmentObject = searchAppointmentByID(id);
        //Appointment anzeigen, damit man die aktuellen Werte sieht
        showAppointmentById(foundAppointmentObject);
        //Appointment löschen
        deleteAppointment(foundAppointmentObject);
        //Eingabemaske für neues Appointment anzeigen
        addingAppointment();
    }

    public void addingAppointment() {
        //neues Appointment hinzufügen - alle Felder nacheinander abfragen
        System.out.println();
        System.out.println("Enter Appointment ID: ");
        int appointmentID = GetIntOrString.GetmyInt();
        while (checkIfIDExists(appointmentID)) { //überprüfen, ob es nicht bereits ein Appointment Objekt mit der ID gibt
            System.out.println("ID already taken, try a new one:");
            appointmentID = GetIntOrString.GetmyInt();
        }
        System.out.println("Enter Patient Id: ");
        int patientID = GetIntOrString.GetmyInt();
        System.out.println("Enter Medical Procedure : ");
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
