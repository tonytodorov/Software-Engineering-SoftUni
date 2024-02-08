package raw.data;

public class Car {

    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private double firstTirePressure;
    private int firstTireAge;
    private double secondTirePressure;
    private int secondTireAge;
    private double thirdTirePressure;
    private int thirdTireAge;
    private double fourthTirePressure;
    private int fourthTireAge;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight,
               String cargoType, double firstTirePressure,
               int firstTireAge, double secondTirePressure,
               int secondTireAge, double thirdTirePressure,
               int thirdTireAge, double fourthTirePressure, int fourthTireAge) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.firstTirePressure = firstTirePressure;
        this.firstTireAge = firstTireAge;
        this.secondTirePressure = secondTirePressure;
        this.secondTireAge = secondTireAge;
        this.thirdTirePressure = thirdTirePressure;
        this.thirdTireAge = thirdTireAge;
        this.fourthTirePressure = fourthTirePressure;
        this.fourthTireAge = fourthTireAge;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public double getFirstTirePressure() {
        return firstTirePressure;
    }

    public void setFirstTirePressure(double firstTirePressure) {
        this.firstTirePressure = firstTirePressure;
    }

    public int getFirstTireAge() {
        return firstTireAge;
    }

    public void setFirstTireAge(int firstTireAge) {
        this.firstTireAge = firstTireAge;
    }

    public double getSecondTirePressure() {
        return secondTirePressure;
    }

    public void setSecondTirePressure(double secondTirePressure) {
        this.secondTirePressure = secondTirePressure;
    }

    public int getSecondTireAge() {
        return secondTireAge;
    }

    public void setSecondTireAge(int secondTireAge) {
        this.secondTireAge = secondTireAge;
    }

    public double getThirdTirePressure() {
        return thirdTirePressure;
    }

    public void setThirdTirePressure(double thirdTirePressure) {
        this.thirdTirePressure = thirdTirePressure;
    }

    public int getThirdTireAge() {
        return thirdTireAge;
    }

    public void setThirdTireAge(int thirdTireAge) {
        this.thirdTireAge = thirdTireAge;
    }

    public double getFourthTirePressure() {
        return fourthTirePressure;
    }

    public void setFourthTirePressure(double fourthTirePressure) {
        this.fourthTirePressure = fourthTirePressure;
    }

    public int getFourthTireAge() {
        return fourthTireAge;
    }

    public void setFourthTireAge(int fourthTireAge) {
        this.fourthTireAge = fourthTireAge;
    }
}
