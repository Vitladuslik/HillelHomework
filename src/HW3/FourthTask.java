package HW3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FourthTask {

    static Scanner scan;
    static int num;

    public static void main(String[] args) {

        oddNumbers();
        System.out.println("------------------------------");
        factorial();

    }

    private static void oddNumbers() {
        int x = 1;
        do {
            System.out.println(x);
            x += 2;
        } while (x < 100);

    }

    private static void factorial() {
        int counter;
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
            counter = num - 1;
            do {
                num *= counter;
                counter--;
            } while (counter > 0);
            System.out.print("Factorial of your number is : " + num);
        }
    }

}
