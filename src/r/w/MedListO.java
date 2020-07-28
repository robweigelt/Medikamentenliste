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
    String neuDateipfad = Path.getPathofCSV();

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

        //Lets print the Employee List
        //  for(MedListO Objektklasse : MedList)
        //{
        //  System.out.println(Objektklasse.getActiveSubstance() );
        //}

    }
            catch(Exception ee)
    {
        ee.printStackTrace();
    }
            finally {
        try {
            CSVReader.close();
        } catch (IOException ie) {
            System.out.println("Error occured while closing the BufferedReader");
            ie.printStackTrace();

        }
    }
    }
}


