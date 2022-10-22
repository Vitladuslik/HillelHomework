import java.util.InputMismatchException;
import java.util.Scanner;

public class SecondTask {

    static Scanner scan;
    static int num;

    public static void main(String[] args) {

        scan = new Scanner(System.in);
        System.out.print("Hi! Enter the number, factorial of which you want to receive: ");
        try {
            num = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.print("Wrong input!");
        }
        if (num == 0) {
            System.out.print("Factorial of your number is : 1");
        } else {
            for (int x = num - 1; x > 0; x--) {
                num *= x;
            }
            System.out.print("Factorial of your number is : " + num);
        }
    }

}
