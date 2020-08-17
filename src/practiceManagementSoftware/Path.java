package practiceManagementSoftware;

import java.nio.file.Paths;

//Code Tabea Boeger -- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt

//Get Nio-Path
class Path {

    private static String path;
    
    static String getPathofMedikamentenliste(){
        path = Paths.get("").toAbsolutePath().toString()+ "/medicines_output_european_public_assessment_reports.csv" ;
        return path;
    }

    static String getPathofDarreichungsformen(){
        path = Paths.get("").toAbsolutePath().toString()+ "/MedicalRecord.csv" ;
        return path;
    }
}
