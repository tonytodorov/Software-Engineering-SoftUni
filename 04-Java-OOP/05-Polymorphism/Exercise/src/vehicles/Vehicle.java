package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double km) {
        if (this.fuelConsumption * km <= this.fuelQuantity) {
            this.fuelQuantity -= this.fuelConsumption * km;

            System.out.printf("%s travelled %s km%n",
                    this.getClass().getSimpleName(),
                    new DecimalFormat("#.##").format(km));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    public void refuel(double liters) {
        if (this.getClass().getSimpleName().equals("Car")) {
            this.fuelQuantity += liters;
        } else if (this.getClass().getSimpleName().equals("Truck")){
            this.fuelQuantity += liters * 0.95;
        }
    }


    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
