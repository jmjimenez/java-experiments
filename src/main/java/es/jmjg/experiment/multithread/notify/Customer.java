package es.jmjg.experiment.multithread.notify;

public class Customer {
    private final Account account;

    public Customer(Account account) {
        this.account = account;
    }

    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    public void deposit(int amount) {
        account.deposit(amount);
    }
}