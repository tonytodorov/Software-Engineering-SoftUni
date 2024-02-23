package card_suit;

public enum CardSuit {

    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);

    private final int ordinalValue;

    CardSuit(int ordinalValue) {
        this.ordinalValue = ordinalValue;
    }

    public int getOrdinalValue() {
        return ordinalValue;
    }

}
