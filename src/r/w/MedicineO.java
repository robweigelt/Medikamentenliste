package r.w;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicineO
{   private String ID;
    private String Title;
    private String Surname;
    private String Name;
    private String Medicine;
    private String TherapeuticArea;
    private String DosageForm;

    public MedicineO (String ID, String Title, String Surname, String Name, String Medicine, String TherapeuticArea, String DosageForm)
    {
        super();
        this.ID = ID;
        this.Title = Title;
        this.Surname = Surname;
        this.Name = Name;
        this.Medicine = Medicine;
        this.TherapeuticArea = TherapeuticArea;
        this.DosageForm = DosageForm;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String Title)
    {
        this.Title = Title;
    }

    public String getSurname()
    {
        return Surname;
    }

    public void setSurname(String Surname)
    {
        this.Surname = Surname;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getMedicine()
    {
        return Medicine;
    }

    public void setMedicine(String Medicine)
    {
        this.Medicine = Medicine;
    }

    public String getTherapeuticArea()
    {
        return TherapeuticArea;
    }

    public void setTherapeuticArea(String TherapeuticArea)
    {
        this.TherapeuticArea = TherapeuticArea;
    }

    public String getDosageForm()
    {
        return DosageForm;
    }

    public void setDosageForm(String DosageForm)
    {
        this.DosageForm = DosageForm;
    }


    public static List switcherMedicineCategory(int n)
    {
        createMedicine();
        List<String> myList = new ArrayList<>();
        switch (n)
        {
            case 1:
                for (MedicineO m: MedicineO.Medicine1)
                {
                    myList.add(m.getID());
                }
                break;

            case 2:
                for (MedicineO m: MedicineO.Medicine1)
                {
                    myList.add(m.getTitle());
                }
                break;

            case 3:
                for (MedicineO m: MedicineO.Medicine1)
                {
                    myList.add(m.getSurname());
                }
                break;

            case 4:
                for (MedicineO m: MedicineO.Medicine1)
                {
                    myList.add(m.getName());
                }
                break;

            case 5:
                for (MedicineO m: MedicineO.Medicine1)
                {
                    myList.add(m.getMedicine());
                }
                break;

            case 6:
                for (MedicineO m: MedicineO.Medicine1) {
                    myList.add(m.getTherapeuticArea());
                }
                break;

            case 7:
                for (MedicineO m: MedicineO.Medicine1) {
                    myList.add(m.getDosageForm());
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
                + ", Medicine =" + Medicine
                + ", TherapeuticArea =" + TherapeuticArea
                + ", DosageForm =" + DosageForm
                + "]";
    }

    public static List<MedicineO> Medicine1 = new ArrayList<>();
    private static final String Parser = ";";

    public static void createMedicine() {
        String neuDateipfad = Path.getPathofDarreichungsformen();

        BufferedReader CSVReader = null;
        try {
            CSVReader = new BufferedReader(new FileReader(neuDateipfad));


            String line = "";
            CSVReader.readLine();
            while ((line = CSVReader.readLine()) != null) {
                String[] MedicineStringArray = line.split(Parser);


                MedicineO medicine0 = new MedicineO
                (
                        MedicineStringArray[0],
                        MedicineStringArray[1],
                        MedicineStringArray[2],
                        MedicineStringArray[3],
                        MedicineStringArray[4],
                        MedicineStringArray[5],
                        MedicineStringArray[6]
                );
                Medicine1.add(medicine0);

            }

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                CSVReader.close();
            } catch (IOException ie) {
                System.out.println("Error occured while reading the file");
                ie.printStackTrace();

            }
        }
    }
}
