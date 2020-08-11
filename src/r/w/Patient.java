package r.w;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Patient {

    private int patient_Id;
    private String name;
    private String surname;
    private String gender;
    private String dateOfBirth;
    private String insuranceName;
    private String street;
    private String city;
    private String zip;

    public void addPatient() {
        Scanner input = new Scanner(System.in);
        try {
            File myObj = new File("Patients.csv");
            FileWriter myWriter = new FileWriter("Patients.csv", true);
            if (myObj.createNewFile()) {
            }
            System.out.println("**********************");
            System.out.println("Enter Patient Id: ");
            patient_Id = input.nextInt();
            System.out.println("Enter Name: ");
            input.nextLine();
            name = input.nextLine();
            System.out.println("Enter Surname: ");
            surname = input.nextLine();
            System.out.println("Enter gender: ");
            gender = input.nextLine();
            System.out.println("Enter Date of Birth: ");
            dateOfBirth = input.nextLine();
            System.out.println("Enter Insurance: ");
            insuranceName = input.nextLine();
            System.out.println("Enter Street: ");
            street = input.nextLine();
            System.out.println("Enter City: ");
            city = input.nextLine();
            System.out.println("Enter Zip Code: ");
            zip = input.nextLine();

            myWriter.write(patient_Id + "," + name + "," + surname + "," + gender + "," + dateOfBirth + "," + insuranceName + "," + street + "," + city + "," + zip + "," + "\n");

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void showPatients() {
        System.out.println("List of Patients");
        String[] col = {"Name", "Surname", "Gender", "Birth Date", "Insurance", "Street", "City", "Zip"};
        System.out.format("%s", "ID");
        for (int a = 0; a < col.length; a++) {
            System.out.format("%15s", col[a]);
        }
        System.out.println("");
        try {
            File myObj = new File("Patients.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                System.out.format("%s", parts[0]);
                for (int i = 1; i < parts.length; i++) {
                    System.out.format("%15s", parts[i]);
                }
                System.out.println("");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deletePatient(Long id) {
        try {
            File inputFile = new File("Patients.csv");
            File tempFile = new File("TempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = Objects.toString(id, null);
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                String trimmLine[] = trimmedLine.split(" |,");
                String part1 = trimmLine[0];

                if (!part1.equals(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            try {
                Files.move(new File("TempFile.txt").toPath(), new File("Patients.csv").toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Deletion failed!");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void searchPatient(String id) {
        System.out.println("Searched Patient");
        String[] col = {"Name", "Surname", "Gender", "Birth Date", "Insurance", "Street", "City", "Zip"};
        System.out.format("%s", "ID");
        for (int a = 0; a < col.length; a++) {
            System.out.format("%15s", col[a]);
        }
        System.out.println("");
        try {
            File myObj = new File("Patients.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                if (parts[0].equals(id)) {
                    System.out.format("%s", parts[0]);
                    for (int i = 1; i < parts.length; i++) {
                        System.out.format("%15s", parts[i]);
                    }
                    System.out.println("");
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void editPatient(Long id) {
        System.out.println("Existing Details: ");
        searchPatient(id.toString());
        deletePatient(id);
        addPatient();
    }

    public int getPatient_Id() {
        return patient_Id;
    }

    public void setPatient_Id(int patient_Id) {
        this.patient_Id = patient_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
