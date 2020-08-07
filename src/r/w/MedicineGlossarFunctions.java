package r.w;

import java.util.Arrays;

public class MedicineGlossarFunctions {



    static int SelectSearch(){

        System.out.println("Please select between the different categories you are seraching for by pressing the number [] and [Enter]:\n" +
        "MedicineName [1] \n" +
        "TherapeuticArea [2] \n" +
        "INN [3] \n" + "ActiveSubstance [4] \n" +
        "ATC [5]\n"+"Company [6] \n" +
        "PharmacotherapeuticGroup [7]"
    );
        return GetIntOrString.GetmyInt();
    }


    public static boolean useLoop(String[] arr, String targetValue) {
        for(String s: arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }

}
