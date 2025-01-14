import java.util.Scanner;

public class CasinoMenu {

    private Player player;
    private Scanner scanner;

    public CasinoMenu(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n🎰 Welcome to the Java Casino 🎰");
            System.out.println("********************************");
            System.out.println("1. Play Slots");
            System.out.println("2. Play War");
            System.out.println("3. Play Roulette");
            System.out.println("4. Play Blackjack");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit\n");
            System.out.print("Choose an option: ");

            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    playGame(new Slots());
                    break;
                case 2:
                    playGame(new War());
                    break;
                case 3:
                    playGame(new Roulette());
                    break;
                case 4:
                    playGame(new Blackjack());
                    break;
                case 5:
                    System.out.println("Your current balance is: $" + player.getBalance());
                    break;
                case 6:
                    System.out.println("Thank you for visiting the Java Casino. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void playGame(Game game) {
        if (player.isBankrupt()) {
            System.out.println("You have no balance left to play games. Please come back later!");
            return;
        }
        game.play(player);
    }
}

