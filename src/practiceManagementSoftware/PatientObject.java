package practiceManagementSoftware;

public class PatientObject {

    private int patient_Id;
    private String name;
    private String surname;
    private String gender;
    private String dateOfBirth;
    private String insuranceName;
    private String street;
    private String city;
    private String zip;

    public PatientObject(int patient_Id, String name, String surname, String gender, String dateOfBirth, String insuranceName, String street, String city, String zip) {
        super();
        this.patient_Id = patient_Id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.insuranceName = insuranceName;
        this.street = street;
        this.city = city;
        this.zip = zip;
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

//    @Override
//    public String toString() {
//        return "PatientObject [ID: " + patient_Id + ", Name: " + name + ", Surname: " + surname + ", Gender: " + gender + ", DOB: " + dateOfBirth + ", Insurance: " + insuranceName + ", Street: " + street + ", City: " + city + ", Zip: " + zip + "]";
//    }

    @Override
    public String toString() {

        String leftAlignFormat = "| %-10s | %-40s |%n";
        String line = String.format("+------------+------------------------------------------+%n");
        String print = line + String.format(leftAlignFormat,"ID", patient_Id)
                + line + String.format(leftAlignFormat,"Name", name)
                + line + String.format(leftAlignFormat,"Surname", surname)
                + line + String.format(leftAlignFormat,"Gender", gender)
                + line + String.format(leftAlignFormat,"Birth date", dateOfBirth)
                + line + String.format(leftAlignFormat,"Insurance", insuranceName)
                + line + String.format(leftAlignFormat,"Street", street)
                + line + String.format(leftAlignFormat,"City", city)
                + line + String.format(leftAlignFormat,"ZIP", zip)
                + line;
        return print;
    }

}
