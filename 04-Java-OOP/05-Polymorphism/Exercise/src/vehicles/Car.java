package vehicles;

public class Car extends Vehicle {
    public static final double ADDITIONAL_CONSUMPTION = 0.9;
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION);
    }
}
