package HW2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Vitalii Kirenkin
 */

public class SecondTask {

    static Scanner scan;
    static int numAmount;
    static int sum;
    static int result;
    static int counter;

    public static void main(String[] args) {
        initVars();
        doMath();
        output(result);
    }

    static void initVars() {
        try {
            scan = new Scanner(System.in);
            System.out.println("I can find average value of multiply numbers!");
            System.out.print("Set the amount of numbers you would like to use: ");
            numAmount = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.print("Wrong value!");
        }
    }

    static void doMath() {
        try {
            if (numAmount == 0) {
                System.err.println("Cannot work with zero numbers!");
                System.exit(0);
            } else {
                while (numAmount > counter) {
                    counter++;
                    System.out.print("Please enter the " + counter + " number: ");
                    int num = scan.nextInt();
                    sum += num;
                }
                result = sum / numAmount;
            }
        } catch (InputMismatchException e) {
            System.err.print("Wrong value!");
        }
    }

    static void output(int result) {
        System.out.print("Average value is: " + result + ".");
    }
}