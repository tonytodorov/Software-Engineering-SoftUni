package grocery.payment;

public class Revolut implements Payment {

    @Override
    public void pay() {
        System.out.println("Revolut");
    }
}
