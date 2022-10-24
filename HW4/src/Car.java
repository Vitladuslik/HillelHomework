public class Car {

    private double fuelTankVolume;
    private double fuelLeft;
    private double fuelConsumedPerHundredKm;

    public Car(double fuelTankVolume, double fuelLeft, double fuelConsumedPerHundred) {
        this.fuelTankVolume = fuelTankVolume;
        this.fuelLeft = fuelLeft;
        this.fuelConsumedPerHundredKm = fuelConsumedPerHundred;
    }

    public Car() {
    }

    public double fillTheTank (double fuelLeft, double fuelCost) {
        double fuelPoured = getFuelTankVolume()-fuelLeft;
        double moneySpent = fuelCost * fuelPoured;
        setFuelLeft(getFuelTankVolume());
        return moneySpent;
    }

    public double calculateFuelLeftAfterTrip(double tripLength, double fuelLeft ) {
        return fuelLeft-(tripLength* getFuelConsumedPerHundredKm());
    }

    public double calculateNeededFuel(double fuelLeft, double tripLength){
        return (tripLength*getFuelConsumedPerHundredKm()) - fuelLeft;
    }

    public double getFuelTankVolume() {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(double fuelTankVolume) {
        this.fuelTankVolume = fuelTankVolume;
    }

    public double getFuelLeft() {
        return fuelLeft;
    }

    public void setFuelLeft(double fuelLeft) {
        this.fuelLeft = fuelLeft;
    }

    public double getFuelConsumedPerHundredKm() {
        return fuelConsumedPerHundredKm;
    }

    public void setFuelConsumedPerHundredKm(double fuelConsumedPerHundredKm) {
        this.fuelConsumedPerHundredKm = fuelConsumedPerHundredKm;
    }
}
