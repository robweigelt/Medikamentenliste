package r.w;

import java.nio.file.Paths;

class Path {

    private static String path;
    
    static String getPathofMedikamentenliste(int a){
        path = Paths.get("").toAbsolutePath().toString()+ "\\medicines_output_european_public_assessment_reports.csv" ;
        return path;
    }

    static String getPathofDarreichungsformen(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\Darreichungsformen.csv" ;
        return path;
    }
    public static String getPathofMedikamentenakte(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\Medikamentenakte.csv" ;
        return path;
    }
    static String getPathofTerminbuchungen(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\Terminbuchungen.csv" ;
        return path;
    }
    static String getPathofPatientenakte(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\Patientenakte.csv" ;
        return path;
    }
}
