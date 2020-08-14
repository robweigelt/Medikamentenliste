package PracticeManagementSoftware;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class PatientManager {

    private final List<Patient> patients = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public void readPatientCSV() {
        patients.clear();
        List<String> Helper = new ArrayList<>();
        String filepath = "Patients.csv";
        File f = new File(filepath);
        try (Scanner scCSV = new Scanner(f)) {
            while (scCSV.hasNextLine()) {
                Helper.add(scCSV.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String s : Helper) {
            Patient pat = new Patient(0, null, null, null, null, null, null, null, null);

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
        String[] pCol = {"ID", "Name", "Surname", "Gender", "Birth Date", "Insurance", "Street", "City", "Zip"};
        System.out.println("__________________________________________");
        System.out.println("List of Patients\n");
        for (String pCol1 : pCol) {
            System.out.print(pCol1 + "\t");
        }
        System.out.println();
        for (Patient patient : patients) {
            System.out.println(patient.getPatient_Id() + "\t" + patient.getName() + "\t" + patient.getSurname()
                    + "\t" + patient.getGender() + "\t" + patient.getDateOfBirth() + "\t" + patient.getInsuranceName()
                    + "\t" + patient.getCity() + "\t" + patient.getStreet() + "\t" + patient.getZip()
            );
        }
    }

    public void addPatient(int patient_Id, String name, String surname, String gender, String dateOfBirth, String insuranceName, String street, String city, String zip) {
        try {
            Patient pt = new Patient(patient_Id, name, surname, gender, dateOfBirth, insuranceName, street, city, zip);
            patients.add(pt);
            System.out.println("Patient saved!");
        } catch (Exception e) {
            System.out.println("Patient could not be saved!");
        }
    }

    public void deletePatient(Patient foundpatient) {
        try {
            patients.remove(foundpatient);
        } catch (Exception e) {
            System.out.println("Patient could not be removed!");
        }
    }

    public void showPatientById(Patient foundpatient) {
        try {
            System.out.println(foundpatient);
        } catch (Exception e) {
            System.out.println("Patient could not be found!");
        }
    }

    public Patient searchPatientByID(int patId) {
        for (Patient foundPatient : patients) {
            if (foundPatient.getPatient_Id() == patId) {
                return foundPatient;
            }
        }
        return null;
    }

    public void writePatientToCSV() {
        ListIterator<Patient> lItr = patients.listIterator();

        String tempFile = "temp.csv";

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Patient patientIt1 = lItr.next();

            pw.print(patientIt1.getPatient_Id() + ";" + patientIt1.getName() + ";" + patientIt1.getSurname() + ";" + patientIt1.getGender() + ";" + patientIt1.getDateOfBirth() + ";" + patientIt1.getInsuranceName() + ";" + patientIt1.getCity() + ";" + patientIt1.getStreet() + ";" + patientIt1.getZip() + ";");
            while (lItr.hasNext()) {
                Patient patIt = lItr.next();
                pw.print("\n" + patIt.getPatient_Id() + ";" + patIt.getName() + ";" + patIt.getSurname() + ";" + patIt.getGender() + ";" + patIt.getDateOfBirth() + ";" + patIt.getInsuranceName() + ";" + patIt.getCity() + ";" + patIt.getStreet() + ";" + patIt.getZip() + ";");
            }
            pw.flush();
            pw.close();
            System.out.println("Patients were successfully written to CSV!");
        } catch (Exception e) {
            System.out.println("Patients could not be written to CSV!");
        }
    }

    public boolean checkIfIDExists(int id) {
        for (Patient pat : patients) {
            if (pat.getPatient_Id() == id) {
                return true;
            }
        }
        return false;
    }

    public void editPatient(int id) {
        System.out.println();
        System.out.println("Existing details: ");

        Patient foundPatient = searchPatientByID(id);
        showPatientById(foundPatient);
        deletePatient(foundPatient);
        addingPatient();
    }

    public void addingPatient() {
        System.out.println();
        System.out.println("Enter Patient ID: ");
        int Id = input.nextInt();
        while (checkIfIDExists(Id)) {
            System.out.println("ID already taken, try a new one:");
            Id = input.nextInt();
        }
        System.out.println("Enter Name: ");
        input.nextLine();
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
