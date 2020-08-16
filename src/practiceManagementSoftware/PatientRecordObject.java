package practiceManagementSoftware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Creates Object for CSV
class PatientRecordObject
{
    private String ID;
    private String Title;
    private String Surname;
    private String Name;
    private String Medicine;
    private String TherapeuticArea;
    private String DosageForm;

    PatientRecordObject(String ID, String Title, String Surname, String Name, String Medicine, String TherapeuticArea, String DosageForm)
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

    public PatientRecordObject() {

    }

    static int SelectSearch(){
        System.out.print("__________________________________________\n"+
                "Main Menu \n"+
                "⌞ Patient Medical Record Menu\n"+
                "  ⌞ Search\n\n" +
                "[1] ID  \n" +
                "[2] Title  \n" +
                "[3] Surname  \n" + "[4] Name  \n" +
                "[5] Medicine \n"+"[6] TherapeuticAreal  \n" +
                "[7] DosageForm\n\nEnter choice here: ");
        return GetIntOrString.GetmyInt();
    }
    //List Array Indexing
    static void SearchInsideListArray(int index) {
        createMedicine();
        System.out.println(Medicine1.get(index));
        Medicine1.clear();
    }
    //Creates new Entry
     void newEntry() throws IOException, CloneNotSupportedException {
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
            String Splitter = ";";
            String RowString = "\n" +ID + Splitter + Title + Splitter + Surname + Splitter + Name + Splitter + Medicine + Splitter + TherapeuticArea + Splitter + DosageForm;
            try {
                createnewLine.append(RowString);
                createnewLine.flush();
                createnewLine.close();
            } catch (IOException ignored) {
            }
        }
        else{
            PatientRecordMenu.Menu();
        }
        Medicine1.clear();



    }


    //List all Items
//    static void ListAllItems(){
//        createMedicine();
//        for (PatientRecordObject patientRecordObject : Medicine1)
//            try {
//                System.out.println(patientRecordObject);
//            } catch (IndexOutOfBoundsException ignored) {
//            }
//        Medicine1.clear();
//    }

        static void ListAllItems(){
        createMedicine();
        String leftAlignFormat = "| %-5s | %-5s | %-15s | %-15s | %-15s | %-15s | %-30s |%n";
        System.out.format("+-------+-------+-----------------+-----------------+-----------------+-----------------+--------------------------------+%n");
        System.out.format("| ID    | Title | Name            | Surname         | Medicine        | TherapeuticArea | DosageForm                     |%n");
        System.out.format("+-------+-------+-----------------+-----------------+-----------------+-----------------+--------------------------------+%n");

        for (PatientRecordObject patientRecordObject : Medicine1){

                System.out.format(leftAlignFormat,patientRecordObject.getID(),patientRecordObject.getTitle(),patientRecordObject.getName(),patientRecordObject.getSurname(),HelperFunctions.cut(patientRecordObject.getMedicine(),15), HelperFunctions.cut(patientRecordObject.getTherapeuticArea(),15),HelperFunctions.cut(patientRecordObject.getDosageForm(),30));

        }


        System.out.format("+-------+-------+-----------------+-----------------+-----------------+-----------------+--------------------------------+%n");

        Medicine1.clear();
    }

//Getter
    private String getID()
    {
        return ID;
    }

    private String getTitle()
    {
        return Title;
    }

    private String getSurname()
    {
        return Surname;
    }

    private String getName()
    {
        return Name;
    }

    private String getMedicine()
    {
        return Medicine;
    }

    private String getTherapeuticArea()
    {
        return TherapeuticArea;
    }

    private String getDosageForm()
    {
        return DosageForm;
    }

//Get full list with comparing PatientRecordObject
    static List <String> switcherMedicineCategory(int n)
    {
        createMedicine();
        List<String> myList = new ArrayList<>();
        switch (n)
        {
            case 1:
                for (PatientRecordObject m: PatientRecordObject.Medicine1)
                {
                    myList.add(m.getID());
                }
                break;
            case 2:
                for (PatientRecordObject m: PatientRecordObject.Medicine1)
                {
                    myList.add(m.getTitle());
                }
                break;
            case 3:
                for (PatientRecordObject m: PatientRecordObject.Medicine1)
                {
                    myList.add(m.getSurname());
                }
                break;
            case 4:
                for (PatientRecordObject m: PatientRecordObject.Medicine1)
                {
                    myList.add(m.getName());
                }
                break;
            case 5:
                for (PatientRecordObject m: PatientRecordObject.Medicine1)
                {
                    myList.add(m.getMedicine());
                }
                break;
            case 6:
                for (PatientRecordObject m: PatientRecordObject.Medicine1) {
                    myList.add(m.getTherapeuticArea());
                }
                break;
            case 7:
                for (PatientRecordObject m: PatientRecordObject.Medicine1) {
                    myList.add(m.getDosageForm());
                }
                break;
            default:
                System.out.println("You entered an invalid number");

        }
        return myList;
    }
//Convert Object to visable String
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
//Filereader
    private final static List<PatientRecordObject> Medicine1 = new ArrayList<>();
    private static final String Parser = ";";

    private static void createMedicine() {
        String neuDateipfad = Path.getPathofDarreichungsformen();

        BufferedReader CSVReader = null;
        try {
            CSVReader = new BufferedReader(new FileReader(neuDateipfad));

            String line;
            CSVReader.readLine();
            while ((line = CSVReader.readLine()) != null) {
                String[] MedicineStringArray = line.split(Parser);

                PatientRecordObject medicine0 = new PatientRecordObject
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
        } catch (IOException ee) {
            ee.printStackTrace();
        } finally {
            try {
                assert CSVReader != null;
                CSVReader.close();
            } catch (IOException ie) {
                System.out.println("Error occurred while reading the file");
                ie.printStackTrace();
            }
        }
    }
}
