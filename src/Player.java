public class Player {

    private int balance;

    public Player(int startingBalance) {
        this.balance = startingBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        balance += amount;
        System.out.println("You won $" + amount + "!\nNew balance: $" + balance);
    }

    public void subtractBalance(int amount) {
        balance -= amount;
    }

    public boolean isBankrupt() {
        return balance <= 0;
    }

}

