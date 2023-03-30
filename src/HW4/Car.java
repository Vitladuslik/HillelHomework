package HW4;

public class Car {

    private double fuelTankCapacity;
    private double fuelLeft;
    private double fuelConsumedPerHour;

    public Car(double fuelTankVolume, double fuelLeft, double fuelConsumedPerHundred) {
        this.fuelTankCapacity = fuelTankVolume;
        this.fuelLeft = fuelLeft;
        this.fuelConsumedPerHour = fuelConsumedPerHundred;
    }

    public double fillTheTank(double fuelLeft, double fuelCost) {  // заповнює бак до повного і видає затрати на паливо
        double fuelPoured = getFuelTankCapacity() - fuelLeft;
        double moneySpent = fuelCost * fuelPoured;
        setFuelLeft(getFuelTankCapacity());
        return moneySpent;
    }

    public double calculateFuelLeftAfterTrip(double tripLength, double fuelLeft) {  //вираховує скільки палива
        return fuelLeft - (tripLength/100 * getFuelConsumedPerHour());       // залишиться після поїздки
    }

    public double calculateNeededFuel(double tripLength) { //вираховує необхідну кількість палива
        return (tripLength/100 * getFuelConsumedPerHour());
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public double getFuelLeft() {
        return fuelLeft;
    }

    public void setFuelLeft(double fuelLeft) {
        this.fuelLeft = fuelLeft;
    }

    public double getFuelConsumedPerHour() {
        return fuelConsumedPerHour;
    }
}
