package automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }


    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < this.capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        Vehicle dummyVehicle = new Vehicle(vin, 0, "");
        return this.vehicles.remove(dummyVehicle);
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        Vehicle vehicle = null;
        int minMileage = Integer.MAX_VALUE;

        for (Vehicle currentVehicle : vehicles) {
            if (currentVehicle.getMileage() < minMileage) {
                vehicle = currentVehicle;
            }
        }

        return vehicle;
    }

    public String report() {
        return String.format("Vehicles in the preparatory: %n%s", this.vehicles.stream()
                .map(Vehicle::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
