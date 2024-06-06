public abstract class Abstract implements Test {

    private String name;
    private int age;

    public Abstract(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Abstract(String name) {
        this(name, 19);
    }

    public String getName() {
        return name;
    }

    public abstract void sumAge();

    @Override
    public void write(String text) {

    }

    @Override
    public void sum(int num) {

    }
}
