package say_hello_extend;

public class European extends BasePerson {

    private String name;

    protected European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
