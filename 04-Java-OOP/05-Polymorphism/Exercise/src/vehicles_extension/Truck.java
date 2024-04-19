package vehicles_extension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void driving(double distance) {
        double neededFuel = (distance * 1.6) + (distance * super.getFuelConsumption());

        if (super.getFuelQuantity() > neededFuel) {
            super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
            System.out.printf("vehicles_extension.Truck travelled %s km%n", new DecimalFormat("#.##").format(distance));
        } else {
            System.out.println("vehicles_extension.Truck needs refueling");
        }
    }

    @Override
    public void refueling(double liters) {
        super.setFuelQuantity(liters * 0.95);
    }

    @Override
    public String toString() {
        return String.format("vehicles_extension.Truck: %s", super.toString());
    }
}
