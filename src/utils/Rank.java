package utils;

public enum Rank {

    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(11), QUEEN(12), KING(13);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return switch (this) {
            case ACE -> "Ace";
            case JACK -> "Jack";
            case QUEEN -> "Queen";
            case KING -> "King";
            default -> String.valueOf(value);
        };
    }

}
