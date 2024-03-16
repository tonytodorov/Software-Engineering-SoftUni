package solidLab.p02_OpenClosedPrinciple.p02_ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {

    private String sku;
    private int quantity;
    private List<Cart> items;

    public OrderItem(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
        this.items = new ArrayList<>();
    }

    public String getSku() {
        return this.sku;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotalAmount() {
        double total = 0;

        for (Cart cart : this.items) {
            OrderItem next = cart.getItems().iterator().next();
            total += next.getQuantity();
        }

        return total;
    }

}
