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

            System.out.print("Do you want to play again (Y/N):  ");
            playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")){
                break;
            }

        }


    }

}
