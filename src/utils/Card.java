package utils;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public int compareTo(Card other){
        return Integer.compare(this.getValue(), other.getValue());
    }

}
