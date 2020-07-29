package r.w;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedListO {
    private String MedicineName;
    private String TherapeuticArea;
    private String INN;
    private String ActiveSubstance;
    private String ATC;
    private String Company;
    private String PharmacotherapeuticGroup;


    public MedListO(String MedicineName, String TherapeuticArea,
                    String INN, String ActiveSubstance, String ATC, String Company, String PharmacotherapeuticGroup) {
        super();
        this.MedicineName = MedicineName;
        this.TherapeuticArea = TherapeuticArea;
        this.INN = INN;
        this.ActiveSubstance = ActiveSubstance;
        this.ATC = ATC;
        this.Company = Company;
        this.PharmacotherapeuticGroup = PharmacotherapeuticGroup;

    }

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String MedicineName) {
        this.MedicineName = MedicineName;
    }

    public String getTherapeuticArea() {
        return TherapeuticArea;
    }

    public void setTherapeuticArea(String TherapeuticArea) {
        this.TherapeuticArea = TherapeuticArea;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getActiveSubstance() {
        return ActiveSubstance;
    }

    public void setActiveSubstance(String ActiveSubstance) {
        this.ActiveSubstance = ActiveSubstance;
    }

    public String getATC() {
        return ATC;
    }

    public void setATC(String ATC) {
        this.ATC = ATC;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getPharmacotherapeuticGroup() {
        return PharmacotherapeuticGroup;
    }

    public void setPharmacotherapeuticGroup(String TherapeuticArea) {
        this.PharmacotherapeuticGroup = PharmacotherapeuticGroup;
    }

  public static List switcherMedCategorie(int n) {
        createMedList();
        List<String> myList = new ArrayList<>();
        switch (n) {
            case 1:
                for (MedListO m: MedListO.MedList){
                    myList.add(m.getMedicineName());
                };
                break;
            case 2:
                for (MedListO m: MedListO.MedList){
                    myList.add(m.getTherapeuticArea());
                };
                break;
            case 3:
                for (MedListO m: MedListO.MedList){
                    myList.add(m.getINN());
                };
                break;
            case 4:
                for (MedListO m: MedListO.MedList){
                    myList.add(m.getActiveSubstance());
                };
                break;
            case 5:
                for (MedListO m: MedListO.MedList){
                    myList.add(m.getATC());
                };
                break;
            case 6:
                for (MedListO m: MedListO.MedList){
                    myList.add(m.getCompany());
                };
                break;
            case 7:
                for (MedListO m: MedListO.MedList){
                    myList.add(m.getTherapeuticArea());
                };
                break;
            default:
                System.out.println("You Entered an invalid Nuber");

    }
        return myList;
    }

    @Override
    public String toString() {
        return "Medicine [MedicineName=" + MedicineName
                + ", TherapeuticArea=" + TherapeuticArea
                + ", INN=" + INN
                + ", ActiveSubstance=" + ActiveSubstance
                + ", ATC=" + ATC
                +", Company=" + Company
                +", PharmacotherapeuticGroup=" + PharmacotherapeuticGroup
                +"]";
    }
    public static List<MedListO> MedList = new ArrayList<>();
    private static final String Parser = ";";

    public static void createMedList(){
    String neuDateipfad = Path.getPathofMedikamentenliste();

    BufferedReader CSVReader = null;
            try
    {
        CSVReader = new BufferedReader(new FileReader(neuDateipfad));


        String line = "";
        CSVReader.readLine();
        while ((line = CSVReader.readLine()) != null)
        {
            String[] MedicineStringArray = line.split(Parser);


            MedListO medO = new MedListO(
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


    }
            catch(Exception ee)
    {
        ee.printStackTrace();
    }
            finally {
        try {
            CSVReader.close();
        } catch (IOException ie) {
            System.out.println("Error occured while reading the file");
            ie.printStackTrace();

        }
    }
    }
}


