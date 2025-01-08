import java.util.Random;
import java.util.Scanner;

public class Roulette implements Game{

    public void play(Player player){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        System.out.println("***********************");
        System.out.println("♦️♠️Welcome to Java Roulette!♦️♠️");
        System.out.println("***********************");

        while (!player.isBankrupt()){

            System.out.println("Current Balance: $" + player.getBalance());

            System.out.println("\nPlace your bet type: ");
            System.out.println("1. Single Number (Payout 35:1)");
            System.out.println("2. Color: Red or Black (Payout 1:1)");
            System.out.println("3. Odd/Even (Payout 1:1)");
            System.out.print("Enter your choice (1/2/3): ");

            int betType = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter your bet amount: $");
            int betAmount = scanner.nextInt();
            scanner.nextLine();

            if (betAmount > player.getBalance()) {
                System.out.println("You cannot bet more than your current balance!");
                continue;
            }

            String colorBet = "";
            int numberBet = -1;
            boolean isOdd = false;

            switch (betType) {
                case 1 -> {
                    System.out.print("Enter a number to bet on (0-36): ");
                    numberBet = scanner.nextInt();
                    scanner.nextLine();
                    if (numberBet < 0 || numberBet > 36) {
                        System.out.println("Invalid number. Please bet on a number between 0 and 36.");
                        continue;
                    }
                }
                case 2 -> {
                    System.out.print("Bet on color (Red/Black): ");
                    colorBet = scanner.nextLine().toLowerCase();
                    if (!colorBet.equals("red") && !colorBet.equals("black")) {
                        System.out.println("Invalid color. Please bet on 'Red' or 'Black'.");
                        continue;
                    }
                }
                case 3 -> {
                    System.out.print("Bet on Odd or Even: ");
                    String oddEven = scanner.nextLine().toLowerCase();
                    if (oddEven.equals("odd")) {
                        isOdd = true;
                    } else if (!oddEven.equals("even")) {
                        System.out.println("Invalid input. Please bet on 'Odd' or 'Even'.");
                        continue;
                    }
                }
                default -> {
                    System.out.println("Invalid bet type. Try again.");
                    continue;
                }
            }

            System.out.println("\nSpinning the wheel...");
            int resultNumber = random.nextInt(37); // 0-36
            String resultColor = (resultNumber % 2 == 0) ? "black" : "red";
            System.out.printf("The ball landed on %d (%s)!\n", resultNumber, resultColor);

            // Determine payout
            int payout = 0;
            if (betType == 1 && resultNumber == numberBet) {
                payout = betAmount * 35; // Single number payout
            } else if (betType == 2 && resultColor.equals(colorBet)) {
                payout = betAmount * 2; // Color payout
            } else if (betType == 3 && ((resultNumber % 2 != 0) == isOdd)) {
                payout = betAmount * 2; // Odd/Even payout
            }

            if (payout > 0) {
                System.out.printf("Congratulations! You won $%d!\n", payout);
                player.addBalance(payout);
            } else {
                System.out.println("Sorry, you lost this round...");
                player.subtractBalance(betAmount);
            }

            System.out.printf("Your current balance: $%d\n", player.getBalance());

            System.out.print("Do you want to play again (Y/N):  ");
            playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")){
                break;
            }

        }

        System.out.println("Thanks for playing Java Roulette!");

    }

}
