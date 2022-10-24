public class Main {

    private static final int KYIV_TO_ZHASHKIV = 150;
    private static final int ZHASHKIV_TO_KRYVE_OZERO = 153;
    private static final int KRYVE_OZERO_TO_ODESA = 179;
    private static double moneySpent;

    public static void main(String[] args) {

        Car markII = new Car(70, 6.8, 8.3);
        double fuelCost = Double.parseDouble(args[0]); //ініціалізація

        System.out.println("-------------------------------------------------------------------------------\n");

        System.out.printf("""
                        We currently have %.2f fuel left.
                        Our car use %.2f litres per 100 km.
                        Our fuel tank can be filled up to %.2f litres
                                                
                        """,
                markII.getFuelLeft(), markII.getFUEL_CONSUMED_PER_HUNDRED(), markII.getFUEL_TANK_CAPACITY());

        System.out.println("-------------------------------------------------------------------------------\n");

        System.out.println("Let's start our journey to Zhaskiv!"); //відправлення

        System.out.printf("We need %.2f litres of fuel for this trip!\n",
                markII.calculateNeededFuel(KYIV_TO_ZHASHKIV));

        moneySpent += markII.fillTheTank(markII.getFuelLeft(), fuelCost);

        System.out.printf("We spent %.2f UAH so far!\n", moneySpent); //прибуття

        markII.setFuelLeft(markII.calculateFuelLeftAfterTrip(KYIV_TO_ZHASHKIV, markII.getFuelLeft()));

        System.out.printf("We have %.2f litres of fuel left after reaching Zhashkiv. \n\n", markII.getFuelLeft());

        System.out.println("-------------------------------------------------------------------------------\n");

        System.out.println("Let's move on to Kryve Ozero!");  //відправлення

        System.out.printf("We need %.2f litres of fuel for this trip!\n",
                markII.calculateNeededFuel(ZHASHKIV_TO_KRYVE_OZERO));

        moneySpent += markII.fillTheTank(markII.getFuelLeft(), fuelCost);

        System.out.printf("We spent %.2f UAH so far!\n", moneySpent);  //прибуття

        markII.setFuelLeft(markII.calculateFuelLeftAfterTrip(ZHASHKIV_TO_KRYVE_OZERO, markII.getFuelLeft()));

        System.out.printf("We have %.2f litres of fuel left after reaching Kryve Ozero. \n\n", markII.getFuelLeft());

        System.out.println("-------------------------------------------------------------------------------\n");

        System.out.println("Let's finish this!"); // відправлення
        System.out.printf("We need %.2f litres of fuel for this trip!\n\n",
                markII.calculateNeededFuel(KRYVE_OZERO_TO_ODESA));

        moneySpent += markII.fillTheTank(markII.getFuelLeft(), fuelCost);

        markII.setFuelLeft(markII.calculateFuelLeftAfterTrip(KRYVE_OZERO_TO_ODESA, markII.getFuelLeft()));

        System.out.printf("We spent %.2f UAH for the ride and we have %.2f litres of fuel left!", //фініш
                moneySpent, markII.getFuelLeft());
    }

}