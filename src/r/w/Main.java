package r.w;

import java.io.IOException;

import static r.w.Controller.Menu;

public class Main {


    public static void main(String[] args) throws CloneNotSupportedException, IOException, InterruptedException {


        Controller.Funtext();
       int a = Controller.WelcomeText();
        if (a == 1){
            Menu();

        }
        else {System.exit(0);}

     }}

