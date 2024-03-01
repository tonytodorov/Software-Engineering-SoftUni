package animals;

public class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return super.produceSound();
    }

    @Override
    public String toString() {
        return "Woof!";
    }

}
