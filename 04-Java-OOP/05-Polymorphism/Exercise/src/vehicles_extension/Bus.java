package vehicles_extension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void driving(double distance) {
        double neededFuel = (distance * 1.4) + (distance * super.getFuelConsumption());

        if (super.getFuelQuantity() > neededFuel) {
            super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
            System.out.printf("vehicles_extension.Bus travelled %s km%n", new DecimalFormat("#.##").format(distance));
        } else {
            System.out.println("vehicles_extension.Bus needs refueling");
        }
    }

    @Override
    public void refueling(double liters) {
        super.setFuelQuantity(liters);
    }

    @Override
    public String toString() {
        return String.format("vehicles_extension.Bus: %s", super.toString());
    }
}
