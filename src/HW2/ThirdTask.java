package HW2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Vitalii Kirenkin
 */

public class ThirdTask {
    static double depositAmount;
    static double annualRate;
    static int years;
    static int yearsCounter;
    static double revenue;

    public static void main(String[] args) {
        try {
            depositAmount = Integer.parseInt(args[0]);
            annualRate = Double.parseDouble(args[1]);
            years = Integer.parseInt(args[2]);
            doMath();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Need three arguments to run this app!");
        }

    }

    static void doMath() {
        System.out.println("Deposit amount = " + depositAmount + " UAH.");
        System.out.println("Annual rate = " + annualRate + "%.");
        System.out.println("Years = " + years);
        System.out.println("--------------------------------");
        yearsCounter = 1;
        annualRate /= 100;
        while (yearsCounter <= years) {
            System.out.println("Year " + yearsCounter);
            double depositBefore = depositAmount;
            double depositAfter = calcRevenue(depositBefore);
            revenue = depositAfter - depositBefore;
            depositAmount = depositAfter;
            System.out.printf("Deposit amount =  %.2f UAH. \n", depositAmount);
            System.out.printf("Revenue amount : %.2f UAH. \n", revenue);
            System.out.println("--------------------------------");
            yearsCounter++;
        }
    }

    static double roundValue(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    static double calcRevenue(double depositBefore) {
        double depositAfter = depositBefore + roundValue((depositAmount * (annualRate) * 31) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 28) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 30) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 30) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 30) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 30) / 365);
        depositAfter += roundValue((depositAfter * (annualRate) * 31) / 365);
        return depositAfter;
    }

}
