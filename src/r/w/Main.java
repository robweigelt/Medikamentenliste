package r.w;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) {
       int a = Controller.WelcomeText();
        if (a == 1){
            Controller.Menu();
        }
        else {System.exit(0);}

     }}

