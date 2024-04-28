package strategy;

public class PayPalPayment implements Payment {

    private String emailId;
    private String password;

    public PayPalPayment(String email, String password) {
        this.emailId = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }
}
