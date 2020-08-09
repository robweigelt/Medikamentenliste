package r.w;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PatientO
{
    private String ID;
    private String Title;
    private String Surname;
    private String Name;
    private String DateOfBirth;
    private String HealthInsurance;
    private String City;
    private String Postcode;
    private String Street;


    private PatientO(String ID, String Title, String Surname, String Name, String DateOfBirth, String HealthInsurance, String City, String Postcode, String Street)
    {
        super();
        this.ID = ID;
        this.Title = Title;
        this.Surname = Surname;
        this.Name = Name;
        this.DateOfBirth = DateOfBirth;
        this.HealthInsurance = HealthInsurance;
        this.City = City;
        this.Postcode = Postcode;
        this.Street = Street;
    }

    private String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    private String getTitle()
    {
        return Title;
    }

    public void setTitle(String Title)
    {
        this.Title = Title;
    }

    private String getSurname()
    {
        return Surname;
    }

    public void setSurname(String Surname)
    {
        this.Surname = Surname;
    }

    private String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    private String getDateOfBirth()
    {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth)
    {
        this.DateOfBirth = DateOfBirth;
    }

    private String getHealthInsurance()
    {
        return HealthInsurance;
    }

    public void setHealthInsurance(String HealthInsurance)
    {
        this.HealthInsurance = HealthInsurance;
    }

    private String getCity()
    {
        return City;
    }

    public void setCity(String City)
    {
        this.City = City;
    }

    private String getPostcode()
    {
        return Postcode;
    }

    public void setPostcode(String Postcode)
    {
        this.Postcode = Postcode;
    }

    private String getStreet()
    {
        return Street;
    }

    public void setStreet(String Street)
    {
        this.Street = Street;
    }

    public static List switcherPatientCategory(int n)
    {
        createPatient();
        List<String> myList = new ArrayList<>();
        switch (n)
        {
            case 1:
                for (PatientO p: PatientO.Patient)
                {
                    myList.add(p.getID());
                }
                break;

            case 2:
                for (PatientO p: PatientO.Patient)
                {
                    myList.add(p.getTitle());
                }
                break;

            case 3:
                for (PatientO p: PatientO.Patient)
                {
                    myList.add(p.getSurname());
                }
                break;

            case 4:
                for (PatientO p: PatientO.Patient)
                {
                    myList.add(p.getName());
                }
                break;

            case 5:
                for (PatientO p: PatientO.Patient)
                {
                    myList.add(p.getDateOfBirth());
                }
                break;

            case 6:
                for (PatientO p: PatientO.Patient) {
                    myList.add(p.getHealthInsurance());
                }
                break;

            case 7:
                for (PatientO p: PatientO.Patient) {
                    myList.add(p.getCity());
                }
                break;

            case 8:
                for (PatientO p: PatientO.Patient) {
                    myList.add(p.getPostcode());
                }
                break;

            case 9:
                for (PatientO p: PatientO.Patient) {
                    myList.add(p.getStreet());
                }
                break;
            default:
                System.out.println("You Entered an invalid Number");

        }
        return myList;
    }

    @Override
    public String toString() {
        return "ID [ID =" + ID
                + ", Title =" + Title
                + ", Surname =" + Surname
                + ", Name =" + Name
                + ", DateOfBirth =" + DateOfBirth
                + ", HealthInsurance =" + HealthInsurance
                + ", City =" + City
                + ", Postcode =" + Postcode
                + ", Street =" + Street
                + "]";
    }

    private final static List<PatientO> Patient = new ArrayList<>();
    private static final String Parser = ";";

    private static void createPatient() {
        String neuDateipfad = Path.getPathofPatientenakte();

        BufferedReader CSVReader = null;
        try {
            CSVReader = new BufferedReader(new FileReader(neuDateipfad));


            String line;
            CSVReader.readLine();
            while ((line = CSVReader.readLine()) != null) {
                String[] PatientStringArray = line.split(Parser);


                PatientO patientO = new PatientO(
                        PatientStringArray[0],
                        PatientStringArray[1],
                        PatientStringArray[2],
                        PatientStringArray[3],
                        PatientStringArray[4],
                        PatientStringArray[5],
                        PatientStringArray[6],
                        PatientStringArray[7],
                        PatientStringArray[8]
                );
                Patient.add(patientO);

            }

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(CSVReader).close();
            } catch (IOException ie) {
                System.out.println("Error occurred while reading the file");
                ie.printStackTrace();

            }
        }
    }
}
