import java.util.Random;
import java.util.Scanner;

public class Slots implements Game{

    public void play(Player player) {

        Scanner scanner = new Scanner(System.in);
        int bet;
        int payout;
        String[] row;
        String playAgain;

        System.out.println("***********************");
        System.out.println("Welcome to Java Slots!");
        System.out.println("Symbols: 🍒 🍉 🍋 🔔 ⭐️");
        System.out.println("***********************");

        while (!player.isBankrupt()){

            System.out.println("Current Balance: $" + player.getBalance());
            System.out.print("Place your bet amount ($): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer:");
                scanner.next();
            }
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet > player.getBalance()) {
                System.out.println("Your bet exceeds your balance! Please enter a valid amount.");
                continue;
            }

            player.subtractBalance(bet);
            System.out.println("Current balance: $" + player.getBalance());

            System.out.println("SPINNING . . .  ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("The spin was interrupted!");
            }
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);

            if (payout > 0){
                player.addBalance(payout);
            } else {
                System.out.println("Sorry, you lost this round...");
                System.out.println("Current balance: $" + player.getBalance());
            }

            System.out.print("Do you want to play again (Y/N):  ");
            playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")){
                break;
            }
        }

    }

    // Creates a new row length 3, with random symbols

    static String[] spinRow(){

        String[] symbols = {"🍒", "🍒", "🍒", "🍉", "🍉", "🍋", "🍋", "🔔", "🔔", "⭐️"};
        String [] row = new String[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++){
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;

    }

    // Prints out the spin with the symbols separated

    static void printRow(String[] row){
        System.out.println("***********************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("***********************");
    }

    static int getPayout(String[] row, int bet){

        // All Matching: higher payout

        if (row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch(row[0]){
                case "🍒" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🍋" -> bet * 5;
                case "🔔" -> bet * 10;
                case "⭐" -> bet * 20;
                default -> 0;
            };
        }

        //Only first two matching: lower payout

        else if (row[0].equals(row[1])){
            return switch(row[0]){
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }

        // Only last two matching: lower payout

        else if (row[1].equals(row[2])){
            return switch(row[1]){
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }

        return 0;
    }

}
