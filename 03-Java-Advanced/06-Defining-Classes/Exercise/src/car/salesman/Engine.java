package car.salesman;

public class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;


    public Engine(String model, int power) {
        this(model, power, 0, "");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
