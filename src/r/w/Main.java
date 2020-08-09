package r.w;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException, IOException {


       int a = Controller.WelcomeText();
        if (a == 1){
            Controller.Menu();
            System. out. print("\033[H\033[2J");
        }
        else {System.exit(0);}

     }}

