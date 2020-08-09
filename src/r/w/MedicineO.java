package r.w;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MedicineO
{
    private static String ID;
    private static String Title;
    private static String Surname;
    private static String Name;
    private static String Medicine;
    private static String TherapeuticArea;
    private static String DosageForm;

    private MedicineO(String ID, String Title, String Surname, String Name, String Medicine, String TherapeuticArea, String DosageForm)
    {
        super();
        MedicineO.ID = ID;
        MedicineO.Title = Title;
        MedicineO.Surname = Surname;
        MedicineO.Name = Name;
        MedicineO.Medicine = Medicine;
        MedicineO.TherapeuticArea = TherapeuticArea;
        MedicineO.DosageForm = DosageForm;
    }
    static int SelectSearch(){

        System.out.println("Please select between the different categories you are seraching for by pressing the number [] and [Enter]:\n" +
                "ID [1] \n" +
                "Title [2] \n" +
                "Surname [3] \n" + "Name [4] \n" +
                "Medicine [5]\n"+"TherapeuticAreal [6] \n" +
                "DosageForm [7]"
        );
        return GetIntOrString.GetmyInt();
    }
    static void SearchInsideListArray(int index)

    {

        createMedicine();
        System.out.println(Medicine1.get(index));
        Medicine1.removeAll(Medicine1);


    }
    public static void newEntry() throws IOException{
        String neuDateipfad = Path.getPathofDarreichungsformen();
        FileWriter createnewLine = new FileWriter(neuDateipfad,true);
        System.out.println("Please enter all the information an press enter");
        System.out.println("ID:");
         ID =GetIntOrString.GetmyString();
        System.out.println("Title:");
        Title =GetIntOrString.GetmyString();
        System.out.println("Surname:");
        Surname =GetIntOrString.GetmyString();
        System.out.println("Name:");
        Name =GetIntOrString.GetmyString();
        System.out.println("Medicine:");
        Medicine =GetIntOrString.GetmyString();
        System.out.println("TherapeuticArea:");
        TherapeuticArea =GetIntOrString.GetmyString();
        System.out.println("DosageForm:");
        DosageForm =GetIntOrString.GetmyString();

        System.out.println("You entered:\nID:"+ ID +"\nTitle:"+Title+"\nSurname:"+Surname+"\nName:"+Name+"\nMedicine:"+Medicine+"\nTherapeutic Area:"+TherapeuticArea+"\nDosage Form:"+DosageForm+"\nIf everything is correct please Press[1] otherwise Enter [0]");
        var correctionInt = GetIntOrString.GetmyInt();

        if (correctionInt == 1) {
            String Spliter = ";";
            String RowString = "\n" +ID + Spliter + Title + Spliter + Surname + Spliter + Name + Spliter + Medicine + Spliter + TherapeuticArea + Spliter + DosageForm;
            try {
                createnewLine.append(RowString);
                createnewLine.flush();
                createnewLine.close();
            } catch (IOException ignored) {
            }
        }
        else{
            newEntry();
        }



    }
    static void ListAllItems(){
        createMedicine();
        for (MedicineO medicineO : Medicine1)
            try {
                System.out.println(medicineO);
            } catch (IndexOutOfBoundsException e) {
            }
        Medicine1.removeAll(Medicine1);
    }

    private String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        MedicineO.ID = ID;
    }

    private String getTitle()
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
        return " ID =" + ID +"\n"
                + " Title =" + Title + "\n"
                + " Surname =" + Surname + "\n"
                + " Name =" + Name + "\n"
                + " Medicine =" + Medicine + "\n"
                + " TherapeuticArea =" + TherapeuticArea + "\n"
                + " DosageForm =" + DosageForm + "\n"
                ;
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
