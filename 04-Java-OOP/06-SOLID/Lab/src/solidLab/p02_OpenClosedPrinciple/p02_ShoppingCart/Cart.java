package solidLab.p02_OpenClosedPrinciple.p02_ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String customerEmail;
    private List<OrderItem> items;

    public Cart(String customerEmail) {
        this.customerEmail = customerEmail;
        this.items = new ArrayList<>();
    }

    public void add(OrderItem orderItem) {
        this.items.add(orderItem);
    }

    public Iterable<OrderItem> getItems() {
        return new ArrayList<>(this.items);
    }
}
