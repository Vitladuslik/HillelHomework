
/**
 * @author Vitalii Kirenkin
 */

public class ThirdTask {
    static double depositAmount;
    static double annualRate;
    static int years;
    static int counter;

    public static void main(String [] args) {

        depositAmount = Integer.parseInt(args[0]);
        annualRate = Double.parseDouble(args[1]);
        years = Integer.parseInt(args[2]);
        doMath();

    }

    static void doMath() {
        System.out.println("Deposit amount = " + depositAmount + " UAH.");
        System.out.println("Annual rate = " + annualRate + "%.");
        System.out.println("Years = " + years);
        System.out.println("--------------------------------");
        counter = 1;
        while (counter <= years) {
            System.out.println("Year " + counter);
            depositAmount*=(1+(annualRate/100));
            System.out.printf("Deposit amount =  %.2f UAH \n", depositAmount);
            System.out.println("--------------------------------");
            counter++;
        }
    }
}
