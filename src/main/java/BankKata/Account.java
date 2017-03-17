package BankKata;

public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public Account(double amount) {
        this.balance = amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (isValidWithdrawal(amount)) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException();
        }
    }

    private boolean isValidWithdrawal(double amount) {
        return amount <= balance;
    }
}
