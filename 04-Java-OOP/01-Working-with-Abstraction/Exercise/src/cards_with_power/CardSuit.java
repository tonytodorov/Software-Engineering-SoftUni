package cards_with_power;

public enum CardSuit {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int value;

    CardSuit(int ordinalValue) {
        this.value = ordinalValue;
    }

    public int getValue() {
        return value;
    }

}
