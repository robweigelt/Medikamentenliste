package r.w;
public class Main {


    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {


       int a = Controller.WelcomeText();
        if (a == 1){
            Controller.Menu();
            System. out. print("\033[H\033[2J");
        }
        else {System.exit(0);}

     }}

