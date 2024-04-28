package strategy;

public class Main {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.pay(new CreditCardPayment("test", "123456"));
        shoppingCart.pay(new PayPalPayment("test", "123456"));
        shoppingCart.pay(new RevolutPayment("test", "123456"));
    }
}
