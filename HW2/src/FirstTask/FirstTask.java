package FirstTask;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Vitalii Kirenkin
 */

public class FirstTask {

    static Scanner scan;
    static int firstNum;
    static int secondNum;
    static int result;

    public static void main(String[] args) {

        initVars();
        doMath(firstNum, secondNum);
        output(result);
    }


    static void initVars() {
        try {
            scan = new Scanner(System.in);
            System.out.println("I can find average value of two numbers!");
            System.out.print("Enter the first number: ");
            firstNum = scan.nextInt();
            System.out.print("Enter the second number: ");
            secondNum = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.print("Wrong value!");
        }
    }

    static void doMath(int firstNum, int secondNum) {
        result = (firstNum + secondNum) / 2;
    }

    static void output(int result) {
        System.out.print("Your result is: " + result + ".");
    }
}
