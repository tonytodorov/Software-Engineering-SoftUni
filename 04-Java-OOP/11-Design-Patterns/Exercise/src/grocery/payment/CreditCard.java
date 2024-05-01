package grocery.payment;

public class CreditCard implements Payment {

    @Override
    public void pay() {
        System.out.println("Credit card");
    }
}
