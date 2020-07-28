package r.w;

import java.nio.file.Paths;

public class Path {

    private static String path;
    //Erzeugt den Pfad zur CSV DATEI
    public static String getPathofCSV(){

        path = Paths.get("").toAbsolutePath().toString()+ "\\medicines_output_european_public_assessment_reports.csv" ;
        System.out.println(path + " aus Klasse Path");
        return (path);

    }

}
