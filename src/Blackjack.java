import utils.Card;
import utils.Deck;
import java.util.Random;
import java.util.Scanner;

public class Blackjack implements Game{

    public void play(Player player){

        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        int bet;
        String playAgain;

        System.out.println("********************************");
        System.out.println("♦️♠️Welcome to Java Blackjack!♦️♠️");
        System.out.println("********************************");

        while (!player.isBankrupt()){

            System.out.println("Current Balance: $" + player.getBalance());
            System.out.print("Place your bet amount ($): ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet <= 0 || bet > player.getBalance()) {
                System.out.println("Invalid bet amount. Please try again.");
                continue;
            }

            System.out.println("Press Enter to get your cards...");
            scanner.nextLine();

            Card playerCard1 = deck.drawCard();
            Card playerCard2 = deck.drawCard();

            Card dealerCard1 = deck.drawCard();
            Card dealerCard2 = deck.drawCard();

            BlackjackUtils.displayHand("Player", playerCard1, playerCard2);
            System.out.println("Dealer's visible card: " + dealerCard1);

            int playerTotal = BlackjackUtils.calculateHandValue(playerCard1, playerCard2);
            int dealerTotal = BlackjackUtils.calculateHandValue(dealerCard1, dealerCard2);

            if (BlackjackUtils.isBlackjack(playerCard1, playerCard2)) {
                System.out.println("Blackjack! You win!");
                player.addBalance((int) (1.5 * bet));
                continue;
            }

            if (BlackjackUtils.isBlackjack(dealerCard1, dealerCard2)) {
                System.out.println("Dealer has Blackjack. You lose!");
                player.subtractBalance(bet);
                continue;
            }

            // Player's turn

            while (true){
                System.out.println("Your total: " + playerTotal);
                System.out.print("Do you want to (H)it or (S)tand? ");
                String decision = scanner.nextLine().toUpperCase();

                if (decision.equals("H")) {
                    Card newCard = deck.drawCard();
                    System.out.println("You drew: " + newCard);
                    playerTotal = BlackjackUtils.calculateHandValue(newCard, playerCard1, playerCard2);
                    BlackjackUtils.displayHand("Player", playerCard1, playerCard2, newCard);

                    if (BlackjackUtils.isBust(playerTotal)) {
                        System.out.println("Bust! You lose this round.");
                        player.subtractBalance(bet);
                        break;
                    }
                } else if (decision.equals("S")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please choose 'H' or 'S'.");
                }
            }

            if (BlackjackUtils.isBust(playerTotal)) {
                continue;
            }

            // Dealer's turn
            System.out.println("Dealer's turn...");
            BlackjackUtils.displayHand("Dealer", dealerCard1, dealerCard2);

            while (dealerTotal < 17) {
                Card newCard = deck.drawCard();
                System.out.println("Dealer drew: " + newCard);
                dealerTotal = BlackjackUtils.calculateHandValue(dealerCard1, dealerCard2, newCard);
                BlackjackUtils.displayHand("Dealer", dealerCard1, dealerCard2, newCard);
            }

            if (BlackjackUtils.isBust(dealerTotal)) {
                System.out.println("Dealer busts! You win!");
                player.addBalance(bet);
            } else {
                // Determine the winner
                System.out.println("Your total: " + playerTotal);
                System.out.println("Dealer's total: " + dealerTotal);

                if (playerTotal > dealerTotal) {
                    System.out.println("You win!");
                    player.addBalance(bet);
                } else if (playerTotal < dealerTotal) {
                    System.out.println("You lose!");
                    player.subtractBalance(bet);
                } else {
                    System.out.println("It's a tie! Bet returned.");
                }
            }

            System.out.print("Do you want to play again (Y/N): ");
            playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")) {
                break;
            }


        }

        System.out.println("Thanks for playing Java Blackjack!");

    }

}
