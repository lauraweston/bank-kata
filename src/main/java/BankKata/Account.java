package BankKata;

public class Account {
    private double balance;

    public void deposit(double amount) {
        this.balance = amount;
    }

    public String printBalance() {
        return String.valueOf(balance);
    }
}
