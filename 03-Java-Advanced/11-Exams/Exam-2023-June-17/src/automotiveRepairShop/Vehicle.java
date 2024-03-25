package automotiveRepairShop;

import java.util.Objects;

public class Vehicle {

    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String VIN, int mileage, String damage) {
        this.VIN = VIN;
        this.mileage = mileage;
        this.damage = damage;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("Damage: %s, Vehicle: %s (%d km)",
                this.getDamage(), this.getVIN(), this.getMileage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return VIN.equals(vehicle.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VIN);
    }
}
