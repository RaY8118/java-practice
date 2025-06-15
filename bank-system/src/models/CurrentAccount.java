package models;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public boolean canWithdraw(double amount) {
        return amount > 0 && (getBalance() + overdraftLimit) >= amount;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
