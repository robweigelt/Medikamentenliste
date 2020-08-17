package practiceManagementSoftware;

import java.io.IOException;

public class Main {

    //Code Tabea Boeger -- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt
    public static void main(String[] args) throws CloneNotSupportedException, IOException, InterruptedException {

       int a = MainMenu.WelcomeText();
        if (a == 1){
            MainMenu.Menu();

        }
        else {System.exit(0);}

     }}

