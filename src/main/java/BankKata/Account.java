package BankKata;

public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public Account(double amount) {
        this.balance = amount;
    }

    public void deposit(double amount) throws NoCoinsAllowedException {
        if (!isValidDepositAmount(amount)) {
            throw new NoCoinsAllowedException();
        }
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

    private boolean isValidDepositAmount(double amount) {
        return amount % 5 == 0;
    }

    private boolean isValidWithdrawal(double amount) {
        return amount <= balance;
    }
}
