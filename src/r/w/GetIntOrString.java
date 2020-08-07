package r.w;
import java.util.Scanner;

class GetIntOrString {

static String GetmyString(){
    Scanner input = new Scanner(System.in);
    while (true) {
        try {
            return input.nextLine();
        }
        catch (java.util.InputMismatchException e) {
            input.nextLine();
        }
    }
}
static int GetmyInt() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                return input.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("You entered an invalid number");
                input.nextLine();
            }
        }
    }
}
