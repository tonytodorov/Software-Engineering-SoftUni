package vehicles_extension;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (getFuelQuantity() + fuelQuantity > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else if (getFuelQuantity() > fuelQuantity) {
            this.fuelQuantity = fuelQuantity;
        } else {
            this.fuelQuantity += fuelQuantity;
        }
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public abstract void driving(double distance);
    public abstract void refueling(double liters);

    @Override
    public String toString() {
        return String.format("%.2f", this.getFuelQuantity());
    }
}
