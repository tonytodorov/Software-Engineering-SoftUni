package vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void driving(double distance) {
        double neededFuel = (distance * 0.9) + (distance * super.getFuelConsumption());

        if (super.getFuelQuantity() > neededFuel) {
            super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
            System.out.printf("vehicles_extension.Car travelled %s km%n", new DecimalFormat("#.##").format(distance));
        } else {
            System.out.println("vehicles_extension.Car needs refueling");
        }
    }

    @Override
    public void refueling(double liters) {
        super.setFuelQuantity(super.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("vehicles_extension.Car: %s", super.toString());
    }
}
