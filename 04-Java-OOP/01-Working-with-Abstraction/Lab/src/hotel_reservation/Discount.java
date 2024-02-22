package hotel_reservation;

public enum Discount {

    VIP(0.8), SECOND_VISIT(0.9), NONE(1.0);

    private final double percent;

    Discount(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public static Discount validateDiscount(String discount) {
        if (discount.equals("SecondVisit")) {
            return SECOND_VISIT;
        } else if (discount.equals("VIP")) {
            return VIP;
        } else {
            return NONE;
        }
    }
}
