package PracticeManagementSoftware;

public class AppointmentObject {

    private int appointmentID;
    private int patientID;
    private String title;
    private String date;
    private String startTime;
    private String endTime;

    public AppointmentObject(int appointmentID, int patientID, String title, String date, String startTime, String endTime) {
        super();
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "AppointmentObject [AptID: " + appointmentID + ", PatId: " + patientID + ", Title: " + title + ", Date: " + date + ", Start Time: " + startTime + ", End Time: " + endTime + "]";
    }
}
