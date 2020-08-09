package r.w;

import java.io.IOException;

import static r.w.Controller.Menu;

public class Main {


    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException, IOException {


       int a = Controller.WelcomeText();
        if (a == 1){
            Menu();
            System. out. print("\033[H\033[2J");
        }
        else {System.exit(0);}

     }}

