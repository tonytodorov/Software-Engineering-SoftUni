package factory;

public class CakeFactory {

    private CakeFactory() {

    }

    public static Cake createCake(String type, double diameter, double price, int pieces) {
        Cake cake = null;

        if (type.equals("BiscuitCake")) {
            cake = new BiscuitCake(diameter, price, pieces);
        } else if (type.equals("ChocolateCake")) {
            cake = new ChocolateCake(diameter, price, pieces);
        } else if (type.equals("SpinachCake")) {
            cake = new SpinachCake(diameter, price, pieces);
        } else if (type.equals("WhiteCake")) {
            cake = new WhiteCake(diameter, price, pieces);
        }

        return cake;
    }
}
