import utils.Card;
import utils.Deck;
import java.util.Random;
import java.util.Scanner;

public class War implements Game{

    public void play(Player player){

        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        int bet;
        String playAgain;

        System.out.println("***********************");
        System.out.println("⚔️ Prepare for Java War! ⚔️");
        System.out.println("***********************");

        while (!player.isBankrupt() && !deck.isEmpty()){

            System.out.println("Current Balance: $" + player.getBalance());
            System.out.print("Place your bet amount ($): ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet <= 0 || bet > player.getBalance()) {
                System.out.println("Invalid bet amount. Please try again.");
                continue;
            }

            System.out.println("Press Enter to draw a card...");
            scanner.nextLine();

            Card playerCard = deck.drawCard();
            Card computerCard = deck.drawCard();

            System.out.println("Your card: " + playerCard);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Computer's card: " + computerCard);
            System.out.println("****************");

            int comparison = playerCard.compareTo(computerCard);
            if (comparison > 0) {
                System.out.println("You win this round!");
                player.addBalance(bet);
            } else if (comparison < 0) {
                System.out.println("You lose this round!");
                player.subtractBalance(bet);
            } else {
                System.out.println("It's a tie! Your bet is refunded.");
            }

            if (player.isBankrupt()) {
                System.out.println("You're bankrupt! Game over.");
                break;
            }

            System.out.print("Do you want to play again (Y/N):  ");
            playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")){
                System.out.println("Thanks for playing Java War!");
                break;
            }

        }

        if (deck.isEmpty()) {
            System.out.println("The deck is empty! The game is over.");
        }

    }

}
