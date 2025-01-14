import utils.Card;

public class BlackjackUtils {

    public static int calculateHandValue(Card... cards) {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            int value = card.getValue(); // Assuming Card has a method to get its numeric value
            if (value == 1) { // Ace
                aceCount++;
                total += 11;
            } else if (value > 10) { // Face cards
                total += 10;
            } else {
                total += value;
            }
        }

        // Adjust Ace values from 11 to 1 if the total exceeds 21
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public static boolean isBlackjack(Card card1, Card card2) {
        int value1 = card1.getValue();
        int value2 = card2.getValue();

        // Check for Ace + 10-value card
        return (value1 == 1 && (value2 == 10 || value2 > 10)) ||
                (value2 == 1 && (value1 == 10 || value1 > 10));
    }

    public static boolean isBust(int handValue) {
        return handValue > 21;
    }

    public static void displayHand(String owner, Card... cards) {
        System.out.print(owner + "'s hand: ");
        for (Card card : cards) {
            System.out.print(card + " "); // Assuming Card's toString() provides a readable format
        }
        System.out.println();
    }

}
