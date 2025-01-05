import java.util.Scanner;

public class Casino {

    private Player player;
    private Scanner scanner;

    public Casino(){
        this.player = new Player(100);
        this.scanner = new Scanner(System.in);
    }

    public void start(){

        System.out.println("***********************");
        System.out.println("Welcome to Java Casino!");
        System.out.printf("You start with: $%,.2f%n", player.getBalance());
        System.out.println("***********************");

        boolean keepPlaying  = true;

        while(keepPlaying){
            displayMenu();
            System.out.print("Pick an option: ");
            int choice = getValidInput(1, 5);
            switch(choice){
                case 1 -> playSlots();
                case 2 -> playWar();
                case 3 -> playRoulette();
                case 4 -> System.out.println("Check Balance");
                case 5 -> {
                    keepPlaying = false;
                    System.out.println("\nThanks for playing!");
                    System.out.printf("You final balance is: $%,.2f%n", player.getBalance());
                }

            }
        }

    }
    public void displayMenu(){
        System.out.println("\nChoose an option:");
        System.out.println("1. Play Slots");
        System.out.println("2. Play War");
        System.out.println("3. Play Roulette");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
    }

    private int getValidInput(int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                }
            }
            System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            scanner.nextLine(); // Clear invalid input
        }
        return choice;
    }

    private void playSlots() {
        Slots slots = new Slots(player);
        slots.playGame();
    }

    private void playWar() {
        War war = new War(player);
        war.playGame();
    }

    private void playRoulette() {
        Roulette roulette = new Roulette(player);
        roulette.playGame();
    }

    private void displayBalance() {
        System.out.println("Your current balance is: $" + player.getBalance());
    }

    public static void main(String[] args){

        Casino casino = new Casino();
        casino.start();

    }

}
