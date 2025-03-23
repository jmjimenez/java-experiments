package es.jmjg.experiment.multithread.notify;

public class Account {
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public synchronized void withdraw(int amount) {
        System.out.printf("Trying to withdraw %d...%n", amount);

        while (this.amount < amount) {
            System.out.printf("Balance %d to withraw %d too small, waiting for deposit%n", this.amount, amount);

            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e);
            }
        }

        this.amount -= amount;
        System.out.printf("Withdrawal %d completed%n", amount);
    }

    public synchronized void deposit(int amount) {
        System.out.printf("Trying to deposit %d...%n", amount);

        this.amount += amount;

        System.out.printf("Deposit %d completed new balance is %d%n", amount, this.amount);

        notify();
        notifyAll();
    }

    public synchronized int amount() {
        return amount;
    }
}
