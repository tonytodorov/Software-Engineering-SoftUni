package grocery.payment;

public class Cash implements Payment {

    @Override
    public void pay() {
        System.out.print("Successfully payment!");
    }
}
