package animals;

public class Cat extends Animal {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return super.produceSound();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
