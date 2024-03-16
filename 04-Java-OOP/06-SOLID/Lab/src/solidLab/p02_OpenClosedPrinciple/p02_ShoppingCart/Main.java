package solidLab.p02_OpenClosedPrinciple.p02_ShoppingCart;

public class Main {

    public static void main(String[] args) {

        Cart cart = new Cart("test@abv.bg");
        OrderItem orderItem = new OrderItem("EACH123", 13);

        cart.add(orderItem);

        System.out.println("Total amount of order: " + orderItem.getTotalAmount());
    }
}
