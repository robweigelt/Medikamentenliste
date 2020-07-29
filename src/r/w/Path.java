package r.w;

import java.nio.file.Paths;

public class Path {

    private static String path;
    //Erzeugt den Pfad zur CSV DATEI
    public static String getPathofMedikamentenliste(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\medicines_output_european_public_assessment_reports.csv" ;
        System.out.println(path + " aus Klasse Path");
        return (path);
    }

    public static String getPathofDarreichungsformen(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\Darreichungsformen.csv" ;
        System.out.println(path + " aus Klasse Path");
        return (path);
    }
    public static String getPathofMedikamentenakte(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\Medikamentenakte.csv" ;
        System.out.println(path + " aus Klasse Path");
        return (path);
    }
    public static String getPathofTerminbuchungen(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\Terminbuchungen.csv" ;
        System.out.println(path + " aus Klasse Path");
        return (path);
    }
    public static String getPathofPatientenakte(){
        path = Paths.get("").toAbsolutePath().toString()+ "\\Patientenakte.csv" ;
        System.out.println(path + " aus Klasse Path");
        return (path);
    }
}
