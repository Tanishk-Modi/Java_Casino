import java.util.Scanner;

public class Casino {

    // The entire casino program will be run from this method

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Every player starts with $100
        Player player = new Player(100);

        CasinoMenu menu = new CasinoMenu(player, scanner);
        menu.showMenu();
        scanner.close();

    }

}
