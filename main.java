class Account {
    private final int id;
    protected double balance;

    Account(int id) {
        this.id = id;
        this.balance = 1000.0;
        System.out.println("Account constructor: ID = " + id);
    }

    public final int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful: Rs. " + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}

class SavingsAccount extends Account {
    private final Money minBalance;

    SavingsAccount(int id) {
        super(id);
        minBalance = new Money(100.0);
        System.out.println("SavingsAccount constructor called.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= minBalance.getValue()) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal denied: minimum balance is Rs. "
                    + minBalance.getValue());
        }
    }
}

final class Money {
    private final double value;

    Money(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount(101);

        System.out.println("Account ID: " + account.getId());
        System.out.println("Initial balance: Rs. "
                + account.getBalance());

        System.out.println("\n--- First Transaction ---");
        account.withdraw(500.0);
        System.out.println("Current balance: Rs. "
                + account.getBalance());

        System.out.println("\n--- Second Transaction ---");
        account.withdraw(450.0);
        System.out.println("Final balance: Rs. "
                + account.getBalance());
    }
}
