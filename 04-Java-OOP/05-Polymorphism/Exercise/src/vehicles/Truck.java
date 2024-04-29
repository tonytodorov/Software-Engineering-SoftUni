package vehicles;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

}
