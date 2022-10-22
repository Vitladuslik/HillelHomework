import java.util.InputMismatchException;
import java.util.Scanner;

public class SeventhTask {

    static Scanner scan;
    static int num;

    public static void main(String[] args) {

        scan = new Scanner(System.in);
        System.out.println("Hi! I can give you the multiplication table of your number!");
        System.out.println("Please enter your number : ");
        try {
            num = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.print("Wrong input!");
            System.exit(0);
        }
        for (int counter = 1; counter <= 10; counter++) {
            int result = num * counter;
            System.out.println(num + " * " + counter + " = " + result);
        }
    }

}
