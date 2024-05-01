package vehicles;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double km) {
        double distance = this.fuelConsumption * km;

        if (distance <= this.fuelQuantity) {
            this.fuelQuantity -= distance;

            System.out.printf("%s travelled %s km%n",
                    this.getClass().getSimpleName(),
                    new DecimalFormat("#.##").format(km));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
