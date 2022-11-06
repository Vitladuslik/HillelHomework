package HW4;

public class Car {

    private final double FUEL_TANK_CAPACITY;
    private double fuelLeft;
    private final double FUEL_CONSUMED_PER_HUNDRED;

    public Car(double fuelTankVolume, double fuelLeft, double fuelConsumedPerHundred) {
        this.FUEL_TANK_CAPACITY = fuelTankVolume;
        this.fuelLeft = fuelLeft;
        this.FUEL_CONSUMED_PER_HUNDRED = fuelConsumedPerHundred;
    }

    public double fillTheTank(double fuelLeft, double fuelCost) {  // заповнює бак до повного і видає затрати на паливо
        double fuelPoured = getFUEL_TANK_CAPACITY() - fuelLeft;
        double moneySpent = fuelCost * fuelPoured;
        setFuelLeft(getFUEL_TANK_CAPACITY());
        return moneySpent;
    }

    public double calculateFuelLeftAfterTrip(double tripLength, double fuelLeft) {  //вираховує скільки палива
        return fuelLeft - (tripLength/100 * getFUEL_CONSUMED_PER_HUNDRED());       // залишиться після поїздки
    }

    public double calculateNeededFuel(double tripLength) { //вираховує необхідну кількість палива
        return (tripLength/100 * getFUEL_CONSUMED_PER_HUNDRED());
    }

    public double getFUEL_TANK_CAPACITY() {
        return FUEL_TANK_CAPACITY;
    }

    public double getFuelLeft() {
        return fuelLeft;
    }

    public void setFuelLeft(double fuelLeft) {
        this.fuelLeft = fuelLeft;
    }

    public double getFUEL_CONSUMED_PER_HUNDRED() {
        return FUEL_CONSUMED_PER_HUNDRED;
    }
}
