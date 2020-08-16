package practiceManagementSoftware;

import java.io.IOException;

public class Main {

    //Code Tabea Boeger -- Design Hannes Kukulenz-- Exception Handling Robert Weigelt
    public static void main(String[] args) throws CloneNotSupportedException, IOException {

        //MainMenu.Funtext();
       int a = MainMenu.WelcomeText();
        if (a == 1){
            MainMenu.Menu();

        }
        else {System.exit(0);}

     }}

