import java.util.InputMismatchException;
import java.util.Scanner;

public class FifthTask {

    static Scanner scan;
    static int x;
    static int n;

    public static void main(String[] args) {
        initVars();
        output(doMath(x, n));
    }

    private static void initVars() {
        try {
            scan = new Scanner(System.in);
            System.out.println("Hi! I can return you x^n!");
            System.out.print("Please enter x : ");
            x = scan.nextInt();
            System.out.print("Please enter n : ");
            n = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.print("Wrong input!");
        }
    }
    private static int doMath(int x, int n) {
        if (x == 0 || n == 0) {
            System.err.print("Wrong input!");
            System.exit(0);
        }
        return (int) Math.pow(x, n);
    }

    private static void output(int result) {
        System.out.print("Your result is : " + result);
    }

}
