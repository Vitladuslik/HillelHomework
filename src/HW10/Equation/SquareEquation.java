package HW10.Equation;

import java.util.Scanner;

public class SquareEquation {

    static int a;
    static int b;
    static int c;

    static double x1;

    static double x2;

    static int discriminant;

    public static void main(String[] args) {

        initVars();

        countDiscriminant(a, b, c);

        if (discriminant < 0) {
            System.out.println("This equation has no roots");
        } else if (discriminant == 0) {
            x1 = -b / 2 * a;
            System.out.println("This equation has only one root : " + x1);
        } else if (discriminant > 0) {
            x1 =  (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 =  (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots of this equation are : " + x1 + ", " + x2);
        }


    }

    static void initVars() {

        Scanner scan = new Scanner(System.in);

        System.out.println("I can help you to solve quadratic equation and find 'x'.");

        System.out.print("Enter 'a' : ");
        a = scan.nextInt();

        System.out.print("Enter 'b' : ");
        b = scan.nextInt();

        System.out.print("Enter 'c' : ");
        c = scan.nextInt();

    }

    static void countDiscriminant(int a, int b, int c) {
        discriminant = ((int) Math.pow(b, 2) - 4 * a * c);
    }

}
