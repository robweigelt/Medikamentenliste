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

//Code Hannes Kukulenz-- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt
public class PatientManager {


    private final List<PatientObject> patients = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public void readPatientCSV() {
        //Patients Objekt Liste aus der CSV Patients.csv erstellen
        patients.clear();
        List<String> Helper = new ArrayList<>();
        String filepath = "Patients.csv";
        File f = new File(filepath);
        //die CSV einlesen
        try (Scanner scCSV = new Scanner(f)) {
            while (scCSV.hasNextLine()) {
                Helper.add(scCSV.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //die Patients Objeke aus den Zeilen einlesen
        for (String s : Helper) {
            PatientObject pat = new PatientObject(0, null, null, null, null, null, null, null, null);
            String[] parts = s.split(";");
            pat.setPatient_Id(Integer.parseInt(parts[0]));
            pat.setName(parts[1]);
            pat.setSurname(parts[2]);
            pat.setGender(parts[3]);
            pat.setDateOfBirth(parts[4]);
            pat.setInsuranceName(parts[5]);
            pat.setCity(parts[6]);
            pat.setStreet(parts[7]);
            pat.setZip(parts[8]);
            patients.add(pat);
        }
    }

    public void printPatients() {
        //Ausgabe aller Patients in Tabellenform
        String leftAlignFormat = "| %-5d | %-15s | %-15s | %-6s | %-10s | %-15s | %-20s | %-10s | %5s |%n";
        System.out.format("+-------+-----------------+-----------------+--------+------------+-----------------+----------------------+------------+-------+%n");
        System.out.format("| ID    | Name            | Surname         | Gender | Birth Date | Insurance       | Street               | City       | Zip   |%n");
        System.out.format("+-------+-----------------+-----------------+--------+------------+-----------------+----------------------+------------+-------+%n");
        for (PatientObject patient : patients) {
            System.out.format(leftAlignFormat,patient.getPatient_Id(),patient.getName(),patient.getSurname(),patient.getGender(),patient.getDateOfBirth(),patient.getInsuranceName(),patient.getCity(),patient.getStreet(),patient.getZip());
        }
        System.out.format("+-------+-----------------+-----------------+--------+------------+-----------------+----------------------+------------+-------+%n");
    }

    public void addPatient(int patient_Id, String name, String surname, String gender, String dateOfBirth, String insuranceName, String street, String city, String zip) {
        //neues Patient Objekt erstellen und zur Liste hinzufügen
        try {
            PatientObject pt = new PatientObject(patient_Id, name, surname, gender, dateOfBirth, insuranceName, street, city, zip);
            patients.add(pt);
            System.out.println("Patient saved!");
        } catch (Exception e) {
            System.out.println("Patient could not be saved!");
        }
    }

    public void deletePatient(PatientObject foundPatient) {
        //Patient Objekt aus der Liste entfernen
        try {
            patients.remove(foundPatient);
        } catch (Exception e) {
            System.out.println("Patient could not be removed!");
        }
    }

    public void showPatientById(PatientObject foundPatient) {
        //einzelnen Patient ausgeben
        try {
            System.out.println(foundPatient);
        } catch (Exception e) {
            System.out.println("Patient could not be found!");
        }
    }

    public PatientObject searchPatientByID(int patId) {
        //Patient Objekt mit bestimmter ID zurückgeben
        for (PatientObject foundPatient : patients) {
            if (foundPatient.getPatient_Id() == patId) {
                return foundPatient;
            }
        }
        return null;
    }

    public void writePatientToCSV() {
        //die aktuelle Liste mit Patients Objekten in die CSV schreiben
        ListIterator<PatientObject> lItr = patients.listIterator();
        String tempFile = "temp.csv";
        File newFile = new File(tempFile);
        String filepath = "Patients.csv";
        File oldFile = new File(filepath);

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            PatientObject patientIt1 = lItr.next();
            //eine einzelne Zeile formulieren
            pw.print(patientIt1.getPatient_Id() + ";" + patientIt1.getName() + ";" + patientIt1.getSurname() + ";" + patientIt1.getGender() + ";" + patientIt1.getDateOfBirth() + ";" + patientIt1.getInsuranceName() + ";" + patientIt1.getStreet() + ";" + patientIt1.getCity() + ";" + patientIt1.getZip() + ";");
            while (lItr.hasNext()) {
                PatientObject patIt = lItr.next();
                pw.print("\n" + patIt.getPatient_Id() + ";" + patIt.getName() + ";" + patIt.getSurname() + ";" + patIt.getGender() + ";" + patIt.getDateOfBirth() + ";" + patIt.getInsuranceName() + ";" + patIt.getStreet() + ";" + patIt.getCity() + ";" + patIt.getZip() + ";");
            }
            pw.flush();
            pw.close();

            boolean wasSuccessful = oldFile.delete();
            File dump = new File(filepath);
            boolean wasAlsoSuccesfull = newFile.renameTo(dump);
            if (wasSuccessful && wasAlsoSuccesfull){
                System.out.println("Patients were successfully written to CSV!");
            }
        } catch (Exception e) {
            System.out.println("Patients could not be written to CSV!");
        }
    }

    public boolean checkIfIDExists(int id) {
        //überprüfen, ob es bereits ein Patient Objekt mit der übergebenen Patient ID gibt
        for (PatientObject pat : patients) {
            if (pat.getPatient_Id() == id) {
                return true;
            }
        }
        return false;
    }

    public void editPatient(int id) {
        //das Patient Objekt mit der übergebenen ID bearbeiten
        System.out.println();
        System.out.println("Existing details: ");
        //Patient Objekt suchen
        PatientObject foundPatient = searchPatientByID(id);
        //Patient Objekt anzeigen, damit man die aktuellen Werte sieht
        showPatientById(foundPatient);
        //Patient Objekt löschen
        deletePatient(foundPatient);
        //Eingabemaske für neues Patient Objekt anzeigen
        addingPatient();
    }

    public void addingPatient() {
        //neuen Patient hinzufügen - alle Felder nacheinander abfragen
        System.out.println();
        System.out.println("Enter Patient ID: ");
        int Id = GetIntOrString.GetmyInt();
        while (checkIfIDExists(Id)) {//überprüfen, ob es nicht bereits ein Patient Objekt mit der ID gibt
            System.out.println("ID already taken, try a new one:");
            Id = GetIntOrString.GetmyInt();
        }
        System.out.println("Enter Name: ");
        String name = input.nextLine();
        System.out.println("Enter Surname: ");
        String surname = input.nextLine();
        System.out.println("Enter gender: ");
        String gender = input.nextLine();
        System.out.println("Enter Date of Birth: ");
        String dateOfBirth = input.nextLine();
        System.out.println("Enter Insurance: ");
        String insuranceName = input.nextLine();
        System.out.println("Enter Street: ");
        String street = input.nextLine();
        System.out.println("Enter City: ");
        String city = input.nextLine();
        System.out.println("Enter Zip Code: ");
        String zip = input.nextLine();
        addPatient(Id, name, surname, gender, dateOfBirth, insuranceName, street, city, zip);
    }
}
