package car.salesman;

public class Car {

    private String model;
    private String engine;
    private int weight;
    private String color;


    public Car(String model, String engine) {
        this(model, engine, 0, "");
    }

    public Car(String model, String engine, int weight) {
        this(model, engine, weight, "");
    }

    public Car(String model, String engine, String color) {
        this(model, engine, 0, color);
    }

    public Car(String model, String engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s: %n%s: %nPower: %d%n Displacement: %d%n " +
                "Efficiency: %s%n Weight: %d%n Color: %s%n",
                getModel(), getEngine());
    }
}
