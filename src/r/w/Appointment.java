package r.w;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Appointment {

    private int appointmentID;
    private int patientID;
    private String title;
    private String date;
    private String startTime;
    private String endTime;

    public void addAppointment() {
        Scanner input = new Scanner(System.in);
        try {
            File myObj = new File("Appointment.csv");
            FileWriter myWriter = new FileWriter("Appointment.csv", true);
            myObj.createNewFile();
            System.out.println("**********************");
            System.out.println("Enter Appointment Id: ");
            appointmentID = input.nextInt();
            System.out.println("Enter Patient Id: ");
            patientID = input.nextInt();
            System.out.println("Enter Title: ");
            input.nextLine();
            title = input.nextLine();
            System.out.println("Enter Date: ");
            date = input.nextLine();
            System.out.println("Enter Start Time: ");
            startTime = input.nextLine();
            System.out.println("Enter End Time: ");
            endTime = input.nextLine();

            myWriter.write(appointmentID + "," + patientID + "," + title + "," + date + "," + startTime + "," + endTime + "\n");

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void showAppointments() {
        System.out.println("List of Appointments");
        String[] col = {"PatientId", "Title", "Date", "Start Time", "End Time"};
        System.out.format("%s", "ID");
        for (String s : col) {
            System.out.format("%15s", s);
        }
        System.out.println();
        try {
            File myObj = new File("Appointment.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                System.out.format("%s", parts[0]);//id print without space
                for (int i = 1; i < parts.length; i++) {
                    System.out.format("%15s", parts[i]); //priting with 15 space except id
                }
                System.out.println(); // for new line
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deleteAppointment(Long id) {
        try {
            File inputFile = new File("Appointment.csv");
            File tempFile = new File("T.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = Objects.toString(id, null);
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                String[] trimmLine = trimmedLine.split("[ ,]");
                String part1 = trimmLine[0];

                if (!part1.equals(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            try {
                Files.move(new File("T.txt").toPath(), new File("Appointment.csv").toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Deletion failed!");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void searchAppointment(String id) {
        System.out.println("Searched Appointment");
        String[] col = {"PatientId", "Title", "Date", "Start Time", "End Time"};
        System.out.format("%s", "ID");
        for (String s : col) {
            System.out.format("%15s", s);
        }
        System.out.println();
        try {
            File myObj = new File("Appointment.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                if (parts[0].equals(id)) {
                    System.out.format("%s", parts[0]);
                    for (int i = 1; i < parts.length; i++) {
                        System.out.format("%15s", parts[i]);
                    }
                    System.out.println();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void editAppointment(Long id) {
        System.out.println("Existing Details: ");
        searchAppointment(id.toString());
        deleteAppointment(id);
        addAppointment();
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int AppointmentID) {
        this.appointmentID = AppointmentID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int PatientID) {
        this.patientID = PatientID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public String getStarttime() {
        return startTime;
    }

    public void setStarttime(String Starttime) {
        this.startTime = Starttime;
    }

    public String getEndtime() {
        return endTime;
    }

    public void setEndtime(String Endtime) {
        this.endTime = Endtime;
    }
}
