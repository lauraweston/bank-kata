package BankKata;

public class Account {
    private double balance;

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
