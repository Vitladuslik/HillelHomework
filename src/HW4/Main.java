package HW4;

public class Main {

    private static Car markII;
    private static double fuelCost;
    private static final int KYIV_TO_ZHASHKIV = 150;
    private static final int ZHASHKIV_TO_KRYVE_OZERO = 153;
    private static final int KRYVE_OZERO_TO_ODESA = 179;
    private static double moneySpent;

    public static void main(String[] args) {
        try {
            fuelCost = Double.parseDouble(args[0]);  //ініціалізація
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("This app needs arguments to run properly");
        }

        init();

        makeTrip(KYIV_TO_ZHASHKIV);

        makeTrip(ZHASHKIV_TO_KRYVE_OZERO);

        makeTrip(KRYVE_OZERO_TO_ODESA);

        finish();

    }

    private static void init () {
        markII = new Car(70, 6.8, 8.3);

        System.out.println("-------------------------------------------------------------------------------\n");

        System.out.printf("""
                        We currently have %.2f fuel left.
                        Our car use %.2f litres per 100 km.
                        Our fuel tank can be filled up to %.2f litres
                                                
                        """,
                markII.getFuelLeft(), markII.getFUEL_CONSUMED_PER_HUNDRED(), markII.getFUEL_TANK_CAPACITY());

        System.out.println("-------------------------------------------------------------------------------\n");
    }
    private static void makeTrip (int distance) {

        switch (distance) {
            case 150 -> System.out.println("Let's start our journey to Zhashkiv!");
            case 153 -> System.out.println("Let's start our journey to Kryve Pole!");
            case 179 -> System.out.println("Let's start our journey to Odesa!");

        }
        System.out.printf("We need %.2f litres of fuel for this trip!\n",
                markII.calculateNeededFuel(distance));

        moneySpent += markII.fillTheTank(markII.getFuelLeft(), fuelCost);

        System.out.printf("We spent %.2f UAH so far!\n", moneySpent);

        markII.setFuelLeft(markII.calculateFuelLeftAfterTrip(distance, markII.getFuelLeft()));

        System.out.printf("We have %.2f litres of fuel left after reaching our destination. \n\n",
                markII.getFuelLeft());

        System.out.println("-------------------------------------------------------------------------------\n");
    }

    private static void finish() {

        System.out.printf("During the whole trip we spent %.2f UAH and we have %.2f litres of fuel left!",
                moneySpent, markII.getFuelLeft());

    }

}