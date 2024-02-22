package hotel_reservation;

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season seasons, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = seasons;
        this.discount = discount;
    }

    public double totalPrice() {
        return pricePerDay * numberOfDays * season.getMultiplyIndex() * discount.getPercent();
    }


}
