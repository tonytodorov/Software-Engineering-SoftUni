package factory;

public class PastryShop {

    private PastryShop() {

    }

    public static void orderCake(String type, double diameter, double price, int pieces) {
        Cake cake = CakeFactory.createCake(type, diameter, price, pieces);

        cake.prepare();
        cake.bake();
        cake.box();
    }
}
