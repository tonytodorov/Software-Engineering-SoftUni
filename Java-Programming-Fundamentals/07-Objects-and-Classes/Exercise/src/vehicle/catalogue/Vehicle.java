package vehicle.catalogue;

public class Vehicle {

    String typeOfVehicle;
    String model;
    String color;
    int horsepower;

    public Vehicle(String typeOfVehicle, String model, String color, int horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public String getTypeOfVehicleWithUpperCase() {
        return typeOfVehicle.substring(0, 1).toUpperCase() + typeOfVehicle.substring(1);
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }
}
