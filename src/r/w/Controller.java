package r.w;

public class Controller {

    //Starter
    public static int WelcomeText(){
        System.out.println("Welcome to the private practice, Please press [1] and [Enter] to continue");
         var a = GetIntOrString.GetmyInt();
         return a;


    }
    //Main Menu
    public static void Menu(){
       System.out.println("Please choose between the different menus by pressing the number [] and [Enter]:\n" +
               "Patient Record [1] \n" +
               "Medicine Glossar [2]\n" +
               "Inventory [3]\n" +
               "Calendar [4]\n" +
               "Close [5]"
      );
        InsideMenu(GetIntOrString.GetmyInt());
    }
    //Switch to Submenus
    public static void InsideMenu ( int Switcher) {
        switch (Switcher) {
            case 1:

                break;
            case 2:

                break;
            case 3:
                System.out.println("i ist drei");
                break;
            case 4:
                System.out.println("Ups");
            case 5:
            {System.exit(0);}

            //Invalid Number
            default: System.out.println("You entered an invalid number");


        }
    }
}
