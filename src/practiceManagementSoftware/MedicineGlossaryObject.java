package practiceManagementSoftware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Creates PatientRecordObject -> ListArray
class MedicineGlossaryObject {
    private final String MedicineName;
    private final String TherapeuticArea;
    private final String INN;
    private final String ActiveSubstance;
    private final String ATC;
    private final String Company;
    private final String PharmacotherapeuticGroup;


    private MedicineGlossaryObject(String MedicineName, String TherapeuticArea,
                                   String INN, String ActiveSubstance, String ATC, String Company, String PharmacotherapeuticGroup) {
        //Superclass
        super();
        this.MedicineName = MedicineName;
        this.TherapeuticArea = TherapeuticArea;
        this.INN = INN;
        this.ActiveSubstance = ActiveSubstance;
        this.ATC = ATC;
        this.Company = Company;
        this.PharmacotherapeuticGroup = PharmacotherapeuticGroup;

    }

    //Getter
    private String getMedicineName() {
        return MedicineName;
    }

    private String getTherapeuticArea() {
        return TherapeuticArea;
    }

    private String getINN() {
        return INN;
    }

    private String getActiveSubstance() {
        return ActiveSubstance;
    }

    private String getATC() {
        return ATC;
    }

    private String getCompany() {
        return Company;
    }

    private String getPharmacotherapeuticGroup() {
        return PharmacotherapeuticGroup;
    }

    //Searcher
    static void SearchInsideListArray(int index)

    {
        createMedList();
        try{
        System.out.println(MedList.get(index));}
        catch (IndexOutOfBoundsException ignored){}
        MedList.clear();


    }

//
  static List<String> switcherMedCategories(int n) {
      ArrayList<String> myList = new ArrayList<>();
        {
        createMedList();

        switch (n) {
            case 1:
                for (MedicineGlossaryObject m: MedicineGlossaryObject.MedList){
                    myList.add(m.getMedicineName());
                }
                break;
            case 2:
                for (MedicineGlossaryObject m: MedicineGlossaryObject.MedList){
                    myList.add(m.getTherapeuticArea());
                }
                break;
            case 3:
                for (MedicineGlossaryObject m: MedicineGlossaryObject.MedList){
                    myList.add(m.getINN());
                }
                break;
            case 4:
                for (MedicineGlossaryObject m: MedicineGlossaryObject.MedList){
                    myList.add(m.getActiveSubstance());
                }
                break;
            case 5:
                for (MedicineGlossaryObject m: MedicineGlossaryObject.MedList){
                    myList.add(m.getATC());
                }
                break;
            case 6:
                for (MedicineGlossaryObject m: MedicineGlossaryObject.MedList){
                    myList.add(m.getCompany());
                }
                break;
            case 7:
                for (MedicineGlossaryObject m: MedicineGlossaryObject.MedList){
                    myList.add(m.getPharmacotherapeuticGroup());
                }
                break;
            default:
                System.out.println("You Entered an invalid Number");

    }


    }
      MedList.clear();
      return myList;

    }

    @Override
    public String toString() {
        return "MedicineName=" + MedicineName +"\n"
                + "TherapeuticArea=" + TherapeuticArea +"\n"
                + "INN=" + INN +"\n"
                + "ActiveSubstance=" + ActiveSubstance +"\n"
                + "ATC=" + ATC +"\n"
                +"Company=" + Company +"\n"
                +"PharmacotherapeuticGroup=" + PharmacotherapeuticGroup +"\n";
    }
    static int SelectSearch(){

        System.out.println("Please select between the different categories you are searching for by pressing the number [] and [Enter]:\n" +
                "MedicineName [1] \n" +
                "TherapeuticArea [2] \n" +
                "INN [3] \n" + "ActiveSubstance [4] \n" +
                "ATC [5]\n"+"Company [6] \n" +
                "PharmacotherapeuticGroup [7]"
        );
        return GetIntOrString.GetmyInt();
    }
    private final static List<MedicineGlossaryObject> MedList = new ArrayList<>();
    private static final String Parser = ";";

    private static void createMedList(){
    String neuDateipfad = Path.getPathofMedikamentenliste();

    BufferedReader CSVReader = null;
        try {
            CSVReader = new BufferedReader(new FileReader(neuDateipfad));


            String line;
            CSVReader.readLine();
            while ((line = CSVReader.readLine()) != null) {
                String[] MedicineStringArray = line.split(Parser);


                var medO = new MedicineGlossaryObject(
                        MedicineStringArray[0],
                        MedicineStringArray[1],
                        MedicineStringArray[2],
                        MedicineStringArray[3],
                        MedicineStringArray[4],
                        MedicineStringArray[5],
                        MedicineStringArray[6]
                );
                MedList.add(medO);

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


