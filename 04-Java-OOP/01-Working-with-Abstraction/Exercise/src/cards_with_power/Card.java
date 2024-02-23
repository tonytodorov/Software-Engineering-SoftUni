package cards_with_power;

public class Card {

    private String name;
    private String suit;

    public Card(String name, String suit) {
        this.name = name;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", name, suit,
                CardRank.valueOf(name).getValue() + CardSuit.valueOf(suit).getValue());
    }
}
