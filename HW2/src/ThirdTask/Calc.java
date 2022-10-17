package ThirdTask;

import static ThirdTask.ThirdTask.depositAmount;
import static ThirdTask.ThirdTask.annualRate;

public class Calc {
    static double calcRevenue(double depositBefore) {
        double depositAfter = depositBefore + Rounder.roundValue((depositAmount * (annualRate) * 31) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 28) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 30) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 30) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 30) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 31) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 30) / 365);
        depositAfter += Rounder.roundValue((depositAfter * (annualRate) * 31) / 365);
        return depositAfter;
    }
}
